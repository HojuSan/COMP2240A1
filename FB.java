
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class FB 
{

    private List<Process> pro,bro,jro;
    private int dis;

    // constructor
    public FB() 
    {
        //ready que
        pro = new LinkedList<Process>();
        //job que(priority)
        jro = new LinkedList<Process>();
        //finished que
        bro = new LinkedList<Process>();
    }
}