import java.sql.*;

public class BaseDeDatosNoFunciona {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33006/contactos", "root",
                    "dbrootpass");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contacto");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println(nombre + ": " + edad);
            }
            int filas = st.executeUpdate(
                    "INSERT INTO contactos.contacto (DNI, NOMBRE, EDAD) VALUES ('07834658F', 'Alberto Velez Rodrigo', 51)");
            int update = st.executeUpdate(
                    "UPDATE contactos.contacto SET DNI='26583790X', NOMBRE='Rich', EDAD='19' WHERE DNI='07834658F'");
            int borrar = st.executeUpdate("DELETE FROM contactos.contacto WHERE DNI='26583790X'");
            System.out.println("Se han añadido " + filas + " a la tabla");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getErrorCode() + "-" + e.getMessage());
        }
    }
}
