package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {

    public CustomTree() {
        nodes.add(new Node("0", null));
    }

    @Override
    public boolean add(String nodeName) {

        Node last = nodes.get(indexAdd);
        if (last.getLeft() != null & last.getRight() != null) {
            ++indexAdd;
            last = nodes.get(indexAdd);
        }

        if (last.getLeft() == null) {
            Node newNode = new Node(nodeName, last);
            nodes.add(newNode);
            last.setLeft(newNode);
            return true;
        } else if (last.getRight() == null) {
            Node newNode = new Node(nodeName, last);
            nodes.add(newNode);
            last.setRight(newNode);
            return true;
        }

        return false;
    }


    @Override
    public boolean remove(Object o) {
        Node rNode = null;
        for (Node node : nodes) {
            if (node.getNodeName().equals(o)) {
                rNode = node;
                break;
            }
        }
        if (rNode != null) {
            removeChild(rNode);
            Node p = rNode.getParent();
            if (p.getRight().equals(rNode)) {
                p.setRight(null);
            } else p.setLeft(null);
            return true;
        } else return false;
    }

    private void removeChild(Node parrent) {
        if(nodes.indexOf(parrent) <= indexAdd){
            --indexAdd;
        }
        nodes.remove(parrent);

        if (parrent.getLeft() != null) {
            removeChild(parrent.getLeft());
        }
        if (parrent.getRight() != null) {
            removeChild(parrent.getRight());
        }
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public String getParent(String nodeChildName) {
        for (Node node : nodes) {
            if (node.getNodeName().equals(nodeChildName)) {
                return node.getParent().getNodeName();
            }
        }
        return "null";
    }


    private static class Node {

        public Node(String nodeName, Node parrent) {
            this.nodeName = nodeName;
            this.parent = parrent;
        }

        public Node getParent() {
            return parent;
        }

        public String getNodeName() {
            return nodeName;

        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        private String nodeName;
        private Node parent;
        private Node left;
        private Node right;
    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
        list.add("16");

    }

    private static List<Node> nodes = new ArrayList<>();
    private static int indexAdd = 0;

}
