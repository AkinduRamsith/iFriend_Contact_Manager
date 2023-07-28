public class DBConnection{
	private ContactList contactList;
	private static DBConnection dbConnection;
	private DBConnection(){
		contactList=new ContactList();
	}
	public static DBConnection getInstance(){
		if(dbConnection==null){
			dbConnection=new DBConnection();
		}
		return dbConnection;
	}
	public ContactList getContactList(){
		return contactList;
	}
}
