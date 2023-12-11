package subway.controller;

import subway.domain.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printMainMenu();
        MainMenu mainMenu = createMainMenu();
        if (!mainMenu.isQuit()) {
            outputView.printPathCriteria();
            
        }
    }

    private MainMenu createMainMenu() {
        while (true) {
            try {
                String button = inputView.readButton();
                return new MainMenu(button);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
