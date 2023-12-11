package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainMenuRepository {
    private static final List<MainMenu> mainMenus = new ArrayList<>();

    public static List<MainMenu> mainMenus() {
        return Collections.unmodifiableList(mainMenus);
    }

    public static void addMainMenu(MainMenu mainMenu) {
        mainMenus.add(mainMenu);
    }

    public static boolean deleteMainMenu(String name) {
        return mainMenus.removeIf(mainMenu -> Objects.equals(mainMenu.getName(), name));
    }

    public static void deleteAll() {
        mainMenus.clear();
    }
}
