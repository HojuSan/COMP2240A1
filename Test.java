/*
Starting anew
*/

import java.lang.*;
import java.io.*;

public class Test
{
    private static FCFS fcfs;

    public static void main(String[] args)
    {

        fcfs = new FCFS();

        fcfs.addDis(1);
        fcfs.addProcess("p1",10,2);
        fcfs.doStuff();
        

        /*
        int dis = 0;
        String id = "";
        int ari = 0;
        int exe = 0;
        int counter = 5;

        try
        {
        // Open the file that is the first 
        // command line parameter
        FileInputStream fstream = new FileInputStream("datafile1.txt");

            for (int i = 0; i <= counter; i++)
            {
                System.out.println ("Yeet");
            }

        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

        try
        {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("datafile1.txt");
            
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
           
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   
            {
                // Print the content on the console
                System.out.println (strLine);
            }
            //Close the input stream
            in.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        */

    //main
    }

//Test
}