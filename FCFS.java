import java.util.List;
import java.util.LinkedList;

public class FCFS {

    private List<Process> pro;
    private int dis;
    // constructor
    public FCFS() 
    {
        pro = new LinkedList<Process>();
    }

    //Setting the process into a list
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
        int counter = pro.size()-1;
        int num = 0;
        System.out.println("FCFS:");

        for (int i = 0; i <= counter; i++)
        {
            num += dis;
            pro.get(i).setWt(num);

            System.out.println("T" + num + ":" + pro.get(i).getId());

            num += pro.get(i).getExecute();
            pro.get(i).setTr(num);
       
        }

        System.out.println("          ");

        System.out.println("Process Turnaround Time Waiting Time");
        for (int i = 0; i <= counter; i++)
        {
            System.out.println(pro.get(i).getId() + "       " + pro.get(i).getTr() + "               " + pro.get(i).getWt());
        }
    }

}