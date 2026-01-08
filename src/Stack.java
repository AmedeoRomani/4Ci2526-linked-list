public class Stack {
    
    //head of the list
    private Node top;

    public Stack(){
        this.top = null;
    }
    public Stack(Node newNode){
        this.top = newNode;
    }
    public boolean isEmpty(){
        return top == null;
    }

    public int head(){

    }

    public Node push(Node newNode){
        Node cursore;
        cursore = 
        newNode.setNext(top);
    }

    public Node pop(){
        Node cursor;
        cursor 
        //cambio il riferimento
        top = top.getNext();
        //rimuovere il riferimento di prima 
    }
}
