/*7) (Desafio) Fazer, com o Java SWING, uma aplicação de caça-níquel, conforme figura abaixo.
O caça níquel tem 3 JTextFields, independentes, que giram, aleatoriamente, de 1 a 150 vezes e
apresentará um número de 1 a 7. Quando iniciado, o botão Jogar deve desaparecer.
*/
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadRoleta;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnJogar.setBounds(376, 246, 89, 23);
		contentPane.add(btnJogar);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setEditable(false);
		textField1.setBounds(33, 63, 98, 106);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setBounds(202, 63, 98, 106);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setEditable(false);
		textField3.setColumns(10);
		textField3.setBounds(367, 63, 98, 106);
		contentPane.add(textField3);
		
		ActionListener jogar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t = new ThreadRoleta(textField1, btnJogar);
				Thread t2 = new ThreadRoleta(textField2, btnJogar);
				Thread t3 = new ThreadRoleta(textField3, btnJogar);
				
				t.start();
				t2.start();
				t3.start();
			}
			
		};
	
		btnJogar.addActionListener(jogar);
	}
}
