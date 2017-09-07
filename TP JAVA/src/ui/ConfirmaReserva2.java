package ui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Elemento;

public class ConfirmaReserva2 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmaReserva2 frame = new ConfirmaReserva2();
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
	public ConfirmaReserva2() {
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnConfirmarReserva = new JButton("Confirmar Reserva");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addComponent(btnConfirmarReserva)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConfirmarReserva)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	public ConfirmaReserva2(ArrayList<Elemento> elementos) {
		return;
	}
}
