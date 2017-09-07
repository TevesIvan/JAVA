package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlador.CtrlReserva;
import entidades.Categoria;
import entidades.Elemento;
import entidades.Persona;
import entidades.Reserva;
import entidades.TipoElemento;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class ReservaElemento extends JInternalFrame {
	private JTextField txtFechaDesde;
	private JTextField txtFechaHasta;
	private JComboBox cboTipoElemento;
	private CtrlReserva ctrl=new CtrlReserva();
	private JTextField txtDetalle;
	private JTable table;
	private Persona usuario;
	private ArrayList<Elemento> elementos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaElemento frame = new ReservaElemento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ReservaElemento() {
		initialize();
	}
	
	public ReservaElemento(Persona usu){
		this.usuario=usu;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 757, 300);
		
		JLabel lblFechaDesde = new JLabel("Fecha Desde");
		
		JLabel lblFechaHasta = new JLabel("Fecha Hasta");
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		
		txtFechaDesde = new JTextField();
		txtFechaDesde.setColumns(10);
		
		txtFechaHasta = new JTextField();
		txtFechaHasta.setColumns(10);
		
		cboTipoElemento = new JComboBox();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aceptarClick();
			}
		});
		
		JLabel lblDetalle = new JLabel("Detalle");
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaDesde)
						.addComponent(lblFechaHasta)
						.addComponent(lblTipoElemento)
						.addComponent(lblDetalle))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAceptar)
						.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtFechaHasta, Alignment.LEADING)
							.addComponent(txtFechaDesde, Alignment.LEADING)
							.addComponent(cboTipoElemento, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaDesde)
								.addComponent(txtFechaDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaHasta)
								.addComponent(txtFechaHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoElemento)
								.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDetalle)
								.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(btnAceptar)))
					.addGap(27))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		cargarListas();
		initDataBindings();
	}
	

	private void cargarListas(){
		try {
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrl.getTiposElementos().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	} 
	
	protected void aceptarClick()
	{
		this.elementos= new ArrayList<Elemento>();
		try {
			elementos=ctrl.buscaElementosDisp(this.mapearDeForm());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initDataBindings();
		
//		this.setVisible(false);
//		ConfirmaReserva cr = new ConfirmaReserva(elementos);
//		cr.setVisible(true);
	}
	
	private Reserva mapearDeForm(){
		Reserva r=new Reserva();
		r.setElemento(new Elemento());
		DateFormat format=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
		try {
			r.setFechaHoraDesde(format.parse(this.txtFechaDesde.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			r.setFechaHoraHasta(format.parse(this.txtFechaHasta.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(cboTipoElemento.getSelectedIndex()!=-1){
			r.getElemento().setTipoElemento( (TipoElemento) this.cboTipoElemento.getSelectedItem());
		}
		r.setDetalle(this.txtDetalle.getText());
		r.setPersona(this.usuario);
		return r;
	}
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elementos, table);
		//
		BeanProperty<Elemento, String> elementoBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Elemento, TipoElemento> elementoBeanProperty_1 = BeanProperty.create("tipoElemento");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Tipo Elemento").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
