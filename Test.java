/*
Starting anew
*/

import java.util.List;
import java.util.LinkedList;


public class Test
{
    private static FCFS fcfs;
    private static RR rr;
    private static NRR nrr;
    private static FB fb;

    public static void main(String[] args)
    {

        fcfs = new FCFS();
        rr = new RR();
        nrr = new NRR();
        fb = new FB();

        fb.addDis(1);
        fb.addProcess("p1",0,10);
        fb.addProcess("p2",0,1);
        fb.addProcess("p3",0,2);
        fb.addProcess("p4",0,1);
        fb.addProcess("p5",0,5);
        fb.doStuff();
/*
        fb.addDis(1);
        fb.addProcess("p1",0,10);
        fb.addProcess("p2",2,1);
        fb.addProcess("p3",6,2);
        fb.addProcess("p4",10,1);
        fb.addProcess("p5",14,5);
        fb.doStuff();       
*/
/*
        nrr.addDis(1);
        nrr.addProcess("p1",0,10);
        nrr.addProcess("p2",0,1);
        nrr.addProcess("p3",0,2);
        nrr.addProcess("p4",0,1);
        nrr.addProcess("p5",0,5);
        nrr.doStuff();

        nrr.addDis(1);
        nrr.addProcess("p1",0,10);
        nrr.addProcess("p2",2,1);
        nrr.addProcess("p3",6,2);
        nrr.addProcess("p4",10,1);
        nrr.addProcess("p5",14,5);
        nrr.doStuff();
*/
/*
        rr.addDis(1);
        rr.addProcess("p1",0,10);
        rr.addProcess("p2",0,1);
        rr.addProcess("p3",0,2);
        rr.addProcess("p4",0,1);
        rr.addProcess("p5",0,5);
        rr.doStuff();

        rr.addDis(1);
        rr.addProcess("p1",0,10);
        rr.addProcess("p2",2,1);
        rr.addProcess("p3",6,2);
        rr.addProcess("p4",10,1);
        rr.addProcess("p5",14,5);
        rr.doStuff();
*/
/*
        fcfs.addDis(1);
        fcfs.addProcess("p1",0,10);
        fcfs.addProcess("p2",0,1);
        fcfs.addProcess("p3",0,2);
        fcfs.addProcess("p4",0,1);
        fcfs.addProcess("p5",0,5);
        fcfs.doStuff();
*/        

    }//main

}//Test