import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JFrame{

	private JPanel panel;
	
	private JButton login;

	
	private JLabel username;
	private JLabel password;
	
	private JTextField user;
	
	private JPasswordField pass;
	
	public LoginScreen(){
		
		panel= new JPanel();
		login= new JButton("Login");
		
		user=new JTextField("");
		pass=new JPasswordField("");
		
		password= new JLabel("Password");
		username= new JLabel("Username");
	
		panel.add(username);	
		panel.add(user);

		panel.add(password);		
		panel.add(pass);
		
		panel.add(login);
		
		this.setContentPane(panel);
		
		panel.setBackground(Color.ORANGE );
		
		//event
		ButtonListener listener = new ButtonListener();
		login.addActionListener(listener);
		
		pass.setColumns(5);
		user.setColumns(5);
		
		
		this.setVisible(true);
		this.setSize(300,300);
		this.setLocation(500,200);
		this.setTitle("Login Sreen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		while(true){
//
//			panel.setBackground(Color.LIGHT_GRAY);
//			panel.setBackground(Color.WHITE );
//		
//		
//	}
		}
	

	//event
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String u,p;
			u="u";
			p="p";
			
			if(user.getText().equals(u) && pass.getPassword().equals(p) ) {
				dispose();
				new MainScreen();}
			else{
				JOptionPane.showMessageDialog(null, "Non-authorised access!","Error!", JFrame.EXIT_ON_CLOSE);
			}

		}
	}
	
	
}
