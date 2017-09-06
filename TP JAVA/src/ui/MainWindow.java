package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import entidades.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	JFrame frame;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}
	
	public MainWindow(Persona usu){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 678, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnuPersona = new JMenu("Persona");
		menuBar.add(mnuPersona);
		
		JMenuItem mnuABMCPersona = new JMenuItem("ABMCPersona");
		mnuABMCPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCPersonaClick();
			}
		});
		mnuPersona.add(mnuABMCPersona);
		
		JMenuItem mnuListadoPersonas = new JMenuItem("Listado Personas");
		mnuListadoPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoPersonasClick();
			}
		});
		mnuPersona.add(mnuListadoPersonas);
		
		JMenu mnuTipoElemento = new JMenu("Tipo de Elemento");
		menuBar.add(mnuTipoElemento);
		
		JMenuItem mnuABMCTipoElemento = new JMenuItem("ABMCTipoElemento");
		mnuABMCTipoElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCTipoElementoClick();
			}
		});
		mnuTipoElemento.add(mnuABMCTipoElemento);
		
		JMenu mnuElemento = new JMenu("Elemento");
		menuBar.add(mnuElemento);
		
		JMenuItem mnuABCMElemento = new JMenuItem("ABMCElemento");
		mnuABCMElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnuABMCElementoClick();
			}
		});
		mnuElemento.add(mnuABCMElemento);
		
		JMenu mnuReserva = new JMenu("Reserva");
		menuBar.add(mnuReserva);
		
		JMenuItem mnuReservarElemento = new JMenuItem("ReservarElemento");
		mnuReservarElemento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnuReservarElementoClick();
			}
		});
		mnuReserva.add(mnuReservarElemento);
		
		JMenuItem mnuConsultarReservas = new JMenuItem("ConsultarReservas");
		mnuReserva.add(mnuConsultarReservas);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
	}

	protected void mnuABMCPersonaClick() {
		ABMCPersonaDesktop pd= new ABMCPersonaDesktop();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	
	protected void mnuABMCTipoElementoClick() {
		ABMCTipoElemento te= new ABMCTipoElemento();
		desktopPane.add(te);
		te.setVisible(true);
}
	
	protected void mnuABMCElementoClick() {
		ABMCElementoDesktop ed= new ABMCElementoDesktop();
		desktopPane.add(ed);
		ed.setVisible(true);
}
	
	protected void mnuReservarElementoClick(){
		ReservaElemento re=new ReservaElemento();
		desktopPane.add(re);
		re.setVisible(true);
	}
	
	protected void mnuListadoPersonasClick(){
		ListadoPersonas lp=new ListadoPersonas();
		desktopPane.add(lp);
		lp.setVisible(true);
	}
}