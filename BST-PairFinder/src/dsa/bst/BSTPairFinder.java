package dsa.bst;

import java.util.LinkedHashSet;
import java.util.Set;

public class BSTPairFinder {

    BinarySearchTree bst;
    Integer sum;

    Set<Integer> previouslyVisitedNodes;


    public BSTPairFinder(BinarySearchTree bst, Integer sum) {

        this.bst = bst;
        this.sum = sum;

        this.previouslyVisitedNodes =
                new LinkedHashSet<>();
        // new HashSet
    }

    void findPairs() {

        preOrderTraversal();
    }

    void preOrderTraversal() {

        // Outcome
        // 70, 50, 30, 20, 40, 60, 90, 80, 100

        // Pre order Travel
        // TODO

        preOrderTraveralInternal(bst.getRoot());
    }

    void preOrderTraveralInternal(Node currentNode) {

        if (currentNode == null) {
            return;
        }

        // Logic
        // currentNode, previousVisitedNodes

        // Find out the difference
        // SumValue - currentNode
        // Check if difference is present in the previous-visited-nodes
        // Match
        // Print the Pair [30, 70]


        Integer difference = (sum - currentNode.getData());
        if (previouslyVisitedNodes.contains(difference)) {

            System.out.println("Match Identified");
            System.out.printf("[%d, %d]",
                    currentNode.getData(), difference);
            System.out.println();
        }

//		System.out.println(currentNode);
        this.previouslyVisitedNodes.add(currentNode.getData());



        preOrderTraveralInternal(currentNode.getLeft());
        preOrderTraveralInternal(currentNode.getRight());
    }



}