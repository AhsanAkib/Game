import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends Frame implements ActionListener, WindowListener{
	
	public boolean startGame;   
	private mainMenu first;    
	//public  Window gameObj1;
	private Frame parent; 
	
	private TextField tf;
	private TextField tf2;
	
	
	public Login(mainMenu obj){
		super("Login");
		first=obj; 
		startGame=false;               /* Waiting for Login Details validation */
		//gameObj1=first.gameObj; 
		
		Label l=new Label("User Name: ");
		Label l2=new Label("Password: ");
		tf=new TextField(28);
		tf2=new TextField(28);
		tf2.setEchoChar('*');
		
		Button b=new Button("Login");
		Button b2=new Button("Cancel");
		Button b3=new Button("Signup");
		add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b2);add(b3);
		
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		
		if(s.equals("Login")){
			DataAccess da=new DataAccess();
			String typedName=tf.getText();
			String typedPass=tf2.getText();
			String q="select name,pass from Tetris";
			ResultSet rs=null;
			System.out.println("Checking Login Details..");		
			
			try{
				rs=da.getData(q);
				System.out.println(q);
				while(rs.next()){
					String n = rs.getString("name");
					String p= rs.getString("pass");
					if(n.equals(typedName) && p.equals(typedPass)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred."); 
						startGame=true;                     // Login successful so we set boolean value 'true' //
						first.gameObj.startGameF(startGame);      // sending 'true' value to start the game //
						this.setVisible(false);
						break;
					}
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
				ex.printStackTrace();
			}
		}
		else if(s.equals("Cancel")){
			first.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Signup")){
			this.setVisible(false);
			first.sign.setVisible(true);
			first.sign.setParent(first);
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