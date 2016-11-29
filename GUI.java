import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
//import javax.swing.SwingUtilities;

public class GUI extends JFrame{	 
	public GUI(){
		
		super("Menu");		
		JMenuBar menuBar = new JMenuBar();		
		Container c = getContentPane();		
		c.setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850,650);
		setResizable(false);
		
		/*http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java  this sets the window to the
		 *center of the screen*/ 
	
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    	int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    	setLocation(x, y);
    	   	
    	JPanel title = new JPanel();
    	JLabel wel = new JLabel("Welcome to RPE");
    	title.setBackground(Color.WHITE);
    	wel.setFont(new Font("Sans Serif", Font.BOLD, 50));
    	wel.setForeground(Color.BLUE);
    	
    	JPanel center = new JPanel(new BorderLayout());
    	JLabel home = new JLabel("The Home of music entertainment");
    	center.setBackground(Color.WHITE);
    	home.setFont(new Font("Sans Serif", Font.PLAIN, 50));
    	home.setForeground(Color.BLUE); 	   	
    	add(title);
    	setLayout(new FlowLayout()); 	
    	title.add(wel); 
    	center.add(home, BorderLayout.CENTER);
  		add(center);
    	
 		JMenu FileMenu = new JMenu("Concert");
    	JMenuItem concerts = new JMenuItem("Add Concert");
    	FileMenu.add(concerts);
    	JMenuItem concertsTwo = new JMenuItem("Search Concert");
    	FileMenu.add(concertsTwo);
    	JMenuItem concertsThree = new JMenuItem("Remove Concert");
    	FileMenu.add(concertsThree);
    	concerts.addActionListener(new ActionHandler());
    	concertsTwo.addActionListener(new ActionHandler());
    	concertsThree.addActionListener(new ActionHandler());
    	menuBar.add(FileMenu);    		
    	
      	JMenu Cust = new JMenu("Register");
    	menuBar.add(Cust);
    	JMenuItem Reg = new JMenuItem("Add Customer");
    	Cust.add(Reg);
    	JMenuItem RegTwo = new JMenuItem("Remove Customer");
    	Cust.add(RegTwo);
    	Reg.addActionListener(new ActionHandler());
    	RegTwo.addActionListener(new ActionHandler());
    	
  		JMenu Purch = new JMenu("Tickets");
  		menuBar.add(Purch);
  		JMenuItem get = new JMenuItem("Purchase Ticket");
  		Purch.add(get);
  		JMenuItem getTwo = new JMenuItem("Cancel Ticket");
  		Purch.add(getTwo);
  		get.addActionListener(new ActionHandler());
  		getTwo.addActionListener(new ActionHandler());
  		setJMenuBar(menuBar);	
		
	}
	
	private class ActionHandler extends JFrame implements ActionListener{
			public void actionPerformed(ActionEvent e){
			ArrayList <Concert> Concerts = new ArrayList<Concert>();
			String item = e.getActionCommand();	
			JTextArea text;
				
			if(item.equals("Add Concert")){
				
				JFrame addWindow = new JFrame();
				this.setSize(600, 300);
				setLayout(new FlowLayout());
				this.setVisible(true);
				this.setTitle("Add a customer");
				this.setResizable(false);
				Font font = new Font("Sans Serif", Font.PLAIN, 25);
				
				JLabel label1 = new JLabel("Concert name: ");
				label1.setFont(font);
				this.add(label1);
				JTextField Cname = new JTextField(20);
				add(Cname);				
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    			setLocation(x, y);
				
				
				} 
				else if(item.equals("Search Concert")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 600);
					this.setVisible(true);
					this.setTitle("Search for customer");
					this.setResizable(false);
					//textarea.setText("Enter customer name: ");
					this.setLayout(new BorderLayout());
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
				}
				
				else if(item.equals("Remove Concert")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 600);
					this.setVisible(true);
					this.setTitle("Remove a  customer");
					this.setResizable(false);
					//textarea.setText("Enter customer name: ");
					this.setLayout(new BorderLayout());
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
					
				}	
					
				else if(item.equals("Add Customer")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 600);
					this.setVisible(true);
					this.setTitle("Add a Customer");
					this.setResizable(false);
					//textarea.setText("Enter customer name: ");
					this.setLayout(new BorderLayout());
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);	
					
				}
				
				else if(item.equals("Remove Customer")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 600);
					this.setVisible(true);
					this.setTitle("Remove a Customer");
					this.setResizable(false);
					//textarea.setText("Enter customer name: ");
					this.setLayout(new BorderLayout());
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);	
				}
				
				else if(item.equals("Purchase Ticket")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 600);
					this.setVisible(true);
					this.setTitle("Purchase a Ticket");
					this.setResizable(false);
					//textarea.setText("Enter customer name: ");
					this.setLayout(new BorderLayout());
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
				}
				
				else if(item.equals("Cancel Ticket")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 600);
					this.setVisible(true);
					this.setTitle("Cancel a Ticket");
					this.setResizable(false);
					//textarea.setText("Enter customer name: ");
					this.setLayout(new BorderLayout());
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
				}
			}
		}
	}
		
	
		
