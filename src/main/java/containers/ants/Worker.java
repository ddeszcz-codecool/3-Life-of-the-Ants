package containers.ants;

import enums.Direction;
import model.Position;

public class Worker extends AntCasts {

    public Worker(Position position) {
        super(position);
    }

    @Override
    public void move(int boardSize) {
        boolean moveOutsideBoard = true;
        while (moveOutsideBoard) {
            Direction direction = selectRandomDirection();
            int[] coordinates = convertDirectionToCoordinates(getPosition().getX(), getPosition().getY(), direction);
            if (coordinatesWithinBoard(coordinates, boardSize)) {
                getPosition().setX(coordinates[0]);
                getPosition().setY(coordinates[1]);
                moveOutsideBoard = false;
            }
        }
    }
}
