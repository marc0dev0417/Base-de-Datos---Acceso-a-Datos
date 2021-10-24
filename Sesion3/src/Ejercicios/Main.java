package Ejercicios;
import java.util.Scanner;
public class Main {

	public static void importePedido() {
		Scanner leer = new Scanner(System.in);

		AccesoDatos bd = new AccesoDatos();

		bd.conectar();
		
		double importePedido;
		
		System.out.print("Introduce el número de pedido:");
		int pedido = leer.nextInt();
		
		
		importePedido = bd.importePedido(pedido);
		
		if(importePedido != -1) {
			System.out.println("El importe total del pedido "+pedido+" es "+importePedido);
		}else {
			System.out.println("El numero de pedido "+pedido+" no existe");
		}
		bd.desconectar();
	}
	public static void productosCategoriaBajoMinimos() {
		Scanner leer = new Scanner(System.in);
		
		AccesoDatos bd = new AccesoDatos();
		
		bd.conectar();
		
		System.out.println("Introduce número de categoría:");
		int categoria = leer.nextInt();
		bd.productosCategoriaBajoMinimos(categoria);
		
		bd.desconectar();
	}
	public static void incrementarPrecioCategoria() {
		Scanner leer = new Scanner(System.in);
		
		AccesoDatos bd = new AccesoDatos();
		
		bd.conectar();
		
		System.out.println("Introduce número de categoría:");
		int categoria = leer.nextInt();
		
		System.out.println("Introduce porcentaje:");
		int porcentaje = leer.nextInt();
		
		int resultado = bd.incrementarPrecioCategoria(categoria, porcentaje);
		
		if(resultado != 0) {
			System.out.println("Se incrementó el precio un "+porcentaje+" para 5 productos de la categoría -> "+categoria);
		}else {
			System.out.println("No se actualizó ningún producto de la categoría -> "+categoria);
		}
		bd.desconectar();
	}
	public static void main(String[] args) {
		importePedido();
		System.out.println("");
		
		productosCategoriaBajoMinimos();
	}

}
