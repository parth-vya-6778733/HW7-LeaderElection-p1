import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tphadke on 8/29/17.
 */
public class Main {


    /**
     * asks user for selecting a root value to initiate the program
     * @param args
     */
    public static void main ( String args[]){
        Processor p0 = new Processor(0);
        Processor p1 = new Processor(85);
        Processor p2 = new Processor(72);
        Processor p3 = new Processor(99);
        Processor p4 = new Processor(60);

        p0.setNext(p1);
        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p0);

//        CircularLinkedList c = new CircularLinkedList();
//        c.addProcessorAtStart(p0.id);
//        c.addProcessorAtStart(p1.id);
//        c.addProcessorAtStart(p2.id);
//        c.addProcessorAtStart(p3.id);
//        c.addProcessorAtStart(p4.id);

        Executor e0 = new Executor(p0);
        Executor e1 = new Executor(p1);
        Executor e2 = new Executor(p2);
        Executor e3 = new Executor(p3);
        Executor e4 = new Executor(p4);

        e0.run();
        e1.run();
        e2.run();
        e3.run();
        e4.run();


        System.out.println("Processor0: "+ p0.id + "has leader: " + p0.currentLeader);
        System.out.println("Processor1: "+ p1.id + "has leader: " + p1.currentLeader);
        System.out.println("Processor2: "+ p2.id + "has leader: " + p2.currentLeader);
        System.out.println("Processor3: "+ p3.id + "has leader: " + p3.currentLeader);
        System.out.println("Processor4: "+ p4.id + "has leader: " + p4.currentLeader);



    }


}

class Executor implements Runnable
{
    Processor p;

    public Executor(Processor p)
    {
        this.p = p;
    }

    @Override
    public void run() {
        Message nextId = new Message(p.next.id);
        this.p.sendMessgeToMyBuffer(nextId);
    }
}
