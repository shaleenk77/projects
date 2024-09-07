import java.util.*;
class Mainmansha
{
	public static void main(String args[])
	{ 
		Scanner sc=new Scanner(System.in);
		System.out.println("LOGIN AS:");
	    System.out.println("1.INQUIRY DESK MEMBER");
        System.out.println("2.CONTROL ROOM MEMBER");
		System.out.println("SELECT AN OPTION");
		int n=sc.nextInt();
		if(n==1 || n==2)
	    {	
		switch(n)
		{
			case 1: 
			Inquirydesk Iq=new Inquirydesk();
			System.out.println("ENTER LOGIN PASSCODE:");
			int pc=sc.nextInt();
			if(pc==iq.ipasscode)
			{
				System.out.println("              ----------------");
				System.out.println("              | WELCOME USER |");
				System.out.println("              ----------------");
				System.out.println("1.SEE FLIGHT SCHEDULES AND AVAILABLE FLIGHTS");
				System.out.println("2.BOOK TICKETS");
				System.out.println("3.ADD RESERVED PASSENGERS TO THE CURRENT PASSENGER'S LIST");
				System.out.println("4.REMOVE RESERVED PASSENGERS FROM THE CURRENT PASSENGER'S LIST");
				System.out.println("5.PILOTS INFORMATION");
				System.out.print("SELECT AN OPTION :");
				int s=sc.nextInt();
				switch(s)
				{
					case 1: 
			        Iq.seeflightschedule();
			        Iq.Availableflights();
					break;
					case 2:
					Iq.ticketbooking();
					break;
					case 3:
					break;
					case 4:
					break;
					case 5:
					break;
				}
			}
			else
			{
				System.out.println("INCORRECT PASSCODE");
			}
			break;
			case 2:
			break;
		
        }
		}
		    else
			System.out.println("SELECT A VALID OPTION");
    }
}

class Inquirydesk 
{
	
	Scanner sc=new Scanner(System.in);
	static int f;static int t;
	String ipasscode="1706";
	
	
	void seeflightschedule()
	{
		System.out.println("SEE FLIGHT SCHEDULES");
		System.out.println("FROM:");
		String from[]={"1.AHMEDABAD","2.MUMBAI","3.DELHI"};
		
		for(int i=0;i<from.length;i++)
		{
		 System.out.println(from[i]);
		}
		 f=sc.nextInt();
		 switch(f)
		 {
			 case 1: 
			 break;
			 case 2:
			 break;
			 case 3:
			 break;
		 }
		System.out.println("TO:");
		String to[]={"1.AHMEDABAD","2.MUMBAI","3.DELHI"};
	
		for(int i=0;i<to.length;i++)
		{
		 System.out.println(to[i]);
		}
	     t=sc.nextInt();	
		  switch(t)
		 {
			 case 1: 
			 break;
			 case 2:
			 break;
			 case 3:
			 break;
		 }
    }
	void Availableflights()
	{
		if(f==1 && t==2)
		{
			System.out.println("AVAILABLE FLIGHTS:3");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    08635       |     9:00 am      |     11:00 am  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    03548      |     3:00 pm      |     4:30 pm    |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    74123       |     7:00 pm      |     11:00 pm  |");
			System.out.println("-----------------------------------------------------");
		}
		if(f==1 && t==3)
		{
			System.out.println("AVAILABLE FLIGHTS:2");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    25864      |     5:00 am      |     9:00 am  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    89745      |     1:00 pm      |     6:00 pm    |");
			System.out.println("-----------------------------------------------------");
			
		}
		if(f==2 && t==1)
		{
			System.out.println("AVAILABLE FLIGHTS:4");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    52378       |     6:00 am      |     8:45 am  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    31456      |     11:00 am      |     3:00 pm    |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    01597       |     9:00 pm      |     2:00 pm  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    45875      |     9:00 pm      |     1:00 am  |");
			System.out.println("-----------------------------------------------------");
		}
		if(f==2 && t==3)
		{
			System.out.println("AVAILABLE FLIGHTS:3");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    57896       |     4:30 am      |     7:00 am  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    48563       |     5:00 pm      |     8:30 pm    |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    12856       |     9:00 pm      |     12:00 am  |");
			System.out.println("-----------------------------------------------------");
		}
		if(f==3 && t==1)
		{
			System.out.println("AVAILABLE FLIGHTS:3");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    48563       |     1:00 am      |     4:00 am   |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    22548      |     8:00 am      |     11:00 am   |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    78555       |     7:00 pm      |     11:00 pm  |");
			System.out.println("-----------------------------------------------------");
		}
	
	if(f==3 && t==2)
		{
			System.out.println("AVAILABLE FLIGHTS:5");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    55896       |     8:00 am      |     12:00 pm  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    14568      |     4:00 pm      |     8:30 pm    |");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    58642       |     10:00 pm      |     1:45 am  |");
			System.out.println("-----------------------------------------------------");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    53966       |     6:30 pm      |     8:45 pm   |");
			System.out.println("-----------------------------------------------------");
			System.out.println("-----------------------------------------------------");
			System.out.println("| FLIGHT NUMBER  |  DEPARTURE TIME  |  ARRIVAL TIME |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|    58744       |     3:00 pm      |     6:00 pm   |");
			System.out.println("-----------------------------------------------------");
			
		}
	}
		
	void ticketbooking()	
	{
       
		this.seeflightschedule();
		this.Availableflights();
		System.out.println("DATE :");
		int date=sc.nextInt();
        System.out.println("MONTH :");
		int month=sc.nextInt();
		System.out.println("2023");
		System.out.println("TOTAL NUMBER OF TRAVELLERS: ");
		int travellers=sc.nextInt();
		String x=sc.nextLine();
		for(int i=0;i<travellers;i++)
			{
				System.out.println("ENTER FULL NAME:");
				String name=sc.nextLine();
				System.out.println("ENTER AGE:");
				int age=sc.nextInt();
				String z=sc.nextLine();
			}
				System.out.print("ENTER FLIGHT CLASS:");
				System.out.println("1.FIRST CLASS");
				System.out.println("2.BUSINESS CLASS");
				System.out.println("3.ECONOMY CLASS");
				int cl=sc.nextInt();
				switch(cl)
				{
					 case 1: 
					 System.out.println("TOTAL AMOUNT :" + (50000*travellers));
					 break;
					 case 2: 
					 System.out.println("TOTAL AMOUNT :" + (25000*travellers));
					 break;
					 case 3: 
					 System.out.println("TOTAL AMOUNT :" + (10000*travellers));
					 break;
				}
				System.out.println("PAYMENENT METHOD : CASH/CARD/UPI");
				String pay=sc.nextLine();
				System.out.println("PAYMENT SUCCESSFUL");
	}
}

class ControlRoom extends Inquirydesk
{
    void Addflight()
	{
		
	}	
}