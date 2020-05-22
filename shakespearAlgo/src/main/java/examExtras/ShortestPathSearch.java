package examExtras;

import java.util.*;
import java.util.PriorityQueue;

public class ShortestPathSearch {

    private Node startNode = new Node("A");

    public ShortestPathSearch() {



        Node b = new Node("B");

        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        startNode.addRoute(new Route(2, b));
        startNode.addRoute(new Route(6, c));
        c.addRoute(new Route(3, d));
        d.addRoute(new Route(4, f));

        d.addRoute(new Route(1, e));
        b.addRoute(new Route(11, e));
    }

    public Node getStartNode() {
        return startNode;
    }

    public Map<String, ShortestGraphTable> findShortestDistance(Node current, String dest, Map<String, ShortestGraphTable> nodeTable, Queue<Route> queue) {
        if (nodeTable == null) {
            nodeTable = new HashMap<>();
            nodeTable.put(current.getName(), new ShortestGraphTable(0, current, null));
        }
        if (queue == null) {
            queue = new PriorityQueue<>(Comparator.comparingInt(Route::getDistance));
        }

        if (current.getName().equals(dest)) {
            return nodeTable;
        }


        for (Route route : current.getChildren()) {

            int currentNodeDistance = nodeTable.get(current.getName()).distance + route.getDistance();

            if (!nodeTable.containsKey(route.getDestination().getName())) {
                queue.add(route);
                nodeTable.put(route.getDestination().getName(), new ShortestGraphTable(currentNodeDistance, route.getDestination(), current));
            } else {
                int nextDistance = nodeTable.get(route.getDestination().getName()).distance;
                if (currentNodeDistance < nextDistance) {
                    queue.add(route);
                    nodeTable.put(route.getDestination().getName(), new ShortestGraphTable(currentNodeDistance, route.getDestination(), current));
                }
            }
        }

        if (queue.isEmpty()) {
            return nodeTable;
        }
        Route r = queue.remove();
        Node n = r.getDestination();
        return findShortestDistance(n, dest, nodeTable, queue);
    }

    private class ShortestGraphTable{

            public final int distance;
            public final Node node;
            public final Node edge;

            public ShortestGraphTable(int distance, Node node, Node edge) {
                this.distance = distance;
                this.node = node;
                this.edge = edge;
        }
    }
    private class Node {

        String name;

        public Node(String name) {
            this.name = name;
        }

        List<Route> children = new ArrayList<>();

        public List<Route> getChildren() {
            return children;
        }

        public void addRoute(Route n) {
            children.add(n);
        }

        public String getName() {
            return name;
        }


    }

    private class Route {

        private int distance;
        private Node destination;

        public Route(int distance, Node destination) {
            this.distance = distance;
            this.destination = destination;
        }


        public Node getDestination() {
            return destination;
        }

        public int getDistance() {
            return distance;
        }



        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        ShortestPathSearch sps = new ShortestPathSearch();
        Map<String, ShortestGraphTable> map = sps.findShortestDistance(sps.getStartNode(), "E", null, null);



    }

}
