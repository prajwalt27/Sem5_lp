
//31184_Prajwal_Toundakar


package lp_assignments;
import java.util.Scanner;


public class second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         System.out.println("ok go ahead");
		
         Scanner s= new Scanner(System.in);
         System.out.println("\n Enter Total FCFS Values: ");
         
         float avg_waitingtime=0;
         float avg_tat_time=0;
         int n= s.nextInt();
         int arr[]= new int[n];
         int arr1[]= new int[n];
         
         System.out.println("\n Enter TS values: ");
         for(int i=0;i<n;i++)
         {
        	 System.out.println("\n For P"+(i+1)+" "+",Ts"+(i+1)+" = ");
        	 arr[i]=s.nextInt();
         }
         System.out.println('\n');
         //Array for Waiting Time
         arr1[0]=0;
         for(int i=1;i<n;i++)
         {
        	 arr1[i]=arr[i-1]+arr1[i-1];
         }
         
         System.out.println("Tw values: ");
         for(int i=0;i<n;i++)
         {
        	 avg_waitingtime+=arr1[i];
        	 System.out.println("Tw("+(i+1)+"): "+arr1[i]);
         }
         System.out.println("\n The TAT values are: ");
         
         for(int i=0;i<n;i++)
         {          	 
        	 System.out.println("\n TAT("+(i+1)+")"+" : "+(arr[i]+2*arr1[i]));
        	 avg_tat_time+=(arr[i]+2*arr1[i]);
         }
         System.out.println("\n The avg. Waiting Time is: "+(avg_waitingtime/n));
         System.out.println("\n The avg. turn around time is: "+(avg_tat_time/n));
         

	}

}

//OUTPUT
// Enter Total FCFS Values: 
// 5

//  Enter TS values: 

//  For P1 ,Ts1 = 
// 300


//  For P2 ,Ts2 = 
// 125

//  For P3 ,Ts3 = 
// 400

//  For P4 ,Ts4 = 
// 150

//  For P5 ,Ts5 = 
// 100


// Tw values: 
// Tw(1): 0
// Tw(2): 300
// Tw(3): 425
// Tw(4): 825
// Tw(5): 975

//  The TAT values are: 

//  TAT(1) : 300

//  TAT(2) : 725

//  TAT(3) : 1250

//  TAT(4) : 1800

//  TAT(5) : 2050

//  The avg. Waiting Time is: 505.0

//  The avg. turn around time is: 1225.0
