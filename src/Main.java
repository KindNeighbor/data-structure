import linear.DoubleLinkedList;
import linear.SingleLinkedList;
import nonlinear.Tree;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================단일 연결리스트======================");

        SingleLinkedList<Number> l = new SingleLinkedList<>();

        l.add(1);
        l.add(3);
        l.add(5);
        l.add(7);
        l.add(9);
        l.add(11);
        l.add(13);
        System.out.println(l);

        l.add(6, 100);
        l.add(0, 101);
        l.add(1, 102);
        System.out.println(l);

        l.removeFirst();
        l.removeFirst();
        l.remove(1);
        System.out.println(l);

        l.remove(new Integer(5));
        l.remove(new Integer(9));
        System.out.println(l);

        System.out.println(l.get(4));

        l.set(4, 999);
        System.out.println(l);
        System.out.println("=====================================================");

//        System.out.println("==================이중 연결리스트======================");

//        DoubleLinkedList<Number> list = new DoubleLinkedList<>();
//        list.addFirst(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//
//        System.out.println(list);
//
//        list.removeFirst();
//
//        System.out.println(list);
//
//        list.removeLast();
//
//        System.out.println(list);
//
//        list.remove(2.5);
//
//        System.out.println(list);
//
//        System.out.println(list.get(2));
//        list.set(1, 3.5);
//
//        System.out.println(list);


//        Tree normalTree = new Tree();
//        normalTree.add(1);
//        normalTree.add(2);
//        normalTree.add(3);
//        normalTree.add(4);
//        normalTree.add(5);
//        normalTree.add(6);
//        normalTree.add(7);
//        normalTree.add(8);
//        normalTree.add(9);
//        normalTree.add(10);
//        normalTree.add(11);
//        normalTree.add(12);
//        normalTree.printTree();
//        System.out.println("traversal");
//        normalTree.levelOrder();
    }
}
