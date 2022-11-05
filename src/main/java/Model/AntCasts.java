package Model;

import Enums.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AntCasts {
    public int getStepsInMove() {
        return stepsInMove;
    }

    private int stepsInMove;

    public AntCasts(int stepsInMove) {
        this.stepsInMove = stepsInMove;
    }

    public Direction selectRandomDirection(){
        List<Direction> directionList = Arrays.asList(Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH);
        Random random = new Random();
        return directionList.get(random.nextInt(directionList.size()));
    }
}
