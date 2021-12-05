/* import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent; */ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class mainMenu extends Frame implements ActionListener, WindowListener{ 


    public Login log;
	public Signup sign;
	public Score scoreobj; 
	public Window gameObj;


	public mainMenu(){
		super("Tetris (Main Menu)"); 
		log=new Login(this);
		sign=new Signup(this);
		scoreobj=new Score(this); 
		gameObj=new Window(this);
			 
		 
		Button b1=new Button("Login"); 
		Button b2=new Button("Signup");
		Button b3=new Button("Score");
		 
		add(b1); 
		add(b2);
		add(b3); 
		
		b1.addActionListener(this);
	    b2.addActionListener(this);
		b3.addActionListener(this);
		
		addWindowListener(this);
		setLayout(new FlowLayout());
		setSize(320,400);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Login")){
			this.setVisible(false);
			log.setVisible(true); 
			log.setParent(this); 
		}
		else if(s.equals("Signup")){
			sign.setVisible(true);
			this.setVisible(false);
			sign.setParent(this);
		}
		else if(s.equals("Score")){
			this.setVisible(false);
			scoreobj.setVisible(true);
			scoreobj.setParent(this); 
		}

	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		//this.setVisible(false);
		System.exit(0);
		//System.out.println("Game Closing..");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
}