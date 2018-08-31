import java.util.List;

public class FCFS {

    private List<Process> pro;
    private int dis;
    private int counter;
    // constructor
    public FCFS() 
    {
        counter = 0;
    }

    //Setting the process into a list
    public void addProcess(String id, int arrival, int execute)
    {
        Process tempPro = new Process();
        tempPro.setId(id);
        tempPro.setArrival(arrival);
        tempPro.setExecute(execute);

        pro.add(tempPro);

        counter++;

    }

    public void addDis(int num)
    {
        dis = num;
    }

    public void doStuff()
    {
        int num = 0;
        System.out.println("FCFS:");

        for (int i = 0; i <= counter; i++)
        {
            num += dis;
            System.out.println("T" + num + ":" + pro.get(i).getId());
            num += pro.get(i).getExecute();
       
        }

        System.out.println("Process Turnaround Time Waiting Time");
        for (int i = 0; i <= counter; i++)
        {
            System.out.println(pro.get(i).getId() + "  " + pro.get(i).getTr() + "      " + pro[i].getWt());
        }
    }

}