package examExtras;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    private Node startNode = new Node("A");

    public DepthFirstSearch() {
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
        C.addNode(startNode);
        D.addNode(E);
        E.addNode(F);
    }


    public Node getStartNode() {
        return startNode;
    }

    public boolean findConnection(Node source, String dest, Set<String> visited) {
        if (visited == null) {
            visited = new HashSet<>();
            visited.add(source.getName());
        }

        for (Node node : source.getChildren()) {
            if(!visited.contains(node.getName())){
                visited.add(node.getName());
                if (node.getName().equals(dest)) return true;

                boolean res = findConnection(node, dest, visited);
                if (res) return true;
            }
        }
        return false;
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
        DepthFirstSearch dfs = new DepthFirstSearch();

        System.out.println(dfs.findConnection(dfs.getStartNode(), "F", null));

    }

//    public boolean depthFirst(String source, String dest, String airlineCode, Set<String> visitedAirports) {
//        // in order to keep track of our visited airports we use a hashset to make sure
//        // we dont check the same airport twice
//        if (visitedAirports == null) {
//            visitedAirports = new HashSet<>();
//            visitedAirports.add(source);
//        }
//
//        // gets the current airport
//        Airport airport = airportMap.get(source);
//        // Check if its the correct airport
//        if (airport.code.equals(dest)) {
//            return true;
//        }
//
//        // itterates over all the airports routes and checks if is from the airline we
//        // want and we have not visited it before
//        for (Route route : airport.routes) {
//            if (route.airlineCode.equals(airlineCode)) {
//                if (visitedAirports.contains(route.destCode)) {
//                    continue;
//                }
//                visitedAirports.add(route.destCode);
//                // call the method recursive with routes dest airport code
//                boolean res = depthFirst(route.destCode, dest, airlineCode, visitedAirports);
//                if (res) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


}
