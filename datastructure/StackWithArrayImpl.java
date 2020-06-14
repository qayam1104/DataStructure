package datastructure;

public class StackWithArrayImpl {

    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>(4);
        myStack.push(2);
        myStack.push(3);
        myStack.push(9);
        myStack.push(11);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

    }
}

class MyStack<T>{

    T array [] ;
    int top=-1;

    MyStack(int size){
        this.array = (T[]) new Object[size];
    }

    public void push(T value){
      if(top==array.length-1){
          System.out.println("Stack is full, cannot push element:"+value);
          return;
      }
       top++;
       array[top]=value;
        System.out.println("Element pushed to stack:"+value);

  }

    public T pop(){
        if(top<0){
            System.out.println("Stack is empty");
            return null;
        }
       T data = array[top];
        array[top] = null;
        top--;
        System.out.println("Element poped from stack:"+data);
        return data;

    }

    public T peek() {
        return array[top] ;
    }

    public int size(){
        return top;
    }
}
