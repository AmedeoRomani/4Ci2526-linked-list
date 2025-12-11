public class CustomList {
    
    private Node head;

    public CustomList() {
        this.head = null;
    }

    public CustomList(Node newHead) {
        this.head = newHead;
    }

    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {
        /* 
        if(isEmpty()){
            this.head = newNode;
            return;
        }
        Node cursor = head;

        while(cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        cursor.setNext(newNode);
        */ 
    }
    private void appendRec(Node cursor, Node newNode) {
        if (cursor.getNext() == null){
            cursor.setNext(newNode);
            return;

        }
        appendRec(cursor.getNext(),newNode);
    }
    public void appendRec(Node newNode){
        if(isEmpty())
            this.head = newNode;
        else
            appendRec(head, newNode);
    }
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Outputs every list item on the console
     */
    /* 
    public void print() {
        Node cursor = head;
        System.out.print("[");
        while (cursor != null) {
            System.out.print(cursor.getValue()+ " ");
            cursor = cursor.getNext();
        }
        System.out.print("]");
        }
        */
    
        private void printRec(Node cursor){
            if (cursor == null)
                return;
            System.out.println(cursor.getValue()+ " ");

            printRec(cursor.getNext());
        }

        public void printRec(){
            System.out.print("[");
            printRec(head);
            System.out.print("]" +" ");
        }
    
}
