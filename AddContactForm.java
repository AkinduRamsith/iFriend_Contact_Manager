import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
public class AddContactForm extends JFrame{
	
	private JLabel titleLabel;
	private JButton addButton;
	private JButton cancelButton;
	private JButton backToHomeButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel phoneNumberLabel;
	private JLabel companyNameLabel;
	private JLabel salaryLabel;
	private JLabel birthDayLabel;
	
	private JLabel genIdLabel;
	
	private JTextField nameText;
	private JTextField phoneNumberText;
	private JTextField companyNameText;
	private JTextField salaryText;
	private JTextField birthDayText;
	
	public AddContactForm(){
		setSize(725,735);
		setTitle("Add Contact Form ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(725, 100));
		titlePanel.setBackground(new Color(204,231,232));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("Add Contact ");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel detailPanel=new JPanel(new GridLayout(8,1));
		detailPanel.setPreferredSize(new Dimension(725,635));
		detailPanel.setLayout(null);
		
		idLabel=new JLabel("Contact ID -");
		idLabel.setFont(new Font("",1,26));
		idLabel.setBounds(24,18,200,45);
		detailPanel.add(idLabel);
		
		nameLabel=new JLabel("Name");
		nameLabel.setFont(new Font("",0,25));
		nameLabel.setBounds(37,80,250,55);
		detailPanel.add(nameLabel);
		
		phoneNumberLabel=new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("",0,25));
		phoneNumberLabel.setBounds(37,145,250,55);
		detailPanel.add(phoneNumberLabel);
		
		companyNameLabel=new JLabel("Company Name");
		companyNameLabel.setFont(new Font("",0,25));
		companyNameLabel.setBounds(37,210,250,55);
		detailPanel.add(companyNameLabel);
		
		salaryLabel=new JLabel("Salary");
		salaryLabel.setFont(new Font("",0,25));
		salaryLabel.setBounds(37,275,250,55);
		detailPanel.add(salaryLabel);
		
		birthDayLabel=new JLabel("B'Day(YYYY-MM-DD)");
		birthDayLabel.setFont(new Font("",0,25));
		birthDayLabel.setBounds(37,340,250,55);
		detailPanel.add(birthDayLabel);
		
		genIdLabel=new JLabel("0");
		genIdLabel.setFont(new Font("",1,26));
		genIdLabel.setBounds(180,18,200,45);
		genIdLabel.setText(ContactController.genarateId());
		detailPanel.add(genIdLabel);
		
		nameText=new JTextField(15);
		nameText.setFont(new Font("",0,25));
		nameText.setBounds(350,95,260,36);
		detailPanel.add(nameText);
		
		phoneNumberText=new JTextField(20);
		phoneNumberText.setFont(new Font("",0,25));
		phoneNumberText.setBounds(350,155,260,36);
		phoneNumberText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean tele=ContactController.readingphonenumber(phoneNumberText.getText());
				if(!tele){
					int a=JOptionPane.showConfirmDialog(null,"Invalid Number...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						phoneNumberText.setText("");
						phoneNumberText.requestFocus();
						return;
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						nameText.setText("");
						phoneNumberText.setText("");
						companyNameText.setText("");
						salaryText.setText("");
						birthDayText.setText("");
						return;
					}
				}
				return;
			}
		});
		detailPanel.add(phoneNumberText);
		
		companyNameText=new JTextField(10);
		companyNameText.setFont(new Font("",0,25));
		companyNameText.setBounds(350,220,260,36);
		detailPanel.add(companyNameText);
		
		salaryText=new JTextField(10);
		salaryText.setFont(new Font("",0,25));
		salaryText.setBounds(350,285,260,36);
		salaryText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean sala=ContactController.checkSalary(Double.parseDouble(salaryText.getText()));
				if(sala){
					int a=JOptionPane.showConfirmDialog(null,"Invalid Salary...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						salaryText.setText("");
						salaryText.requestFocus();
						return;
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						nameText.setText("");
						phoneNumberText.setText("");
						companyNameText.setText("");
						salaryText.setText("");
						birthDayText.setText("");
						return;
					}
				}
				return;
			}
		});
		detailPanel.add(salaryText);
		
		birthDayText=new JTextField(10);
		birthDayText.setFont(new Font("",0,25));
		birthDayText.setBounds(350,350,260,36);
		birthDayText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean dob=ContactController.birthDayValidate(birthDayText.getText());
				if(!dob){
					int a=JOptionPane.showConfirmDialog(null,"Invalid Birthday...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						birthDayText.setText("");
						birthDayText.requestFocus();
						return;
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						nameText.setText("");
						phoneNumberText.setText("");
						companyNameText.setText("");
						salaryText.setText("");
						birthDayText.setText("");
						return;
					}
				}
				return;
			}
		});
		detailPanel.add(birthDayText);
		
		
		addButton=new JButton("Add Contact");
		addButton.setFont(new Font("",1,24));
		addButton.setBounds(350,425,180,36);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
				String id=genIdLabel.getText();
				String name=nameText.getText();
				String phoneNumber="";
				boolean tele=ContactController.readingphonenumber(phoneNumberText.getText());
				if(tele){
					phoneNumber=phoneNumberText.getText();
				}else{
					int a=JOptionPane.showConfirmDialog(null,"Invalid Number...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						phoneNumberText.setText("");
						phoneNumberText.requestFocus();
						
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						nameText.setText("");
						phoneNumberText.setText("");
						companyNameText.setText("");
						salaryText.setText("");
						birthDayText.setText("");
						return;
					}
				}
				String companyName=companyNameText.getText();
				double salary=0.0;
				boolean sala=ContactController.checkSalary(Double.parseDouble(salaryText.getText()));
				if(!sala){
					salary=Double.parseDouble(salaryText.getText());
				}else{
					int a=JOptionPane.showConfirmDialog(null,"Invalid Salary...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						salaryText.setText("");
						salaryText.requestFocus();
						
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						nameText.setText("");
						phoneNumberText.setText("");
						companyNameText.setText("");
						salaryText.setText("");
						birthDayText.setText("");
						return;
					}
				}
				
				String birthDay="";
				boolean dob=ContactController.birthDayValidate(birthDayText.getText());
				if(dob){
					birthDay=birthDayText.getText();
				}else{
					int a=JOptionPane.showConfirmDialog(null,"Invalid Birthday...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						birthDayText.setText("");
						birthDayText.requestFocus();
						return;
					}else {
						
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						nameText.setText("");
						phoneNumberText.setText("");
						companyNameText.setText("");
						salaryText.setText("");
						birthDayText.setText("");
						dispose();
						return;
					}
				}
				
				Contacts contact=new Contacts(id,name,phoneNumber,companyName,salary,birthDay);
				boolean isAdded=ContactController.addContact(contact);
				if(isAdded){
					JOptionPane.showMessageDialog(null,"Added Success");
					genIdLabel.setText(ContactController.genarateId());
					nameText.setText("");
					phoneNumberText.setText("");
					companyNameText.setText("");
					salaryText.setText("");
					birthDayText.setText("");
					return;
				}
			}catch(StringIndexOutOfBoundsException ex){
				JOptionPane.showMessageDialog(null,"Empty Slots..Complete the Fields");
			}
			}
		});
		detailPanel.add(addButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setFont(new Font("",1,24));
		cancelButton.setBounds(550,425,130,36);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactController.reduceCount();
				genIdLabel.setText(ContactController.genarateId());
				nameText.setText("");
				phoneNumberText.setText("");
				companyNameText.setText("");
				salaryText.setText("");
				birthDayText.setText("");
				return;
			}
		});
		detailPanel.add(cancelButton); 
		
		backToHomeButton=new JButton("Back To HomePage");
		backToHomeButton.setFont(new Font("",1,24));
		backToHomeButton.setBounds(350,480,331,36);
		backToHomeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				ContactController.reduceCount();
				genIdLabel.setText(ContactController.genarateId());
				nameText.setText("");
				phoneNumberText.setText("");
				companyNameText.setText("");
				salaryText.setText("");
				birthDayText.setText("");
				return;
			}
		});
		detailPanel.add(backToHomeButton);
		
		add(detailPanel);
		
	
	}

}
