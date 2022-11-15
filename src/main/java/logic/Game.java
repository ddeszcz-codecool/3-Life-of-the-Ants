package logic;

import containers.Colony;
import utilities.DisplayBoard;

public class Game {

    private Colony colony;

    public Game() {
    }

    public void start(){
//        int colonySize = Input.askUserForColonySize();
        createColony(9);
//        createColony(colonySize);
        colony.generateAnts(6,4,3);
        DisplayBoard.print(colony);
    }


    private void createColony(int colonySize){
        colony=new Colony(colonySize);
    }




}
