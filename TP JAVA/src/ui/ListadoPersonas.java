package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlador.CrtlABMCPersona;
import entidades.Persona;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import entidades.Categoria;

public class ListadoPersonas extends JInternalFrame {
	
	private ArrayList<Persona> pers;
	CrtlABMCPersona ctrl= new CrtlABMCPersona();
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoPersonas frame = new ListadoPersonas();
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
	public ListadoPersonas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 745, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		try {
			this.pers=ctrl.getAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		initDataBindings();
		

	}
	protected void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pers, table);
		//
		BeanProperty<Persona, String> personaBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Apellido").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty_2, "DNI").setColumnName("DNI").setEditable(false);
		//
		BeanProperty<Persona, Categoria> personaBeanProperty_3 = BeanProperty.create("categoria");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Categoria").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
