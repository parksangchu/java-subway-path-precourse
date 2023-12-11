package subway.domain;

public class MainMenu {
    private static final String PATH_INQUIRY = "1";
    private static final String QUIT = "Q";
    private static final String BUTTON_ERROR = "[ERROR] 잘못된 메인 화면을 입력하셨습니다.";
    private final String button;

    public MainMenu(String button) {
        validate(button);
        this.button = button;
    }

    private void validate(String button) {
        if (!button.equals(PATH_INQUIRY) && !button.equals(QUIT)) {
            throw new IllegalArgumentException(BUTTON_ERROR);
        }
    }

    public boolean isQuit() {
        return button.equals("Q");
    }
}
