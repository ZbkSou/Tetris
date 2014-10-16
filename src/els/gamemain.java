package els;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.*;
class gameFrame extends JFrame{
	public  gameFrame (){
		gameWin p1 = new gameWin ();
		add (p1);
		//p1.paintcomponent(g);
		this.setTitle("¶íÂÞË¹·½¿é");
		this.setBounds(80, 80, 380, 420);
		this.setVisible(true);
		this.setResizable(false);	
	}
	
}
public class gamemain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gameFrame a = new gameFrame();
	}

}
