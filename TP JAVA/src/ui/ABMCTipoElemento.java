package ui;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import datos.FactoryConexion;
import entidades.Categoria;
import entidades.Persona;
import entidades.TipoElemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlador.CtrlTipoElemento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class ABMCTipoElemento extends JInternalFrame {
	private CtrlTipoElemento ctrl=new CtrlTipoElemento();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCantMax;
	private JCheckBox chkPrivilegio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCTipoElemento frame = new ABMCTipoElemento();
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
	public ABMCTipoElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblCantidadMaxima = new JLabel("Cantidad M\u00E1xima");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setColumns(10);
		
		txtCantMax = new JTextField();
		txtCantMax.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBuscar();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickAgregar();
			}
		});
		

		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBorrar();
			}

			
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickModificar();
			}
		});
		
		chkPrivilegio = new JCheckBox("Privilegio");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre)
									.addGap(56)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblCantidadMaxima)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnAgregar, Alignment.TRAILING)
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(lblId)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(chkPrivilegio))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(btnBorrar)))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModificar)
						.addComponent(btnBuscar))
					.addGap(106))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadMaxima)
						.addComponent(txtCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(chkPrivilegio)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnAgregar)
						.addComponent(btnModificar))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	private void mapearAForm(TipoElemento t){
		this.txtNombre.setText(t.getNombre());
		this.txtCantMax.setText(String.valueOf(t.getCantMax()));
		this.txtId.setText(String.valueOf(t.getId()));
		this.chkPrivilegio.setSelected(t.isPrivilegio());
	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento t=new TipoElemento();
		if(!this.txtId.getText().isEmpty()){
			t.setId(Integer.parseInt(this.txtId.getText()));
		}
		t.setNombre(this.txtNombre.getText());
		if(!this.txtCantMax.getText().isEmpty()){
		t.setCantMax(Integer.parseInt(this.txtCantMax.getText()));}
		t.setPrivilegio(this.chkPrivilegio.isSelected());
		return t;
	}
	
	protected void clickAgregar() {
		TipoElemento t=this.mapearDeForm();
		try {
			ctrl.add(t);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(t.getId()));				
	}
	
	private void clickBorrar() {
		try {
			ctrl.delete(this.mapearDeForm());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void clickModificar(){
		try {
			ctrl.update(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void clickBuscar() {
		try {
			this.mapearAForm(ctrl.getByNombre
					
					(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());;
		}	
	}
}
