package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadRoleta extends Thread {
	
	private JTextField campo;
	private JButton botao;
	
	public ThreadRoleta(JTextField campo, JButton botao) {
		this.campo = campo;
		this.botao = botao;
	}
	
	public void run() {
		botao.setVisible(false);
		roletar();
		
	}
	
	public void roletar() {
		int giros = (int)((Math.random() * 150) + 1);
		for(int i = 0; i <= giros; i++) {
			int num = ((int)(Math.random() * 7) + 1); 
			campo.setText(Integer.toString(num));
			
			try {
				Thread.sleep(50);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		if(Thread.activeCount() == 3) {
			botao.setVisible(true);
		}
	}
}
