import java.util.*;

class Main{
	public static void main(String args[]){
		System.out.println("\n\n       : WELCOME TO AHMEDABAD RAILWAY STATION : ");
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n       : SELECT AN OPTION : ");
		System.out.println("\n   1. - MANAGER");
		System.out.println("   2. - INQUIRY");
		System.out.println("   3. - TC");
		System.out.println("   4. - CLEANER");
		System.out.print("\n   SELECT : ");
		int n = sc.nextInt();
		sc.nextLine();
		switch(n){
			case 1 :
				Manager manager = new Manager();
				int i = 0;
				while(true){
					if( i == 3 ){
						System.out.println("\n      !!  EXITING SYSTEM  !!");
						System.out.println("      !!  3 FAILED ATTEMPTS  !!\n");
						break;
					}
					System.out.print("\n   ENTER ID : ");
					String id = sc.nextLine();
					if( id.compareTo(manager.id) == 0 ){
						i = 0;
						while(true){
							if( i == 3 ){
								System.out.println("\n      !!  EXITING SYSTEM  !!");
								System.out.println("      !!  3 FAILED ATTEMPTS  !!\n");
								break;
							}
							System.out.print("\n   ENTER PASS CODE : ");
							String code = sc.nextLine();
							if( code.compareTo(manager.m_passcode) == 0 ){
								boolean flag1 = true ;
								while(flag1){
									System.out.println("\n\n       : SELECT AN OPTION : \n");
									System.out.println("   1. - ADD TRAIN");
									System.out.println("   2. - BOOK TICKETS");
									System.out.println("   3. - SEE TRAIN SCHEDULE");
									System.out.println("   4. - EXIT");
									System.out.print("\n   SELECT : ");
									int a = sc.nextInt();
									switch(a){
										case 1 :
											manager.addTrain();
											break;
										case 2 :
											manager.bookTicket();
											flag1 = false;
											break;
										case 3 :
											manager.trainSchedule();
											break;
										case 4 :
											flag1 = false;
											break;
									}
								}
								break;
							}else{
								i++;
								System.out.println("\n      !!  INVALID CODE !!\n");
							}
						}
						break;
					}else{
						i++;
						System.out.println("\n      !! INVALID ID !!\n");
					}
				}
				break;
			case 2 :
				Inquiry inq = new Inquiry();
				i = 0;
				while(true){
					if( i == 3 ){
						System.out.println("\n      !!  EXITING SYSTEM  !!");
						System.out.println("      !!  3 FAILED ATTEMPTS  !!\n");
						break;
					}
					System.out.println();
					System.out.print("   ENTER PASS CODE : ");
					String code = sc.nextLine();
					if( code.compareTo(inq.passcode) == 0 ){
						boolean flag1 = true ;
						while(flag1){
							System.out.println();
							System.out.println("         : SELECT TASK :");
							System.out.println();
							System.out.println("   1. - BOOK TICKETS");
							System.out.println("   2. - SEE TRAIN SCHEDULE");
							System.out.println("   3. - EXIT");
							System.out.println();
							System.out.print("   SELECT : ");
							int a = sc.nextInt();
							switch(a){
								case 1 :
									inq.bookTicket();
									flag1 = false;
									break;
								case 2 :
									inq.trainSchedule();
									break;
								case 3 :
									flag1 = false;
									break;
							}
						}
						break;
					}else{
						i++;
						System.out.println();
						System.out.println("    !! INVALID CODE !!");
						System.out.println();
					}
				}
				break;
			case 3 :
				TC tc = new TC();
				tc.staffSchedule();
				break;
			case 4 :
				Cleaner cl = new Cleaner();
				cl.staffSchedule();
				break;
		}
	}
}

class TC{
	void staffSchedule()
	{
		System.out.println();
		System.out.println("   |================================================|");
		System.out.println("   |               : STAFF SCHEDULE :               |");
		System.out.println("   |================================================|");
		System.out.println("   |                                                |");
		System.out.println("   |   BANGALORE EXPRESS       TC:PARESH PATEL      |");
		System.out.println("   |   VADODARA EXPRESS        TC:SUKESH SHAH       |");
		System.out.println("   |   SHATABDI EXPRESS        TC:MOHAN SHAH        |");
		System.out.println("   |   AJMER EXPRESS           TC:FENIL MEHTA       |");
		System.out.println("   |   DELHI EXPRESS           TC:KALI FAZAL        |");
		System.out.println("   |                                                |");
		System.out.println("   |   PLATFORM 1            CLEANER:RAMESH PATEL   |");
		System.out.println("   |   PLATFORM 2            CLEANER:MUKESH SHAH    |");
		System.out.println("   |   PLATFORM 3            CLEANER:HITESH SHAH    |");
		System.out.println("   |   PLATFORM 4            CLEANER:YOGESH MEHTA   |");
		System.out.println("   |   PLATFORM 5            CLEANER:ALI FAZAL      |");	
		System.out.println("   |                                                |");
		System.out.println("   |================================================|");
	}
}

class Cleaner{
	void staffSchedule()
	{
		System.out.println();
		System.out.println("   |================================================|");
		System.out.println("   |               : STAFF SCHEDULE :               |");
		System.out.println("   |================================================|");
		System.out.println("   |                                                |");
		System.out.println("   |   BANGALORE EXPRESS       TC:PARESH PATEL      |");
		System.out.println("   |   VADODARA EXPRESS        TC:SUKESH SHAH       |");
		System.out.println("   |   SHATABDI EXPRESS        TC:MOHAN SHAH        |");
		System.out.println("   |   AJMER EXPRESS           TC:FENIL MEHTA       |");
		System.out.println("   |   DELHI EXPRESS           TC:KALI FAZAL        |");
		System.out.println("   |                                                |");
		System.out.println("   |   PLATFORM 1            CLEANER:RAMESH PATEL   |");
		System.out.println("   |   PLATFORM 2            CLEANER:MUKESH SHAH    |");
		System.out.println("   |   PLATFORM 3            CLEANER:HITESH SHAH    |");
		System.out.println("   |   PLATFORM 4            CLEANER:YOGESH MEHTA   |");
		System.out.println("   |   PLATFORM 5            CLEANER:ALI FAZAL      |");	
		System.out.println("   |                                                |");
		System.out.println("   |================================================|");
	}
}

class Inquiry {
	
	String passcode="2207";
	String train[]=new String[]{ "Bangalore Express" , "Vadodara Express"  , "Ajmer Express" , "Delhi Express" , "" , "" , "" , "" , "" , "" };
	//"Mumbai Express" , "Kolkata Express" , "Punjab Express" , "Maharaja Express" , "Kashmir Express"

	String cleaners[]=new String[]{ "Ramesh Patel" , "Mukesh Shah" , "Hitesh Shah" , "Yogesh Mehta" , "Mukesh Modi" };

	String[] departure_time=new String[]{ "9:00 AM" , "9:00 PM" , "12:30 PM" , "3:45 PM" , "" , "" , "" , "" , "" , "" };
		
	String train_destination[]=new String[]{ "Bangalore" , "Vadodara" , "Ajmer" , "Delhi" , "" , "" , "" , "" , "" , "" };
	
	String arrival_time[]=new String[]{ "4:00 PM" , "6:00 AM" , "5:30 PM" , "7:50 PM" , "" , "" , "" , "" , "" , "" };

	void trainSchedule(){
		System.out.println();
		System.out.println("   |======================================================================|");
		System.out.println("   |                         : TRAIN SCHEDULE :                           |");
		System.out.println("   |======================================================================|");		
		for(int i = 0 ; i < train.length ; i++ ){
			if( train[i].compareTo("") == 0 ){
				break;
			}
			System.out.println("   |                                                                      |");
			System.out.println("   |   "+(i+1)+".) TRAIN : "+String.format("%-25s",train[i])+"DESTINATION : "+String.format("%-15s",train_destination[i]) + " |\n   |       DEPARTURE : " + String.format("%-25s",departure_time[i])+"ARRIVAL : "+String.format("%-15s",arrival_time[i])+" |");
			System.out.println("   |                                                                      |");
		}
		System.out.println("   |======================================================================|\n\n");
	}
	
	void bookTicket(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\n   ENTER BUYERS NAME : ");
		String name = sc.nextLine();
		trainSchedule();
		System.out.print("   SELECT TRAIN : ");
		int i = sc.nextInt();
		System.out.print("\n   ENTER NUMBER OF TICKETS : ");
		int ticketcount = sc.nextInt();
		System.out.print("\n   PAYMENT DETAILS : CASH");
		System.out.print("\n   PAYMENT SUCCESSFUL : ");
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("   |======================================================================|");
		System.out.println("   |                              : TICKET :                              |");
		System.out.println("   |======================================================================|");		
		System.out.println("   |                                                                      |");
		System.out.println("   |        NAME :"+String.format("%-56s",name)+"|");
		System.out.println("   |                                                                      |");
		System.out.println("   |        TICKET COUNT :"+String.format("%-48s",ticketcount)+"|");
		System.out.println("   |                                                                      |");
		System.out.println("   |        TRAIN :"+String.format("%-55s",train[i-1])+"|");
		System.out.println("   |        TRAIN ARRIVAL TIME : " + String.format("%-41s",arrival_time[i-1]) + "|");
		System.out.println("   |        TRAIN DEPARTURE TIME : " + String.format("%-39s",departure_time[i-1]) + "|");
		System.out.println("   |        TRAIN DESTINATION : " + String.format("%-42s",train_destination[i-1]) + "|");
		System.out.println("   |                                                                      |");
		System.out.println("   |======================================================================|");		
	}
	
}

class Manager extends Inquiry{

	String id= "manager_8518";
	String m_passcode= "man_123";
	static int traincount = 4 ;
	
	void addTrain(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\n   ENTER TRAIN NAME : ");
		train[traincount] = sc.nextLine();
		System.out.print("\n   ENTER ARRIVAL TIME : ");
		arrival_time[traincount] =  sc.nextLine();
		System.out.print("\n   ENTER DEPARTURE TIME: ");
		departure_time[traincount] =  sc.nextLine();
		System.out.print("\n   ENTER DESTINATION : ");
		train_destination[traincount] =  sc.nextLine();
		traincount++;
	}
	
}