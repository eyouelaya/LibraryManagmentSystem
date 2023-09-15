package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import business.SystemController;
import dataaccess.Auth;


public class LoginUI extends JFrame {
    public static final LoginUI INSTANCE = new LoginUI();
	
	private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;
	
	private JTextField username;
	private JTextField password;
	private JLabel label;
	private JButton loginButton;
	private JButton logoutButton;
	
	
	
	
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	private JTextField messageBar = new JTextField();
	public void clear() {
		messageBar.setText("");
	}
	

    public LoginUI() {
		init();
	}
    public void init() {     		
    		mainPanel = new JPanel();
    		defineUpperHalf();
    		BorderLayout bl = new BorderLayout();
    		bl.setVgap(30);
    		mainPanel.setLayout(bl);
    		mainPanel.add(upperHalf, BorderLayout.NORTH);
    		getContentPane().add(mainPanel);
    		isInitialized(true);
    		pack();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
			GuiProperties.centerFrameOnDesktop(this);

    	
    }
    private void defineUpperHalf() {
    		
    		upperHalf = new JPanel();
    		upperHalf.setLayout(new BorderLayout());
    		defineTopPanel();
    		defineMiddlePanel();
    		defineLowerPanel();
    		upperHalf.add(topPanel, BorderLayout.NORTH);
    		upperHalf.add(middlePanel, BorderLayout.CENTER);
    		upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    		
    	}

    	private void defineTopPanel() {
    		topPanel = new JPanel();
    		JPanel intPanel = new JPanel(new BorderLayout());
    		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
    		JLabel loginLabel = new JLabel("Login");
    		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
    		intPanel.add(loginLabel, BorderLayout.CENTER);
    		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    		topPanel.add(intPanel);
    		
    	}
    	
    	
    	
    	private void defineMiddlePanel() {
    		middlePanel=new JPanel();
    		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    		defineLeftTextPanel();
    		defineRightTextPanel();
    		middlePanel.add(leftTextPanel);
    		middlePanel.add(rightTextPanel);
    	}
    	private void defineLowerPanel() {
    		lowerPanel = new JPanel();
    		loginButton = new JButton("Login");
    		addLoginButtonListener(loginButton);
    		lowerPanel.add(loginButton);
    	}
    	private void defineLeftTextPanel() {
    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
    		bottomText.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
    		
    		username = new JTextField(10);
    		label = new JLabel("Username");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		topText.add(username);
    		bottomText.add(label);
    		
    		leftTextPanel = new JPanel();
    		leftTextPanel.setLayout(new BorderLayout());
    		leftTextPanel.add(topText,BorderLayout.NORTH);
    		leftTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	private void defineRightTextPanel() {
    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
    		
    		password = new JPasswordField(10);
    		label = new JLabel("Password");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		topText.add(password);
    		bottomText.add(label);
    		
    		rightTextPanel = new JPanel();
    		rightTextPanel.setLayout(new BorderLayout());
    		rightTextPanel.add(topText,BorderLayout.NORTH);
    		rightTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	
    	public void displayLoginError() {
			JOptionPane.showMessageDialog(LoginUI.this, "Login Error");

		}

		public void login(Auth role) {
		MainView mainView = new MainView(role);
		mainView.setVisible(true);
	}
    	private void addLoginButtonListener(JButton butn) {
    		butn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String passInput = password.getText();
					String id = username.getText();
					int integerId;
					try {
						integerId = Integer.parseInt(id);
						if (!(passInput.isEmpty() && id.isEmpty()))
							SystemController.getInstance().login(integerId, passInput, LoginUI.this);
					} catch (NumberFormatException err) {
						JOptionPane.showMessageDialog(LoginUI.this, "Invalid id or password");
					}
				}
			});
    	}
	
        
    
}
