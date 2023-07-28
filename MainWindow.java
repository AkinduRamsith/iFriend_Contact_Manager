import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
public class MainWindow extends JFrame{
	
	private JLabel titleLabel;
	private JButton btnaddContactFrom;
	private JButton btnupdateContactFrom;
	private JButton btndeleteContactFrom;
	private JButton btnsearchContactFrom;
	private JButton btnviewContactFrom;
	private JButton btnExit;
	private JLabel iFriendLabel;
	private JLabel contactLabel;
	private JLabel homeLabel;
	
	private AddContactForm addContactForm;
	private UpdateContactForm updateContactForm;
	private SearchContactForm searchContactForm;
	private DeleteContactForm deleteContactForm;
	private SortContactForm sortContactForm;
	
	public MainWindow(){
		setSize(950,600);
		setTitle("iFriend Contact Organizer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		 setLayout(new BorderLayout());
		
		JPanel westPanel=new JPanel(null);
		 westPanel.setPreferredSize(new Dimension(400, 600));
		//~ westPanel.setLayout(null);
		iFriendLabel=new JLabel("iFRIEND");
		iFriendLabel.setFont(new Font("",1,40));
		iFriendLabel.setBounds(50,0,300,100);
		 iFriendLabel.setHorizontalAlignment(SwingConstants.CENTER);
		westPanel.add("Center",iFriendLabel);
		
		contactLabel =new JLabel("Contact Manager");
		contactLabel.setFont(new Font("",1,36));
		contactLabel.setBounds(10,50,380,130);
		contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		westPanel.add("Center",contactLabel);
		
		
		 add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel=new JPanel(null){
			
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawLine(40, 105, 510, 105);
			}
			};
		 eastPanel.setPreferredSize(new Dimension(550, 600));
		 eastPanel.setBackground(new Color(204,231,232));
		//~ eastPanel.setLayout(null);
		homeLabel=new JLabel("Home Page");
		homeLabel.setFont(new Font("",1,40));
		homeLabel.setBounds(100,25,380,70);
		 homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eastPanel.add(homeLabel);
		
		btnaddContactFrom=new JButton("Add Contacts");
		btnaddContactFrom.setFont(new Font("",1,21));
		btnaddContactFrom.setBounds(140,140,300,32);
		btnaddContactFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContactForm==null){
					addContactForm=new AddContactForm();
				}
				
				addContactForm.setVisible(true);
			}
		});
		eastPanel.add(btnaddContactFrom);
		
			
		btnupdateContactFrom=new JButton("Update Contacts");
		btnupdateContactFrom.setFont(new Font("",1,21));
		btnupdateContactFrom.setBounds(140,200,300,32);
		btnupdateContactFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateContactForm==null){
					updateContactForm=new UpdateContactForm();
				}
				
				updateContactForm.setVisible(true);
				//~ new UpdateContactForm().setVisible(true);
			}
		});
		eastPanel.add(btnupdateContactFrom);
		
		
		btndeleteContactFrom=new JButton("Delete Contacts");
		btndeleteContactFrom.setFont(new Font("",1,21));
		btndeleteContactFrom.setBounds(140,260,300,32);
		btndeleteContactFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deleteContactForm==null){
					deleteContactForm=new DeleteContactForm();
				}
				
				deleteContactForm.setVisible(true);
				
				//~ new DeleteContactForm().setVisible(true);
			}
		});
		eastPanel.add(btndeleteContactFrom);
		
		
		btnsearchContactFrom=new JButton("Search Contacts");
		btnsearchContactFrom.setFont(new Font("",1,21));
		btnsearchContactFrom.setBounds(140,320,300,32);
		btnsearchContactFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			if(searchContactForm==null){
					searchContactForm=new SearchContactForm();
				}
				
				searchContactForm.setVisible(true);
				//~ new SearchContactForm().setVisible(true);
			}
		});
		eastPanel.add(btnsearchContactFrom);
		
		
		btnviewContactFrom=new JButton("View Contacts");
		btnviewContactFrom.setFont(new Font("",1,21));
		btnviewContactFrom.setBounds(140,380,300,32);
		btnviewContactFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortContactForm==null){
					sortContactForm=new SortContactForm();
				}
				
				sortContactForm.setVisible(true);
				//~ new SortContactForm().setVisible(true);
			}
		});
		eastPanel.add(btnviewContactFrom);
		
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,21));
		btnExit.setBounds(400,480,100,32);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		eastPanel.add(btnExit);
		
		 add(eastPanel, BorderLayout.EAST);
	
	}
	public static void main(String args[]){
		new MainWindow().setVisible(true);
	}	

}
