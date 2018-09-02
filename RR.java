
import java.util.List;
import java.util.LinkedList;

public class RR {

    private List<Process> pro,bro;
    private int dis;

    // constructor
    public RR() 
    {
        //ready que
        pro = new LinkedList<Process>();
        //finished que
        bro = new LinkedList<Process>();
    }

    public void addProcess(String id, int arrival, int execute)
    {
        Process tempPro = new Process();
        tempPro.setId(id);
        tempPro.setArrival(arrival);
        tempPro.setExecute(execute);

        pro.add(tempPro);
    }

    public void addDis(int num)
    {
        dis = num;
    }

    public void doStuff()
    {
        int counter1 = pro.size()-1;
        int counter2 = pro.size()-1;
        int num = 0;
        int i = 0;
        System.out.println("RR:");

        //System.out.println(pro.size());

        //Runs while que is not empty
        while (counter1 != 0)
        {
            num += dis;

            System.out.println("que size " + pro.size());

            //runs while 
            if(pro.get(i).getRun() > 0)
            {
                //get starting wait time and additional waiting time
                pro.get(i).setWt(pro.get(i).getWt() + num);

                //simple printing
                System.out.println("T" + num + ":" + pro.get(i).getId());

                //in NRR setSplice reduced by one with an if else statement
                num += pro.get(i).getSplice();

                //set left over runtime
                pro.get(i).setRun(pro.get(i).getRun()-pro.get(i).getSplice());

                //setting total runtime
                pro.get(i).setTr(num);
            }

            //has finished execution so push out of ready que into finished que
            if(pro.get(i).getRun() <= 0)
            {
                //push process to the back of the Queue
                bro.add(pro.get(i));
                //remove process from Queue
                pro.remove(i);
                i--;
                counter1--;
            }

            i++;

            if(counter1 == i)
            {
                i = 0;
            }
       
        }

        System.out.println("que size " + pro.size());

        System.out.println("          ");

        System.out.println("Process Turnaround Time Waiting Time");

        for (int j = 0; j <= counter2; j++)
        {
            System.out.println(bro.get(j).getId() + "       " + bro.get(j).getTr() + "               " + bro.get(j).getWt());
        }
    }
}