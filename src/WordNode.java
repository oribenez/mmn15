/**
 * String node that is pointing to other node recursively
 * @author Ori Ben Ezra
 * @version 24/04/21
 */
public class WordNode {
    private String _word; // node value
    private WordNode _next; // next node to be pointed

    /** Constructor which creates a new node that doesn't have another node to point to
     * @param word new word to insert to the new and empty list
     */
    public WordNode(String word) {
        _word = word;
        _next = null;
    }

    /**
     * Constructor which creates a new node and point to another WordNode
     * @param word new word to insert to the new and empty list
     * @param node WordNode to point to.
     */
    public WordNode(String word, WordNode node) {
        _word = word;
        _next = node;
    }

    /**
     * @return returns the string of this node
     */
    public String getWord() {
        return _word;
    }

    /**
     * sets the word of this node
     * @param word the new word to place instead of the current one.
     */
    public void setWord(String word) {
        _word = word;
    }

    /**
     *
     * @return next WordNode after the current
     */
    public WordNode getNext() {
        return _next;
    }

    /**
     * sets the next word after the current one
     * @param node new node to be set after current one
     */
    public void setNext(WordNode node) {
        _next = node;
    }

    /**
     * description of current node
     * @return string word of the current WordNode
     */
    public String toString() {
        return _word;
    }
}
