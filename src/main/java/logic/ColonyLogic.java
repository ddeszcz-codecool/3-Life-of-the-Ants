package logic;

import containers.ants.AntCasts;

import java.util.List;

public class ColonyLogic {


    public void update(int boardSize, List<AntCasts> antsList) {
        for (AntCasts ant:antsList) {
            ant.move(boardSize);
            }
        try {
            Thread.sleep(1000);
        }catch (Exception exception){
            System.out.println("InterruptedException was recorded");
        }
    }
}
