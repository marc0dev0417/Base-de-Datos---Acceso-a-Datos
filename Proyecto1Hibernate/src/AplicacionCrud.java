import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.mapping.Component;

import primero.SessionFactoryUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import primero.Departamentos;
import primero.Empleados;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class AplicacionCrud {
	private JFrame frame;
	private JTextField txtNumEmpleado;
	private JTextField txtApellido;
	private JTextField txtOficio;
	private JTextField txtSalario;
	private JTextField txtComision;
	private JTextField textFechaAlta;
	private JComboBox comboDirectores;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionCrud window = new AplicacionCrud();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public AplicacionCrud() {
		initialize();
	}
	public void cargarDirectores() {
		
		comboDirectores.removeAllItems();
		
		
		String hql = "from empleados where empleado.dir";
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumEmpleado = new JLabel("N\u00BA Empleado:");
		lblNumEmpleado.setBounds(30, 25, 93, 14);
		frame.getContentPane().add(lblNumEmpleado);
		
		txtNumEmpleado = new JTextField();
		txtNumEmpleado.setBounds(133, 22, 86, 20);
		frame.getContentPane().add(txtNumEmpleado);
		txtNumEmpleado.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(30, 56, 73, 14);
		frame.getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(133, 53, 86, 20);
		frame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblOficio = new JLabel("Oficio:");
		lblOficio.setBounds(30, 87, 73, 14);
		frame.getContentPane().add(lblOficio);
		
		txtOficio = new JTextField();
		txtOficio.setBounds(133, 84, 86, 20);
		frame.getContentPane().add(txtOficio);
		txtOficio.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(30, 118, 73, 14);
		frame.getContentPane().add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(133, 115, 86, 20);
		frame.getContentPane().add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblComision = new JLabel("Comisi\u00F3n:");
		lblComision.setBounds(30, 149, 73, 14);
		frame.getContentPane().add(lblComision);
		
		txtComision = new JTextField();
		txtComision.setBounds(133, 146, 86, 20);
		frame.getContentPane().add(txtComision);
		txtComision.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar Empleado");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() != null) {
					SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
					Session session = sesion.openSession();
					
					Empleados empleados = new Empleados();
					empleados = (Empleados)session.load(Empleados.class, (short) (Short.valueOf(txtNumEmpleado.getText())));
					
					JOptionPane.showMessageDialog(null, "Numero Empleado: "+empleados.getEmpNo()+"\n"+"Apellido: "+empleados.getApellido()+"\n"+"Oficio: "+empleados.getOficio());
				}
			}
		});
		btnConsultar.setBounds(298, 21, 169, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(102, 267, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(291, 267, 89, 23);
		frame.getContentPane().add(btnLimpiar);
		
		JComboBox comboDepartamentos = new JComboBox();
		comboDepartamentos.setModel(new DefaultComboBoxModel(new String[] {"Elige Departamento", "10/CONTABILIDAD", "20/INVESTIGACION", "30/VENTAS", "40/PRODUCCION"}));
		comboDepartamentos.setBounds(317, 56, 129, 22);
		frame.getContentPane().add(comboDepartamentos);
		
		comboDirectores = new JComboBox();
		comboDirectores.setModel(new DefaultComboBoxModel(new String[] {"7369/SANCHES", "7499/ARROYO", "7521/SALA", "7566/JIMENES", "7654/MARTIN", "7698/NEGRO", "7782/CEREZO"}));
		comboDirectores.setBounds(317, 87, 129, 22);
		frame.getContentPane().add(comboDirectores);
		
		JButton btnInsertar = new JButton("Insertar");
		
		
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource() != null) {
					System.out.println("funciona el insert");
				
					String idEmpleadoDirector;
					
				
					
						//System.out.println(comboDepartamentos.getSelectedItem().toString());
						
						String[] dividirNumeroDepartamento = comboDepartamentos.getSelectedItem().toString().split("/");
						String[] directorEmpleado = comboDirectores.getSelectedItem().toString().split("/");
						
						
						System.out.println(dividirNumeroDepartamento[0]);
						System.out.println(directorEmpleado[0]);
						
						
				
					SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
					Session session = sesion.openSession();
					Transaction tx = session.beginTransaction();
					
					System.out.println("Inserto un empleado");
					
					Float salario = new Float(Float.valueOf(txtSalario.getText()));
					Float comision = new Float(Float.valueOf(txtComision.getText()));
					
					Empleados empleado = new Empleados();
					
					empleado.setEmpNo(Short.valueOf(txtNumEmpleado.getText()));
					empleado.setApellido(txtApellido.getText());
					empleado.setOficio(txtOficio.getText());
					empleado.setSalario(salario);
					empleado.setComision(comision);
					empleado.setDir(Short.valueOf(directorEmpleado[0]));
					
					Departamentos departamento = new Departamentos();
					departamento.setDeptNo((byte)Byte.valueOf(dividirNumeroDepartamento[0]));
					
					empleado.setDepartamentos(departamento);
					try {
					empleado.setFechaAlt(Date.valueOf(textFechaAlta.getText()));
					}catch(IllegalArgumentException fecha) {
						System.out.println("Fecha mal introducida");
					}
					session.save(empleado);
					
					try {
						tx.commit();
						comboDirectores.addItem(txtNumEmpleado.getText()+"/"+txtApellido.getText());
					}catch (ConstraintViolationException e) {
						// EMPLEADO REPETIDO O NO EXISTE EL DEPARTAMENTO
					    System.out.println("ERROR EN RESTRICCIONES (primaria o ajena)");
						System.out.printf("MENSAJE: %s%n", e.getMessage());
						// ERROR PROPIO MYSQL
						System.out.printf("COD ERROR DE MYSQL: %d%n", e.getErrorCode());
						System.out.printf("ERROR SQL: %s%n", e.getSQLException().getMessage());
						// ERROR ESTANDAR, MISMO PARA CUALQUIER GESTOR DE BASE DE DATOS
						// REALMENTE NO ME VALE PUES DOS ERRORES DISTINTOS (clave primaria o
						// (clave ajena) TIENEN ASIGNADO EL MISMO ERROR ESTANDAR!!!!! (23000)
						System.out.printf("ERROR SQL ESTANDAR: %s%n", e.getSQLException().getSQLState());
				}
				catch (Exception e) {
					System.out.println("ERROR NO CONTROLADO....");
					e.printStackTrace();
				}
					session.close();
					
				}
				
			}
		});
		btnInsertar.setBounds(102, 233, 89, 23);
		frame.getContentPane().add(btnInsertar);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta:");
		lblFechaAlta.setBounds(264, 149, 67, 14);
		frame.getContentPane().add(lblFechaAlta);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setBounds(327, 146, 119, 20);
		frame.getContentPane().add(textFechaAlta);
		textFechaAlta.setColumns(10);
	}
}