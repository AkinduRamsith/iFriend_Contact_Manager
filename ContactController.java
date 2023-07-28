import java.time.LocalDate;
public class ContactController{
	public static int count=1;
	public static boolean addContact(Contacts contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.add(contact);
		return true;
	}
	
	public static boolean readingphonenumber(String phonenumber){
		do{
		boolean phonenumbervalidate=isDuplicate(phonenumber);
				if(phonenumbervalidate){
					if(phonenumber.charAt(0)=='0'  && phonenumber.length()==10){
						return true;
					}else{
						return false;
					}
				}
			}while(true);
			
	}
	public static boolean isDuplicate(String phonenumber){
		ContactList contactList=DBConnection.getInstance().getContactList();
		for(int i=0;i<contactList.size();i++){
			if(Integer.parseInt(contactList.get(i).getphoneNumber())==Integer.parseInt(phonenumber)){
				return false;
			}
		}
		return true;
	}
	public static String genarateId(){
		String genID=String.format("C%04d",count);
		count++;
		return genID;
	}
	public static void reduceCount(){
		count--;
	}
	
	public static boolean checkSalary(double salary){
		if(salary<0){
			return true;
		}
		return false;
	}
	
	public static boolean futureDate(int year,int month,int days,String dob){
		LocalDate today=LocalDate.now();
		int currentYear=today.getYear();
		int currentMonth=today.getMonthValue();
		int currentDay=today.getDayOfMonth();
		if(year<currentYear){
			return true;
		}if(year==currentYear){
			if(month<currentMonth){
				return true;
			}else if(month==currentMonth){
				if(days<=currentDay){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean birthDayValidate(String dob){
		int year=Integer.parseInt(dob.substring(0,4));
		int mon=Integer.parseInt(dob.substring(5,7));
		int day=Integer.parseInt(dob.substring(8));
		boolean dobvalidate=isdob(year,mon,day,dob);
		do{
			if(dobvalidate){
				boolean future=futureDate(year,mon,day,dob);
				if(future){
					break;
				}else{
					return false;
					}
			}else{
				return false;
			}
			
		}while(true);
		return true;
	}
	public static boolean isdob(int year,int mon,int day,String dob){
		boolean isdob=true;
				if((year%4==0 &&( mon==2 & day<=29)||(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12)&& day<=31||((mon==4||mon==6||mon==9||mon==11)&&day<=30) ||(year%4!=0 &&( mon==2 & day<=28)||(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12)&& day<=31||((mon==4||mon==6||mon==9||mon==11)&&day<=30)))){
					if(dob.charAt(4)=='-' && dob.charAt(7)=='-'){
						isdob=true;
							
						}else{
							isdob=false;
						}
					}else{
						isdob=false;
					}
		return isdob;
	}
	
	public static Contacts getC(int i){
		return DBConnection.getInstance().getContactList().get(i);
	}
	
	public static int searchContact(String search){
		return DBConnection.getInstance().getContactList().search(search);
	}
	
	public static boolean updateContact(String name,String phoneNumber,String companyName,double salary,int i){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.setupdateName(i,name);
		contactList.setupdateNumber(i,phoneNumber);
		contactList.setupdatecompanyName(i,companyName);
		contactList.setupdateSalary(i,salary);
		return true;
	}
	public static void deleteContact(int i){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.delete(i);
	}
	
	public static void sortName(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Node temp=contactList.getFirst(), index=null;
		
		if(contactList.getFirst()==null){
			return;
		}else{
			while(temp!=null){
				index=temp.getNext();
				
				while(index!=null){
					if(temp.getContacts().getName().compareToIgnoreCase(index.getContacts().getName()) > 0){
						Contacts t=temp.getContacts();
						temp.set(index.getContacts());
						index.set(t);
					}
					index=index.getNext();
				}
				temp=temp.getNext();
			}
		}
		
	}
	public static void sortSalary(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Node temp=contactList.getFirst(), index=null;
		
		if(contactList.getFirst()==null){
			return;
		}else{
			while(temp!=null){
				index=temp.getNext();
				
				while(index!=null){
					if(temp.getContacts().getSalary()>index.getContacts().getSalary()){
						Contacts t=temp.getContacts();
						temp.set(index.getContacts());
						index.set(t);
					}
					index=index.getNext();
				}
				temp=temp.getNext();
			}
		}
	}
	public static void sortBDay(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Node temp=contactList.getFirst(), index=null;
		
		if(contactList.getFirst()==null){
			return;
		}else{
			while(temp!=null){
				index=temp.getNext();
				
				while(index!=null){
					if(temp.getContacts().getbirthDay().compareToIgnoreCase(index.getContacts().getbirthDay()) > 0){
						Contacts t=temp.getContacts();
						temp.set(index.getContacts());
						index.set(t);
					}
					index=index.getNext();
				}
				temp=temp.getNext();
			}
		}
	}
	public static Contacts table() {
    
    ContactList contactList=DBConnection.getInstance().getContactList();
    Node temp = contactList.getFirst();
    return temp.getContacts();
   
    
}
}
