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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ReservaElemento extends JInternalFrame {
	private JTextField txtFechaDesde;
	private JTextField txtFechaHasta;
	private JComboBox cboTipoElemento;
	private CtrlReserva ctrl=new CtrlReserva();
	private JTextField txtDetalle;

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

	/**
	 * Create the frame.
	 */
	public ReservaElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDetalle)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFechaDesde)
									.addGap(18)
									.addComponent(txtFechaDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaHasta)
										.addComponent(lblTipoElemento))
									.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cboTipoElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtFechaHasta)
										.addComponent(btnAceptar)
										.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(201, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();
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
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		try {
			elementos=ctrl.buscaElementosDisp(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.setVisible(false);
		ConfirmaReserva cr = new ConfirmaReserva(elementos);
		cr.setVisible(true);
	}
	
	private Reserva mapearDeForm(){
		Reserva r=new Reserva();
		DateFormat format=new SimpleDateFormat("dd/mm/aa",Locale.getDefault());
		try {
			r.setFechaHoraDesde((Date)format.parse(this.txtFechaDesde.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			r.setFechaHoraHasta((Date)format.parse(this.txtFechaHasta.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(cboTipoElemento.getSelectedIndex()!=-1){
			r.getElemento().setTipoElemento((TipoElemento)this.cboTipoElemento.getSelectedItem());
		}
		r.setDetalle(this.txtDetalle.getText());
		return r;
	}
}
