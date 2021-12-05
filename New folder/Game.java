import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


class Game extends Frame implements ActionListener, WindowListener{
	
	public Frame parent;
	public mainMenu first;
	
	public Game(mainMenu f){
		super("Play!");
		first=f; 
	
		
		Button b=new Button("Go Back");

		add(b);
		b.addWindowListener(this);
		setLayout(new FlowLayout());
		
		setSize(280,400);
		setVisible(true);
	}

}

	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Go Back")){
			this.setVisible(false);
			log.setVisible(true); 
			log.setParent(this); 
		}
	}


	
	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		//this.setVisible(false);
		System.exit(0);
		System.out.println("Window closing");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	public void setParent(Frame f){parent=f;}
}