package subway.controller;

import subway.domain.MainMenu;
import subway.domain.PathCriteria;
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
        checkPath(mainMenu);
    }

    private void checkPath(MainMenu mainMenu) {
        while (!mainMenu.isQuit()) {
            outputView.printPathCriteria();
            PathCriteria pathCriteria = createPathCriteria();
            if (!pathCriteria.isGoingBack()) {
                System.out.println("aaaaa");
            }
            outputView.printMainMenu();
            mainMenu = createMainMenu();
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

    private PathCriteria createPathCriteria() {
        while (true) {
            try {
                String button = inputView.readButton();
                return new PathCriteria(button);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
