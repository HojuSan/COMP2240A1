/*
Starting anew
*/

import java.util.List;
import java.util.LinkedList;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;


public class Test
{
    private static FCFS fcfs;
    private static RR rr;
    private static NRR nrr;
    private static FB fb;

        // method to read file and store its data as a String
        public static String readFileAsString(String inputFile)
        {
            String data = null;

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

        fcfs = new FCFS();
        rr = new RR();
        nrr = new NRR();
        fb = new FB();
        List<String> id = new LinkedList<String>();
        List<Integer> arrival = new ArrayList<Integer>();
        List<Integer> execute = new ArrayList<Integer>();
        int dis=0, counter = 0;
        
        String data = readFileAsString("datafile1.txt");            // pulls data from input file and stores in String 'data'
        String[] parts = data.split("\\s+");              // splits data by word into an array
        
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


        fcfs.addDis(dis);
        rr.addDis(dis);
        fb.addDis(dis);
        nrr.addDis(dis);
        
        for(int i = 0; i < counter;i++)
        {
                fcfs.addProcess(id.get(i),arrival.get(i),execute.get(i));
                 rr.addProcess(id.get(i),arrival.get(i),execute.get(i));
                 fb.addProcess(id.get(i),arrival.get(i),execute.get(i));
                 nrr.addProcess(id.get(i),arrival.get(i),execute.get(i));
        }
        
        fcfs.doStuff();
        System.out.println("  ");
        rr.doStuff();
        System.out.println("  ");
        fb.doStuff();
        System.out.println("  ");
        nrr.doStuff();
        System.out.println("  ");

        System.out.println("Algorithm       Average Turnaround Time   Average Waiting Time");
        System.out.println("FCFS           "+String.format("%.2f", fcfs.aTR()));
        System.out.println("RR             "+"");
        System.out.println("FB  (constant) "+"");
        System.out.println("NRR            "+"");
        System.out.println("*  ");
     

    }//main

}//Test