package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathDistanceRepository {
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

    public static List<String> getShortestPath(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(pathGroup);
        return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
    }
}
