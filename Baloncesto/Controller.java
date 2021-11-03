package Baloncesto;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
 
public class Controller implements ActionListener,
                                    MouseListener {
    private View view;
 
    //CONSTRUCTOR
    Controller( View view ){
        this.view   = view;
        cargarTabla();
    }
 
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
        PreparedStatement cs;
        PreparedStatement cs2;
        int id;
 
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
 
        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase View
        switch (comando) {
            case "INSERTAR":
                try{
                    //Preparar la llamada
                    cs  = Bd.getConexion().prepareStatement("INSERT INTO socio VALUES(?,?,?,?,?)");
                    //Indicar qué información se pasa al
                    //  procedimiento
                    cs.setString(1,
                        this.view.txtSocioID.getText());
                    cs.setString(2,
                        this.view.txtNombre.getText());
                    cs.setString(3,
                        this.view.txtEstatura.getText());
                    cs.setInt(4, 
                    	Integer.valueOf(this.view.txtEdad.getText()));
                    cs.setString(5, 
                    	this.view.txtLocalidad.getText());
                    
                   
                    //Ejecutar el procedimiento
                    cs.executeUpdate();
                    limpia();
                    cargarTabla();
                }catch (SQLException e) {
                    System.err.println("Error en la INSERCIÓN");
                }
 
            break;
 
            case "BORRAR":
                //Recoger qué fila se ha pulsado
            int filaPulsada = this.view.tabla.getSelectedRow();
            
             id = (int) this.view.dtm.getValueAt(filaPulsada, 0);
            
            try {
				cs = Bd.getConexion().prepareStatement("DELETE FROM socio WHERE socioID = ?");
				cs.setInt(1, id);
	            
	            cs.executeUpdate();
	            limpia();
                cargarTabla();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            break;
            
            case "MODIFICAR":
                //Recoger qué fila se ha pulsadao en la tabla
                filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se recoge el id de la fila marcada
                    id   = (int)this.view.dtm.getValueAt(filaPulsada, 0);
                    try{
                        //Preparar la llamada
                        cs  = Bd.getConexion().prepareStatement("UPDATE socio SET nombre = ?, estatura = ?, edad = ?, localidad = ? WHERE socioID = ?");
                        //Indicar qué información se pasa al procedimiento
                        cs.setString(1, this.view.txtNombre.getText());
                        cs.setInt(2,
                            Integer.parseInt(this.view.txtEstatura.getText()));
                        cs.setInt(3,
                            Integer.parseInt(this.view.txtEdad.getText()));
                        cs.setString(4,
                            this.view.txtLocalidad.getText());
                        cs.setInt(5, id);
                        //Ejecutar el procedimiento
                        cs.executeUpdate();
                        //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
                        limpia();
                        cargarTabla();
                    }catch (SQLException e) {
                        System.err.println("Error en la MODIFICACION");
                        System.out.println(e.getMessage());
                    }
                }
            break;
            
            case "BUSCAR" :
            	
			try {
				Vector<Object> fila;
				 
				for(int i=this.view.dtm.getRowCount(); i>0; i--){
			            this.view.dtm.removeRow(i-1);
			        }
				
				cs = Bd.getConexion().prepareStatement("SELECT * FROM socio WHERE socioID = ?");
				cs.setInt(1, Integer.valueOf(this.view.txtBuscar.getText()));
				
				ResultSet rs = cs.executeQuery();
				
				if(rs.next()) {
					 fila    = new Vector<Object>();
					this.view.txtSocioID.setText(String.valueOf(rs.getInt("socioID")));
					this.view.txtNombre.setText(rs.getString("nombre"));
					this.view.txtEstatura.setText(String.valueOf(rs.getInt("estatura")));
					this.view.txtEdad.setText(String.valueOf(rs.getInt("edad")));
					this.view.txtLocalidad.setText(rs.getString("localidad"));
					
					  fila.add(rs.getInt("socioID"));
		                fila.add(rs.getString("nombre"));
		                fila.add(rs.getInt("estatura"));
		                fila.add(rs.getInt("edad"));
		                fila.add(rs.getString("localidad"));
		                //Añadir el vector a la tabla de la clase View
		                this.view.dtm.addRow(fila);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
            default:
                System.err.println("Comando no definido");
            break; 
        }
    }
 
    //Método para limpiar los campos de la ventana
    private void limpia(){
        this.view.txtSocioID.setText("");
        this.view.txtNombre.setText("");
        this.view.txtEstatura.setText("");
        this.view.txtEdad.setText(""); 
        this.view.txtLocalidad.setText("");
    }
 
    //Método que recarga los datos de la tabla de la base de datos
    // en la tabla de la clase View
    protected void cargarTabla(){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
    	PreparedStatement cs;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View
        Vector<Object> fila;
 
        //Limpiar los datos de la tabla
        for(int i=this.view.dtm.getRowCount(); i>0; i--){
            this.view.dtm.removeRow(i-1);
        }
 
        //Cargar datos en la tabla
        
        try {
            //Preparar la llamada
            cs  = Bd.getConexion().prepareStatement("SELECT * FROM socio");
          
            //Ejecutarla y recoger el resultado
            
            rs  = cs.executeQuery();
          
            //Recorrer el resultado
           
            while(rs.next()){
                //Añadir registro a registro en el vector
                fila    = new Vector<Object>();
                fila.add(rs.getInt("socioID"));
                fila.add(rs.getString("nombre"));
                fila.add(rs.getInt("estatura"));
                fila.add(rs.getInt("edad"));
                fila.add(rs.getString("localidad"));
                //Añadir el vector a la tabla de la clase View
                this.view.dtm.addRow(fila);
            }
 
        } catch (SQLException e) {
            System.out.println("Error al CARGAR DATOS");
            System.out.println(e.getMessage());
        }
    }
 
    @Override
    public void mouseClicked(MouseEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement cs;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
 
        //Recoger qué fila se ha pulsadao en la tabla
        int filaPulsada = this.view.tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0){
            //Se recoge el id de la fila marcada
            int identificador= (int)this.view.dtm.getValueAt(
                            filaPulsada, 0);
            try{
                //Preparar la llamada
                cs  = Bd.getConexion().prepareStatement("SELECT * FROM socio WHERE socioID = ?");
                //Indicar qué información se pasa al procedimiento
                cs.setInt(1, identificador);
                //Ejecutar el procedimiento
                rs  = cs.executeQuery();
                //Cargar los datos devueltos en los cuadros de texto
                if(rs.next()){
                    this.view.txtSocioID.setText(rs.getString(1));
                    this.view.txtNombre.setText(rs.getString(2));
                    this.view.txtEstatura.setText(rs.getString(3));
                    this.view.txtEdad.setText(String.valueOf(rs.getInt(4)));
                    this.view.txtLocalidad.setText(rs.getString(5));
                }
                //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            }catch (SQLException e) {
                System.err.println("Error al CARGAR UN CLIENTE");
            }
        }
    }
 
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}
}