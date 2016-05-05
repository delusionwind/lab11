package tasktimer;

import java.io.InputStream;

public class Dictionary {
	public static InputStream getWordsAsStream() {
		return TaskTimer.class.getClassLoader().getResourceAsStream("wordlist.txt");
	}
}
