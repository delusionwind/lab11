package tasktimer;

import java.io.InputStream;

/**
 * Dictionary to get word form word list.
 * @author Napon Kittsiriprasert
 */
public class Dictionary {
	public static InputStream getWordsAsStream() {
		return TaskTimer.class.getClassLoader().getResourceAsStream("wordlist.txt");
	}
}
