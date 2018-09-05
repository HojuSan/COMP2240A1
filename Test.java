/*
Starting anew
*/

import java.util.List;
import java.util.LinkedList;
import java.nio.file.*;
import java.io.IOException;


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
        List id = new LinkedList<String>();
        List arrival = new LinkedList();
        List execute = new LinkedList();
        int dispatcher, counter = 0;
        String data = readFileAsString("datafile1.txt");            // pulls data from input file and stores in String 'data'
        String[] parts = data.split("\\s+");              // splits data by word into an array

        for(int t = 0; t <= parts.length;t++)
        {
                if(parts[t] == "DISP:")
                {
                    dispatcher = Integer.parseInt(parts[t+1]);    
                }
                if(parts[t] == "ID:")
                {
                        id.add(parts[t+1]);
                        counter++;
                }
                if(parts[t] == "Arrive:")
                {
                        arrival.add(Integer.parseInt(parts[t+1]));
                }
                if(parts[t] == "ExecSize:")
                {
                        execute.add(Integer.parseInt(parts[t+1]));
                }
        }



        fcfs.addDis(dispatcher);
        rr.addDis(dispatcher);
        fb.addDis(dispatcher);
        nrr.addDis(dispatcher);
        
        for(int i = 0; i <= counter;i++)
        {
                fcfs.addProcess(id.get(i),arrival.get(i),execute.get(i));
                 rr.addProcess(id.get(i),arrival.get(i),execute.get(i));
                 fb.addProcess(id.get(i),arrival.get(i),execute.get(i));
                 nrr.addProcess(id.get(i),arrival.get(i),execute.get(i));
        }
    
        fcfs.doStuff();
        rr.doStuff();
        fb.doStuff();
        nrr.doStuff();
      

    }//main

}//Test