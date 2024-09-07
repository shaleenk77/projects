import java.util.*;

class AirlineManagement{
	public static void main(String args[]){
		System.out.println("\n\n       : WELCOME TO AHMEDABAD INTERNATIONAL AIRPORT : ");
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n       : SELECT AN OPTION : ");
		System.out.println("\n   1. - CONTROL ROOM");
		System.out.println("   2. - INQUIRY DESK");
		System.out.print("\n   SELECT : ");
		int n = sc.nextInt();
		sc.nextLine();
		switch(n){
			case 1 :
				ControlRoom cr = new ControlRoom();
				int i = 0;
				while(true){
					if( i == 3 ){
						System.out.println("\n      !!  EXITING SYSTEM  !!");
						System.out.println("      !!  3 FAILED ATTEMPTS  !!\n");
						break;
					}
					System.out.print("\n   ENTER ID : ");
					String id = sc.nextLine();
					if( id.compareTo(cr.id) == 0 ){
						i = 0;
						while(true){
							if( i == 3 ){
								System.out.println("\n      !!  EXITING SYSTEM  !!");
								System.out.println("      !!  3 FAILED ATTEMPTS  !!\n");
								break;
							}
							System.out.print("\n   ENTER PASS CODE : ");
							String code = sc.nextLine();
							if( code.compareTo(cr.m_passcode) == 0 ){
								boolean flag1 = true ;
								while(flag1){
									System.out.println("\n\n       : SELECT AN OPTION : \n");
									System.out.println("   1. - ADD FLIGHT");
									System.out.println("   2. - BOOK TICKETS");
									System.out.println("   3. - SEE FLIGHT SCHEDULE");
									System.out.println("   4. - EXIT");
									System.out.print("\n   SELECT : ");
									int a = sc.nextInt();
									switch(a){
										case 1 :
											cr.addFlight();
											break;
										case 2 :
											cr.bookTicket();
											flag1 = false;
											break;
										case 3 :
											cr.flightSchedule();
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
							System.out.println("   2. - SEE FLIGHT SCHEDULE");
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
									inq.flightSchedule();
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
		}
	}
}
class Inquiry {
	
	String passcode="2207";
	String flight[]=new String[]{ "Bangalore Flight" , "Vadodara Flight"  , "Ajmer Indigo" , "Delhi spicejet" , "" , "" , "" , "" , "" , "" };

	String[] departure_time=new String[]{ "9:00 AM" , "9:00 PM" , "12:30 PM" , "3:45 PM" , "" , "" , "" , "" , "" , "" };
		
	String flight_destination[]=new String[]{ "Bangalore" , "Vadodara" , "Ajmer" , "Delhi" , "" , "" , "" , "" , "" , "" };
	
	String arrival_time[]=new String[]{ "4:00 PM" , "6:00 AM" , "5:30 PM" , "7:50 PM" , "" , "" , "" , "" , "" , "" };

	void flightSchedule(){
		System.out.println();
		System.out.println("   |======================================================================|");
		System.out.println("   |                         : FLIGHT SCHEDULE :                           |");
		System.out.println("   |======================================================================|");		
		for(int i = 0 ; i < flight.length ; i++ ){
			if( flight[i].compareTo("") == 0 ){
				break;
			}
			System.out.println("   |                                                                      |");
			System.out.println("   |   "+(i+1)+".)FLIGHT : "+String.format("%-25s",flight[i])+"DESTINATION : "+String.format("%-15s",flight_destination[i]) + " |\n   |       DEPARTURE : " + String.format("%-25s",departure_time[i])+"ARRIVAL : "+String.format("%-15s",arrival_time[i])+" |");
			System.out.println("   |                                                                      |");
		}
		System.out.println("   |======================================================================|\n\n");
	}
	
	void bookTicket(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\n   ENTER BUYERS NAME : ");
		String name = sc.nextLine();
		flightSchedule();
		System.out.print("   SELECT FLIGHT : ");
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
		System.out.println("   |        PLANE :"+String.format("%-55s",flight[i-1])+"|");
		System.out.println("   |        PLANE ARRIVAL TIME : " + String.format("%-41s",arrival_time[i-1]) + "|");
		System.out.println("   |        PLANE DEPARTURE TIME : " + String.format("%-39s",departure_time[i-1]) + "|");
		System.out.println("   |        PLSNE DESTINATION : " + String.format("%-42s",flight_destination[i-1]) + "|");
		System.out.println("   |                                                                      |");
		System.out.println("   |======================================================================|");		
	}
	
}

class ControlRoom extends Inquiry{

	String id= "1706";
	String m_passcode= "123";
	static int flightcount = 4 ;
	
	void addFlight(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\n   ENTER FLIGHT NAME : ");
		flight[flightcount] = sc.nextLine();
		System.out.print("\n   ENTER ARRIVAL TIME : ");
		arrival_time[flightcount] =  sc.nextLine();
		System.out.print("\n   ENTER DEPARTURE TIME: ");
		departure_time[flightcount] =  sc.nextLine();
		System.out.print("\n   ENTER DESTINATION : ");
		flight_destination[flightcount] =  sc.nextLine();
		flightcount++;
	}	
}