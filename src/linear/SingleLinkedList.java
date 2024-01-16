package linear;

import java.util.Objects;

public class SingleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> search(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void addFirst(E value) {

        Node<E> first = head;

        Node<E> newNode = new Node<>(value, first);

        size++;

        head = newNode;

        if (first == null) {
            tail = newNode;
        }
    }

    public void addLast(E value) {

        Node<E> last = tail;

        Node<E> newNode = new Node<>(value, null);

        size++;

        tail = newNode;

        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
    }

    public void add(int index, E value) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size - 1) {
            addLast(value);
            return;
        }

        Node<E> prevNode = search(index - 1);

        Node<E> nextNode = prevNode.next;

        Node<E> newNode = new Node<>(value, nextNode);

        size++;

        prevNode.next = newNode;
    }


    public boolean add(E value) {
        addLast(value);
        return true;
    }


    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        Node<E> n = head;
        String result = "[";

        while (n.next != null) {
            result += n.data + ", ";
            n = n.next;
        }

        result += n.data + "]";

        return result;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return search(index).data;
    }

    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> replace_node = search(index);

        replace_node.data = null;
        replace_node.data = value;
    }

    public E removeFirst() {

        if (head == null) {
            throw new RuntimeException();
        }

        E returnValue = head.data;

        Node<E> first = head.next;

        head.next = null;
        head.data = null;

        head = first;

        size--;

        if (head == null) {
            tail = null;
        }

        return returnValue;
    }

    public E remove() {
        return removeFirst();
    }

    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }

        Node<E> prevNode = search(index - 1);

        Node<E> delNode = prevNode.next;

        Node<E> nextNode = delNode.next;

        E returnValue = delNode.data;

        delNode.next = null;
        delNode.data = null;

        size--;

        prevNode.next = nextNode;

        return returnValue;
    }

    public boolean remove(Object value) {

        if (head == null) {
            throw new RuntimeException();
        }

        Node<E> prevNode = null;
        Node<E> delNode = null;
        Node<E> nextNode = null;

        Node<E> i = head;

        while (i != null) {
            if (Objects.equals(i.data, value)) {
                delNode = i;
                break;
            }

            prevNode = i;

            i = i.next;
        }

        if (delNode == null) {
            return false;
        }

        if (delNode == head) {
            removeFirst();
            return true;
        }

        nextNode = delNode.next;

        delNode.next = null;
        delNode.data = null;

        size--;

        prevNode.next = nextNode;

        return true;
    }

    public E removeLast() {
        return remove(size - 1);
    }
}

