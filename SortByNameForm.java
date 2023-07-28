import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class SortByNameForm extends JFrame {
	private JLabel titleLabel;
	private JTable contactTable;
	private DefaultTableModel dtm;

	public SortByNameForm() {
		setSize(900, 600);
		setTitle("Contacts List");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(900, 100));
		titlePanel.setBackground(new Color(204,231,232));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("LIST CONTACTS BY NAME");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);

		String[] columnNames = {"Contact ID", "Name", "Contact Number", "Company Name", "Salary", "BirthDay"};
		dtm = new DefaultTableModel(columnNames, 0);
		contactTable = new JTable(dtm);
		JPanel panel=new JPanel();
		JScrollPane tablePane = new JScrollPane(contactTable);
		getContentPane().add("Center", tablePane);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				try {
					ContactList contactList = DBConnection.getInstance().getContactList();
					Node temp = contactList.getFirst();

					while (temp != null) {
						ContactController.sortName();
						Contacts contacts = temp.getContacts();
						Object[] rowData = {contacts.getID(), contacts.getName(), contacts.getphoneNumber(), contacts.getcompanyName(), contacts.getSalary(), contacts.getbirthDay()};
						dtm.addRow(rowData);
						temp = temp.getNext();
					}
				} catch (NullPointerException ex) {
				   JOptionPane.showMessageDialog(null, "No Information..");
				}
			}
		});
	}
}
