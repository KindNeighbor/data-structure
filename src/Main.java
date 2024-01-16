import linear.DoubleLinkedList;
import nonlinear.Tree;

public class Main {

    public static void main(String[] args) {

        DoubleLinkedList<Number> list = new DoubleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(list);

        list.removeFirst();

        System.out.println(list);

        list.removeLast();

        System.out.println(list);

        list.remove(2.5);

        System.out.println(list);

        System.out.println(list.get(2));
        list.set(1, 3.5);

        System.out.println(list);




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
