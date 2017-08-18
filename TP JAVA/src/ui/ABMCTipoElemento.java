package ui;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import datos.FactoryConexion;
import entidades.Persona;

public class ABMCTipoElemento extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

	
}
