import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class Score extends Frame implements ActionListener, WindowListener{
	
	private Frame parent;
	private mainMenu first;
	
	public Score(mainMenu f){
	   super("Score Board"); 
	   first=f;
	   
	   
	   	Label l=new Label("Name ");
		Label l2=new Label("  Score");
		Button b=new Button("Go Back");
		add(l); add(l2); add(b);
		
		
		b.addActionListener(this);
		setLayout(new FlowLayout());
		       
       setSize( 400, 600 );
       //setVisible( true );   
     
    
		
  } 
  
  
    public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed (score)");
		String s=ae.getActionCommand();

		
		if(s.equals("Go Back")){
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
		//System.out.println("Window closing");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	
}