import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainScreen extends JFrame{

	private ArrayList<Esoda> esoda = new ArrayList<Esoda>();
	private ArrayList<E3oda> e3oda = new ArrayList<E3oda>();
	
	
	private JPanel panel;
	
	private JButton save;
	private JButton add;
	private JButton calc;
	private JButton details;
	
	private JLabel esodaLabel;
	private JLabel e3odaLabel;
	
	private JTextField esodaField;
	private JTextField e3odaField;
	private JTextField esodaName;
	private JTextField e3odaName;
	private JTextArea display;
	
	private JTextField result;

	
	public MainScreen(){
		
		panel= new JPanel();
		
		display = new JTextArea(12, 30);
		
		save= new JButton("Save");
		calc= new JButton("Calculate");
		add= new JButton("Add");
		details= new JButton("Details");
		
		esodaField=new JTextField("0");
		e3odaField=new JTextField("0");
		esodaName=new JTextField("name");
		e3odaName=new JTextField("name");
		
		
		
		
		result=new JTextField("Total");
		
		esodaLabel= new JLabel("E3oda");
		e3odaLabel= new JLabel("Esoda");
		
		panel.add(e3odaLabel);
		panel.add(e3odaField);
		panel.add(e3odaName);
		
		panel.add(esodaLabel);
		panel.add(esodaField);
		panel.add(esodaName);
		
		
		//frame.setVisible (true);
		
			
		panel.add(add);
		panel.add(calc);
		panel.add(save);		
		panel.add(details);
	
		panel.add(result);
		panel.add(display);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		add.addActionListener(listener);
		save.addActionListener(listener);
		calc.addActionListener(listener);
		details.addActionListener(listener);
		
		
		//diastaseis
		e3odaField.setColumns(5);
		esodaField.setColumns(5);
		e3odaName.setColumns(5);
		esodaName.setColumns(5);
		result.setColumns(8);

		//add.setBackground(Color.GREEN);
		
	
		
		this.setVisible(true);
		this.setSize(500,400);
		this.setLocation(500,200);
		this.setTitle("Main Sreen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display.setEditable(false);

			panel.setBackground(Color.ORANGE );
			

			
			this.focus();
			
		
	}
	
	
		
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(add)){
				if(!esodaField.equals("0"))
					esoda.add(new Esoda(Integer.parseInt(esodaField.getText()), esodaName.getText()));
				else
					esoda.add(0,null);
				if(!e3odaField.equals("0"))
					e3oda.add(new E3oda(Integer.parseInt(e3odaField.getText()), e3odaName.getText()));
				else
					e3oda.add(0,null);
				
				this.clear();
				result.setText("Total");
				
			}
			
			if(e.getSource().equals(calc)){
				
				this.total();
				
				result.setText(Integer.toString(this.total()));  	
				this.clear();
			}
			
			if(e.getSource().equals(save)){
				
				try{
					//dimiourgia path
					File myDir = new File("C:\\Users\\Kostas\\Downloads\\U.O.M\\java");
					//dhmiourgia arxeiou
					File myFile = new File(myDir, "Esoda_E3oda.txt");
					FileWriter writer = new FileWriter(myFile);
					{
						writer.write(display.getText());
					}
					writer.close();
					}
				catch(IOException ex)
					{
						ex.printStackTrace();
					}
					
				this.clear();
				
			}
			
			if(e.getSource().equals(details)){
				display.append("ESODA:"+System.getProperty("line.separator"));
				for(Esoda esodo:esoda){
				display.append(esodo.getName()+"   |   "+Integer.toString(esodo.getEsoda())+" euro"+System.getProperty("line.separator"));
				}
				display.append(System.getProperty("line.separator")+"E3ODA:"+System.getProperty("line.separator"));
				for(E3oda e3odo:e3oda){
				display.append(e3odo.getName()+"   |   "+Integer.toString(e3odo.getE3oda())+" euro"+System.getProperty("line.separator"));
				
				}
				
				display.append(System.getProperty("line.separator")+"Total: "+Integer.toString(this.total()));  
				this.clear();
				
			}

		}
		
		
		public void clear(){
			esodaField.setText("0");
			e3odaField.setText("0");
			esodaName.setText("name");
			e3odaName.setText("name");
			//result.setText("Total");
		}
		
		public int total(){
			int sum1=0;
			for(Esoda esodo:esoda){
				sum1+=esodo.getEsoda();
			}
			int sum2=0;
			for(E3oda e3odo:e3oda){
				sum2+=e3odo.getE3oda();
			}
			
			int res=sum2-sum1;
			return res;
		}
	}
	
	public void focus() {
		esodaName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				esodaName.setText(""); 
			}
			public void focusLost(FocusEvent e) {
				if(esodaName.getText().trim().length()==0)
					esodaName.setText("name");   }
			});  
		e3odaName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				e3odaName.setText(""); 
			}
			public void focusLost(FocusEvent e) {
				if(e3odaName.getText().trim().length()==0)
					e3odaName.setText("name");   }
			}); 
		
		esodaField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				esodaField.setText(""); 
			}
			public void focusLost(FocusEvent e) {
				if(esodaField.getText().trim().length()==0)
					esodaField.setText("0");   }
			});  
		e3odaField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				e3odaField.setText(""); 
			}
			public void focusLost(FocusEvent e) {
				if(e3odaField.getText().trim().length()==0)
					e3odaField.setText("0");   }
			}); 
	
		result.setEditable(false);
		result.setFocusable(false);
	}
	
}
