package subway.view;

public class OutputView {
    private static final String MAIN_MENU = "## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String PATH_CRITERIA = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printPathCriteria() {
        System.out.println(PATH_CRITERIA);
    }
}
