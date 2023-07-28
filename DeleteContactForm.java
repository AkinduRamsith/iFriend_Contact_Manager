import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
public class DeleteContactForm extends JFrame{
	
	private JLabel titleLabel;
	private JButton deleteButton;
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
	private JLabel searchNameLabel;
	private JLabel searchTpLabel;
	private JLabel searchCompanyLabel;
	private JLabel searchSalaryLabel;
	private JLabel searchBirthDayLabel;
	
	private JTextField searchText;
	
	public DeleteContactForm(){
		setSize(725,735);
		setTitle("Delete Contact Form ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(725, 100));
		titlePanel.setBackground(new Color(204,231,232));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("Delete Contact ");
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
					searchNameLabel.setText(ContactController.getC(i).getName());
					searchTpLabel.setText(ContactController.getC(i).getphoneNumber());
					searchCompanyLabel.setText(ContactController.getC(i).getcompanyName());
					searchSalaryLabel.setText(Double.toString(ContactController.getC(i).getSalary()));
					searchBirthDayLabel.setText(ContactController.getC(i).getbirthDay());
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
					searchNameLabel.setText(ContactController.getC(i).getName());
					searchTpLabel.setText(ContactController.getC(i).getphoneNumber());
					searchCompanyLabel.setText(ContactController.getC(i).getcompanyName());
					searchSalaryLabel.setText(Double.toString(ContactController.getC(i).getSalary()));
					searchBirthDayLabel.setText(ContactController.getC(i).getbirthDay());
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
		
		searchNameLabel=new JLabel();
		searchNameLabel.setFont(new Font("",0,25));
		searchNameLabel.setBounds(350,135,260,36);
		detailPanel.add(searchNameLabel);
		
		searchTpLabel=new JLabel();
		searchTpLabel.setFont(new Font("",0,25));
		searchTpLabel.setBounds(350,195,260,36);
		detailPanel.add(searchTpLabel);
		
		searchCompanyLabel=new JLabel();
		searchCompanyLabel.setFont(new Font("",0,25));
		searchCompanyLabel.setBounds(350,260,260,36);
		detailPanel.add(searchCompanyLabel);
		
		searchSalaryLabel=new JLabel();
		searchSalaryLabel.setFont(new Font("",0,25));
		searchSalaryLabel.setBounds(350,325,260,36);
		detailPanel.add(searchSalaryLabel);
		
		searchBirthDayLabel=new JLabel();
		searchBirthDayLabel.setFont(new Font("",0,25));
		searchBirthDayLabel.setBounds(350,390,260,36);
		detailPanel.add(searchBirthDayLabel);
		
		
		deleteButton=new JButton("Delete");
		deleteButton.setFont(new Font("",1,24));
		deleteButton.setBounds(350,450,180,36);
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String search=searchText.getText();
				int i=ContactController.searchContact(search);
				
				if(searchText.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Empty...");
					}else{
						int a=JOptionPane.showConfirmDialog(null,"Do you want to delete the Contact ?","Confirmation", JOptionPane.YES_NO_OPTION);
						if(a==JOptionPane.YES_OPTION){
						ContactController.deleteContact(i);
						JOptionPane.showMessageDialog(null,"Delete Success...");
						searchText.setText("");
						genIdLabel.setText("");
						searchNameLabel.setText("");
						searchTpLabel.setText("");
						searchCompanyLabel.setText("");
						searchSalaryLabel.setText("");
						searchBirthDayLabel.setText("");
						return; 
					
					
					}
						
						}
			}
		});
		detailPanel.add(deleteButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setFont(new Font("",1,24));
		cancelButton.setBounds(550,450,130,36);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactController.reduceCount();
				searchText.setText("");
				genIdLabel.setText("");
				searchNameLabel.setText("");
				searchTpLabel.setText("");
				searchCompanyLabel.setText("");
				searchSalaryLabel.setText("");
				searchBirthDayLabel.setText("");
				return;
			}
		});
		detailPanel.add(cancelButton); 
		
		backToHomeButton=new JButton("Back To HomePage");
		backToHomeButton.setFont(new Font("",1,24));
		backToHomeButton.setBounds(350,500,331,36);
		backToHomeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				ContactController.reduceCount();
				searchText.setText("");
				genIdLabel.setText("");
				searchNameLabel.setText("");
				searchTpLabel.setText("");
				searchCompanyLabel.setText("");
				searchSalaryLabel.setText("");
				searchBirthDayLabel.setText("");
				return;
			}
		});
		detailPanel.add(backToHomeButton);
		
		add(detailPanel);
		
	
	}
	public static void main(String args[]){
		new DeleteContactForm().setVisible(true);
	}	

}
