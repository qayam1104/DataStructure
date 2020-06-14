package datastructure;


class LinkedListRunner {
    public static void main(String[] args) throws Exception {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast("Hello");
        myLinkedList.addLast("World");
        myLinkedList.addLast("Jan");
        myLinkedList.addLast("Feb");
        myLinkedList.addAtPosition("March",3);
        myLinkedList.removeAtIndex(4);
       for(int i =0;i<myLinkedList.size(); i++){
           System.out.println(myLinkedList.get(i));
       }


    }
}

public class MyLinkedList<T> {

    Node<T> head;
    Node<T> tail;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(T value) {
        Node<T> node = new Node(value);

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(T value) {
        Node<T> node = new Node(value);

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next=node;
            tail=node;
        }
    }


    public void addAtPosition(T value, int i) throws Exception {

 /*       if(i>this.size()-1){
            throw new Exception("index is bigger than size of list ");
        }

        if(i==0)
            this.addFirst(value);
        else if(i==this.size())
            this.addLast(value);

        else {*/
            Node<T> node = new Node(value);
            Node<T> crntNode = head;
            Node<T> prevNode = head;
            int cnt = 0;
            while (cnt != i) {
                prevNode = crntNode;
                crntNode = crntNode.next;

                cnt++;
            }

            prevNode.next = node;
            node.next = crntNode;
        }

  //  }


    public void removeFirst() {
        Node<T> temp=head;
        head=temp.next;
        temp=null;

    }

    public void removeLast() {
        Node<T> temp=head;
        Node<T> prev = head;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;

        tail=prev;
        prev=null;
        temp=null;

    }

    public void removeAtIndex(int i) {

        if(i==0){
            removeFirst();
        }

        if (i==size()){
            removeLast();
        }

        Node<T> temp=head;
        Node<T> prev=head;
        int cnt = 0;
        while(cnt!=i){
            prev=temp;
            temp=temp.next;
            cnt++;
        }
        prev.next=temp.next;

        temp=null;

    }

    public int size() {
        int cnt = 0;
        Node<T> crntNode;
        crntNode = head;
        while (crntNode != null) {
            crntNode = crntNode.next;
            cnt++;

        }
        return cnt;

    }

    public T get(int index){

        Node<T> crntNode;
        int i=0;
        crntNode = head;
        while(crntNode!=null){
            if(i==index){
                return crntNode.getValue();
            }
            else{
                crntNode = crntNode.next;
                i++;
            }

        }

        return null;
    }


}

class Node<T> {

    T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
