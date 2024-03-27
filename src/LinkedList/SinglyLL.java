package LinkedList;

public class SinglyLL {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

        Node(int data,Node node){
            this.data = data;
            this.next = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    Node head;
    SinglyLL(){
        this.head=null;
    }

    public void displayLL(){
        Node current = head;
        while (current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void insertFirst(int data){
        Node current  = new Node(data);
        current.next=head;
        head=current;
    }

    public void insertLast(int data){
        Node node  = new Node(data);
        Node current = this.head;
        if(current==null){
            this.head=node;
        }else {
            while (current.next!=null){
                current=current.next;
            }
            current.next=node;
        }
    }

    public void insert(int data ,int index){
        Node node = new Node(data);
        Node current = head;
        if(index==0){
           node.next=head;
           head=node;
           return;
        }else{
            for (int i = 1; i < index; i++) {
                current=current.next;
            }
            if(current!=null){
                node.next = current.next;
                current.next=node;
            }
        }
    }
}


