package Examen_Final;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;

//Definicion de la clase articulo
class Articulo{
	  int ID;
	  String nombre;
	  String descripcion;
	  String fechaVencimiento;
	  String lote;
	  String precio;
		
	public Articulo(int ID,String nombre,String descripcion,String fechaVencimiento,String lote, String precio) {
		this.ID=ID;
		this.nombre=nombre;
		this.descripcion=descripcion;
	    this.fechaVencimiento=fechaVencimiento;
	    this.lote=lote;
	    this.precio=precio;
		}
}

//Definicion de la clase Cliente
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

//Definicion de la clase Ticket
class Ticket{
	int ID;
	String fecha;
	String hora;
	int clienteDNI;
	String clienteNombre;
	int articuloID;
	String articuloNombre;
	int cantidad;
	String total;
	
	public Ticket(int ID,String fecha,String hora,int clienteDNI,String clienteNombre,int articuloID,String articuloNombre,int cantidad,String total) {
		this.ID=ID;
		this.fecha=fecha;
		this.hora=hora;
		this.clienteDNI=clienteDNI;
		this.clienteNombre=clienteNombre;
		this.articuloID=articuloID;
		this.articuloNombre=articuloNombre;
		this.cantidad=cantidad;
		this.total=total;
	}
}

public class examen_final {
	
	public static void main(String[] arg) {
		//Definicion de variables iniciales y las variables a usar para la conexion con la BD
		Scanner sc = new Scanner(System.in);
		int op=0;
		Connection conexion;
	    	String url="jdbc:mysql://localhost:3306/supermercado";
	    	String usuario="root";
	    	String clave="1932107-Lim";
		
		//Visualización del menu de opciones de carga
		while(op!=4) {
			System.out.println("");
			System.out.println("----------------MENU DE OPCIONES----------------");
			System.out.println("1) Registrar un nuevo cliente");
			System.out.println("2) Registrar un nuevo articulo");
			System.out.println("3) Registrar una nuevo ticket");;
			System.out.println("4) Salir");
			System.out.println("");
			System.out.print("Por favor ingrese la opcion: ");
			//Uso de una sentencia try-catch por si el usuario ingresa un valor de distinto tipo
			try {
				op=sc.nextInt();
			}
			catch(Exception ex) {
				System.out.println("El valor ingresado no es valido. Reinicie la aplicacion y vuelva a intentarlo");
				break;
			}
			System.out.println("");
			
			//Definicion de opciones
			
			//Opcion 1
			switch(op) {
			case 1:
				try {
					//Carga de datos del cliente
					System.out.print("Ingrese el DNI del cliente(maximo 8 numeros): ");
					int DNI=sc.nextInt();
					System.out.println("");
					System.out.print("Ingrese el nombre del cliente(maximo 50 caracteres): ");
					String nombre=sc.next();
					System.out.println("");
					System.out.print("Ingrese el apellido del cliente(maximo 50 caracteres): ");
					String apellido=sc.next();
					System.out.println("");
					System.out.print("Ingrese la calle donde vive el cliente(maximo 50 caracteres):");
					String calle=sc.next();
					System.out.println("Ingrese la numeracion de la calle: ");
					int numero=sc.nextInt();
					String domicilio=calle + " " + numero;
					System.out.println("");
					System.out.print("Ingrese el numero de telefono del cliente(maximo 20 numeros): ");
					int telefono=sc.nextInt();
					Cliente c = new Cliente(DNI,nombre,apellido,domicilio,telefono);
					
					//Conexion con la BD para agregar el registro en la tabla cliente
					String consulta="insert into cliente(DNI,nombre,apellido,domicilio,telefono) values('" + c.DNI + "','" + c.nombre + "','" + c.apellido + "','" + c.domicilio + "','" + c.telefono + "')";
					Class.forName("com.mysql.jdbc.Driver");     
			        	conexion=DriverManager.getConnection(url,usuario,clave);    
			        	Statement sentencia=conexion.createStatement();
			        	sentencia.execute(consulta);   
			        	System.out.println("Los nuevos datos se agregaron a la tabla!!");
				}
				catch(InputMismatchException a) {
					System.out.println("Se ha ingresado una palabra en una cadena. Por favor vuelva a intentarlo");
					System.out.println("");
				}
				catch(Exception e) {
					e.printStackTrace();
				      System.out.println("Error en la insercion de datos!!");
				}
				break;
			case 2:
				try {
					//Carga de datos del articulo
					System.out.print("Ingrese el numero de ID del articulo (maximo 10 numeros): ");
					int ID = sc.nextInt();
					System.out.println("");
					System.out.print("Ingrese el nombre del articulo (maximo 50 caracteres): ");
					String nombre= sc.next();
					System.out.println("");
					System.out.print("Ingrese la descripcion del producto(maximo 50 caracteres): ");
					String descripcion=sc.next();
					System.out.println("");
					System.out.println("Fecha de vencimiento. La misma debe tener el siguiente formato: AAAA-MM-DD.");
					System.out.print("Ingrese la fecha de vencimiento del producto: ");
					String fecha=sc.next();
					System.out.println("");
					System.out.print("Ingrese el lote del producto (maximo 50 caracteres): ");
					String lote=sc.next();
					System.out.println("");
					System.out.print("Igrese el precio del producto (maximo 2 enteros y 2 decimeles separados por punto): ");
					String precio=sc.next();
					System.out.println("");
					Articulo a = new Articulo(ID,nombre,descripcion,fecha,lote,precio);
					//Conexion con la BD para agregar el registro en la tabla articulo
					String consulta="insert into articulo(ID,articuloNombre,articuloDescripcion,fechaVencimiento,lote,precio) values('" + a.ID + "','" + a.nombre + "','" + a.descripcion + "','" + a.fechaVencimiento + "','" + a.lote + "','" + a.precio + "')";
					Class.forName("com.mysql.jdbc.Driver");     
			        	conexion=DriverManager.getConnection(url,usuario,clave);    
			        	Statement sentencia=conexion.createStatement();
			        	sentencia.execute(consulta);   
			        	System.out.println("Los nuevos datos se agregaron a la tabla!!");
				}
				catch(InputMismatchException a) {
					System.out.println("Se ha ingresado una palabra en una cadena. Por favor vuelva a intentarlo");
					System.out.println("");
				}
				catch (Exception e) {  
			      		e.printStackTrace();
			      		System.out.println("Error en la insercion de datos!!");
			    }
				break;
			//Opcion 3
			case 3:
				try {
					//Ingreso de datos del ticket
					System.out.println("ATENCION!! Recuerde que para registrar un nuevo ticket el cliente y el articulo deben estar registrados en el sistema");
					System.out.println("");
					System.out.print("Ingrese el ID del ticket(maximo 10 numeros): ");
					int iD=sc.nextInt();
					System.out.println("Fecha del ticket. La misma debe tener el siguiente formato: AAAA-MM-DD.");
					System.out.print("Ingrese la fecha del ticket: ");
					String fecha=sc.next();
					LocalTime h = LocalTime.now();
					String hora = String.valueOf(h);
					System.out.println("");
					System.out.print("Ingrese el DNI del cliente(maximo 8 caracteres): ");
					int DNICli=sc.nextInt();
					System.out.println("");
					System.out.print("Ingrese el nombre del cliente(maximo 50 carateres): ");
					String nomCli=sc.next();
					System.out.println("");
					System.out.print("Ingrese el ID del producto(maximo 10 numeros):");
					int artID=sc.nextInt();
					System.out.println("");
					System.out.print("Ingrese el nombre del articulo(maximo 50 caracteres): ");
					String nomArtic=sc.next();
					System.out.println("");
					System.out.print("Ingrese la cantidad a llevar(maximo 10 numeros): ");
					int cantidad=sc.nextInt();
					System.out.println("");
					System.out.print("Ingrese el total a abonar(maximo 10 enteros y 2 decimales separados por un punto)");
					String total=sc.next();
					Ticket t = new Ticket(iD,fecha,hora,DNICli,nomCli,artID,nomArtic,cantidad,total);
					
					//Conexion con la BD para agregar el registro en la tabla ticket
					String consulta="insert into ticket(tiketID,fecha,hora,clienteDNI,clienteNombre,articuloID,articuloNombre,cantidad,total) values('" + t.ID + "','" + t.fecha + "','" + t.hora + "','" + t.clienteDNI + "','" + t.clienteNombre + "','" + t.articuloID + "','" + t.articuloNombre + "','" + t.cantidad + "','" + t.total + "')";
					Class.forName("com.mysql.jdbc.Driver");     
		        		conexion=DriverManager.getConnection(url,usuario,clave);    
		        		Statement sentencia=conexion.createStatement();
		        		sentencia.execute(consulta);   
		        		System.out.println("Los nuevos datos se agregaron a la tabla!!");
				}
				catch(InputMismatchException a) {
					System.out.println("Se ha ingresado una palabra en una cadena. Por favor vuelva a intentarlo");
					System.out.println("");
				}
				catch(Exception e) {
					e.printStackTrace();
				    	System.out.println("Error en la insercion de datos!!");
				}
				
				break;
			}
			//Salida del menu
			if(op==7) {
				break;
			}
		}
		System.out.println("Hasta pronto!!!!");
		sc.close();
	}
}
