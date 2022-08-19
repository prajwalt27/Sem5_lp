package lp_assignments;
import java.util.Scanner;
public class second {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // System.out.println("ok go ahead");

    Scanner s = new Scanner(System.in);
    System.out.println("\n Enter Total FCFS Values: ");

    float avg_waitingtime = 0;
    float avg_tat_time = 0;
    int n = s.nextInt();
    int arr[] = new int[n];
    int arr1[] = new int[n];

    System.out.println("\n Enter TS values: ");
    for (int i = 0; i < n; i++) {
      System.out.println("\n For P" + (i + 1) + " " + ",Ts" + (i + 1) + " = ");
      arr[i] = s.nextInt();
    }

    System.out.println('\n');
    //Array for Waiting Time
    arr1[0] = 0;
    for (int i = 1; i < n; i++) {
      arr1[i] = arr[i - 1] + arr1[i - 1];
    }

    System.out.println("Tw values: ");
    for (int i = 0; i < n; i++) {
      avg_waitingtime += arr1[i];
      System.out.println("Tw(" + (i + 1) + "): " + arr1[i]);
    }
    System.out.println("\n The TAT values are: ");

    for (int i = 0; i < n; i++) {
      System.out.println("\n TAT(" + (i + 1) + ")" + " : " + (arr[i] + 2 * arr1[i]));
      avg_tat_time += (arr[i] + 2 * arr1[i]);
    }
    System.out.println("\n The avg. Waiting Time is: " + (avg_waitingtime / n));
    System.out.println("\n The avg. turn around time is: " + (avg_tat_time / n));

  }

}

//OUTPUT
// Enter Total FCFS Values:
// 5

// Enter TS values:

// For P1 ,Ts1 =
// 300

// For P2 ,Ts2 =
// 125

// For P3 ,Ts3 =
// 400

// For P4 ,Ts4 =
// 150

// For P5 ,Ts5 =
// 100

// Tw values:
// Tw(1): 0
// Tw(2): 300
// Tw(3): 425
// Tw(4): 825
// Tw(5): 975

// The TAT values are:

// TAT(1) : 300

// TAT(2) : 725

// TAT(3) : 1250

// TAT(4) : 1800

// TAT(5) : 2050

// The avg. Waiting Time is: 505.0

// The avg. turn around time is: 1225.0

2) SJF
import java.util.*;
public class assign1sjf {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter no of process:");
    int n = sc.nextInt();
    int pid[] = new int[n];
    int at[] = new int[n]; // at means arrival time
    int bt[] = new int[n]; // bt means burst time
    int ct[] = new int[n]; // ct means complete time
    int ta[] = new int[n]; // ta means turn around time
    int wt[] = new int[n]; //wt means waiting time
    int f[] = new int[n]; // f means it is flag it checks process is completed or not
    int st = 0, tot = 0;
    float avgwt = 0, avgta = 0;
    for (int i = 0; i < n; i++) {
      System.out.println("enter process " + (i + 1) + " arrival time:");
      at[i] = sc.nextInt();
      System.out.println("enter process " + (i + 1) + " brust time:");
      bt[i] = sc.nextInt();
      pid[i] = i + 1;
      f[i] = 0;
    }

    boolean a = true;
    while (true) {
      int c = n, min = 999;
      if (tot == n) // total no of process = completed process loop will be terminated
        break;
      for (int i = 0; i < n; i++) {
       
        if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
          min = bt[i];
          c = i;
          System.out.println("order:" + pid[i] + " bursttime:" + min);
        }
      }
     
      if (c == n)
        st++;
      else {
        ct[c] = st + bt[c];

        st += bt[c];
        ta[c] = ct[c] - at[c];
        wt[c] = ta[c] - bt[c];
        f[c] = 1;
        tot++;
      }
    }
    System.out.println("\npid arrival brust complete turn waiting");
    for (int i = 0; i < n; i++) {
      avgwt += wt[i];
      avgta += ta[i];
      System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
    }
    System.out.println("\naverage tat is " + (float)(avgta / n));
    System.out.println("average wt is " + (float)(avgwt / n));
    sc.close();
  }
}

//OUTPUT:
//   enter no of process: 3
// enter process 1 arrival time:
//   0
// enter process 1 brust time:
//   3
// enter process 2 arrival time:

//   0
// enter process 2 brust time: 1
// enter process 3 arrival time: 0
// enter process 3 brust time:
//   2
// order: 1 bursttime: 3 order: 2 bursttime: 1 order: 1 bursttime: 3 order: 3
// bursttime: 2 order: 1
// bursttime: 3 pid arrival brust complete turn waiting
// 1 0 3 6 6 32 0 1 1 1 0
// 3 0 2 3 3 1
// average tat is 3.3333333 average wt is 1.3333334

3) Priority
import java.util.Scanner;
public class NonPreemptivePriorityCPUSchedulingAlgorithm {
  int burstTime[];
  int priority[];
  int arrivalTime[];
  String[] processId;
  int numberOfProcess;
  void getProcessData(Scanner input) {
    System.out.print("Enter the number of Process for Scheduling : ");
    int inputNumberOfProcess = input.nextInt();
    numberOfProcess = inputNumberOfProcess;

    burstTime = new int[numberOfProcess];
    priority = new int[numberOfProcess];
    arrivalTime = new int[numberOfProcess];
    processId = new String[numberOfProcess];
    String st = "P";
    for (int i = 0; i < numberOfProcess; i++) {
      processId[i] = st.concat(Integer.toString(i));
      System.out.print("Enter the burst time for Process - " + (i) + " : ");
      burstTime[i] = input.nextInt();
      System.out.print("Enter the arrival time for Process - " + (i) + " : ");
      arrivalTime[i] = input.nextInt();
      System.out.print("Enter the priority for Process - " + (i) + " : ");
      priority[i] = input.nextInt();
    }
  }
  void sortAccordingArrivalTimeAndPriority(int[] at, int[] bt, int[] prt, String[] pid) {
    int temp;
    String stemp;
    for (int i = 0; i < numberOfProcess; i++) {
      for (int j = 0; j < numberOfProcess - i - 1; j++) {
        if (at[j] > at[j + 1]) {

          //swapping arrival time
          temp = at[j];
          at[j] = at[j + 1];
          at[j + 1] = temp;
          //swapping burst time
          temp = bt[j];
          bt[j] = bt[j + 1];
          bt[j + 1] = temp;
          //swapping priority
          temp = prt[j];
          prt[j] = prt[j + 1];
          prt[j + 1] = temp;
          //swapping process identity
          stemp = pid[j];
          pid[j] = pid[j + 1];
          pid[j + 1] = stemp;
        }
        //sorting according to priority when arrival timings are same
        if (at[j] == at[j + 1]) {
          if (prt[j] > prt[j + 1]) {
            //swapping arrival time
            temp = at[j];
            at[j] = at[j + 1];
            at[j + 1] = temp;

            //swapping burst time
            temp = bt[j];
            bt[j] = bt[j + 1];
            bt[j + 1] = temp;
            //swapping priority
            temp = prt[j];
            prt[j] = prt[j + 1];
            prt[j + 1] = temp;
            //swapping process identity
            stemp = pid[j];
            pid[j] = pid[j + 1];
            pid[j + 1] = stemp;
          }
        }
      }
    }
  }
  void priorityNonPreemptiveAlgorithm() {
    int finishTime[] = new int[numberOfProcess];
    int bt[] = burstTime.clone();
    int at[] = arrivalTime.clone();
    int prt[] = priority.clone();
    String pid[] = processId.clone();
    int waitingTime[] = new int[numberOfProcess];
    int turnAroundTime[] = new int[numberOfProcess];

    sortAccordingArrivalTimeAndPriority(at, bt, prt, pid);
    //calculating waiting & turn-around time for each process
    finishTime[0] = at[0] + bt[0];
    turnAroundTime[0] = finishTime[0] - at[0];
    waitingTime[0] = turnAroundTime[0] - bt[0];
    for (int i = 1; i < numberOfProcess; i++) {
      finishTime[i] = bt[i] + finishTime[i - 1];
      turnAroundTime[i] = finishTime[i] - at[i];
      waitingTime[i] = turnAroundTime[i] - bt[i];
    }
    float sum = 0;
    for (int n: waitingTime) {
      sum += n;
    }
    float averageWaitingTime = sum / numberOfProcess;
    sum = 0;
    for (int n: turnAroundTime) {
      sum += n;
    }
    float averageTurnAroundTime = sum / numberOfProcess;
    //print on console the order of processes along with their finish time & turn
    around time
    System.out.println("Priority Scheduling Algorithm : ");

    System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId",
      "BurstTime",
      "ArrivalTime", "Priority", "FinishTime", "WaitingTime", "TurnAroundTime");
    for (int i = 0; i < numberOfProcess; i++) {
      System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", pid[i], bt[i],
        at[i], prt[i],
        finishTime[i], waitingTime[i], turnAroundTime[i]);
    }
    System.out.format("%100s%20f%20f\n", "Average", averageWaitingTime,
      averageTurnAroundTime);
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    NonPreemptivePriorityCPUSchedulingAlgorithm obj = new
    NonPreemptivePriorityCPUSchedulingAlgorithm();
    obj.getProcessData(input);
    obj.priorityNonPreemptiveAlgorithm();
  }
}

4) Round Robin
import java.util.Scanner;
public class RoundRobin {
  public static void main(String args[]) {
      int n, i, qt, count = 0, temp, sq = 0, bt[], wt[], tat[], rem_bt[];
      float awt = 0, atat = 0;
      bt = new int[10];
      wt = new int[10];
      tat = new int[10];
      rem_bt = new int[10];
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the number of process (maximum 10) = ");
      n = s.nextInt();
      System.out.print("Enter the burst time of the process\n");
      for (i = 0; i < n; i++) {
        System.out.print("P" + i + " = ");
        bt[i] = s.nextInt();
        rem_bt[i] = bt[i];
      }
      System.out.print("Enter the quantum time: ");
      qt = s.nextInt();
      while (true) {

        for (i = 0, count = 0; i < n; i++) {
          temp = qt;
          if (rem_bt[i] == 0) {
            count++;
            continue;
          }
          if (rem_bt[i] > qt)
            rem_bt[i] = rem_bt[i] - qt;
          else
          if (rem_bt[i] >= 0) {
            temp = rem_bt[i];
            rem_bt[i] = 0;
          }
          sq = sq + temp;
          tat[i] = sq;
        }
        if (n == count)
          break;
      }
      System.out.print("--------------------------------------------------------------------------
          -- -- --");
          System.out.print("\nProcess\t Burst Time\t Turnaround Time\t Waiting Ti
            me\ n ");

            System.out.print("--------------------------------------------------------------------------
              -- -- --");
              for (i = 0; i < n; i++) {
                wt[i] = tat[i] - bt[i];
                awt = awt + wt[i];
                atat = atat + tat[i];
                System.out.print("\n " + (i + 1) + "\t " + bt[i] + "\t\t " + tat[i] + "\t\t " + wt[i] + "\n");
              }
              awt = awt / n; atat = atat / n; System.out.println("\nAverage waiting Time = " + awt + "\n"); System.out.println("Average turnaround time = " + atat);
            }
          }
//           OUTPUT:
//           Enter the number of process(maximum 10) = 5 Enter the burst time of the process P0 = 6 P1 = 32 P2 = 25 P3 = 80 P4 = 14 Enter the quantum time: 5
//           -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
//           Process Burst Time Turnaround Time Waiting Time

//           -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --1 6 26 20 2 32 107 75 3 25 90 65 4 80 157 77 5 14 65 51 Average waiting Time = 57.6 Average turnaround time = 89.0
