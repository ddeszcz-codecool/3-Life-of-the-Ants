package logic;

import containers.Colony;
import utilities.Display;
import utilities.Input;

public class Game {

    private Colony colony;

    public Game() {

    }

    public void start(){
//        int colonySize = Input.askUserForColonySize();
        createColony(10);
        colony.generateAnts(1,1,1);
        Display.board(colony);

    }


    private void createColony(int colonySize){
        colony=new Colony(colonySize);
    }




}
