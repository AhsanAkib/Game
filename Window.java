import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Window extends Frame implements WindowListener{
	
	public static final int WIDTH = 307, HEIGHT = 630;
	private JFrame window;
	private Board board; 
	public Frame parent; 
	private boolean startGame;
	public mainMenu First; 
	//public Login log;
	
	public Window(mainMenu obj){
		First=obj; 
		startGame=false;
		window = new JFrame("Play!");
		
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(false);	
	}
	
	
	public void startGameF(boolean strCheck){ 
	
	startGame=strCheck;           //  true Boolean value starts the game //
		
		if(startGame == true){ 
		
		board = new Board();
		
		window.add(board);
		window.addKeyListener(board);
		
		window.setVisible(true); 
		
		}
		
	}
	
	
	public void setParent(Frame f){parent=f;} 
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		//this.setVisible(false);
		System.exit(0);
		System.out.println("Window closing..");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
}
