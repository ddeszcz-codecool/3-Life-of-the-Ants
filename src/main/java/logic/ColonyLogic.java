package logic;

import containers.ants.AntCasts;
import containers.ants.Drone;
import containers.ants.Queen;

import java.util.List;

public class ColonyLogic {


    public void update(int boardSize, List<AntCasts> antsList) {
        int queenMatingMood = queenMatingMood(antsList);


        for (AntCasts ant : antsList) {
            ant.move(boardSize);
            if (ant instanceof Drone) {
                if (loveMakingWithQueenTimeLaps((Drone) ant) < 10) {
                } else if (ant.getIsAntNextToQueen()) {
                    if (queenMatingMood == 0) {
                        System.out.println("HALLELUJAH");
                        if (ant instanceof Drone) {
                            ((Drone) ant).setLoveMakingWithQueen(0);
                        }
                    } else {
                        ant.setCoordinatesToTheBoardEdge(boardSize);
                        ant.setIsAntNextToQueen(false);
                    }
                }
            }
        }
        seeBoardBetweenToursForThisNumberOfSeconds(2);
    }


    private int queenMatingMood(List<AntCasts> antsList) {
        for (AntCasts ant : antsList) {
            if (ant instanceof Queen) {
                return ((Queen) ant).getMatingMood();
            }
        }
        return -1;
    }

    private int loveMakingWithQueenTimeLaps(Drone drone) {
        return drone.getLoveMakingWithQueen();
    }

    private void seeBoardBetweenToursForThisNumberOfSeconds(int numberOfSeconds) {
        try {
            Thread.sleep(numberOfSeconds * 1000);
        } catch (Exception exception) {
            System.out.println("InterruptedException was recorded");
        }
    }
}
