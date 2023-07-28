import java.util.*;
public class Contacts{

	private String genId;
	private String name;
	private String phonenumber;
	private String companyname;
	private double salary;
	private String dob;
	Contacts(){}
	Contacts(String genId,String name,String phonenumber,String companyname,double salary, String dob){
		super();
		this.genId=genId;
		this.name=name;
		this.phonenumber=phonenumber;
		this.companyname=companyname;
		this.salary=salary;
		this.dob=dob;
	}
	public void setId(String genId){
		this.genId=genId;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setphoneNumbers(String phonenumber){
		this.phonenumber=phonenumber;
	}
	public void setcompanyName(String companyname){
		this.companyname=companyname;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public void setbirthDay(String dob){
		this.dob=dob;
	}
	public String getID(){
		return genId;
	}
	public String getName(){
		return name;
	}
	public String getphoneNumber(){
		return phonenumber;
	}
	public String getcompanyName(){
		return companyname;
	}
	public double getSalary(){
		return salary;
	}
	public String getbirthDay(){
		return dob;
	}
}
