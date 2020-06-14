package datastructure;

class DListRunner{
    public static <T> void main(String[] args) {

        MyDoubleLinkedList<String> dl = new MyDoubleLinkedList<>();
       dl.addAtEnd("data");
       dl.addAtEnd("Structure");
       dl.addAtEnd("DOuble");
       dl.addAtEnd("Linked");
       dl.addAtEnd("List");
       dl.addAtIndex(5,"intr");
        dl.addAtBeg("nskdhde");

        //dl.deleteAtFirst();
       // dl.deleteAtLast();
      MyDoubleLinkedList.DNode ab=dl.deleteAtIndex(2);
        dl.dispaly();


    }
}
public class MyDoubleLinkedList<T> {

    DNode<T> head;
    DNode<T> tail;
    int size = 0;

    public void addAtBeg(T data) {
        DNode crntNode = new DNode(data);
        if (head == null && tail == null) {
            head = crntNode;
            tail = crntNode;
            size++;
        } else {
            head.prev = crntNode;
            crntNode.next = head;
            head = crntNode;
            size++;

        }

    }

    public void addAtEnd(T data) {
        DNode crntNode = new DNode(data);
        if (head == null && tail == null) {
            head = crntNode;
            tail = crntNode;
            size++;
        } else {
            tail.next = crntNode;
            crntNode.prev = tail;
            tail = crntNode;
            size++;

        }
    }

    public void addAtIndex(int pos, T data) {
        if (pos == 0) {
            addAtBeg(data);
            return;
        }
        if (pos == size) {
            addAtEnd(data);
            return;
        }
        if (pos > size) {
            System.out.println("invlaid position: " + pos);
            return;
        }
        DNode crntNode = new DNode(data);
        DNode tempBefore = head;
        DNode tempAfter = head;
        int i = 0;
        while (i != pos) {
            tempBefore = tempAfter;
            tempAfter = tempAfter.next;
            i++;
        }

        tempBefore.next = crntNode;
        crntNode.prev = tempBefore;
        crntNode.next = tempAfter;
        tempAfter.prev = crntNode;
        size++;


    }

    public void dispaly() {

        if (head == null) {
            System.out.println("List is empty No data to display");
            return;
        }
        DNode crntNode = head;
        while (crntNode != null) {
            System.out.println(crntNode.data);
            crntNode = crntNode.next;
        }
    }

    public DNode<T> deleteAtFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        DNode<T> crntNode = head;

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = crntNode.next;
            head.prev = null;
            //crntNode = null;
        }
        size--;
        return crntNode;

    }


    public DNode<T> deleteAtLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        DNode<T> crntNode = tail;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            tail = crntNode.prev;
            tail.next = null;
        }
        size--;
        return crntNode;
    }

    public DNode<T> deleteAtIndex(int pos) {
        if (pos > size) {
            throw new RuntimeException("Index is not valid: " + pos);
        }

        DNode crntNode = head;
        DNode tempNode = crntNode;
        if (pos == 0) {
            deleteAtLast();
        } else if (pos == size - 1)
            deleteAtLast();
        else {
            for (int i = 0; i < pos && crntNode.next!=null; i++) {
                crntNode = crntNode.next;
            }
            crntNode.prev.next = crntNode.next;
            crntNode.next.prev = crntNode.prev;
            tempNode = crntNode;
            crntNode = null;
            size--;

        }
        return tempNode;
    }


    class DNode<T> {

        T data;
        DNode<T> prev;
        DNode<T> next;

        DNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }


    }
}
