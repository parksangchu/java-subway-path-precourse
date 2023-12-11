package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathTimeRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> pathGroup
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStations() {
        for (Station station : StationRepository.stations()) {
            pathGroup.addVertex(station.getName());
        }
    }

    public static void addPath(String departureStation, String arrivalStation, int interval) {
        pathGroup.setEdgeWeight(pathGroup.addEdge(departureStation, arrivalStation), interval);
    }

    public static List<String> getShortestPath(Path path) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(pathGroup);
        return dijkstraShortestPath.getPath(path.getDepartureStation(), path.getArrivalStation()).getVertexList();
    }

    public static int getTime(List<String> path) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(pathGroup);
        int time = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            time += dijkstraShortestPath.getPathWeight(path.get(i), path.get(i + 1));
        }
        return time;
    }
}
