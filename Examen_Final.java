import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

class Producto{
  int ID;
	String nombre;
  String descripcion;
  String fechaVencimiento;
  String origen;
	int precio;
	
	public Producto(int ID,String nombre,String descripcion,String fechaVencimiento,String origen, int precio) {
		this.ID=ID
    this.nombre=nombre;
		this.descripcion=descripcion;
    this.fechaVencimiento;
    this.origen=origen;
    this.precio=precio;
	}
}

class Cliente{
  int DNI;
  String nombre;
  String apellido;
  String domicilio;
  int telefono;
  
  public Cliente(int DNI,String nombre,String apellido,String domicilio,int telefono){
    this.DNI=DNI;
    this.nombre=nombre;
    this.apellido=apellido;
    this.domicilio=domicilio;
    this.telefono=telefono;
  }
}




public class Examen_Final {
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
