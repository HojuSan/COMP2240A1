/* 
Assignment 1
Course:     COMP2240
Author:     Juyong Kim
Student No: c3244203
Date:       09/08/18
Description: Primary Class
*/
//Libraries
import java.util.List;
import java.util.LinkedList;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;


public class c3244203A1
{
    //variables
    private static FCFS fcfs;
    private static RR rr;
    private static NRR nrr;
    private static FB fb;

    // method to read file and store its data as a String
    public static String readFileAsString(String inputFile)
    {
        String data = null;

        //Throw and catch
        try 
        {
            data = new String(Files.readAllBytes(Paths.get(inputFile)));
        } 
        catch (IOException e)           
        {
            //TODO: handle exception
            System.err.println(e);
        }
        return data;
    }

    public static void main(String[] args) 
    {
        //variables
        fcfs = new FCFS();
        rr = new RR();
        nrr = new NRR();
        fb = new FB();
        List<String> id = new LinkedList<String>();
        List<Integer> arrival = new ArrayList<Integer>();
        List<Integer> execute = new ArrayList<Integer>();
        int dis=0, counter = 0;
        
        String data = readFileAsString("datafile2.txt");            // pulls data from input file and stores in String 'data'
        String[] parts = data.split("\\s+");              // splits data by word into an array
        
        //runs through an array of strings, and seperates them into
        //seperate arrays for things such as id, arrival, execution
        for(int t = 0; t < parts.length;t++)
        {
                if(parts[t].equals("DISP:"))
                {
                    dis = Integer.parseInt(parts[t+1]);    
                }
                if(parts[t].equals("ID:"))
                {
                        id.add(parts[t+1]);
                        counter++;
                }
                if(parts[t].equals("Arrive:"))
                {
                        arrival.add(Integer.parseInt(parts[t+1]));
                }
                if(parts[t].equals("ExecSize:"))
                {
                        execute.add(Integer.parseInt(parts[t+1]));
                }
        }

        //adds dispatcher to each class
        fcfs.addDis(dis);
        rr.addDis(dis);
        fb.addDis(dis);
        nrr.addDis(dis);
        
        //goes through the array above, subs in values into addprocess in each
        //algorithm, feel bad since I know i could have saved so much
        //extra code if i just made another class, but to late not enough time
        for(int i = 0; i < counter;i++)
        {
            fcfs.addProcess(id.get(i),arrival.get(i),execute.get(i));
            rr.addProcess(id.get(i),arrival.get(i),execute.get(i));
            fb.addProcess(id.get(i),arrival.get(i),execute.get(i));
            nrr.addProcess(id.get(i),arrival.get(i),execute.get(i));
        }
        
        //Prints the values needed for the assignment
        fcfs.doStuff();
        System.out.println("  ");
        rr.doStuff();
        System.out.println("  ");
        fb.doStuff();
        System.out.println("  ");
        nrr.doStuff();
        System.out.println("  ");

        System.out.println("Algorithm       Average Turnaround Time   Average Waiting Time");
        System.out.println("FCFS            "+String.format("%.2f", fcfs.aTR())+"                     "+String.format("%.2f", fcfs.aWT()));
        System.out.println("RR              "+String.format("%.2f", rr.aTR())+"                     "+String.format("%.2f", rr.aWT()));
        System.out.println("FB  (constant)  "+String.format("%.2f", fb.aTR())+"                     "+String.format("%.2f", fb.aWT()));
        System.out.println("NRR             "+String.format("%.2f", nrr.aTR())+"                     "+String.format("%.2f", nrr.aWT()));
        System.out.println("*  ");
     

    }//main

}//Test