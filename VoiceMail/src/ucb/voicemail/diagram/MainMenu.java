package ucb.voicemail.diagram;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUno = new JButton("1");
		btnUno.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUno.setBounds(41, 62, 58, 49);
		contentPane.add(btnUno);
		
		JButton btnDos = new JButton("2");
		btnDos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnDos.setBounds(111, 62, 58, 49);
		contentPane.add(btnDos);
		
		JButton btnTres = new JButton("3");
		btnTres.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnTres.setBounds(181, 62, 58, 49);
		contentPane.add(btnTres);
		
		JButton btnCuatro = new JButton("4");
		btnCuatro.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnCuatro.setBounds(41, 123, 58, 49);
		contentPane.add(btnCuatro);
		
		JButton btnCinco = new JButton("5");
		btnCinco.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnCinco.setBounds(111, 123, 58, 49);
		contentPane.add(btnCinco);
		
		JButton btnSeis = new JButton("6");
		btnSeis.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnSeis.setBounds(181, 123, 58, 49);
		contentPane.add(btnSeis);
		
		JButton btnSiete = new JButton("7");
		btnSiete.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnSiete.setBounds(41, 181, 58, 49);
		contentPane.add(btnSiete);
		
		JButton btnOcho = new JButton("8");
		btnOcho.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnOcho.setBounds(111, 181, 58, 49);
		contentPane.add(btnOcho);
		
		JButton btnNueve = new JButton("9");
		btnNueve.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNueve.setBounds(181, 181, 58, 49);
		contentPane.add(btnNueve);
		
		JButton btnCero = new JButton("0");
		btnCero.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnCero.setBounds(41, 242, 95, 49);
		contentPane.add(btnCero);
		
		JButton btnNumeral = new JButton("#");
		btnNumeral.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNumeral.setBounds(144, 242, 95, 49);
		contentPane.add(btnNumeral);
		
		JButton btnH = new JButton("H");
		btnH.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnH.setBounds(290, 242, 159, 49);
		contentPane.add(btnH);
		
		JButton btnQ = new JButton("Q");
		btnQ.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnQ.setBounds(469, 242, 150, 49);
		contentPane.add(btnQ);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnEnter.setBounds(300, 181, 319, 49);
		contentPane.add(btnEnter);
		
		textField = new JTextField();
		textField.setBounds(290, 53, 329, 119);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
