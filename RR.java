
import java.util.List;
import java.util.LinkedList;

public class RR {

    private List<Process> pro;
    private int dis;
    private int slice = 4;

    // constructor
    public RR() 
    {
        pro = new LinkedList<Process>();
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
        int counter = pro.size()-1;
        int num = 0;
        System.out.println("RR:");

        
        /*
        for(int i = 0; i <= 11;i++)
        {
            System.out.println ("Yeet");
        }
        */
    }
}