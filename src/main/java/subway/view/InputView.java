package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String AKS_BUTTON = "\n## 원하는 기능을 선택하세요.";
    private static final String ASK_DEPARTURE_STATION = "\n## 출발역을 입력하세요.";
    private static final String ASK_ARRIVAL_STATION = "\n## 도착역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readButton() {
        System.out.println(AKS_BUTTON);
        return scanner.nextLine();
    }

    public String readDepartureStation() {
        System.out.println(ASK_DEPARTURE_STATION);
        return scanner.nextLine();
    }

    public String readArrivalStation() {
        System.out.println(ASK_ARRIVAL_STATION);
        return scanner.nextLine();
    }
}
