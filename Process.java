/*.java 
Assignment 1
Author:     Juyong Kim
Student No: c3244203
Date:       09/08/18
Description: has all the details about the process
*/
public class Process implements Comparable<Process>
{
    //variables
    private String id;
    private int arrival;
    private int execute;
    //turnaround time
    private int tr;
    //waiting time
    private int wt;
    //priority
    private int pri;
    //splicing interval
    private int splice;
    //runtime
    private int run;

    // constructor
    public Process() 
    {
        id = "";
        arrival = 0;
        execute = 0;
        tr = 0;
        wt = 0;
        pri = 0;
        run = 0;
        splice = 4;
    }

    // getters
    public String getId() 
    { 
        return id; 
    }
    public int getArrival() 
    { 
        return arrival; 
    }
    public int getExecute()
    {
        return execute;
    }
    public int getTr() 
    {
        return tr; 
    }
    public int getWt() 
    {
        return wt;
    }
    public int getPri()
    {
        return pri;
    }
    public int getSplice()
    {
        return splice;
    }
    public int getRun()
    {
        return run;
    }

    // setters
    public void setId(String id) 
    {
        this.id = id; 
    }
    public void setArrival(int arrival) 
    {
        this.arrival = arrival; 
//        setComparator(arrival);
    }
    //special since the actual execution time
    //and how much is left is different
    public void setExecute(int execute) 
    {
        this.execute = execute;
        this.run = execute;
    }
    public void setTr(int tr) 
    {
        this.tr = tr; 
    }
    public void setWt(int wt) 
    {
        this.wt = wt;
    }
    public void setPri(int pri)
    {
        this.pri = pri;
    }
    public void setSplice(int splice)
    {
        this.splice = splice;
    }
    public void setRun(int run)
    {
        this.run = run;
    }
 /*   
    public int getComparator()
    {
        return comparator;
    }

    
    public int compareTo(Process p1)
    {
        if (p1.getComparator < this.comparator)
        {
            return 1;
        }
        else if (p1.getComparator() ==  this.comparator)
        {
            if(p1.getId().compareTo(this.id)<0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }
*/
}