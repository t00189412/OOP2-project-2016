import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame{

		static ArrayList <Concert> Concerts = new ArrayList<Concert>();
		static ArrayList <Register> Customers = new ArrayList<Register>();
		static ArrayList <Purchase> Quantity = new ArrayList<Purchase>();
	
		 
	public GUI(){
		
		super("Menu");		
		JMenuBar menuBar = new JMenuBar();		
		Container c = getContentPane();
		c.setBackground(Color.BLACK);
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
    	title.setBackground(Color.blue);
    	wel.setFont(new Font("Sans Serif", Font.BOLD, 50));
    	wel.setForeground(Color.yellow);
    	
    	JPanel center = new JPanel(new BorderLayout());
    	JLabel home = new JLabel("The Home of music entertainment");
    	center.setBackground(Color.blue);
    	home.setFont(new Font("Sans Serif", Font.PLAIN, 50));
    	home.setForeground(Color.yellow);
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


        JMenu Tools = new JMenu("Tools");
        menuBar.add(Tools);
        JMenuItem save = new JMenuItem("Save");
        Tools.add(save);
        setJMenuBar(menuBar);
        save.addActionListener(new ActionHandler());
	}

	private class ActionHandler extends JFrame implements ActionListener{
			public void actionPerformed(ActionEvent e){
		
			String item = e.getActionCommand();	
			String text = "";

                if(item.equals("Save")){
                    // TODO: do that in writeA class.
                    try {
                        writeA(Concerts, Customers, Quantity);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
					JOptionPane.showMessageDialog(null, "Save Successful");
                }

                else if(item.equals("Add Concert")){
				
				JFrame addWindow = new JFrame();
				this.setSize(500, 350);
				setLayout(new FlowLayout());
				this.setVisible(true);
				this.setTitle("Add a concert");
				this.setResizable(false);
				Font font = new Font("Sans Serif", Font.PLAIN, 25);
				
				
				JLabel Conname = new JLabel("Concert name:   ");
				Conname.setFont(font);
				this.add(Conname);
				JTextField Cname = new JTextField(20);
				this.add(Cname);
				JLabel Contype = new JLabel("Concert type:   ");
				JTextField Ctype = new JTextField(20);
				this.add(Contype);
				this.add(Ctype);
				Contype.setFont(font);
				JLabel Convenue = new JLabel("Concert Venue:  ");
				JTextField venue = new JTextField(20);
				this.add(Convenue);
				this.add(venue);
				Convenue.setFont(font);
				JLabel Capacity = new JLabel("Concert Capacity:   ");
				JTextField cap = new JTextField(17);
				this.add(Capacity);
				this.add(cap);	
				Capacity.setFont(font);
				JLabel date = new JLabel("Concert Date:   ");
				JTextField when = new JTextField(20);
				this.add(date);
				this.add(when);	
				date.setFont(font);
				JButton subCon = new JButton("Submit");	
				subCon.setPreferredSize(new Dimension(100, 60));
				this.add(subCon);
				subCon.addActionListener(new ActionHandler(){
					public void actionPerformed(ActionEvent e){
					
					Concert thisConcert = new Concert(Cname.getText(), Ctype.getText(), venue.getText(), when.getText(), cap.getText());	
					
					Concerts.add(thisConcert);
					
					//String text = (Cname.getText() + Ctype.getText() + venue.getText() + when.getText() + cap.getText());
					
					JOptionPane.showMessageDialog(null,"You have added a Concert!","New Concert",JOptionPane.PLAIN_MESSAGE);
					}
					});		
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    			setLocation(x, y);
				
				
				} 
				else if(item.equals("Search Concert")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(700, 275);
					setLayout(new FlowLayout());
					this.setVisible(true);
					this.setTitle("Search for customer");
					this.setResizable(false);
					Font font = new Font("Sans Serif", Font.PLAIN, 25);
					JLabel Conname = new JLabel("Please enter the concert name: ");
					JTextField name = new JTextField(20);
					Conname.setFont(font);
					this.add(Conname);
					this.add(name); 
					JLabel Condate = new JLabel("Please enter the concert date: ");
					JTextField date = new JTextField(23);
					Condate.setFont(font);
					this.add(Condate);
					this.add(date);
					JButton subS = new JButton("Submit");	
					subS.setPreferredSize(new Dimension(100, 60));
					this.add(subS);
					subS.addActionListener(new ActionHandler(){
						public void actionPerformed(ActionEvent e){
							
							String conName = name.getText();
							String dateStr = date.getText();
							
							for(int i=0;i<Concerts.size();i++)
							{
							   	Concert aConcert = Concerts.get(i);
							   	
							   	if(aConcert.getname().equals(conName) && aConcert.getdate().equals(dateStr))
							   	{
							   		JOptionPane.showMessageDialog(null, aConcert, "Results", JOptionPane.PLAIN_MESSAGE);
							   		break;
							   	}
							}
							
							
							//JOptionPane
							}
						}
					);
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
				}
				
				else if(item.equals("Remove Concert")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(600, 200);
					this.setVisible(true);
					this.setTitle("Remove a concert");
					this.setResizable(false);
					setLayout(new FlowLayout());
					JLabel removeCon = new JLabel("Please enter the concert name: ");
					JTextField remove= new JTextField(20);
					Font font = new Font("Sans Serif", Font.PLAIN, 25);
					removeCon.setFont(font);
					this.add(removeCon);
					this.add(remove);
					JButton removeButton = new JButton("Remove");					
					removeButton.setFont(font);					
					this.add(removeButton);
					removeButton.addActionListener(new ActionHandler(){
						public void actionPerformed(ActionEvent e){
							
							String ConName = remove.getText();
							
							for(int i = 0;i < Concerts.size();i++){
							Concert rConcert = Concerts.get(i);
							
							if(rConcert.getname().equals(ConName)){
								
								Concerts.remove(i);
								JOptionPane.showMessageDialog(null,"You have removed a concert!", "Concert Removed",JOptionPane.PLAIN_MESSAGE);
								break; 
								}		
							}
								
						}
						
						
					});
										
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
					
				}	
					
				else if(item.equals("Add Customer")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(700, 300);
					this.setVisible(true);
					this.setTitle("Add a Customer");
					this.setResizable(false);
					setLayout(new FlowLayout());
					JLabel addCust = new JLabel("Customer's name: ");
					JTextField add = new JTextField(20);
					Font font = new Font("Sans Serif", Font.PLAIN, 25);
					this.add(addCust);
					this.add(add);
					addCust.setFont(font);
					add.setFont(font);
					JLabel AddDob = new JLabel("Customer's DOB: ");
					JTextField DOB = new JTextField(20);
					this.add(AddDob);
					this.add(DOB);
					AddDob.setFont(font);
					DOB.setFont(font);
					JLabel Addaddress = new JLabel("Customer's Address: ");
					JTextField Address = new JTextField(17);
					this.add(Addaddress);
					this.add(Address);
					Addaddress.setFont(font);
					Address.setFont(font);
					JButton addButton = new JButton("Register");
					addButton.setFont(font);
					this.add(addButton);
					addButton.addActionListener(new ActionHandler(){
						public void actionPerformed(ActionEvent e){
							
							
							String name = add.getText();
							String birth = DOB.getText();
							String living = Address.getText();
							
							Register nCust = new Register(name, birth, living);
							
							Customers.add(nCust);
							JOptionPane.showMessageDialog(null,nCust,"Customer registered!",JOptionPane.PLAIN_MESSAGE);
							 
						}
					
					});
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);	
					
				}
				
				else if(item.equals("Remove Customer")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(950, 250);
					this.setVisible(true);
					this.setTitle("Remove a Customer");
					setLayout(new FlowLayout());
					JLabel removeCust = new JLabel("Please enter the customer's name: ");
					JTextField remove = new JTextField(20);
					Font font = new Font("Sans Serif", Font.PLAIN, 25);
					removeCust.setFont(font);
					remove.setFont(font);
					this.add(removeCust);
					this.add(remove);
					JLabel removeAddress = new JLabel("Please enter the customer's address: ");
					JTextField removeAdd = new JTextField(20);
					removeAddress.setFont(font);
					removeAdd.setFont(font);
					this.add(removeAddress);
					this.add(removeAdd);
					JButton RemoveButton = new JButton("Remove");
					RemoveButton.setFont(font);
					this.add(RemoveButton);
					RemoveButton.addActionListener(new ActionHandler(){
						public void actionPerformed(ActionEvent e){
							
							String Custname = remove.getText();
							String address = removeAdd.getText();
							
							for(int i=0;i<Customers.size();i++)
							{
								
							   	Register aCustomer = Customers.get(i);
							   	
							   	if(aCustomer.getname().equals(Custname) && aCustomer.getaddress().equals(address))
							   	{
							   		Customers.remove(i);
							   		JOptionPane.showMessageDialog(null, "You have removed a customer!", "Customer Removed", JOptionPane.PLAIN_MESSAGE);
							   		break;
							   	}
							}
							
						}	
					});
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);	
				}
				
				else if(item.equals("Purchase Ticket")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(950, 225);
					this.setVisible(true);
					this.setTitle("Purchase a Ticket");
					setLayout(new FlowLayout());
					this.setResizable(false);
					JLabel BuyTic = new JLabel("Please enter the Concert name: ");
					JTextField BuyTicket = new JTextField(20);
					Font font = new Font("Sans Serif", Font.PLAIN, 25);
					BuyTic.setFont(font);
					BuyTicket.setFont(font);
					this.add(BuyTic);
					this.add(BuyTicket);
					JLabel TicQuan= new JLabel("Please enter the Number of tickets: ");
					JTextField TicketQuan = new JTextField(20);
					TicQuan.setFont(font);
					TicketQuan.setFont(font);
					this.add(TicQuan);
					this.add(TicketQuan);
					JButton purcButton = new JButton("Purchase");
					this.add(purcButton);
					purcButton.addActionListener(new ActionHandler(){
						public void actionPerformed(ActionEvent e){
							
							String name = BuyTicket.getText();
							String Quant = TicketQuan.getText();
								
							Purchase bought = new Purchase(name, Quant);
							Quantity.add(bought);
							JOptionPane.showMessageDialog(null,bought,"Tickets purchased!",JOptionPane.PLAIN_MESSAGE);
							
						}
						
					});
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
				}
				
				else if(item.equals("Cancel Ticket")){
					
					JFrame searchWindow = new JFrame();	
					this.setSize(925, 225);
					this.setVisible(true);
					this.setTitle("Cancel a Ticket");
					this.setResizable(false);
					setLayout(new FlowLayout());
					JLabel CanTic = new JLabel("Please enter the Concert name: ");
					JTextField CancelTicket = new JTextField(20);
					Font font = new Font("Sans Serif", Font.PLAIN, 25);
					CanTic.setFont(font);
					CancelTicket.setFont(font);
					this.add(CanTic);
					this.add(CancelTicket);
					JLabel QuanTic = new JLabel("Please enter the number of tickets you purchased: ");
					JTextField QuanTicket = new JTextField(15);
					QuanTic.setFont(font);
					QuanTicket.setFont(font);
					this.add(QuanTic);
					this.add(QuanTicket);
					JButton CanButton = new JButton("Refund");
					this.add(CanButton);
					CanButton.addActionListener(new ActionHandler(){
						public void actionPerformed(ActionEvent e){
							
							//String Quant = QuanTicket.getText();
							String name = CancelTicket.getText();
							
							for(int i=0; i<Quantity.size();i++){
								
								Purchase purch = Quantity.get(i);
								
								if(purch.getConcertName().equals(name)){
									
									Quantity.remove(i);
									JOptionPane.showMessageDialog(null,"You Cancelled tickets!", "Tickets cancelled",JOptionPane.PLAIN_MESSAGE);
									break;
								}
							} 	
						}		
					});
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    			int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    			int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    			setLocation(x, y);
				}
			}
		}
		
		
	    public static void writeA(ArrayList <Concert> Concerts, ArrayList <Register> Customers, ArrayList <Purchase> Quantity) throws Exception{


			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Project/project.dat"));
			oos.writeObject(Concerts);
			oos.writeObject(Customers);
			oos.writeObject(Quantity);
			oos.close();
	    }
		
		public static void readA()throws Exception{
	
	try{
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("project.dat"));

		
		Concerts= (ArrayList<Concert>) ois.readObject();
		Customers= (ArrayList<Register>)ois.readObject();
		Quantity= (ArrayList<Purchase>) ois.readObject();


		ois.close();


	}
	catch(FileNotFoundException e){
		
		JOptionPane.showMessageDialog(null,"File not found!","Problem",JOptionPane.PLAIN_MESSAGE);
        e.printStackTrace();
	}

	catch(Exception e){

        JOptionPane.showMessageDialog(null,"Could not open!");
        e.printStackTrace();
    }
	
	
		}
	}

		
	
		
