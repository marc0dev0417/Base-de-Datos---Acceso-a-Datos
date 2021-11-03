package Baloncesto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
 
public class View extends JFrame {
 
    /**************** ATRIBUTOS ***************************/
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
 
    //DEFINICIÓN DE LAS ETIQUETAS
    private JLabel lblSocioId;
    private JLabel lblNombre;
    private JLabel lblEstatura;
    private JLabel lblEdad;
    private JLabel lblLocalidad;
    private JLabel lblBuscar;
 
    //DEFINICIÓN DE LOS CUADROS DE TEXTO
    protected JTextField txtSocioID;
    protected JTextField txtNombre;
    protected JTextField txtEstatura;
    protected JTextField txtEdad;
    protected JTextField txtLocalidad;
    protected JTextField txtBuscar;
 
    //DEFINICIÓN DE LOS BOTONES
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
    protected JButton btnBuscar;
 
    //DEFINICIÓN DE LOS OBJETOS PARA LA TABLA
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    protected DefaultTableModel dtm;//Unión de la cabecera y la tabla
    protected JTable tabla; //Tabla propiamente dicha
 
    /**************** MÉTODOS ***************************/
    //CONSTRUCTOR
    View(){
        //Métodos de la JFrame
        setBounds(100, 100, 450, 300);//Definir las dimensiones de la ventana
        setTitle("GESTIÓN DE CLIENTES - KADUM");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
 
        //CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //INDICAR QUE SE QUIERE USAR SPRINGLAYOUT
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        //Vamos al lío
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        //ETIQUETA SOCIOID
        lblSocioId = new JLabel("SocioID:");  //Crear el objeto
        contenedor.add(lblSocioId);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblSocioId, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblSocioId,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA NOMBRE
        lblNombre = new JLabel("Nombre:");
        contenedor.add(lblNombre);
        sp.putConstraint(SpringLayout.NORTH, lblNombre, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNombre,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA ESTATURA
        lblEstatura = new JLabel("Estatura:");
        contenedor.add(lblEstatura);
        sp.putConstraint(SpringLayout.NORTH, lblEstatura, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEstatura,  10,
                        SpringLayout.WEST, contenedor);
        
        //ETIQUETA EDAD
        lblEdad = new JLabel("Edad:");
        contenedor.add(lblEdad);
        sp.putConstraint(SpringLayout.NORTH, lblEdad, 130,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEdad,  10,
                SpringLayout.WEST, contenedor);
        
      //ETIQUETA LOCALIDAD
        lblLocalidad = new JLabel("Localidad:");
        contenedor.add(lblLocalidad);
        sp.putConstraint(SpringLayout.NORTH, lblLocalidad, 170,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblLocalidad,  10,
                SpringLayout.WEST, contenedor);
        
        //ETIQUETA BUSCAR
        lblBuscar = new JLabel("Buscar:");
        contenedor.add(lblBuscar);
        sp.putConstraint(SpringLayout.NORTH, lblBuscar, 210,
                SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblBuscar,  10,
                SpringLayout.WEST, contenedor);
        
        /**************** EOF ETIQUETAS  ^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //CUADRO DE TEXTO PARA EL ID
        txtSocioID       = new JTextField();
        contenedor.add(txtSocioID);
        sp.putConstraint(SpringLayout.NORTH, txtSocioID, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtSocioID, 100,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtSocioID, 300,
                        SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL NOMBRE
        txtNombre = new JTextField();
        contenedor.add(txtNombre);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNombre, 100,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtNombre, 300,
                        SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LOS ESTATURA
        txtEstatura      = new JTextField();
        contenedor.add(txtEstatura);
        sp.putConstraint(SpringLayout.NORTH, txtEstatura, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEstatura, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEstatura, 300, SpringLayout.WEST, contenedor);
        
        //CUADRO DE TEXTO PARA LA EDAD
        txtEdad      = new JTextField();
        contenedor.add(txtEdad);
        sp.putConstraint(SpringLayout.NORTH, txtEdad, 130, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEdad, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEdad, 300, SpringLayout.WEST, contenedor);
        
        //CUADRO DE TEXTO PARA LA LOCALIDAD
        txtLocalidad      = new JTextField();
        contenedor.add(txtLocalidad);
        sp.putConstraint(SpringLayout.NORTH, txtLocalidad, 170, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtLocalidad, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtLocalidad, 300, SpringLayout.WEST, contenedor);
        
        //CUADRO DE TEXTO PARA BUSCAR
        txtBuscar      = new JTextField();
        contenedor.add(txtBuscar);
        sp.putConstraint(SpringLayout.NORTH, txtBuscar, 210, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtBuscar, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtBuscar, 300, SpringLayout.WEST, contenedor);
        /**************** EOF CUADROS DE  TEXTO ^^^^^^^^^ **/
 
        /**************** BOF TABLA  vvvvvvvvvvvvvvvvvvvv **/
        scroll      = new JScrollPane();
        cabecera    = new String[] {"SocioID","Nombre","Estatura"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //y ahora se coloca el scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 300,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10,
                        SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50,
                        SpringLayout.SOUTH, contenedor);
        /**************** EOF TABLA ^^^^^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF BOTONES vvvvvvvvvvvvvvvvvv **/
        //BOTÓN AÑADIR
        btnAdd          = new JButton("Añadir");
        contenedor.add(btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10,
                        SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnAdd,   60,
                        SpringLayout.WEST, contenedor);
        //BOTÓN BORRAR
        btnDel          = new JButton("Borrar");
        contenedor.add(btnDel);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnDel,  190,
                        SpringLayout.WEST, contenedor);
        //BOTÓN MODIFICAR
        btnUpd          = new JButton("Editar");
        contenedor.add(btnUpd);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnUpd,  310,
                        SpringLayout.WEST, contenedor);
        //BOTON BUSCAR
        /*
        btnBuscar          = new JButton("Buscar");
        contenedor.add(btnBuscar);
        sp.putConstraint(SpringLayout.SOUTH, btnBuscar, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnBuscar,  310+110,
                        SpringLayout.WEST, contenedor);
                        */
        btnBuscar          = new JButton("Buscar");
        contenedor.add(btnBuscar);
        sp.putConstraint(SpringLayout.NORTH, btnBuscar, 210,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnBuscar,  310+110,
                        SpringLayout.WEST, contenedor);
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
        setVisible(true);
 
    }
 
    public void conectaControlador(  Controller c  ){
 
        btnAdd.addActionListener(c);
        btnAdd.setActionCommand("INSERTAR");
 
        btnDel.addActionListener(c);
        btnDel.setActionCommand("BORRAR");
 
        btnUpd.addActionListener(c);
        btnUpd.setActionCommand("MODIFICAR");
        
        btnBuscar.addActionListener(c);
        btnBuscar.setActionCommand("BUSCAR");
 
        tabla.addMouseListener(c);
        //sólo se permite pulsar una fila a la vez.
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}