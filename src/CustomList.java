public class CustomList {
    
    private Node head;

    public CustomList() {
        this.head = null;
    }

    public CustomList(Node newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {

        return head == null;
    }

    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {

        // the list is empty, I need to set a new head
        if (isEmpty()) {
            this.head = newNode;
            return;
        }

        // the node that "moves" inside the list
        Node cursor = head;

        // check if I've reached the second-to-last node
        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        }

        // I know that I've reached the end
        cursor.setNext(newNode);  
    }

    // recursive
    private void appendRec(Node cursor, Node newNode) {

        // exit clause
        if (cursor.getNext() == null) {
            cursor.setNext(newNode); 
            return;
        }

        // recursive call
        appendRec(cursor.getNext(), newNode); 
    }

    // wrapper
    public void appendRec(Node newNode) {

        if (isEmpty())
            this.head = newNode;
        else
            appendRec(head, newNode); 
    }

    /**
     * Adds an item to the list at the specified position, pushing all of the following elements in the list 
     * @param index position of the new element to be added
     * @param newNode element to be inserted
     */
    public void add(int index, Node newNode) throws IndexOutOfBoundsException {

        // the node is added before the head
        if (index == 0) {
            // makes the new node the first element, connecting the rest of the list
            newNode.setNext(head); 

            // updated the head reference, which now points to the new node
            this.head = newNode;
        }

        // the node is added inside the list
        else if (index > 0 && index <= size()) {
            // retrieves the previous node
            Node prev = get(index-1); 

            // updates the reference after the new node 
            newNode.setNext(prev.getNext());

            // updates the reference before the node
            prev.setNext(newNode); 
        }

        // the index is invalid
        else 
            throw new IndexOutOfBoundsException("Invalid position");
    }

    // wrapper
    private Node getRec(Node cursor, int index) {

        // exit clause
        if (index == 0)
            return cursor;

        // recursive call
        return getRec(cursor.getNext(), index-1);
    }

    /**
     * Gets the element in the specified position
     * @param index position to read
     * @return the element identified by the index
     * @throws IndexOutOfBoundsException
     */
    public Node get(int index) throws IndexOutOfBoundsException {
        // checks if the index is valid
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");

        return getRec(head, index);
    }

    public Node remove(int index){
        if (index <0 || index >= size())
            throw new IndexOutOfBoundsException("invalid index");

        Node removed;

        if (index ==0){
            removed = head;
            head = head.getNext();
            return removed;
        }

        Node  prev = get(index-1);
        removed = prev.getNext();
        prev.setNext(prev);
        prev.setNext(prev.getNext().getNext());
        return removed;
    }

    public boolean remove(Node n){

        if ( n == null)return false;
        int index = indexOf(n);
        if(index < 0)
            return false;
        remove(index);
        return true;
    }

    public int indexOf(Node n){
        Node cursor = head;
        int index =0;
        while(cursor != null){
            index ++;
            if (cursor == n ){
                return index;
            }
        cursor = cursor.getNext();
        index ++;
       
        }
        return -1;
    }



    private int sizeRec(Node cursor) {

        // exit clause
        if (cursor == null)
            return 0;

        // recursive call
        return sizeRec(cursor.getNext()) + 1;
    }

    public int size() {

        return sizeRec(head);
    }




    // iterative version of size method
    // public int length() {

    //     Node cursor = head;
    //     int count = 0;

    //     while (cursor != null) {
    //         count++;
    //         cursor = cursor.getNext();
    //     }

    //     return count;
    // }


    /**
     * Outputs every list item on the console
     */
    public void print() {

        // the node that "moves" inside the list
        Node cursor = head;

        System.out.print("[");

        // I need to reach the very last element
        while (cursor != null) {
            System.out.print(cursor.getValue() + " ");

            // moves the cursor to the next node in the list
            cursor = cursor.getNext();
        }

        //for (Node cursor = head; cursor != null; cursor = cursor.getNext()) {}

        System.out.println("]");
    }


    // recursive version
    private void printRec(Node cursor) {
        // exit clause
        if (cursor == null) {
            return;
        }

        System.out.print(cursor.getValue() + " ");
        
        // recursive call
        printRec(cursor.getNext()); 
    } 

    // wrapper function
    public void printRec() {
        System.out.print("[");
        printRec(head);
        System.out.println("]");
    }
    public void set(int index,Node newNode) throws IndexOutOfBoundsException{
        if (index <0 || index >= size())
            throw new IndexOutOfBoundsException("invalid exit");
        if (newNode == null) return;

        if (index == 0){
            newNode.setNext(head.getNext());
            head = newNode;
            return;
        }

        Node cursor = get(index-1);
        newNode.setNext(cursor.getNext().getNext());
        cursor.setNext(newNode);
    }


    public boolean  contains(Node cercato){
    boolean trovato = false;
    Node cursor = head;
        if (cercato == null)
            return trovato;
            while(cursor != null){
                if(cursor.equals(cercato)){
                return trovato;
                }
                cursor = cursor.getNext();
            }
   return trovato;
        }
    public boolean containsRec(Node n){
        return containsRec(head,n);
        }
    private boolean containsRec(Node cursor,Node n){


        if(cursor == null)return false;
        if(cursor.equals(n)) return true;

        return containsRec(cursor.getNext(), n);
    }
}