package containers.ants;

import enums.Direction;
import model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AntCasts {


    private Position position;



    public AntCasts(Position position) {
        this.position = position;
    }


    public Direction selectRandomDirection(){
        List<Direction> directionList = Arrays.asList(Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH);
        Random random = new Random();
        return directionList.get(random.nextInt(directionList.size()));
    }


    public Position getPosition() {
        return position;
    }
}
