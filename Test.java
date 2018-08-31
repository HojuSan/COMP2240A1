/*
Starting anew
*/

import java.util.List;
import java.util.LinkedList;


public class Test
{
    private static FCFS fcfs;
    private static RR rr;

    public static void main(String[] args)
    {

        fcfs = new FCFS();
        rr = new RR();

        rr.addDis(1);
        rr.addProcess("p1",0,10);
        rr.addProcess("p2",0,1);
        rr.addProcess("p3",0,2);
        rr.addProcess("p4",0,1);
        rr.addProcess("p5",0,5);
        rr.doStuff();
/*
        fcfs.addDis(1);
        fcfs.addProcess("p1",0,10);
        fcfs.addProcess("p2",0,1);
        fcfs.addProcess("p3",0,2);
        fcfs.addProcess("p4",0,1);
        fcfs.addProcess("p5",0,5);
        fcfs.doStuff();
*/        

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