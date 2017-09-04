package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import entidades.Categoria;
import entidades.Elemento;
import entidades.Persona;
import entidades.TipoElemento;

import javax.swing.JTextField;

import controlador.CtrlABMCElemento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMCElementoDesktop extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtId;
	private JComboBox cboTipoElemento;
	private CtrlABMCElemento ctrl=new CtrlABMCElemento();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElementoDesktop frame = new ABMCElementoDesktop();
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
	public ABMCElementoDesktop() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblId = new JLabel("ID");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		cboTipoElemento = new JComboBox();
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarClick();
			}
		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				borrarClick();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickAgregar();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBorrar)
							.addGap(18)
							.addComponent(btnModificar)
							.addGap(18)
							.addComponent(btnAgregar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblId)
								.addComponent(lblTipoDeElemento))
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtId)
								.addComponent(txtNombre)
								.addComponent(cboTipoElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(37)
							.addComponent(btnBuscar)))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoDeElemento))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnModificar)
						.addComponent(btnAgregar))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();
	}
	
	private void cargarListas(){
		try {
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrl.getAllTipoElemento().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
	
	private void mapearAForm(Elemento el){
		this.txtNombre.setText(el.getNombre());
		this.txtId.setText(String.valueOf(el.getId()));
		this.cboTipoElemento.setSelectedItem(el.getTipoElemento());
	}
	


	private Elemento mapearDeForm(){
		Elemento el=new Elemento();
		if(!this.txtId.getText().isEmpty()){
			el.setId(Integer.parseInt(this.txtId.getText()));
		}
		el.setNombre(this.txtNombre.getText());
		if(cboTipoElemento.getSelectedIndex()!=-1){
			el.setTipoElemento((TipoElemento)this.cboTipoElemento.getSelectedItem());
		}
		return el;
	}
	
	protected void clickAgregar(){
		Elemento el=this.mapearDeForm();
		try {
			ctrl.add(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(el.getId()));
	}
	
	protected void buscarClick(){
		try {
			this.mapearAForm(ctrl.getByNomYTip(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());		}
	}
	
	protected void borrarClick(){
		try {
			ctrl.delete(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try {
			ctrl.update(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
