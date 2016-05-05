package tasktimer;

/**
 * Stop watch to be the timer for task.
 * @author Napon Kittisiriprasert
 */
public class StopWatch {
	private long startTime;
	private long stopTime;
	private boolean running;
	
	public StopWatch() {
		startTime = 0;
		stopTime = 0;
		running = false;
	}
	
	public void start() {
		running = true;
		startTime = System.nanoTime();
	}
	
	public void stop() {
		stopTime = System.nanoTime();
		running = false;
	}
	
	public double getElapsed() {
		return stopTime - startTime;
	}
}
