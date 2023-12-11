package subway.view;

import java.util.List;

public class OutputView {
    private static final String MAIN_MENU = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String PATH_CRITERIA = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static final String DISTANCE_AND_TIME_FORMAT = "\n## 조회 결과\n[INFO] ---\n[INFO] 총 거리: %dkm"
            + "\n[INFO] 총 소요 시간: %d분\n[INFO] ---\n";
    private static final String STATION_FORMAT = "[INFO] %s\n";

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printPathCriteria() {
        System.out.println(PATH_CRITERIA);
    }

    public void printResult(int distance, int time, List<String> shortestPath) {
        System.out.printf(DISTANCE_AND_TIME_FORMAT, distance, time);
        shortestPath.forEach(station -> System.out.printf(STATION_FORMAT, station));
    }
}
