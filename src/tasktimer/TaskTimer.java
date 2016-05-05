package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer {

    private static final double NANOSECONDS = 1.0E-9;

	/** 
     * Define a customer Consumer class that computes <b>both</b> the average 
     * and count of values.
     * An IntConsumer is a special Consumer interface the has an 'int' parameter 
     * in accept().
     */
    static class IntCounter implements IntConsumer {
        // count the values
        public int count = 0;
        // total of the values
        private long total = 0;
        /** accept consumes an int. In this method, count the value and add it to total. */
        public void accept(int value) { count++; total += value; }
        /** Get the average of all the values consumed. */
        public double average() { 
            return (count>0) ? ((double)total)/count : 0.0;
        }
        public int getCount() { return count; }
    }
    
    public static void execAndPrint( Runnable task ) {
    	out.println("Starting task: " + task.toString());
    	long starttime = System.nanoTime();
    	task.run();
    	long stoptime = System.nanoTime();
    	out.printf("Elapsed time is %f sec\n",(stoptime - starttime)*NANOSECONDS );
    }
       
    /** Run all the tasks. */
    public static void main(String [] args) {
        Runnable[] tasks = {new Task1(), new Task2(), new Task3(), new Task4(), new Task5(), new Task6()};
    	for(Runnable task: tasks) {
    		execAndPrint(task);
    	}
    }
    
}
