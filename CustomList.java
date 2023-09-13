package CustomListImplementation;

public class CustomList<E> {

    private class Node {
        private E item;
        private Node next;
        private Node previous;

        private Node(E item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }

        public E getItem() {
            return this.item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return this.previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CustomList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void addNode(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public void addFirst(E item) {
        if (head == null) {
            addNode(item);
        }
        else {
            Node newNode = new Node(item);
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public E removeIndex(int index) {
        if (index < 0 || index >= listSize()) {
            throw new IndexOutOfBoundsException("Invalid index !");
        }

        Node currentNode = head;
        Node previousNode = null;
        int currentIndex = 0;

        while (currentIndex < index) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        size--;
        if (size == 0) {
            head = tail = null;
        }
        else if (previousNode == null) {
            head = head.getNext();
            head.setPrevious(null);
        }
        else if (currentNode.getNext() == null) {
            previousNode.setNext(null);
            tail = previousNode;
        }
        else {
            previousNode.setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(previousNode);
        }
        return currentNode.getItem();
    }

    public int removeValue(E value) {
        Node currentNode = head;
        Node previousNode = null;
        int currentIndex = 0;

        while (currentNode != null) {
            if ((currentNode.getItem() != null) && (currentNode.getItem().equals(value))
                    || (currentNode.getItem() == null) && (value == null)) {
                break;
            }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                currentIndex++;
        }

        if (currentNode != null) {
            size--;
            if(size == 0) {
                head = tail = null;
            }
            else if (previousNode == null) {
                head = head.getNext();
                head.setPrevious(null);
            }
            else if (currentNode.getNext() == null) {
                previousNode.setNext(null);
                tail = previousNode;
            }
            else {
                previousNode.setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(previousNode);
            }
            return currentIndex;
        }
        return -1;
    }

    public void reverse() {
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            currentNode.setPrevious(nextNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        tail = head;
        head = previousNode;
    }

    public int indexOf(E item) {
        Node currentNode = head;
        int currentIndex = 0;

        while (currentNode != null) {
            if(currentNode.getItem() != null && currentNode.getItem().equals(item)
                    || currentNode.getItem() == null && item == null) {
                return currentIndex;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return -1;
    }

    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    public E elementAtIndex(int index) {
        if (index < 0 || index >= listSize()) {
            throw new IndexOutOfBoundsException("Invalid index !");
        }
        Node currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode.getItem();
    }

    public int listSize(){
        return this.size;
    }

    public E firstElement() {
        return this.head.getItem();
    }

    public E lastElement() {
        return this.tail.getItem();
    }
}
