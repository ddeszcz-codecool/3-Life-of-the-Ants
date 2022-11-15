package logic;

import containers.Colony;
import containers.ants.AntCasts;
import utilities.DisplayBoard;
import utilities.Input;

public class Game {

    private Colony colony;
    private ColonyLogic colonyLogic;

    public Game() {
        this.colonyLogic = new ColonyLogic();
    }

    public void start() {
        int colonySize = Input.askUserForColonySize();
//        int colonySize = 19;
        createColony(colonySize);
        colony.generateAnts(5, 5,5 );

        DisplayBoard.print(colony);

        int repeat = 0;
        while (repeat < 40) {
//            for (AntCasts ant:colony.getAntsList()) {
//                System.out.println("x- " + ant.getPosition().getX() + ", y- " + ant.getPosition().getY()+ " antType: " + ant.getPosition().getUnicodeRepresentation());
//
//            }
            System.out.println("----- Round number: " + repeat + " -----------");
            colonyLogic.update(colonySize, colony.getAntsList());
            DisplayBoard.print(colony);
            repeat++;
        }
    }


    private void createColony(int colonySize) {
        colony = new Colony(colonySize);
    }


}
