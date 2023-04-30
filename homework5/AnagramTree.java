/**
 * This class creates and manipulates a TreeMap that contains
 * multiple ArrayLists of words that are anagrams of each other.
 * The key for each list is a String with the letters in alphabetical
 * order.   The sorted word (a String) will be the search key for the  tree, 
 * and all the words that have the same sorted form (like “rats” and
 *  “tars” and “arts”) will all be stored in an ArrayList at the 
 *  node with the sorted word key (in this case, with key “arst”).
 */

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AnagramTree {
    private TreeMap<String, ArrayList<String>> tree;

    /**
     * The constructor.
     */
    public AnagramTree() {
    	tree = new TreeMap<String, ArrayList<String>>();
    }

    /**
     * Reads in words of length <= maxLen and stores them in ArrayLists in the tree,
     * indexed by the sorted form of the word.
     * 
     * @param filename The file to read words from.
     * @param maxLen   The maximum length of a word.
     */
    public void loadWords(String filename, int maxLen) {
    	
    	Scanner inFile = null;
    	try
    	{
   
    		inFile = new Scanner(new File(filename));
    		while (inFile.hasNext())
    		{
    			String word = inFile.next();
    			String sortedWord = sortWord(word);
    			// if sortedWord is contained in tree as a key
                if (tree.containsKey(sortedWord)) {
                    findMatches(sortedWord);
                }
    			// add word to the ArrayList that is its value
    			// FINISH THIS CODE
    		}
    	}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    	}

    }

    /**
     * Helper method to convert word to sorted version
     * @param word
     * @return String
     */
    private String sortWord (String word)
    {
    	// create empty String
    	String sorted = new String();
        
    	// create sorted string
    	// FINISH THIS CODE
    	return sorted;
    	
    }

    /**
     * Returns whether or not the tree is empty (has no nodes)
     * 
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
    	
        return tree.isEmpty();
    }

    /**
     * Determines and returns the size of the tree (number of nodes) storing the
     * anagrams.
     * 
     * @return The number of nodes in the tree.
     */
    public int size() {
        return tree.size();
    }
   
    /**
     * Return the total number of words that have been added to the tree.
     * 
     * @return The number of words in the tree.
     */
    public int numWords() {
       int num = 0;
       // determine how many words are in the tree

       // FINISH THIS CODE
       return tree.size();
    }
    
   
    /**
     * Searches the tree given a sorted word and returns a list of all the words
     * that are anagrams of it.
     *
     * @param sortedWord A word in sorted form
     * @return An ArrayList containing all the words in the tree that are anagrams
     *         of sortedWord.
     */
    public ArrayList<String> findMatches(String sortedWord) {
    	
    	// WRITE THIS CODE
        return null;
    }

    /**
     * Method to get a Scanner object for a particular file name
     * @param filename
     * @return Scanner object
     */
    public static Scanner getFileScanner(String filename) {
        Scanner myFile;
        try {
            myFile = new Scanner(new FileReader(filename));
        } catch (Exception e) {
            System.out.println("File not found: " + filename);
            return null;
        }
        return myFile;
    }
}