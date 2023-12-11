package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String AKS_BUTTON = "\n## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readButton() {
        System.out.println(AKS_BUTTON);
        return scanner.nextLine();
    }
}
