package examExtras;

import java.util.*;

public class BreadthFirstSearch {

    private Node startNode = new Node("A");

    public BreadthFirstSearch() {
        //Setting up a simple graph

        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        startNode.addNode(B);
        startNode.addNode(C);
        B.addNode(D);
        B.addNode(C);
        C.addNode(B);
        //C.addNode(startNode);
        D.addNode(E);
        E.addNode(F);
    }




    public boolean breadthFirst(Node source, String dest, Queue<Node> queue, Set<String> visited) {
        // creates the lists if value is null
        if (queue == null) {
            queue = new LinkedList<>();
        }

        if (visited == null) {
            visited = new HashSet<>();
            // adds the first current airport code on first node
            visited.add(source.getName());
        }



        if (source.getName().equals(dest)) {
            return true;
        }

        for (Node route : source.getChildren()) {
                if (!visited.contains(route.getName())) {
                    queue.add(route);
                    visited.add(route.getName());
                }
        }

        // If a this point the queue is empty we can return false
        if (visited.isEmpty()) {
            return false;
        }


        Node nextNode = queue.remove();
        return breadthFirst(nextNode, dest, queue, visited);
    }

    public Node getStartNode() {
        return startNode;
    }

    private class Node {

        String name;

        public Node(String name) {
            this.name = name;
        }

        List<Node> children = new ArrayList<>();

        public List<Node> getChildren() {
            return children;
        }

        public void addNode(Node n) {
            children.add(n);
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        System.out.println(bfs.breadthFirst(bfs.getStartNode(), "E", null, null));

    }


}
