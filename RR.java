
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class RR 
{

    private List<Process> pro,bro,jro;
    private int dis;

    // constructor
    public RR() 
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
        System.out.println("RR:");

        //Arrivals
        for(int t = 0; t <= counter1; t++)
        {
            if(jro.get(t).getArrival() <= num)
            {
                pro.add(jro.get(t));
                jro.remove(t);
                counter1--;
            }
        }

        //Runs while both que is not empty
        while (!pro.isEmpty() || !jro.isEmpty())
        {

            num += dis;


            for(int t = 0; t <= counter1; t++)
            {
                if(jro.get(t).getArrival() <= num)
                {
                    pro.add(jro.get(t));
                    jro.remove(t);
                    counter1--;
                }
            }

            //Setting the Waiting time
            //if left over run and execute the same, first time running
            if(pro.get(i).getRun() == pro.get(i).getExecute())
            {
                //get starting wait time and additional waiting time
                pro.get(i).setWt(num - pro.get(i).getArrival());
                //System.out.println(pro.get(i).getWt() +"  waiting time of "+ pro.get(i).getId());
            }
            //second time running
            else
            {
                pro.get(i).setWt((num - pro.get(i).getArrival()) - (pro.get(i).getExecute() - pro.get(i).getRun()));
                //System.out.println(pro.get(i).getWt() +"  waiting time of "+ pro.get(i).getId());
            }

            //simple printing
            System.out.println("T" + num + ":" + pro.get(i).getId());

            //Splice is smaller than run
            if(pro.get(i).getSplice() < pro.get(i).getRun())
            {
                num += pro.get(i).getSplice();

                //set left over runtime
                pro.get(i).setRun(pro.get(i).getRun() - pro.get(i).getSplice());
            }

            //less than splice so just finish it
            else if(pro.get(i).getSplice() > pro.get(i).getRun())
            {
                num += pro.get(i).getRun();

                //set left over runtime
                pro.get(i).setRun(0);

            }

            //setting total runtime
            pro.get(i).setTr(num - pro.get(i).getArrival());

            //Arrivals
            for(int t = 0; t <= counter1; t++)
            {
                if(jro.get(t).getArrival() <= num)
                {
                    pro.add(jro.get(t));
                    jro.remove(t);
                    counter1--;
                }
            }
        

            //has finished execution so push out of ready que into finished que
            if(pro.get(i).getRun() <= 0)
            {
                //push process to the back of the Queue
                bro.add(pro.get(i));
                //remove process from Queue
                pro.remove(i);
                i--;
                counter3--;
            }

            if(pro.size() == (i+1))
            {
                i = 0;
            }

            else
            {
                i++;
            }


        
        }


        System.out.println("          ");

        System.out.println("Process Turnaround Time Waiting Time");

        for (int j = 0; j <= counter2; j++)
        {
            System.out.println(bro.get(j).getId() + "       " + bro.get(j).getTr() + "               " + bro.get(j).getWt());
        }

    }
    
}