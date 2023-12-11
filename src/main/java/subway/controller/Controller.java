package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MainMenu;
import subway.domain.PathCriteria;
import subway.domain.PathDistanceRepository;
import subway.domain.PathTimeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
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
        initService();
        outputView.printMainMenu();
        MainMenu mainMenu = createMainMenu();
        checkPath(mainMenu);
    }

    private void checkPath(MainMenu mainMenu) {
        while (!mainMenu.isQuit()) {
            outputView.printPathCriteria();
            PathCriteria pathCriteria = createPathCriteria();
            if (!pathCriteria.isGoingBack()) {
                Station departureStation = createDepartureStation();
                Station arrivalStation = createArrivalStation();
                if (pathCriteria.isShortestDistance()) {
                    List<String> shortestPath = PathDistanceRepository.getShortestPath(departureStation.getName(),
                            arrivalStation.getName());
                    for (String s : shortestPath) {
                        System.out.println(s);
                    }
                }
                if (!pathCriteria.isShortestDistance()) {
                    List<String> shortestPath = PathTimeRepository.getShortestPath(departureStation.getName(),
                            arrivalStation.getName());
                    for (String s : shortestPath) {
                        System.out.println(s);
                    }
                }

            }
            outputView.printMainMenu();
            mainMenu = createMainMenu();
        }
    }

    private void initService() {
        initStationRepository();
        initLineRepository();
        initPath();
    }

    private void initStationRepository() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private void initLineRepository() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void initPath() {
        initPathDistance();
        initPathTime();
    }

    private void initPathDistance() {
        PathDistanceRepository.addStations();
        PathDistanceRepository.addPath("교대역", "강남역", 2);
        PathDistanceRepository.addPath("강남역", "역삼역", 2);
        PathDistanceRepository.addPath("교대역", "남부터미널역", 3);
        PathDistanceRepository.addPath("남부터미널역", "양재역", 6);
        PathDistanceRepository.addPath("양재역", "매봉역", 1);
        PathDistanceRepository.addPath("강남역", "양재역", 2);
        PathDistanceRepository.addPath("양재역", "양재시민의숲역", 10);
    }

    private void initPathTime() {
        PathTimeRepository.addStations();
        PathTimeRepository.addPath("교대역", "강남역", 3);
        PathTimeRepository.addPath("강남역", "역삼역", 3);
        PathTimeRepository.addPath("교대역", "남부터미널역", 2);
        PathTimeRepository.addPath("남부터미널역", "양재역", 5);
        PathTimeRepository.addPath("양재역", "매봉역", 1);
        PathTimeRepository.addPath("강남역", "양재역", 8);
        PathTimeRepository.addPath("양재역", "양재시민의숲역", 3);
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

    private Station createDepartureStation() {
        while (true) {
            try {
                String name = inputView.readDepartureStation();
                return new Station(name);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Station createArrivalStation() {
        while (true) {
            try {
                String name = inputView.readArrivalStation();
                return new Station(name);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
