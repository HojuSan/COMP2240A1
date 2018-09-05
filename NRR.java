
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class NRR 
{

    private List<Process> pro,bro,jro;
    private int dis;

    // constructor
    public NRR() 
    {
        //ready que
        pro = new LinkedList<Process>();
        //job que(priority)
        jro = new LinkedList<Process>();
        //finished que
        bro = new LinkedList<Process>();
    }

    public void addProcess(String id, int arrival, int execute)
    {
        Process tempPro = new Process();
        tempPro.setId(id);
        tempPro.setArrival(arrival);
        tempPro.setExecute(execute);

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
        int counter3 = jro.size()-1;
        int num = 0;
        int i = 0;
        
        System.out.println("NRR:");
//        //Arrivals
//      ## be warned myself be careful when you set counters
        for(int t = 0; t <= counter1; t++)
        {

            if(jro.get(0).getArrival() <= num)
            {
                pro.add(jro.get(0));
                jro.remove(0);
            }
        }

        //Runs while both que is not empty
        while (!pro.isEmpty() || !jro.isEmpty())
        {

            num += dis;

            //Setting the Waiting time
            //if left over run and execute the same, first time running
            if(pro.get(0).getRun() == pro.get(0).getExecute())
            {
                //get starting wait time and additional waiting time
                pro.get(0).setWt(num - pro.get(0).getArrival());
                //System.out.println(pro.get(i).getWt() +"  waiting time of "+ pro.get(i).getId());
            }
            //second time running
            else
            {
                pro.get(0).setWt((num - pro.get(0).getArrival()) - (pro.get(0).getExecute() - pro.get(0).getRun()));
                //System.out.println(pro.get(i).getWt() +"  waiting time of "+ pro.get(i).getId());
            }

            //simple printing
            System.out.println("T" + num + ":" + pro.get(0).getId());

            
            //Splice is smaller than run
            if(pro.get(0).getSplice() < pro.get(0).getRun())
            {
                num += pro.get(0).getSplice();

                //set left over runtime
                pro.get(0).setRun(pro.get(0).getRun() - pro.get(0).getSplice());
            }

            //less than splice so just finish it
            else if(pro.get(0).getSplice() > pro.get(0).getRun())
            {
                num += pro.get(0).getRun();

                //set left over runtime
                pro.get(0).setRun(0);

            }

            //if no more processes left just finish it
            if (pro.size() == 1 && jro.isEmpty())
            {
                num += pro.get(0).getRun();

                //set left over runtime
                pro.get(0).setRun(0);
            }

            //setting total runtime
            pro.get(0).setTr(num - pro.get(0).getArrival());

            //readjusting the splicing reducing it by one
            if(pro.get(0).getSplice() > 2)
            {
                pro.get(0).setSplice(pro.get(0).getSplice()-1);
            }

//            //Arrivals
            for(int t = 0; t <= jro.size()-1; t++)
            {
                if(jro.get(t).getArrival() <= num)
                {
                    pro.add(jro.get(t));
                    jro.remove(t);
                    counter1--;
                }
            }

            //move to back of queue
            if(!pro.isEmpty())
            {
                pro.add(pro.get(0));
                pro.remove(pro.get(0));
            }

                        //deletes finished processes
            for(int f = 0; f <= pro.size()-1; f++)
            {   
                //has finished execution so push out of ready que into finished que
                if(pro.get(f).getRun() == 0)
                {
                    //push process to the back of the Queue
                    bro.add(pro.get(f));
                    //remove process from Queue
                    pro.remove(f);
                }
            }
        
        }

        //sorting figure it out
        Comparator empNameComparator = Comparator.comparing(Process::getId);
        Collections.sort(bro, empNameComparator);

        System.out.println("          ");

        System.out.println("Process Turnaround Time Waiting Time");

        for (int j = 0; j <= counter2; j++)
        {
            System.out.println(bro.get(j).getId() + "      " + bro.get(j).getTr() + "              " + bro.get(j).getWt());
        }

    }
    
}