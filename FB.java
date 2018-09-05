
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import javax.lang.model.util.ElementScanner6;


public class FB 
{

    //finished queue, and arrival queue
    private List<Process> bro,jro;
    //linkedlist of queues
    private List<Queue<Process>> pro;
    private int dis,counterblah;
    private int priNum = 6;

    // constructor
    public FB() 
    {
        //ready que
        pro = new LinkedList<Queue<Process>>();
        //job que(priority)
        jro = new LinkedList<Process>();
        //finished que
        bro = new LinkedList<Process>();   

        counterblah = 0;

        IntStream.rangeClosed(0, priNum).forEachOrdered(
            num -> {
                pro.add(new LinkedList<Process>());
            }
        );


    }

    public void addProcess(String id, int arrival, int execute)
    {
        Process tempPro = new Process();
        tempPro.setId(id);
        tempPro.setArrival(arrival);
        tempPro.setExecute(execute);

        counterblah++;

        jro.add(tempPro);
    }

    public void addDis(int num)
    {
        dis = num;
    }

    public void doStuff()
    {
        int counter1 = jro.size()-1;
        int counter2 = jro.size()-1;
        //total runtime
        int num = 0;
        //priority que counter
        int t = 0;
        //final priority so goes into round robin
        int rrt = 5; 

        System.out.println("FB:");

//        //Arrivals
        for(int u = 0; u <= counter1; u++)
        {

            if(jro.get(0).getArrival() <= num)
            {
                //cause we saving process to queue of the linkedlist
                pro.get(0).add(jro.get(0));
                jro.remove(0);
            }
        }

        //
        //Runs while both que is not empty
        while (bro.size() < counterblah)
        {
            if(bro.size() < counterblah)
            {
                t = 0;
            }
            for(int re = t;re <= 6; re++)
            {
                if (pro.get(re).isEmpty())
                {
                    t++;
                }
                else
                {
                    break;
                }
            }
            
        
            //if the queue is not empty go through it
            if (!pro.get(t).isEmpty())
            {
                num += dis;

                //first time running
                if(pro.get(t).peek().getRun() == pro.get(t).peek().getExecute())
                {
                    pro.get(t).peek().setWt(num - pro.get(t).peek().getArrival());
                }
                //second time running
                else
                {
                    pro.get(t).peek().setWt((num - pro.get(t).peek().getArrival()) - (pro.get(t).peek().getExecute() - pro.get(t).peek().getRun()));
                }
              
                //simple printing
                System.out.println("T" + num + ":" + pro.get(t).peek().getId());

                //execute process
                //Splice is smaller than run
                if(pro.get(t).peek().getSplice() < pro.get(t).peek().getRun())
                {
                    //doing work boi
                    num += pro.get(t).peek().getSplice();

                    //set left over runtime
                    pro.get(t).peek().setRun(pro.get(t).peek().getRun() - pro.get(t).peek().getSplice());
                }
                else
                {
                    //doing work boi
                    num += pro.get(t).peek().getRun();

                    //setting left over runtime
                    pro.get(t).peek().setRun(0);
                }

                //setting total runtime
                pro.get(t).peek().setTr(num - pro.get(t).peek().getArrival());


                //if shit goes wrong check arrival setting times and shiz

                //arrivals
                if(jro.size() != 0)
                {
                    for(int e = 0; e <= jro.size()-1; e++)
                    {
                        if(jro.get(e).getArrival() <= num)
                        {
                            pro.get(0).add(jro.get(e));
                            jro.remove(e);
                        }
                    }
                }
                
                //5
                if(t==5)
                {
                    //this might cause bugs
                    if(pro.get(t).peek().getRun() == 0)
                    {
                        //adds to bro and deletes from queue
                        bro.add(pro.get(t).poll());
                        
                    }
                    //not finished pushes to back of queue
                    else
                    {
                        pro.get(t).add(pro.get(t).peek());
                        pro.get(t).remove();
                    }
                }
                //0-4
                else
                {
                    //push to next priority queue or deletes

                    //this might cause bugs
                    //process has finished
                    if(pro.get(t).peek().getRun() <= 0)
                    {
                        //adds to bro and deletes from queue
                        bro.add(pro.get(t).poll());
                        
                    }
                    //not finished pushes to next priority queue
                    else
                    {
                        //adds to next priority queue
                        pro.get(t+1).add(pro.get(t).peek());
                        //deletes from current priority queue
                        pro.get(t).remove(pro.get(t).peek());   
                    } 
                }

            }

            t++;

        }

        //sorting figure it out
        Comparator empNameComparator = Comparator.comparing(Process::getId);
        Collections.sort(bro, empNameComparator);

        System.out.println("          ");

        System.out.println("Process Turnaround Time Waiting Time");

        for (int j = 0; j <= counter2; j++)
        {
            System.out.println(bro.get(j).getId() + "       " + bro.get(j).getTr() + "              " + bro.get(j).getWt());
        }

    }

    public double aTR()
    {
        int counter = bro.size();
        double ave = 0;
        for (int i = 0; i < counter; i++)
        {
            ave += bro.get(i).getTr();
        }
        ave = ave/counter;
        return ave;
    }

    public double aWT()
    {
        int counter = bro.size();
        double ave = 0;
        for (int i = 0; i < counter; i++)
        {
            ave += bro.get(i).getWt();
        }
        ave = ave/counter;
        return ave;
    }
}