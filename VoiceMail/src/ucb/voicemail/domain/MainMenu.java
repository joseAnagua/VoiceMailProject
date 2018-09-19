package ucb.voicemail.domain;

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
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textInput;

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
		
		JButton btnUno = new JButton("1");
		btnUno.setBounds(41, 92, 58, 49);
		btnUno.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnUno);
		
		JButton btnDos = new JButton("2");
		btnDos.setBounds(111, 92, 58, 49);
		btnDos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnDos);
		
		JButton btnTres = new JButton("3");
		btnTres.setBounds(181, 92, 58, 49);
		btnTres.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnTres);
		
		JButton btnCuatro = new JButton("4");
		btnCuatro.setBounds(41, 153, 58, 49);
		btnCuatro.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnCuatro);
		
		JButton btnCinco = new JButton("5");
		btnCinco.setBounds(111, 153, 58, 49);
		btnCinco.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnCinco);
		
		JButton btnSeis = new JButton("6");
		btnSeis.setBounds(181, 153, 58, 49);
		btnSeis.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnSeis);
		
		JButton btnSiete = new JButton("7");
		btnSiete.setBounds(41, 211, 58, 49);
		btnSiete.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnSiete);
		
		JButton btnOcho = new JButton("8");
		btnOcho.setBounds(111, 211, 58, 49);
		btnOcho.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnOcho);
		
		JButton btnNueve = new JButton("9");
		btnNueve.setBounds(181, 211, 58, 49);
		btnNueve.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnNueve);
		
		JButton btnCero = new JButton("0");
		btnCero.setBounds(41, 272, 95, 49);
		btnCero.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnCero);
		
		JButton btnNumeral = new JButton("#");
		btnNumeral.setBounds(144, 272, 95, 49);
		btnNumeral.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnNumeral);
		
		JButton btnH = new JButton("H");
		btnH.setBounds(290, 242, 159, 49);
		btnH.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnH);
		
		JButton btnQ = new JButton("Q");
		btnQ.setBounds(469, 242, 150, 49);
		btnQ.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnQ);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(300, 181, 319, 49);
		btnEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentPane.add(btnEnter);
		
		textInput = new JTextField();
		textInput.setBounds(290, 53, 329, 119);
		contentPane.add(textInput);
		textInput.setColumns(10);
		
		JLabel lblOutput = new JLabel("Mensajes");
		lblOutput.setBackground(UIManager.getColor("Button.highlight"));
		lblOutput.setBounds(41, 31, 198, 49);
		contentPane.add(lblOutput);
	}
}
