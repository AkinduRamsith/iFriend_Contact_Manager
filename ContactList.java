import java.util.*;
public class ContactList{
	
	private Node first;
	
	public Node getFirst(){
		return first;
	}
	private boolean isValidIndex(int index){
		return index>=0 && index<size();
	}
	
	public boolean add(Contacts contacts){
		Node n1=new Node(contacts);
		
		if(first==null){
			first=n1;
		}else{
			Node lastNode=first;
			while(lastNode.getNext()!=null){
				lastNode=lastNode.getNext();
			} 
			lastNode.setNext(n1);
		}
		return false;
	}
	public int size(){
		int count=0;
		Node temp=first;
		while(temp!=null){
			count++;
			temp=temp.getNext();
		}
		return count;
	}
	
	public int search(String search){
		 Node temp = first;
			int index = 0;
			while (temp != null) {
				
				if (temp.getContacts().getName().equals(search) || temp.getContacts().getphoneNumber().equals(search) ) {
					return index;
				}
				temp = temp.getNext();
				index++;
    }
    return -1;
	}
	public void delete(int index){
		if(isValidIndex(index)){
			if(index==0){
				first=first.getNext();
			}else{
				Node temp=first;
				for(int i=0; i<index-1; i++){
					temp=temp.getNext();
				}
				temp.setNext(temp.getNext().getNext());
			}
		}
	}
	public Contacts get(int index){ 
		if(isValidIndex(index)){
			if(index==0){
				return first.getContacts();
			}else{
				Node temp=first;
				for(int i=0; i<index; i++){
					temp=temp.getNext();
				}
				return temp.getContacts();
			}
		}
		return null;
	}
	
	public boolean setupdateNumber(int index,String phonenumber){
		if(isValidIndex(index)){
			get(index).setphoneNumbers(phonenumber);
		}
		return false;
	}
	public boolean setupdateName(int index,String name){
		if(isValidIndex(index)){
			get(index).setName(name);
		}
		return false;
	}
	public boolean setupdateSalary(int index,double salary){
		if(isValidIndex(index)){
			get(index).setSalary(salary);
		}
		return false;
	}
	public boolean setupdatecompanyName(int index,String companyname){
		if(isValidIndex(index)){
			get(index).setcompanyName(companyname);
		}
		return false;
	}
	
	
	
	
}
