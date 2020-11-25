package spelling;

import java.util.List;

public class Practice {


	public static void main(String[] args) {
		AutoCompleteDictionaryTrie dict = new AutoCompleteDictionaryTrie();
		System.out.println(dict);
		System.out.println(dict.root);
		System.out.println(dict.root.text);
		System.out.println(dict.root.isWord);
		
		System.out.println(dict.size);
		dict.addWord("Hello");
		dict.addWord("Hi");
		dict.addWord("Hell");
		dict.addWord("heat");
		dict.addWord("heal");
		System.out.println(dict.size);
		System.out.println("Infinity");
		
		List<String> res = dict.predictCompletions("h",3);
		System.out.println(res);
		
		
		

	}

}
