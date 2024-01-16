package linear;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> search(int index) {
        Node<E> node;

        if ((size / 2) > index) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    public void addFirst(E value) {
        Node<E> first = head;

        Node<E> newNode = new Node<>(null, value, first);

        size++;

        head = newNode;

        if (first == null) {
            tail = newNode;
        } else {
            first.prev = newNode;
        }
    }

    public void addLast(E value) {
        Node<E> last = tail;

        Node<E> newNode = new Node<>(last, value, null);

        size++;

        tail = newNode;

        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void add(int index, E value) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> nextNode = search(index);

        Node<E> prevNode = nextNode.prev;

        Node<E> newNode = new Node<>(prevNode, value, nextNode);

        size++;

        prevNode.next = newNode;

        nextNode.prev = newNode;
    }

    public E removeFirst() {

        // 1. 만약 삭제할 요소가 아무것도 없으면 에러
        if (head == null) {
            throw new NoSuchElementException();
        }

        // 2. 삭제될 첫번째 요소의 데이터를 백업
        E value = head.data;

        // 3. 두번째 노드를 임시 저장
        Node<E> first = head.next;

        // 4. 첫번째 노드의 내부 요소를 모두 삭제
        head.next = null;
        head.data = null;

        // 5. 요소가 삭제 되었으니 크기 감소
        size--;

        // 6. head가 다음 노드를 가리키도록 업데이트
        head = first;

        if (first == null) {
            // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
            tail = null;
        } else {
            // 8. 만일 빈 리스트가 아닐경우, 삭제되기 이전 두번째 이었던 first가 첫번째 노드가 되니 prev를 null 처리
            first.prev = null;
        }

        // 9. 마지막으로 삭제된 요소를 반환
        return value;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeLast() {

        // 1. 만약 삭제할 요소가 아무것도 없으면 에러
        if (tail == null) {
            throw new NoSuchElementException();
        }

        // 2. 삭제될 첫번째 요소의 데이터를 백업
        E value = tail.data;

        // 3. 마지막 노드의 이전 노드를 임시 저장
        Node<E> last = tail.prev;

        // 4. 마지막 노드의 내부 요소를 모두 삭제
        tail.data = null;
        tail.prev = null;

        // 5. 요소가 삭제 되었으니 크기 감소
        size--;

        // 6. tail이 이전 노드를 가리키도록 업데이트
        tail = last;

        if (last == null) {
            // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, head도 null 처리
            head = null;
        } else {
            // 8. 만일 빈 리스트가 아닐경우, 삭제되기 이전 마지막의 이전 노드 이었던 last가 마지막 노드가 되니 next를 null 처리
            last.next = null;
        }

        // 9. 마지막으로 삭제된 요소를 반환
        return value;
    }

    public E remove(int index) {

        // 1. 인덱스가 0보다 작거나 size 보다 크거나 같은 경우 에러 (size와 같을 경우 빈 공간을 가리키는 거니까)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 인덱스가 0이면 removeFirst 메서드 실행
        if (index == 0) {
            return removeFirst();
        }

        // 3. 인덱스가 size - 1(마지막 요소 위치) 이면 removeLast 메서드 실행
        if (index == size - 1) {
            return removeLast();
        }

        // 4. 삭제할 위치의 노드 저장
        Node<E> delNode = search(index);

        // 5. 삭제할 위치의 이전 노드 저장
        Node<E> prevNode = delNode.prev;

        // 6. 삭제할 위치의 다음 노드 저장
        Node<E> nextNode = delNode.next;

        // 7. 삭제될 첫번째 요소의 데이터를 백업
        E value = delNode.data;

        // 8. 삭제 노드의 내부 요소를 모두 삭제
        delNode.data = null;
        delNode.prev = null;
        delNode.next = null;

        // 9. 요소가 삭제 되었으니 크기 감소
        size--;

        // 10. 이전 노드가 다음 노드를 가리키도록 업데이트
        prevNode.next = nextNode;

        // 11. 다음 노드가 이전 노드를 가리키도록 업데이트
        nextNode.prev = prevNode;

        // 12. 마지막으로 삭제된 요소를 반환
        return value;
    }

    public boolean remove(Object value) {

        // 1. 삭제 노드를 저장할 변수 선언
        Node<E> delNode = null;

        // 2. 리스트를 루프할 변수 선언
        Node<E> i = head;

        // 3. 노드의 next를 순회하면서 해당 값을 찾는다.
        while (i != null) {

            // 노드의 값과 매개변수 값이 같으면
            if (Objects.equals(i.data, value)) {
                delNode = i; // 삭제 노드에 요소를 대입하고 break
                break;
            }

            i = i.next;
        }

        // 4. 만일 찾은 요소가 없다면 false 리턴
        if (delNode == null) {
            return false;
        }

        // 5. 만약 삭제하려는 노드가 head(첫번째 요소) 라면, 기존 removeFirst()를 사용
        if (delNode == head) {
            removeFirst();
            return true;
        }

        // 6. 만약 삭제하려는 노드가 last(마지막 요소) 라면, 기존 removeLast()를 사용
        if (delNode == tail) {
            removeLast();
            return true;
        }

        // 7. 이전 노드, 다음 노드 구하기
        Node<E> prevNode = delNode.prev;
        Node<E> nextNode = delNode.next;

        // 8. 삭제 요소 데이터 모두 제거
        delNode.data = null;
        delNode.prev = null;
        delNode.next = null;

        // 9. 요소가 삭제 되었으니 크기 감소
        size--;

        // 10. 이전 노드와 다음 노드 끼리 서로 링크드 설정
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return true;
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

        // 1. search 메소드를 이용해 교체할 노드를 얻는다.
        Node<E> replace_node = search(index);

        // 2. 교체할 노드의 요소를 변경한다.
        replace_node.data = null;
        replace_node.data = value;
    }

    public int indexOf(Object value) {
        Node<E> node = head;
        int i = 0;
        while (node != null) {
            if (Objects.equals(value, node.data)) {
                return i;
            }

            i++;
            node = node.next;
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        Node<E> node = tail;
        int i = size - 1;
        while (node != null) {
            if (Objects.equals(value, node.data)) {
                return i;
            }

            i--;
            node = node.prev;
        }

        return -1;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (Node<E> i = head; i.next != null; ) {
            Node<E> next_node = i.next;

            i.data = null;
            i.prev = null;
            i.next = null;

            i = next_node;
        }

        head = null;
        tail = null;

        size = 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
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
}
