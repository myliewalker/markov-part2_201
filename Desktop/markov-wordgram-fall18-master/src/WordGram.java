/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Mylie Walker
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value
//	private int mySize;

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		// TODO: initialize myWords and ...
		for (int i = start; i < size-start; i++)
		{
			myWords[i] = source[i];
		}
//		mySize = size;
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
	    // TODO: complete this method
		WordGram wg = (WordGram) o;
//		if (this == wg)
//		{
//			return true;
//		}
		if (this.length() != wg.length())
		{
			return false;
		}
		for (int i = 0; i < myWords.length; i++)
		{
			if (! (myWords[i].equals(wg.wordAt(i))))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 0 && myWords.length > 0)
		{
			myHash = this.toString().hashCode();
		}		
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords, 0, myWords.length);
		// TODO: Complete this method
		for (int i = 0; i < wg.length()-1; i++)
		{
			myWords[i] = this.wordAt(i+1);
		}
		myWords[wg.length()-1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		if (myToString == null)
		{
			myToString = String.join(" ", myWords);
		}	
		return myToString;
	}
}
