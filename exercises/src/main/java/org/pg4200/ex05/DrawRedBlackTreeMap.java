package org.pg4200.ex05;

import org.pg4200.les05.MyMapRedBlackTree;

/*
         [5]
        /   \
       /     \
    (3)       [6]
   /   \     /   \
 [2]   [4] (0)   (0)
* */

public class DrawRedBlackTreeMap<K extends Comparable<K>, V> extends MyMapRedBlackTree<K, V> {
    public static void main(String[] args) {
        DrawRedBlackTreeMap<Integer, String> tree = new DrawRedBlackTreeMap<>();

        tree.put(3, "");

        tree.draw();

        tree.put(2, "");
        tree.draw();

        tree.put(6, "");
        tree.draw();


        tree.put(5, "");
        tree.draw();


        tree.put(4, "");
        tree.draw();
    }

    public void draw() {

        boolean leftExist = root.left != null;
        boolean rightExist = root.right != null;
        //
        printSpaces(9);
        System.out.println(node(root));

        if (!leftExist && !rightExist) {
            System.out.println();
            return;
        }
        //
        printSpaces(8);
        if (leftExist) print("/");
        else printSpaces(1);

        printSpaces(3);
        if (rightExist) print("\\");

        System.out.println();

        //
        printSpaces(7);

        if (leftExist) print("/");
        else printSpaces(1);

        printSpaces(5);
        if (rightExist) print("\\");

        System.out.println();

        //
        printSpaces(4);
        if (leftExist) print(node(root.left));
        else printSpaces(3);

        printSpaces(7);

        if (rightExist) print(node(root.right));
        System.out.println();

        //

        boolean leftLeftExist = leftExist && root.left.left != null;
        boolean leftRightExist = leftExist && root.left.right != null;
        boolean rightLeftExist = rightExist && root.right.left != null;
        boolean rightRightExist = rightExist && root.right.right != null;

        if (!leftLeftExist && !leftRightExist && !rightLeftExist && !rightRightExist){
            System.out.println();
            return;
        }

        printSpaces(3);
        print(leftLeftExist ? "/" : " ");
        printSpaces(3);
        print(leftRightExist ? "\\" : " ");
        printSpaces(5);
        print(rightLeftExist ? "/" : " ");
        printSpaces(3);
        print(rightRightExist ? "\\" : " ");

        System.out.println();

        //
        printSpaces(1);
        if (leftLeftExist) print(node(root.left.left));
        else printSpaces(3);

        printSpaces(3);
        if (leftRightExist) print(node(root.left.right));
        else printSpaces(3);

        printSpaces(1);

        if (rightLeftExist) print(node(root.right.left));
        else printSpaces(3);

        printSpaces(3);
        if (rightRightExist) print(node(root.right.right));
        else printSpaces(3);

        System.out.println("\n");
    }

    private String node(TreeNode node){
        String nodeString = "";

        if (node.is_red){
            nodeString += "(";
        }else {
            nodeString += "[";
        }

        nodeString += node.key;

        if (node.is_red){
            nodeString += ")";
        }else {
            nodeString += "]";
        }

        return nodeString;
    }

    public static void printSpaces(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }

    public static void print(String string){
        System.out.print(string);
    }
}
