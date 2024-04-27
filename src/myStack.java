public class myStack extends myLinkedList{

    public myStack(){
        super();
    }

    public boolean isEmpty(){
        if(myStack.super.getSize() == 0)
            return true;
        else
            return false;
    }

    public void push(int x){

// create Node for x
        Node n = new Node(x);

        //int x goes to top of stack -- insert front
        myStack.super.insertFront(n);

    }

    public int pop(){
        //value at top of stack is deleted and returned by the method
        int copy = myStack.super.getItem(1);
        myStack.super.deleteFront();
        return copy;
    }

    public int top(){
        //returns the value at the top but does not delete the item

        return myStack.super.getItem(1);

    }

}