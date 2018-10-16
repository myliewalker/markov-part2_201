import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

public class EfficientWordMarkov extends BaseWordMarkov{
	private Map<WordGram, ArrayList<String>> myMap;
	
	public EfficientWordMarkov(int order) {
		super(order);
		myRandom = new Random(RANDOM_SEED);
		myMap = new HashMap<>();
	}
	
	public EfficientWordMarkov() {
		this(2);
	}
	
	@Override
	public void setTraining(String text) {
		myWords = text.split("\\s+");
		for (int i = 0; i < myWords.length; i++) {
			WordGram wg = new WordGram(myWords, i, myOrder);
			if (! myMap.containsKey(wg)) {
				myMap.put(wg, new ArrayList<String>());
			}
			myMap.put(wg, super.getFollows(wg));
		}
	}
	
	
	public void setTraining(String[] words) {
		myWords = words;
		for (int i = 0; i < words.length; i++) {
			WordGram wg = new WordGram(words, i, myOrder);
			if (! myMap.containsKey(wg)) {
				myMap.put(wg, new ArrayList<String>());
			}
			myMap.put(wg, super.getFollows(wg));
		}
	}
	
	@Override
	public ArrayList<String> getFollows(WordGram wg) {
		if (! myMap.containsKey(wg)) {
			return new ArrayList<String>();
//			throw new NoSuchElementException(wg + " not in map");
		}
		return myMap.get(wg);
	}
}
