package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * Append all the words from the dictionary to a StringBuilder.
 * Compare how long this takes to appending to String.
 */
public class Task6 implements Runnable{
	private BufferedReader br;
	// Limit number of words read.  Otherwise, the next task could be very sloooow.
    static final int MAXCOUNT = 100_000;
	
	public Task6() {
        br = null;
        try {
            br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStream()) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage() );
            return;
        }
	}
	
	@Override
	public void run() {
        StringBuilder result = new StringBuilder();
        String word = null;
        int count = 0;
        try {
            while( (word=br.readLine()) != null  && count < MAXCOUNT) {
                result.append(word);
                count++;
            }
        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
        System.out.printf("Done appending %d words to StringBuilder.\n", count);
	}
	
	@Override
	public String toString() {
		return "append "+MAXCOUNT+" words to a StringBuilder";
	}
}
