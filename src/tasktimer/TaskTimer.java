package tasktimer;

import static java.lang.System.out;

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * New version which remove duplicate code as separate class name Task*.
 * @author Napon Kittisiriprasert
 */
public class TaskTimer {

    private static final double NANOSECONDS = 1.0E-9;

	/** 
     * Define a customer Consumer class that computes <b>both</b> the average 
     * and count of values.
     * An IntConsumer is a special Consumer interface the has an 'int' parameter 
     * in accept().
     */
    
    
    /**
     * @param task the task to execute
     */
    public static void execAndPrint( Runnable task ) {
    	out.println("Starting task: " + task.toString());
    	StopWatch timer = new StopWatch();
    	timer.start();
    	task.run();
    	timer.stop();
    	out.printf("Elapsed time is %f sec\n",(timer.getElapsed())*NANOSECONDS );
    }
       
    /** Run all the tasks. */
    public static void main(String [] args) {
        Runnable[] tasks = {new Task1(), new Task2(), new Task3(), new Task4(), new Task5(), new Task6()};
    	for(Runnable task: tasks) {
    		execAndPrint(task);
    	}
    }
    
}
