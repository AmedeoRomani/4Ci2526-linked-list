public class CircularList {
    private Node head;
    private Node last;

    // private int value;

    public CircularList(Node head, Node last) {
        this.head = head;
        this.last = last;
    }

    public void print(){
        int contatore = 0;
        Node coursore = head;

        while(true){
            if(coursore == last){
                break;
            }
            System.out.println(coursore.getValue();); 
            coursore.getNext();
        }
    }

    public boolean checkRing() {
        Node coursore = head;
        if (coursore == null)
            return false;
        while (true) {

            if (coursore == last)
                return true;

            coursore.getNext();
        }
    }

    public int removeRange(int start, int end) {
        int sottrazione = start - end;
        Node cursor = head;
        int contatore = 0;
        if (head == null)
            return contatore;
        while (true) {
            cursor.getNext();
            if (contatore == start - 1) {
                for (int i = 0; i < sottrazione; i++) {
                    cursor.setNext(cursor.getNext());
                }
                return contatore;
            }
        }
    }

    public void cut(int index) {
        if (index == 0) {
            head = last;
        }
        Node cursor = head;
        int contatore = 0;

        while (true) {
            if (contatore == index) {
                cursor = last;
            }
            contatore++;
            cursor.getNext();
        }
    }

    public Node prev(Node n) {
        Node cursor = head;
        while (true) {
            if (cursor.getNext().equals(n)) {
                return cursor;
            }
        }
    }

    public void newRing(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            n1.setNext(head);
            this.head = n1;
            last.setNext(n2);
            n2 = last;
        }
        if (n1 != null && n2 == null) {
            Node cursor = head;
            while (cursor == n1) {
                if (cursor == n1) {
                    n1 = head;
                    last.setNext(n2);
                    n2 = last;
                    return;
                }
                cursor.getNext();
            }
        }
        if (n1 != null && n2 != null) {
            Node cursor = head;
            while (cursor == n1) {
                if (cursor == n1) {
                    n1 = head;
                    last.setNext(n2);
                    n2 = last;
                    return;
                }
                cursor.getNext();
            }
        }
    }
}