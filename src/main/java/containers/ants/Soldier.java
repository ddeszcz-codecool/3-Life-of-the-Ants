package containers.ants;

import enums.Direction;
import model.Position;

import java.util.Arrays;


public class Soldier extends AntCasts {


    public Soldier(Position position) {
        super(position);
    }

    @Override
    public void move(int boardSize) {
        Direction direction = Direction.WEST;
        int[] coordinates = convertDirectionToCoordinates(getPosition().getX(), getPosition().getY(), direction);
        if (coordinates[1] >= 0) {
            getPosition().setX(coordinates[0]);
            getPosition().setY(coordinates[1]);
        }
    }
}

