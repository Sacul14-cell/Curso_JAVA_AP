package TP7;
import java.util.Scanner;

class Producto{
	String nombre;
	int precioUnitario;
	int Cantidad;
	
	public Producto(String nombre, int Precio, int cantidad) {
		this.nombre=nombre;
		this.precioUnitario=Precio;
		this.Cantidad=cantidad;
	}
}

class ItemCarrito extends Producto{
	double montoProducto;
	
	public ItemCarrito(String nombre, int Precio, int cantidad, double montoProducto) {
		super(nombre,Precio,cantidad);
		this.montoProducto=montoProducto;
	}
	
	double CalcularTotal() {
		return Cantidad*precioUnitario;
	}
}

class Descuento{
	public Descuento() {}
	double CalcularDescuento(double montoTotal) {
		return montoTotal*0.1;
	}
}

class Carrito extends ItemCarrito{
	public Carrito(String nombre, int Precio, int cantidad, double montoProducto) {
		super(nombre,Precio,cantidad,montoProducto);
	}
}

public class TP7 {
	public static void main(String arg[]) {
		int m = 0;
		double total = 0;
		String nombreProducto = "";
		int precioProducto = 0;
		int cantidadProducto = 0;
		double montoProducto = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Bienvenido. Por favor ingrese el numero de productos a cargar en el carrito: ");
		m = sc.nextInt();
		Carrito[] c = new Carrito[m];
		for(int i = 0;i<m;i++) {
			System.out.println("Ingrese el nombre del producto " + (i+1) + ": ");
			nombreProducto = sc.next();
			System.out.println("Ingrese el precio del producto " + (i+1) + ": ");
			precioProducto = sc.nextInt();
			System.out.println("Ingrese la cantidad a llevar del producto " + (i+1) + ": ");
			cantidadProducto = sc.nextInt();
			montoProducto = precioProducto*cantidadProducto;
			total += montoProducto;
			c[i]= new Carrito(nombreProducto,precioProducto,cantidadProducto,montoProducto);
		}
		
		System.out.println(" ");
		System.out.println("CARRITO");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(int i=0;i<m;i++) {
			System.out.println("Producto " + (i+1));
			System.out.println("Nombre del producto: " + c[i].nombre + " | Precio unitario: $" + c[i].precioUnitario + " | Cantidad: " + c[i].Cantidad);
			System.out.println("---------------------------------------------------------------------------------------------");
		}
		
		if(total>1000) {
			Descuento des = new Descuento();
			double d = des.CalcularDescuento(total);
			System.out.println("Al cliente le corresponde un descuento de $" + d);
			System.out.println("El monto total a abonar es de $" + (total-d));
		}
		else {
			System.out.println("Al cliente no le corresponde un descuento");
			System.out.println("El monto total a abonar es de $" + total);
		}
		sc.close();
	}
}
