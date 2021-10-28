package kadumMVC;
 
public class Principal {
    public static void main(String[] args) {
        //Invocar al constructor de la clase Bd
        new Bd("kadummvc");
        //Crear un objeto de la clase View
        View vista  = new View();
        //Crear un objeto de la clase Controller
        Controller controlador  = new Controller(vista);
        //Vincular la vista y el controlador
        vista.conectaControlador(controlador);
 
    }
}