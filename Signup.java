import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class Signup extends Frame implements ActionListener, WindowListener{
	private TextField tf;
	private TextField tf2;
	private mainMenu first;
	private Frame parent;
	
	public Signup(mainMenu f){
		super("Sign Up");
		first=f;
		Label l=new Label("User Name: ");
		Label l2=new Label("Password: ");
		tf= new TextField(30); 
		tf2=new TextField(30);
		
		Button b=new Button("Sign Up");
		Button b2=new Button("Cancel");
		
		add(l);add(tf);add(l2);add(tf2);
		add(b);add(b2);
		
		l.setBounds(30,65,100,15);
		tf.setBounds(160,65,100,20);
		l2.setBounds(30,100,100,15);
		tf2.setBounds(160,100,100,20);
        b.setBounds(150,140,80,25);
		b2.setBounds(240,140,80,25);

		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(350,400);
		setLocation(400,200);
	}
	
	
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed (signup)");
		String s=ae.getActionCommand();
		//System.out.println(s);
		if(s.equals("Sign Up")){
			if(tf.getText().length()==0){
				JOptionPane.showMessageDialog(this,"You Must Type");
			}
			else{
				String q="insert into tetris values(null,'"+tf.getText()+"','"+tf2.getText()+"','0')";
				System.out.println(q);
				DataAccess da=new DataAccess();
				da.updateDB(q); 
				JOptionPane.showMessageDialog(this,"Done! Login to play."); 
				first.setVisible(true);
			    this.setVisible(false);
			}
		}
		else if(s.equals("Cancel")){
			first.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
	public void setParent(Frame f){parent=f;}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		first.setVisible(true);
		this.setVisible(false);
		//System.exit(0);
		//System.out.println("Window closing..");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}