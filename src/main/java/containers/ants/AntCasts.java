package containers.ants;

import enums.Direction;
import model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AntCasts {


    private Position position;

    private int count = 0;



    public AntCasts(Position position) {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }

    public void move(int boardSize){}

    Direction selectRandomDirection(){
        List<Direction> directionList = Arrays.asList(Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH);
        Random random = new Random();
//        Direction direction = directionList.get(random.nextInt(directionList.size()));
//        return direction;
        return directionList.get(random.nextInt(directionList.size()));
    }
    int[] convertDirectionToCoordinates(int x, int y, Direction direction){
        int[] coordinates = new int[2];
        switch (direction){
            case EAST: coordinates[0]=x+1; coordinates[1]=y; break;
            case WEST: coordinates[0]=x-1; coordinates[1]=y; break;
            case NORTH: coordinates[0]=x; coordinates[1]=y-1; break;
            case SOUTH: coordinates[0]=x; coordinates[1]=y+1; break;
        }
        return coordinates;
    }

    boolean coordinatesWithinBoard(int[] coordinates, int boardSize){
        boolean x = coordinates[0] >= 0 && coordinates[0]<=boardSize-1;
        boolean y = coordinates[1] >= 0 && coordinates[1]<=boardSize-1;
        return x && y;
    }

}
