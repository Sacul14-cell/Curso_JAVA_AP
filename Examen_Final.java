import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Insertar {
  public static void main(String[] args) {
    
    Connection conexion;
    String url="jdbc:mysql://localhost:3306/escuela";
    String usuario="root";
    String clave="pabLo987$";
    String consulta="insert into alumnos(AlumDni,AlumNom,AlumApe) values ('2','Maria','Gonzalez')";
        
    try {
    	Class.forName("com.mysql.jdbc.Driver");     
        conexion=DriverManager.getConnection(url,usuario,clave);    
        Statement sentencia=conexion.createStatement();
        sentencia.execute(consulta);   
        System.out.println("Los nuevos datos se agregaron a la tabla!!");
    } catch (Exception e) {  
      e.printStackTrace();
      System.out.println("Error en la insercion de datos!!");
    }
  }
}
