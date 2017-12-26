package SpyrosBank;

import java.util.*;
		
 class TestBankSystem {
	final static String adminusername="spyros";
	final static int adminpassword=1234;
		
		
	public static void main(String[] args) {
		
		
		System.out.println("|---------------------|");
		System.out.println("|Welcome to SpyrosBank|");
		System.out.println("|-------HELLO!--------|");
		System.out.println("|---------------------|");
		
		checkfortheadmin();
	
		}
public static void checkfortheadmin(){
	HashMap<Integer,Account> mymap=new HashMap<Integer,Account>();
	Account acc=new Account();
	Scanner sc=new Scanner(System.in);
	String answer=null,answer2=null;
	int choice=0,counter=0;
	boolean flag=true;
	do{
		sc.nextLine();
		System.out.println("Are u the admin of the Bank System?? Type yes or no to continue to the USER menu");
		answer=sc.nextLine();
		
		if(answer.equals("yes")){
			
			while(counter<3){
				sc.nextLine();
			System.out.println("plz enter ur username");
			String username=sc.nextLine();   //i wont check for a valid entry
			System.out.println("plz enter ur password");
			int password=sc.nextInt();       //i wont check for a valid entry
			
			if(adminusername.equals(username)&&adminpassword==password){
				System.out.println("U are the admin plz select one of the below options");
				
			do{
				System.out.println("type 1 for creating a new account");
				System.out.println("type 2 for deleting an existing acount");
				System.out.println("type 3 to show all the current accounts in the HashMap");
				System.out.println("type 4 to logout");
				System.out.println("type 5 completely exit the programm");
				int value=sc.nextInt();
				switch(value){
				case(1):{
					
					acc.addnewaccount(mymap);
					break;
					
				}case(2):{
					
					acc.deleteAccount(mymap);
					
					break;
				}case(3):{
					acc.showallacounts(mymap);
					break;
					
				}case(4):{
					flag=false;
					break;
				}case(5):{
					System.exit(0);
				}
				}
			}while(flag);	
			
			counter=3;  // i am making the counter 3 so it could exit the while loop
				
			}else{
				int tries=2;
				tries=tries-counter;
				System.out.println("Your username and password was incorrect plz type them again u have "+tries+"  more tries");
				counter++;
				if(counter==3){
					System.out.println("sir u are not the admin u are trying to cheat me");
				}
			}
		}		
			
		}else if(answer.equals("no")){
			
			
			checkforuser(mymap);
			break;
			
		}else{
			System.out.println("Your input must be yes or no plz try again");
			
		}
		}while(true);
}

public static void checkforuser(HashMap<Integer,Account> mymap){
	Account acc=new Account();
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Hello!! dear user to have access to your account plz give type your ssn number");
	int ssnanswer=sc.nextInt();
	sc.nextLine();
	boolean flag=true;
	if(mymap.containsKey(ssnanswer)){
		
		System.out.println("to be sure that its you plz enter ur username");
		String usernameAnswer=sc.nextLine();
			if(mymap.get(ssnanswer).getUsername().equals(usernameAnswer)){
				System.out.println("now add ur password aswell");
				int passAnswer=sc.nextInt();
					if(mymap.get(ssnanswer).getAccountpassword()==passAnswer){
						
						System.out.println("YOUR CREDENTIALS WAS CORRECT PLZ SELECT ONE OF THE FOLLOWING OPTIONS");
						while(flag){
						System.out.println("type 1 to make a deposit");
						System.out.println("type 2 to make a withdraw");
						System.out.println("type 3 to check your total Balance");
						System.out.println("type 4 to exit the programm ");
						
						int value=sc.nextInt();
						switch(value){
						case(1):{
						
						double deposit=0;
							
						System.out.println("enter the ammount u want to deposit");
						deposit=sc.nextDouble();
						
						double balance=mymap.get(ssnanswer).getCurrentAccountBalance();
						balance=balance+deposit;
						mymap.get(ssnanswer).setCurrentAccountBalance(balance);
						
							break;
						}case(2):{
							double withdraw=0;
							System.out.println("enter the ammount u want to withdraw");
							withdraw=sc.nextDouble();
							
							double balance=mymap.get(ssnanswer).getCurrentAccountBalance();
							if(balance>withdraw){
							balance=balance-withdraw;
							mymap.get(ssnanswer).setCurrentAccountBalance(balance);
							}else{
								System.out.println("u dont have such money in your account");
							}
							
							
							break;
						}case(3):{
							System.out.println("your current balance is: " +mymap.get(ssnanswer).getCurrentAccountBalance());
							break;
							
						}case(4):{
							System.exit(0);
							break;
						}
						}
					}
					}else{
						System.out.println("sorry but ur password was not correct for this account");
					}
				}
	}else{
		System.out.println("there is no such ssn in our HashMap");
	}
}
}

	
