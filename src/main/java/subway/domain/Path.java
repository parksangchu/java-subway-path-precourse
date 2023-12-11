package subway.domain;

import java.util.List;

public class Path {
    private static final String NAME_ERROR = "[ERROR] 존재하지 않는 역을 입력하셨습니다.";
    private static final String DUPLICATED_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";
    private final List<Station> stations;

    public Path(List<Station> stations) {
        validateName(stations);
        validateDuplicated(stations);
        this.stations = stations;
    }

    private void validateName(List<Station> stations) {
        if (stations.stream()
                .noneMatch(StationRepository::contains)) {
            throw new IllegalArgumentException(NAME_ERROR);
        }
    }

    private void validateDuplicated(List<Station> stations) {
        if (stations.stream()
                .distinct()
                .count() != stations.size()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR);
        }
    }
}
