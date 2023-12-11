package subway.domain;

public class PathCriteria {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String SHORTEST_TIME = "2";
    private static final String GOING_BACK = "B";
    private static final String BUTTON_ERROR = "[ERROR] 잘못된 경로 기준을 입력하셨습니다.";

    private final String button;

    public PathCriteria(String button) {
        validate(button);
        this.button = button;
    }

    private void validate(String button) {
        if (!button.equals(SHORTEST_DISTANCE) && !button.equals(SHORTEST_TIME) && !button.equals(GOING_BACK)) {
            throw new IllegalArgumentException(BUTTON_ERROR);
        }
    }
}
