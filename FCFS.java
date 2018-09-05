/* 
Assignment 1
Course:     COMP2240
Author:     Juyong Kim
Student No: c3244203
Date:       09/08/18
Description: FCFS
*/
//Libraries
import java.util.List;
import java.util.LinkedList;

public class FCFS {

    private List<Process> pro;
    private int dis;
    // constructor
    public FCFS() 
    {
        pro = new LinkedList<Process>();
    }

    //Setting the process into a list
    public void addProcess(String id, int arrival, int execute)
    {
        Process tempPro = new Process();
        tempPro.setId(id);
        tempPro.setArrival(arrival);
        tempPro.setExecute(execute);

        pro.add(tempPro);
    }

    //sets dispatcher value
    public void addDis(int num)
    {
        dis = num;
    }

    //bit of a mess
    //both does all the calculations and prints out the values
    public void doStuff()
    {
        //variables and counters
        int counter = pro.size()-1;
        int num = 0;

        System.out.println("FCFS:");

        //FCFS Algorithm, uses one queue
        for (int i = 0; i <= counter; i++)
        {
            //start dispatcher
            num += dis;

            //set waiting time for process
            pro.get(i).setWt(num - pro.get(i).getArrival());

            System.out.println("T" + num + ":" + pro.get(i).getId());

            //add execution time to total time
            num += pro.get(i).getExecute();
            //setting turnaround time
            pro.get(i).setTr(num- pro.get(i).getArrival());
       
        }

        System.out.println("          ");

        System.out.println("Process Turnaround Time Waiting Time");
        //for loop prints out values
        for (int i = 0; i <= counter; i++)
        {
            System.out.println(pro.get(i).getId() + "      " + pro.get(i).getTr() + "              " + pro.get(i).getWt());
        }
    }

    //calculates average turnaround time
    public double aTR()
    {
        int counter = pro.size();
        double ave = 0;
        for (int i = 0; i < counter; i++)
        {
            ave += pro.get(i).getTr();
        }
        ave = ave/counter;
        return ave;
    }

    //calculates average waiting time
    public double aWT()
    {
        int counter = pro.size();
        double ave = 0;
        for (int i = 0; i < counter; i++)
        {
            ave += pro.get(i).getWt();
        }
        ave = ave/counter;
        return ave;
    }

}