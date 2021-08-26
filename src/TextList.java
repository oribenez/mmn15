/**
 * Class which represents a list of WordNode
 * @author Ori Ben Ezra
 * @version 24/04/21
 */
public class TextList {
    private WordNode _head; // pointer to the first element in list

    /**
     * Constructor which initialize new list of TextList
     */
    public TextList() {
        _head = null;
    }

    /**
     * Constructor which initialize new list of TextList using a given text
     * Time Complexity: O(n*log(n)), Space Complexity: O(1).
     * @param text Text of words, inc. only letters and spaces.
     */
    public TextList (String text) { // "hello there my good friends"
        int spaceIndex = text.indexOf(' ');
        // add words to new list
        while(spaceIndex != -1) {
            String currWord = text.substring(0, spaceIndex);
            addToHead(new WordNode(currWord));

            text = text.substring(spaceIndex + 1); // override text with the new cut one.
            spaceIndex = text.indexOf(' ');
        }

        //add last word
        addToHead(new WordNode(text));

        mergeSort();
    }

    /**
     * Method which merge two sorted lists
     * Time Complexity: O(n), Space Complexity: O(1).
     * @param list1 first sorted list
     * @param list2 second sorted list
     */
    private WordNode merge(WordNode list1, WordNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.getWord().compareTo(list2.getWord()) < 0) { // if word is smaller lexicographically than next word
            list1.setNext(merge(list1.getNext(),list2));
            return list1;
        } else {
            list2.setNext(merge(list1,list2.getNext()));
            return list2;
        }
    }

    /**
     * Method which split the list to two
     * * Time Complexity: O(n), Space Complexity: O(1).
     * @param node the list to split
     * @return return pointer to the second list . (the first list is at the same pointer)
     */
    private WordNode split(WordNode node) {
        if (node == null || node.getNext() == null) return null;

        WordNode list2 = node.getNext();
        node.setNext(list2.getNext());
        list2.setNext(split(node.getNext()));
        return list2;
    }

    /**
     * Merge sort this list
     * Time Complexity: O(n log(n)), Space Complexity: O(1).
     */
    private void mergeSort() {
        _head = mergeSort(_head);
    }

    /**
     * Method which sort a given list using merge sort method.
     * Time Complexity: O(n log(n)), Space Complexity: O(1).
     * @param node list to sort
     * @return pointer to the sorted list
     */
    private WordNode mergeSort(WordNode node) {
        if (node == null || node.getNext() == null) return node; // checks for empty or single list

        WordNode list2 = split(node); //split list into two halves.

        node = mergeSort(node);
        list2 = mergeSort(list2);

        return merge(node,list2);
    }

    /**
     * check if the list is empty
     * Time Complexity: O(1), Space Complexity: O(1).
     * @return true if list is empty, otherwise false.
     */
    private boolean empty() {
        return _head == null;
    }

    /**
     * insert WordNode to the HEAD of this list.
     * Time Complexity: O(1), Space Complexity: O(1).
     * @param node the new WordNode instance.
     */
    private void addToHead(WordNode node) {
        WordNode tmp = _head;
        _head = node;
        node.setNext(tmp);
    }

    /**
     * Method which insert new word to the list and sort it lexicographically
     * Time Complexity: O(n*log(n)), Space Complexity: O(1).
     * @param word given word to add to this list
     */
    public void addToData(String word) {
        if (word.equals("")) return;

        addToHead(new WordNode(word));
        mergeSort();
    }

    /**
     * Method which calculates how many words are in this list
     * Time Complexity: O(n), Space Complexity: O(1).
     * @return Amount of words that exist in this list
     */
    public int howManyWords() {
        return howManyWords(_head);
    }

    /**
     * Time Complexity: O(n), Space Complexity: O(1).
     * @param wn pointer to the list
     * @return number of words
     */
    private int howManyWords(WordNode wn) {
        if (wn == null) return 0;
        return 1 + howManyWords(wn.getNext());
    }

    /**
     * Method which calculates the amount of different words that exist in this list
     * Time Complexity: O(n), Space Complexity: O(1).
     * @return amount of different words that exist in this list
     */
    public int howManyDifferentWords () {
        if (empty()) return 0; //

        int counter = 0;
        WordNode curr = _head;

        while(curr != null && curr.getNext() != null) {
            if (!curr.getWord().equals(curr.getNext().getWord())) { // current_word != next_word
                counter++;
            }
            curr = curr.getNext();
        }

        // Edge Case
        //last word or only one word in list
        counter++;

        return counter;
    }

    /**
     * Method which checks the most frequent word that is in this list
     * Time Complexity: O(n), Space Complexity: O(1).
     * @return most frequent word that is in this list
     */
    public String mostFrequentWord() { // hello-> hello-> hello-> there-> hi-> hi-> null
        if (empty()) return "";

        int max = 1;
        WordNode curr = _head;
        String freqWord = curr.getWord();
        int tmpCounter = 1;

        while(curr != null && curr.getNext() != null) {

            if (curr.getWord().equals(curr.getNext().getWord())) { // current word == next word
                tmpCounter++;
                if (tmpCounter > max) { // Change new frequent word
                    freqWord = curr.getWord();
                    max++;
                }
            } else { // new words sequence
                tmpCounter = 1;
            }
            curr = curr.getNext();
        }


        return freqWord;
    }

    /**
     * search for the amount of words that starts with the given letter attribute
     * Time Complexity: O(n), Space Complexity: O(1).
     * @param letter letter to check the amount of existence
     * @return number of letter instances
     */
    public int howManyStarting (char letter) {
        WordNode ptr = _head;
        int counter = 0;

        while(ptr != null && ptr.getWord().charAt(0) <= letter) { // run as long as letter attribute is bigger than curr letter
            if (ptr.getWord().charAt(0) == letter) { // the desired letter to check
                counter++;
            }
            ptr = ptr.getNext();
        }

        return counter;
    }

    /**
     * Method that checks in the list which letter is the most frequent letter
     * @return most frequent letter
     */
    public char mostFrequentStartingLetter() {
        if (empty()) return ' '; // empty list

        return mostFrequentStartingLetter(_head, _head.getWord().charAt(0), 1, 1);
    }
    // Recursive method
    private char mostFrequentStartingLetter(WordNode ptr, char letMaxFreq, int maxFreq, int currFreq) {
        if (ptr.getNext() == null) return letMaxFreq; // break recursion

        if (ptr.getWord().charAt(0) == ptr.getNext().getWord().charAt(0)) { // curr_let == next_let
            currFreq++; // increment current freq word counter

            if (currFreq > maxFreq) { // found new most frequently char
                maxFreq = currFreq;
                letMaxFreq = ptr.getWord().charAt(0);
            }
        } else { // new first letter
            currFreq = 1;
        }

        return mostFrequentStartingLetter(ptr.getNext(), letMaxFreq, maxFreq, currFreq);
    }

    /**
     * creates a string of all words and amount of each word
     * Time Complexity: O(n), Space Complexity: O(1).
     * @return string of all words and amount of each word
     */
    public String toString() {
        String allWords = "";
        WordNode ptr = _head;
        int similarWordCount = 1;

        while (ptr != null) {
            if (ptr.getNext() != null) {
                if (ptr.getWord().equals(ptr.getNext().getWord())) { // current_word == next_word
                    similarWordCount++;
                } else {
                    allWords += ptr.getWord() + "\t" + similarWordCount + "\n";
                    similarWordCount = 1;
                }
            } else { //edge case - last word
                allWords += ptr.getWord() + "\t" + similarWordCount;
            }

            ptr = ptr.getNext();
        }

        return allWords;
    }
}
