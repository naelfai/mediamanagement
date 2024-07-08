package ratings;

import ratings.datastructures.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Map;

public class DegreesOfSeparation {
    private Graph<String> castGraph;

    public DegreesOfSeparation(ArrayList<Movie> movies){
        this.castGraph = new Graph<>();
        buildGraph(movies);
    }

    private void buildGraph(ArrayList<Movie> movies){
        for (Movie movie : movies){
            ArrayList<String> cast = movie.getCast();

            for (int i = 0;i < cast.size(); i++){
                for (int j = i + 1;j < cast.size(); j++){
                    castGraph.addBidirectionalEdge(cast.get(i), cast.get(j));
                }

            }


        }
    }



    public int degreesOfSeparation(String castMember1, String castMember2){
        if (!castGraph.adjacencyList.containsKey(castMember1)||!castGraph.adjacencyList.containsKey(castMember2)){
            return -1;}
        if (castMember1.equals(castMember2)) {
            return 0;}
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> visitedNodes = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();


        queue.add(castMember1);
        visitedNodes.add(castMember1);
        distance.put(castMember1, 0);
        while (!queue.isEmpty()){
            String current = queue.poll();
            int currentDistance = distance.get(current);
            for (String neighborNode : castGraph.adjacencyList.get(current)){
                if (!visitedNodes.contains(neighborNode)){
                    visitedNodes.add(neighborNode);
                    distance.put(neighborNode, currentDistance + 1);
                    queue.add(neighborNode);

                    if (neighborNode.equals(castMember2)){
                        return currentDistance + 1;
                    }

                }
            }


        }
        return -1;
    }
}



