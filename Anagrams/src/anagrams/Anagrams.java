package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
	
//   	public static final ImmutableList<String> ALPHABET = ImmutableList.<String>builder()
//		    .put("a")
//    		.put("b")
//    		.put("c")
//		    .build();

    public static int numberNeeded(String first, String second) {
    	String localFirst = String.valueOf(first);
    	String localSecond = String.valueOf(second);
    	String characterString = null;
    	
    	//ascii a = 97, z = 122
    	int character = 'a';
    	
    	do {
    		characterString = String.valueOf((char)character);
    				
    		if(localFirst.contains(characterString) && localSecond.contains(characterString)) {
    			localFirst = localFirst.replaceFirst(characterString, "");
    			localSecond = localSecond.replaceFirst(characterString, "");
    		} else {
    			character++;
    		}
    		
    	} while(character <= 'z');
    	
    	return localFirst.length() + localSecond.length();
    }
    
    public static int numberNeeded2(String first, String second) {
    	String localFirst = String.valueOf(first);
    	String localSecond = String.valueOf(second);
    	String characterString = null;
    	
    	List<String> alphabet = createAlphabet();
    	
    	int position = 0;
    	do {
    		characterString = alphabet.get(position);
    				
    		if(localFirst.contains(characterString) && localSecond.contains(characterString)) {
    			localFirst = localFirst.replaceFirst(characterString, "");
    			localSecond = localSecond.replaceFirst(characterString, "");
    		} else {
    			position++;
    		}
    		
    	} while(position < alphabet.size());
    	
    	return localFirst.length() + localSecond.length();
    }
    
    public static int numberNeeded3(String first, String second) {
        int[] freq = new int[26];
        first.chars().forEach(c -> freq[c - 'a']++);
        second.chars().forEach(c -> freq[c - 'a']--);
        return Arrays.stream(freq).map(Math::abs).sum();
    }

	private static List<String> createAlphabet() {
		List<String> alphabet = new ArrayList<>();
    	for(int character = 'a'; character <= 'z'; character++) {
    		alphabet.add(String.valueOf((char)character));
    	}
    	return alphabet;
	}
    
      public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
          String a = in.next();
          String b = in.next();
          System.out.println(numberNeeded3(a, b));
      }
}
