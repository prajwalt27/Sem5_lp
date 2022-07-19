
//31184_Prajwal_Toundakar


package lp_assignments;
import java.util.Scanner;


public class second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         System.out.println("ok go ahead");
         Scanner s= new Scanner(System.in);
         System.out.println("\n Enter Total FCFS Values: ");
         
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
        	 System.out.println("Tw("+(i+1)+"): "+arr1[i]);
         }
         System.out.println("\n The TAT values are: ");
         
         for(int i=0;i<n;i++)
         {          	 
        	 System.out.println("\n TAT("+(i+1)+")"+" : "+(arr[i]+2*arr1[i]));
         }
         

	}

}
