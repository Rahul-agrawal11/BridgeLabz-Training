package collectors;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Map;

public class WordFrequencyCounter {

	public static void main(String[] args) {
		String paragraph = "Java is easy. Java is powerful! Java is everywhere.";
		
		Map<String, Integer> wordOccurence = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
                .filter(word -> !word.isBlank())
                .collect(Collectors.toMap(
                        word -> word,          // key = word itself
                        word -> 1,             // value = 1 for first time
                        Integer::sum           // merge duplicates (add counts)
                ));
		
		System.out.println(wordOccurence);
	}

}
