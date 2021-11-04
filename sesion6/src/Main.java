
public class Main {

	public static void main(String[] args) {

		AccesoDatos bd = new AccesoDatos();
		
		bd.conectar();
		
		bd.columnasMetaData("trabajadores", "detalles_pedido");
		
		bd.desconectar();
	}

}
