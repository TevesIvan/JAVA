package ui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.CtrlReserva;
import entidades.Persona;
import entidades.Reserva;

import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import entidades.Reserva.Estado;
import java.util.Date;
import java.util.List;

public class ListadoReservas extends JInternalFrame {
	private JTable table;
	private ArrayList<Reserva> reservas;
	private Persona usuario;
	CtrlReserva ctrl=new CtrlReserva();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoReservas frame = new ListadoReservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListadoReservas() {
		initialize();
	}
	
	public ListadoReservas(Persona usu){
		this.usuario=usu;
		initialize();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialize() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 714, 376);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(302)
							.addComponent(btnCancelarReserva)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancelarReserva)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		try {
			this.reservas=ctrl.getAllUsuario(this.usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, reservas, table);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(reservaBeanProperty).setColumnName("ID").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_1 = BeanProperty.create("detalle");
		jTableBinding.addColumnBinding(reservaBeanProperty_1).setColumnName("Detalle").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_2 = BeanProperty.create("persona.dni");
		jTableBinding.addColumnBinding(reservaBeanProperty_2).setColumnName("DNI").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_3 = BeanProperty.create("elemento.tipoElemento.nombre");
		jTableBinding.addColumnBinding(reservaBeanProperty_3).setColumnName("Tipo Elemento").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_4 = BeanProperty.create("elemento.nombre");
		jTableBinding.addColumnBinding(reservaBeanProperty_4).setColumnName("Elemento").setEditable(false);
		//
		BeanProperty<Reserva, Estado> reservaBeanProperty_5 = BeanProperty.create("estado");
		jTableBinding.addColumnBinding(reservaBeanProperty_5).setColumnName("Estado").setEditable(false);
		//
		BeanProperty<Reserva, Date> reservaBeanProperty_6 = BeanProperty.create("fechaHoraDesde");
		jTableBinding.addColumnBinding(reservaBeanProperty_6).setColumnName("Fecha Desde").setEditable(false);
		//
		BeanProperty<Reserva, Date> reservaBeanProperty_7 = BeanProperty.create("fechaHoraHasta");
		jTableBinding.addColumnBinding(reservaBeanProperty_7).setColumnName("Fecha Hasta").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
