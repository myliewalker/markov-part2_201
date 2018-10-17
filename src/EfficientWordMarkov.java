import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
public class EfficientWordMarkov extends BaseWordMarkov{
	private Map<WordGram, ArrayList<String>> myMap;
	
	public EfficientWordMarkov(int order) {
		super(order);
		myOrder = order;
		myRandom = new Random(RANDOM_SEED);
		myMap = new HashMap<>();
	}
	
	public EfficientWordMarkov() {
		this(2);
	}
	
	@Override
	public void setTraining(String text) {
		myWords = text.split("\\s+");
		for (int i = 0; i < myWords.length - myOrder; i++) {
			int pos = 0;            
			ArrayList<String> follows = new ArrayList<String>();
			WordGram wg = new WordGram(myWords, i, myOrder);
			while (true) {
				int index = indexOf(myWords,wg,pos);
				if (index == -1) {
					break;
				}
				int start = index + wg.length();
				if (start >= myWords.length) {
					follows.add(PSEUDO_EOS);
					break;
				}		
				follows.add(myWords[start]);
				pos = index+1;
			}
			myMap.put(wg, follows);
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