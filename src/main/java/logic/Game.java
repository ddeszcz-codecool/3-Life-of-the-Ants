package logic;

import containers.Colony;
import utilities.Display;
import utilities.Input;

public class Game {

    private Colony colony;

    public Game() {

    }

    public void start(){
        int colonySize = Input.askUserForColonySize();
//        createColony(9);
        createColony(colonySize);
        colony.generateAnts(4,4,8);
        Display.board(colony);

    }


    private void createColony(int colonySize){
        colony=new Colony(colonySize);
    }




}
