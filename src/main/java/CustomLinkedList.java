public class CustomLinkedList<E> {
    private Node<E>head;
    private Node<E>tail;

    private int size;

    private static class Node<E>{
        Node<E>next;
        E value;
        Node(E value){
            this.value = value;
        }
    }

    public void addAtFirst(E val){
        Node<E>newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
        size++;
    }

    public void addLast(E val){
        if (tail == null){
            addAtFirst(val);
            return;
        }
        Node<E>newNode = new Node<>(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int size(){
     return size;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E>cur = head;
        while(cur != null){
            sb.append(cur.value).append("-->");
            cur = cur.next;
        }
        sb.append("End");
        return sb.toString();
    }
    public boolean remove(Object o){
        boolean isRemoved = false;
        Node<E>node = (Node<E>)o;
        Node<E>prev = null;
        Node<E>cur = this.head;
        while (cur != null){
            if (cur.value == node.value){
                if (prev == null){
                    prev = cur = null;
                    isRemoved = true;
                }else{
                    prev.next = cur.next;
                    prev = prev.next;
                }
                cur = cur.next;
            }
        }
        return isRemoved;
    }

    public static void main(String[] args) {
        
    }
}
