import java.util.*;
public class Node{
	
private Contacts contacts;
		private Node next;
		
		Node(Contacts contacts){this.contacts=contacts;}
		
		public Node getNext(){
			return next;
		}
		public Contacts getContacts(){
			return contacts;
		}
		public void set(Contacts contacts){
			this.contacts=contacts;
		}
		 public void setNext(Node next) {
        this.next = next;
    }
}
