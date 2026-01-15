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

  //  public int head(){
   //     if (isEmpty()) throw new NullPointerException();

    //    return top.getData;

   // }

    public void push(Node newNode){
        newNode.setNext(top);
        this.top = newNode;
    }

    public Node pop(){
        Node cursor = this.top;
        
        //cambio il riferimento
        top = top.getNext();
        //rimuovere il riferimento di prima 
        cursor.setNext(null);
        return cursor;
    }
}
