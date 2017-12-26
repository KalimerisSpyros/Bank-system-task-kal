package SpyrosBank;

import java.util.*;

public class Account implements accountInterface{
	private String name;
	private String surname;
	private int ssn;
	private double currentAccountBalance;
	private int accountpassword;
	private String username;
	
	public Account(){
		
	}
	
	public Account(String name,String surname,int ssn,Double balance,int accountpass,String username){
		
		this.name=name;
		this.surname=surname;
		this.ssn=ssn;
		this.currentAccountBalance=balance;
		this.setUsername(username);
		this.accountpassword=accountpass;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public double getCurrentAccountBalance() {

		return currentAccountBalance;
	}
	

	public int getAccountpassword() {

		return accountpassword;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setAccountpassword(int accountpassword) {
		this.accountpassword = accountpassword;
	}

	@Override
	public void addnewaccount(HashMap<Integer,Account> mymap) {
		Scanner sc=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		Account newacc=new Account();
		String answer=null;
		
		System.out.println("Plz insert the following information");
		
		do{
		sc.nextLine();
		System.out.println("Enter the name of the user: ");
		newacc.name=sc.nextLine();
		System.out.println("Enter the surname: ");
		newacc.surname=sc.nextLine();
		System.out.println("Enter user's ssn: ");
		newacc.ssn=sc.nextInt();
		System.out.println("Enter user's currentbalance: ");
		newacc.currentAccountBalance=sc.nextDouble();
		System.out.println("Enter user's  password for this account: ");
		newacc.accountpassword=sc.nextInt();
		System.out.println("Enter user's  username for this account: ");
		newacc.setUsername(sc2.nextLine());
		
		mymap.put(newacc.getSsn(), newacc);
		
		System.out.println("Would u like to add another account?? press y or n to return to the main menu");
		
		
			answer=sc.next();
			if(answer.equals("n")){
				break;
			}else if(answer.equals("y")){
				// we are good proceed
			}else{
		
			System.out.println("wrong input type y or n");
			}
		
		}while(answer.equals("y"));
		
	}

	@Override
	public void showallacounts(HashMap<Integer,Account> mymap) {
		System.out.println(mymap.values());
		
	}
	@Override
	public void deleteAccount(HashMap<Integer,Account> mymap) {
		Scanner sc=new Scanner(System.in);
		
		if(mymap.isEmpty()){
			System.out.println("i am sorry but its seems that the admin hasnt added  ur account yet, plz wait for him");
		}else{
		System.out.println("Plz give me the ssn of the user that u want to remove from the hashmap");
		int ssn=sc.nextInt();
		
		if(mymap.containsKey(ssn)){
			mymap.remove(ssn);
		}else{
			System.out.println("i am sorry but there is no such ssn in out HashMap");
		}
		}
	}

	
	
	public void setCurrentAccountBalance(double currentAccountBalance) {
		this.currentAccountBalance = currentAccountBalance;
	}

	@Override
	public String toString(){
		return "Username: "+name+" surname:"+surname+" ssn:" +ssn+" currentAccountBalance"+currentAccountBalance;
		
	}

	

	
	

}
