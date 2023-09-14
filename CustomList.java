package CustomListImplementation;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {

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

    public void selectionSort(Comparator<E> comparator) {
        sort(comparator);
    }

    private void sort(Comparator<E> comparator) {
        Node previousNode = head;
        Node currentNode = null;
        Node swapPrevious = new Node(null);
        Node swapCurrent = new Node(null);
        Node swap = null;
        int compared = 0;
        int count = 0;

        while (previousNode.getNext() != null) {
            currentNode = previousNode.getNext();
            while (currentNode != null){

                if(comparator != null) {
                    compared = comparator.compare(currentNode.getItem(), previousNode.getItem());
                }

                if (compared < 0) {
                    swapPrevious.setPrevious(previousNode.getPrevious());
                    swapPrevious.setNext(previousNode.getNext());
                    swapCurrent.setPrevious(currentNode.getPrevious());
                    swapCurrent.setNext(currentNode.getNext());

                    if (currentNode.getNext() != null) {
                        currentNode.getNext().setPrevious(previousNode);
                    }
                    if (previousNode.getPrevious() != null) {
                        previousNode.getPrevious().setNext(currentNode);
                    }

                    currentNode.setPrevious(previousNode.getPrevious());
                    previousNode.setNext(currentNode.getNext());

                    if (swapCurrent.getPrevious() == previousNode) {
                        currentNode.setNext(previousNode);
                        previousNode.setPrevious(currentNode);
                    }
                    else {
                        currentNode.setNext(swapPrevious.getNext());
                        previousNode.setPrevious(swapCurrent.getPrevious());
                        swapPrevious.getNext().setPrevious(currentNode);
                        swapCurrent.getPrevious().setNext(previousNode);
                    }

                    swap = previousNode;
                    previousNode = currentNode;
                    currentNode = swap;
                }
                currentNode = currentNode.getNext();
            }

            count++;
            if (count == 1) {
                head = previousNode;
            }

            previousNode = previousNode.getNext();
            if (count == size - 1) {
                tail = previousNode;
            }
        }
    }

    public void mergeSort(Comparator<E> comparator) {
        mergeSort(this.head, comparator);
    }

    private Node mergeSort(Node head, Comparator<E> comparator) {
        if (head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node secondHead = middle.getNext();
        secondHead.setPrevious(null);
        middle.setNext(null);

        Node leftHead = mergeSort(head, comparator);
        Node rightHead = mergeSort(secondHead, comparator);
        this.head = merge(leftHead, rightHead, comparator);

        return this.head;
    }

    private Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    private Node merge(Node leftHead, Node rightHead, Comparator<E> comparator) {
        Node merged = new Node(null);
        Node temp = merged;
        int compared = 0;

        while (leftHead != null && rightHead != null) {
            compared = comparator.compare(leftHead.getItem(), rightHead.getItem());
            if (compared <= 0) {
                temp.setNext(leftHead);
                leftHead.setPrevious(temp);
                leftHead = leftHead.getNext();
                temp = temp.getNext();
            }
            else {
                temp.setNext(rightHead);
                rightHead.setPrevious(temp);
                rightHead = rightHead.getNext();
                temp = temp.getNext();
            }
        }

        while (leftHead != null) {
            temp.setNext(leftHead);
            leftHead.setPrevious(temp);
            leftHead = leftHead.getNext();
            temp = temp.getNext();
        }

        while (rightHead != null) {
            temp.setNext(rightHead);
            rightHead.setPrevious(temp);
            rightHead = rightHead.getNext();
            temp = temp.getNext();
        }

        this.tail = temp;
        return merged.getNext();
    }

    public Iterator<E> iterator() {
        return new customIterator();
    }

    public class customIterator implements Iterator<E> {
        private Node currentNode = null;
        private Node previousNode = null;
        private boolean hasBeenCalled = false;

        @Override
        public boolean hasNext() {
            if (currentNode == null && head != null) {
                return true;
            } else if (currentNode != null) {
                return currentNode.getNext() != null;
            }
            return false;
        }

        @Override
        public E next() {
            if (currentNode == null && head != null) {
                currentNode = head;
                hasBeenCalled = true;
                return head.getItem();
            } else if (currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                hasBeenCalled = true;
                return currentNode.getItem();
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if (!hasBeenCalled) {
                throw new IllegalStateException();
            }
            if (previousNode == null && currentNode.getNext() == null) {
                head = tail = null;
            } else if (previousNode == null && currentNode.getNext() != null) {
                currentNode.getNext().setPrevious(previousNode);
                currentNode = currentNode.getNext();
                head = currentNode;
            } else if (previousNode != null && currentNode.getNext() == null) {
                previousNode.setNext(null);
                currentNode = previousNode;
                previousNode = previousNode.getPrevious();
                tail = currentNode;
            } else {
                previousNode.setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(previousNode);
            }

            hasBeenCalled = false;
            size--;
        }
    }
}
