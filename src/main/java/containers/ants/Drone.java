package containers.ants;

import enums.Direction;
import model.Position;

public class Drone extends AntCasts {

    public Drone(Position position) {
        super(position);
    }


    @Override
    public void move(int boardSize) {
        int coordinateX = setCoordinate(boardSize, getPosition().getX());
        int coordinateY = setCoordinate(boardSize, getPosition().getY());
        getPosition().setX(coordinateX);
        getPosition().setY(coordinateY);
    }

    private int setCoordinate(int boardSize, int currentPosition){
        int middle = boardSize/2;
        int newPosition;
        if (currentPosition < middle -1){
            newPosition = currentPosition +1;
        }else if (currentPosition > middle +1){
            newPosition = currentPosition -1;
        }else {
            newPosition = currentPosition;
        }
        return  newPosition;
    }
}
