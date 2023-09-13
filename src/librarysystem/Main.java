package librarysystem;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class Main {

	public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
			  @Override
			  public void run() {
				  new LoginWindow().setVisible(true);
			  }
		  });
	   }
	   

}
