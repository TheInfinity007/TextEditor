package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		wordList = new LinkedList<ListNode>();
		List<String> source = getTokens(sourceText, "[a-zA-Z.]+");
		if(source.size() < 1) return;
		starter = source.get(0);
		ListNode node;
		String str;
		int i = 0;
		for(i = 0; i < source.size()-1; i++) {
			str = source.get(i);
			node = findNode(wordList, str);
			
			if(node == null) {
				node = new ListNode(str);
				wordList.add(node);
			}			
			node.addNextWord(source.get(i+1));				
		}
		
		//For the last node
		str = source.get(source.size()-1);
		node = findNode(wordList, str);
		if(node == null) {
			node = new ListNode(str);
			wordList.add(node);
		}
		node.addNextWord(source.get(0));
	}
	
	
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		if(numWords < 1) return "";
		if(wordList.size() < 1) return "";
		String res = starter, curr = starter, word;
		int i = 1, r;
		ListNode node = null;
		while(i < numWords) {
			node = findNode(wordList, curr);
			if(node != null) {
				word = node.getRandomNextWord(rnGenerator);
				res += " " + word;
				curr = word;
			}			
			i++;
		}
		
		return res;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		List<String> source = getTokens(sourceText, "[a-zA-Z.]+");
		if(source.size() < 1) return;
		wordList = new LinkedList<ListNode>();
		starter = source.get(0);
		ListNode node;
		String str;
		int i = 0;
		for(i = 0; i < source.size()-1; i++) {
			str = source.get(i);
			node = findNode(wordList, str);
			
			if(node == null) {
				node = new ListNode(str);
				wordList.add(node);
			}			
			node.addNextWord(source.get(i+1));				
		}
		
		//For the last node
		str = source.get(source.size()-1);
		node = findNode(wordList, str);
		if(node == null) {
			node = new ListNode(str);
			wordList.add(node);
		}
		node.addNextWord(source.get(0));
		
	}
	
	// TODO: Add any private helper methods you need here.
	private ListNode findNode(List<ListNode> wordList, String str) {
		ListNode node = null;
		
		for(ListNode temp : wordList) {
			if(temp.getWord().equals(str)) {
				node = temp;
				break;
			}
		}
		
		return node;
	}
	
	private ArrayList<String> getTokens(String sourceText, String pattern){
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(sourceText);
		while(m.find()) {
			tokens.add(m.group());
		}
		return tokens;
	}
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen2 = new MarkovTextGeneratorLoL(new Random(42));
		String text = "";
		System.out.println(text);
		gen2.train(text);
		System.out.println(gen2);
		System.out.println("GEn" + gen2.generateText(5) + "N");
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
//		System.out.println(textString);
//		gen.train(textString);
//		System.out.println(gen);
//		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
//		System.out.println(textString2);
//		gen.retrain(textString2);
//		System.out.println(gen);
//		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int index = generator.nextInt(nextWords.size());
//		System.out.println(index + " " + nextWords.size());
		return nextWords.get(index);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


