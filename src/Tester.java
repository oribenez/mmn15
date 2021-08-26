public class Tester {
    public static void main(String[] args) {
//        WordNode w1 = new WordNode("hello");
//        WordNode w2 = new WordNode("there");
//        WordNode w3 = new WordNode("guys");
//        w1.setNext(w2);
//        w2.setNext(w3);
//
//        TextList list = new TextList(w1);
        String txt = "anything you can do i can do better";
        TextList list2 = new TextList(txt);
        list2.print();
        System.out.println("\n" + list2.toString());





    }
//
//    /**
//     * insert WordNode to the END of this list.
//     * Time Complexity: O(n), Space Complexity: O(1).
//     * @param node the new WordNode instance.
//     */
//    private void addToEnd(WordNode node) {
//        if (empty()) _head = node;
//        else {
//            WordNode ptr = _head;
//
//            while (ptr.getNext() != null)
//                ptr = ptr.getNext();
//
//            ptr.setNext(node);
//        }
//    }
//
//    public WordNode nextElement(WordNode node) {
//        return node.getNext();
//    }
//
//    public String getValueOfNode(WordNode node) {
//        return node.getWord();
//    }
//
//    public void remove(String word) {
//        if (!empty()) {
//            if (_head.getWord().equals(word))
//                _head = _head.getNext();
//            else {
//                WordNode behind,curr;
//                behind = _head;
//                curr = _head.getNext();
//
//                while (curr != null) {
//
//                    if (curr.getWord().equals(word)) {
//                        behind.setNext(curr.getNext());
//                        return;
//                    }
//
//                    behind = behind.getNext();
//                    curr = curr.getNext();
//                }
//            }
//        }
//    }
//
//    public void print() {
//        WordNode curr = _head;
//
//        while (curr != null) {
//            System.out.print(curr.getWord() + ", ");
//            curr = curr.getNext();
//        }
//        System.out.print("null");
//    }
//    public void printRec() {
//        System.out.println("The List is: ");
//        printRec(_head);
//    }
//    private void printRec(WordNode wn) {
//        if (wn == null) {
//            System.out.println("null");
//            return;
//        }
//
//        System.out.println(wn.getWord() + " --> ");
//        printRec(wn.getNext());
//    }
}
