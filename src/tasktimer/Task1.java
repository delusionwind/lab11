package tasktimer;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Process all the words in a file using Scanner to read and parse input.
 * Display summary statistics and elapsed time.
 */
public class Task1 implements Runnable{
	private Scanner in;
	
	public Task1() {
		in = new Scanner(Dictionary.getWordsAsStream());
	}
	
	@Override
	public void run() {
        // perform the task
        int count = 0;
        long totalsize = 0;
        while(in.hasNext()) {
            String word = in.next();
            totalsize += word.length();
            count++;
        }
        double averageLength = ((double)totalsize)/(count>0 ? count : 1);
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}
	
	@Override
	public String toString() {
		return "read words using Scanner and a while loop";
	}
}
