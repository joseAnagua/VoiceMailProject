package ucb.voicemail.presentation.graphical.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ucb.voicemail.domain.Connection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	private JPanel boardMain;
	private JTextField textInput;
	private JLabel lblOutput;
	private Connection connection;

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
		boardMain = new JPanel();
		boardMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(boardMain);
		boardMain.setLayout(null);

		JButton btnUno = new JButton("1");
		btnUno.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("1");
			}
		});
		btnUno.setBounds(41, 62, 58, 49);
		boardMain.add(btnUno);

		JButton btnDos = new JButton("2");
		btnDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("2");
			}
		});
		btnDos.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnDos.setBounds(111, 62, 58, 49);
		boardMain.add(btnDos);

		JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("3");
			}
		});
		btnTres.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnTres.setBounds(181, 62, 58, 49);
		boardMain.add(btnTres);

		JButton btnCuatro = new JButton("4");
		btnCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("4");
			}
		});
		btnCuatro.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnCuatro.setBounds(41, 123, 58, 49);
		boardMain.add(btnCuatro);

		JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("5");
			}
		});
		btnCinco.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnCinco.setBounds(111, 123, 58, 49);
		boardMain.add(btnCinco);

		JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("6");
			}
		});
		btnSeis.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnSeis.setBounds(181, 123, 58, 49);
		boardMain.add(btnSeis);

		JButton btnSiete = new JButton("7");
		btnSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("7");
			}
		});
		btnSiete.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnSiete.setBounds(41, 181, 58, 49);
		boardMain.add(btnSiete);

		JButton btnOcho = new JButton("8");
		btnOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("8");
			}
		});
		btnOcho.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnOcho.setBounds(111, 181, 58, 49);
		boardMain.add(btnOcho);

		JButton btnNueve = new JButton("9");
		btnNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("9");
			}
		});
		btnNueve.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNueve.setBounds(181, 181, 58, 49);
		boardMain.add(btnNueve);

		JButton btnCero = new JButton("0");
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("0");
			}
		});
		btnCero.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnCero.setBounds(41, 242, 95, 49);
		boardMain.add(btnCero);

		JButton btnNumeral = new JButton("#");
		btnNumeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.dial("#");
			}
		});
		btnNumeral.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnNumeral.setBounds(144, 242, 95, 49);
		boardMain.add(btnNumeral);

		JButton btnH = new JButton("H");
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.hangup();
			}
		});
		btnH.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnH.setBounds(290, 242, 159, 49);
		boardMain.add(btnH);

		JButton btnQ = new JButton("Q");
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFrame();
			}
		});
		btnQ.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnQ.setBounds(469, 242, 150, 49);
		boardMain.add(btnQ);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection.record(textInput.getText());
				textInput.setText("");
			}
		});
		btnEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnEnter.setBounds(300, 181, 319, 49);
		boardMain.add(btnEnter);

		textInput = new JTextField();
		textInput.setBounds(290, 53, 329, 119);
		boardMain.add(textInput);
		textInput.setColumns(10);

		JLabel lblOutput = new JLabel("Mensajes");
		lblOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblOutput.setBounds(41, 6, 237, 55);
		boardMain.add(lblOutput);

		this.lblOutput = lblOutput;
	}

	public void display(String output) {
		output = "<html>" + output.replaceAll("\n", "<br/>") + "</html>";
		lblOutput.setText(output);
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private void closeFrame() {
		super.dispose();
	}
}
