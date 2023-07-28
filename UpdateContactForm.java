import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
public class UpdateContactForm extends JFrame{
	
	private JLabel titleLabel;
	private JButton updateButton;
	private JButton cancelButton;
	private JButton backToHomeButton;
	private JButton searchButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel phoneNumberLabel;
	private JLabel companyNameLabel;
	private JLabel salaryLabel;
	private JLabel birthDayLabel;
	
	private JLabel genIdLabel;
	private JTextField updateNameText;
	private JTextField updateTpText;
	private JTextField updateCompanyText;
	private JTextField updateSalaryText;
	private JTextField updateBirthDayText;
	
	
	private JTextField searchText;
	
	public UpdateContactForm(){
		setSize(725,735);
		setTitle("Update Contact Form ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(725, 100));
		titlePanel.setBackground(new Color(204,231,232));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("Update Contact ");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel detailPanel=new JPanel(new GridLayout(9,1));
		detailPanel.setPreferredSize(new Dimension(725,635));
		detailPanel.setLayout(null);
		
		searchText=new JTextField(15);
		searchText.setFont(new Font("",0,25));
		searchText.setBounds(37,18,380,38);
		searchText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String search=searchText.getText();
				int i=ContactController.searchContact(search);
				if(i!=-1){
					genIdLabel.setText(ContactController.getC(i).getID());
					updateNameText.setText(ContactController.getC(i).getName());
					updateTpText.setText(ContactController.getC(i).getphoneNumber());
					updateCompanyText.setText(ContactController.getC(i).getcompanyName());
					updateSalaryText.setText(Double.toString(ContactController.getC(i).getSalary()));
					updateBirthDayText.setText(ContactController.getC(i).getbirthDay());
				}else{
					JOptionPane.showMessageDialog(null,"No Contact found for "+"\""+search+"\".....");
					searchText.setText("");
					return;
				}
			}
		});
		detailPanel.add(searchText);
		
		searchButton=new JButton("Search");
		searchButton.setFont(new Font("",1,25));
		searchButton.setBounds(450,18,150,38);
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String search=searchText.getText();
				int i=ContactController.searchContact(search);
				if(i!=-1){
					genIdLabel.setText(ContactController.getC(i).getID());
					updateNameText.setText(ContactController.getC(i).getName());
					updateTpText.setText(ContactController.getC(i).getphoneNumber());
					updateCompanyText.setText(ContactController.getC(i).getcompanyName());
					updateSalaryText.setText(Double.toString(ContactController.getC(i).getSalary()));
					updateBirthDayText.setText(ContactController.getC(i).getbirthDay());
				}else{
					JOptionPane.showMessageDialog(null,"No Contact found for "+"\""+search+"\".....");
					searchText.setText("");
					return;
				}
			}
		});
		detailPanel.add(searchButton);
		
		idLabel=new JLabel("Contact ID ");
		idLabel.setFont(new Font("",1,25));
		idLabel.setBounds(37,70,250,55);
		detailPanel.add(idLabel);
		
		nameLabel=new JLabel("Name");
		nameLabel.setFont(new Font("",1,25));
		nameLabel.setBounds(37,120,250,55);
		detailPanel.add(nameLabel);
		
		phoneNumberLabel=new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("",1,25));
		phoneNumberLabel.setBounds(37,180,250,55);
		detailPanel.add(phoneNumberLabel);
		
		companyNameLabel=new JLabel("Company Name");
		companyNameLabel.setFont(new Font("",1,25));
		companyNameLabel.setBounds(37,250,250,55);
		detailPanel.add(companyNameLabel);
		
		salaryLabel=new JLabel("Salary");
		salaryLabel.setFont(new Font("",1,25));
		salaryLabel.setBounds(37,315,250,55);
		detailPanel.add(salaryLabel);
		
		birthDayLabel=new JLabel("B'Day(YYYY-MM-DD)");
		birthDayLabel.setFont(new Font("",1,25));
		birthDayLabel.setBounds(37,380,250,55);
		detailPanel.add(birthDayLabel);
		
		genIdLabel=new JLabel("0");
		genIdLabel.setFont(new Font("",1,26));
		genIdLabel.setBounds(347,75,250,55);
		detailPanel.add(genIdLabel);
		
		updateNameText=new JTextField(15);
		updateNameText.setFont(new Font("",0,25));
		updateNameText.setBounds(350,135,260,36);
		detailPanel.add(updateNameText);
		
		updateTpText=new JTextField(20);
		updateTpText.setFont(new Font("",0,25));
		updateTpText.setBounds(350,195,260,36);
		updateTpText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean tele=ContactController.readingphonenumber(updateTpText.getText());
				if(!tele){
					int a=JOptionPane.showConfirmDialog(null,"Invalid Number...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						updateTpText.setText("");
						updateTpText.requestFocus();
						return;
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						updateNameText.setText("");
						updateTpText.setText("");
						updateCompanyText.setText("");
						updateSalaryText.setText("");
						updateBirthDayText.setText("");
						return;
					}
				}
				return;
			}
		});
		detailPanel.add(updateTpText);
		
		updateCompanyText=new JTextField(10);
		updateCompanyText.setFont(new Font("",0,25));
		updateCompanyText.setBounds(350,260,260,36);
		detailPanel.add(updateCompanyText);
		
		updateSalaryText=new JTextField(10);
		updateSalaryText.setFont(new Font("",0,25));
		updateSalaryText.setBounds(350,325,260,36);
		updateSalaryText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean sala=ContactController.checkSalary(Double.parseDouble(updateSalaryText.getText()));
				if(sala){
					int a=JOptionPane.showConfirmDialog(null,"Invalid Salary...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						updateSalaryText.setText("");
						updateSalaryText.requestFocus();
						return;
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						updateNameText.setText("");
						updateTpText.setText("");
						updateCompanyText.setText("");
						updateSalaryText.setText("");
						updateBirthDayText.setText("");
						return;
					}
				}
				return;
			}
		});
		detailPanel.add(updateSalaryText);
		
		updateBirthDayText=new JTextField(10);
		updateBirthDayText.setFont(new Font("",0,25));
		updateBirthDayText.setBounds(350,390,260,36);
		updateBirthDayText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean dob=ContactController.birthDayValidate(updateBirthDayText.getText());
				if(!dob){
					int a=JOptionPane.showConfirmDialog(null,"Invalid Birthday...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						updateBirthDayText.setText("");
						updateBirthDayText.requestFocus();
						return;
					}else {
						dispose();
						ContactController.reduceCount();
						genIdLabel.setText(ContactController.genarateId());
						updateNameText.setText("");
						updateTpText.setText("");
						updateCompanyText.setText("");
						updateSalaryText.setText("");
						updateBirthDayText.setText("");
						return;
					}
				}
				return;
			}
		});
		detailPanel.add(updateBirthDayText);
		
		
		updateButton=new JButton("Update");
		updateButton.setFont(new Font("",1,24));
		updateButton.setBounds(350,450,180,36);
		updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
				String search=searchText.getText();
				int i=ContactController.searchContact(search);
				String name=updateNameText.getText();
				String phoneNumber="";
				boolean tele=ContactController.readingphonenumber(updateTpText.getText());
				if(tele){
					phoneNumber=updateTpText.getText();
				}else{
					int a=JOptionPane.showConfirmDialog(null,"Invalid Number...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						updateTpText.setText("");
						updateTpText.requestFocus();
						return;
					}else {
						dispose();
						searchText.setText("");
						genIdLabel.setText("");
						updateNameText.setText("");
						updateTpText.setText("");
						updateCompanyText.setText("");
						updateSalaryText.setText("");
						updateBirthDayText.setText("");
						return;
					}
				}
				String companyName=updateCompanyText.getText();
				double salary=0.0;
				boolean sala=ContactController.checkSalary(Double.parseDouble(updateSalaryText.getText()));
				if(!sala){
					salary=Double.parseDouble(updateSalaryText.getText());
				}else{
					int a=JOptionPane.showConfirmDialog(null,"Invalid Salary...Do You want add again ?", "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if(a==JOptionPane.YES_OPTION){
						updateSalaryText.setText("");
						updateSalaryText.requestFocus();
						return;
					}else {
						dispose();
						searchText.setText("");
						genIdLabel.setText("");
						updateNameText.setText("");
						updateTpText.setText("");
						updateCompanyText.setText("");
						updateSalaryText.setText("");
						updateBirthDayText.setText("");
						return;
					}
				}
				boolean isUpdated=ContactController.updateContact(name,phoneNumber,companyName,salary,i);
				if(isUpdated){
					JOptionPane.showMessageDialog(null,"Update Success");
					searchText.setText("");
					genIdLabel.setText("");
					updateNameText.setText("");
						updateTpText.setText("");
						updateCompanyText.setText("");
						updateSalaryText.setText("");
						updateBirthDayText.setText("");
					return;
				}
			}catch(StringIndexOutOfBoundsException ex){
				JOptionPane.showMessageDialog(null,"Empty Slots..Complete the Fields");
				searchText.requestFocus();
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Update the feilds first...");
				searchText.requestFocus();
			}
			}
		});
		detailPanel.add(updateButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setFont(new Font("",1,24));
		cancelButton.setBounds(550,450,130,36);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchText.setText("");
				genIdLabel.setText("");
				updateNameText.setText("");
				updateTpText.setText("");
				updateCompanyText.setText("");
				updateSalaryText.setText("");
				updateBirthDayText.setText("");
				return;
			}
		});
		detailPanel.add(cancelButton); 
		
		backToHomeButton=new JButton("Back To HomePage");
		backToHomeButton.setFont(new Font("",1,24));
		backToHomeButton.setBounds(350,500,331,36);
		backToHomeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchText.setText("");
				dispose();
				
				genIdLabel.setText("");
				updateNameText.setText("");
				updateTpText.setText("");
				updateCompanyText.setText("");
				updateSalaryText.setText("");
				updateBirthDayText.setText("");
				return;
			}
		});
		detailPanel.add(backToHomeButton);
		
		add(detailPanel);
		
	
	}
	public static void main(String args[]){
		new UpdateContactForm().setVisible(true);
	}	

}
