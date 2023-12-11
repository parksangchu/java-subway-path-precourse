package subway.domain;

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
}
