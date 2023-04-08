package TPIntegrador;

import java.util.Scanner;

class Calculadora{
	
	
	public Calculadora() {}
	
	
	public double sumar(double unNumero, double otroNumero) {
		return unNumero+otroNumero;
	}
	
	public double restar(double unNumero, double otroNumero) {
		return unNumero-otroNumero;
	}
	
	public double multiplicar(double unNumero, double otroNumero) {
		return unNumero*otroNumero;
	}
	
	public double dividir(double unNumero, double otroNumero) {
		return unNumero/otroNumero;
	}
}

public class TPIntermedio {
	public static void main(String[] arg) {
		int op=0;
		Scanner sc = new Scanner(System.in);
		while(op!=1) {
			try {
				System.out.print("Por favor ingrese el primero numero: ");
				double a=sc.nextDouble();
				System.out.print("Por favor ingrese el segundo numero: ");
				double b=sc.nextDouble();
				System.out.println();
				Calculadora cal=new Calculadora();
				System.out.println("La suma de los numeros " + a + " y " + b + " es: " + cal.sumar(a,b));
				System.out.println();
				System.out.println("La resta de los numeros " + a + " y " + b + " es: " + cal.restar(a,b));
				System.out.println();
				System.out.println("La multiplicación de los numeros " + a + " y " + b + " es: " + cal.multiplicar(a,b));
				System.out.println();
				System.out.println("La division de los numeros " + a + " y " + b + " es: " + cal.dividir(a,b));
				System.out.println();
				op=1;
			}
			catch(Exception e) {
				System.out.println("Debe ingresar un numero");
				sc.next();
			}
		}
		System.out.println("Hasta pronto");
		sc.close();
	}
}
