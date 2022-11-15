package logic;

import containers.Colony;
import containers.ants.AntCasts;
import utilities.DisplayBoard;

public class Game {

    private Colony colony;
    private ColonyLogic colonyLogic;

    public Game() {
        this.colonyLogic = new ColonyLogic();
    }

    public void start() {
//        int colonySize = Input.askUserForColonySize();
        int colonySize = 9;
        createColony(colonySize);
        colony.generateAnts(20, 0, 50);

        DisplayBoard.print(colony);

        int repeat = 0;
        while (repeat < 10) {
//            for (AntCasts ant:colony.getAntsList()) {
//                System.out.println("x- " + ant.getPosition().getX() + ", y- " + ant.getPosition().getY()+ " antType: " + ant.getPosition().getUnicodeRepresentation());
//
//            }
            System.out.println("--------------------" + repeat);
            colonyLogic.update(colonySize, colony.getAntsList());
            DisplayBoard.print(colony);
            repeat++;
        }
    }


    private void createColony(int colonySize) {
        colony = new Colony(colonySize);
    }


}
