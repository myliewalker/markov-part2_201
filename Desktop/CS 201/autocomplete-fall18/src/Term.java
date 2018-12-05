
/*************************************************************************
 * @author Mylie Walker
 *
 * Description: A term and its weight.
 * 
 *************************************************************************/

import java.util.Comparator;

public class Term implements Comparable<Term> {

	private final String myWord;
	private final double myWeight;

	/**
	 * The constructor for the Term class. Should set the values of word and
	 * weight to the inputs, and throw the exceptions listed below
	 * 
	 * @param word
	 *            The word this term consists of
	 * @param weight
	 *            The weight of this word in the Autocomplete algorithm
	 * @throws NullPointerException
	 *             if word is null
	 * @throws IllegalArgumentException
	 *             if weight is negative
	 */
	public Term(String word, double weight) {
		if (word == null) {
			throw new NullPointerException("Word is null");
			//myWord = "";
		}		
		else myWord = word;
		if (weight < 0) {
			throw new IllegalArgumentException("Negative weight "+ weight);
			//myWeight = 0;
		}
		else myWeight = weight;
	}
	
	/**
	 * The default sorting of Terms is lexicographical ordering.
	 */
	public int compareTo(Term that) {
		return myWord.compareTo(that.myWord);
	}

	/**
	 * Getter methods, use these in other classes which use Term
	 */
	public String getWord() {
		return myWord;
	}

	public double getWeight() {
		return myWeight;
	}

	public String toString() {
		return String.format("(%2.1f,%s)", myWeight, myWord);
	}
	
	@Override
	public boolean equals(Object o) {
		Term other = (Term) o;
		return this.compareTo(other) == 0;
	}

	/**
	 * A Comparator for comparing Terms using a set number of the letters they
	 * start with. This Comparator may be useful in writing your implementations
	 * of Autocompletors.
	 *
	 */
	public static class PrefixOrder implements Comparator<Term> {
		private final int myPrefixSize;

		public PrefixOrder(int r) {
			this.myPrefixSize = r;
		}

		/**
		 * Compares v and w lexicographically using only their first r letters.
		 * If the first r letters are the same, then v and w should be
		 * considered equal. This method should take O(r) to run, and be
		 * independent of the length of v and w's length. You can access the
		 * Strings to compare using v.word and w.word.
		 * 
		 * @param v/w
		 *            - Two Terms whose words are being compared
		 */
		public int compare(Term v, Term w) {
			for (int i = 0; i < Math.min(myPrefixSize, Math.min(v.getWord().length(), w.getWord().length())); i++) {
				if(v.getWord().charAt(i) != w.getWord().charAt(i)) {
					return v.getWord().charAt(i) - w.getWord().charAt(i);
				}
			}
			if (v.getWord().length() < myPrefixSize || w.getWord().length() < myPrefixSize) {
				return v.getWord().length() - w.getWord().length();
			}
			return 0;
		}
	
	}

	/**
	 * A Comparator for comparing Terms using only their weights, in descending
	 * order. This Comparator may be useful in writing your implementations of
	 * Autocompletor
	 *
	 */
	public static class ReverseWeightOrder implements Comparator<Term> {
//		Comparator<Term> reverse = new Comparator<Term>() {
//			@Override
//			public int compare(Term v, Term w) {
//				if (v.getWeight() < w.getWeight()) {
//					return 1;
//				}
//				if (v.getWeight() > w.getWeight()) {
//					return -1;
//				}
//				return 0;
//			}
//		};
//
//		@Override
//		public int compare(Term o1, Term o2) {
//			return reverse.compare(o1, o2);
//		}
		
		@Override
		public int compare(Term v, Term w) {
			if (v.getWeight() < w.getWeight()) {
				return 1;
			}
			if (v.getWeight() > w.getWeight()) {
				return -1;
			}
			return 0;
		}
	}

	/**
	 * A Comparator for comparing Terms using only their weights, in ascending
	 * order. This Comparator may be useful in writing your implementations of
	 * Autocompletor
	 *
	 */
	public static class WeightOrder implements Comparator<Term> {
//		Comparator<Term> inOrder = new Comparator<Term>() {
//			@Override
//			public int compare(Term v, Term w) {
//				if (v.getWeight() < w.getWeight()) {
//					return -1;
//				}
//				if (v.getWeight() > w.getWeight()) {
//					return 1;
//				}
//				return 0;
//			}
//		};
//		
//		@Override
//		public int compare(Term o1, Term o2) {
//			return inOrder.compare(o1, o2);
//		}
		
		@Override
		public int compare(Term v, Term w) {
			if (v.getWeight() < w.getWeight()) {
				return -1;
			}
			if (v.getWeight() > w.getWeight()) {
				return 1;
			}
			return 0;
		}
	}
}