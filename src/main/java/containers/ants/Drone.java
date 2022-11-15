package containers.ants;

import enums.Direction;
import model.Position;

public class Drone extends AntCasts {
    private int loveMakingWithQueen;

    public Drone(Position position) {
        super(position);
        this.loveMakingWithQueen = 10;
    }


    @Override
    public void move(int boardSize) {
        if (loveMakingWithQueen <= 10) {
            timeLoveMakingWithQueen();
        } else {
            int coordinateX = setCoordinate(boardSize, getPosition().getX());
            int coordinateY = setCoordinate(boardSize, getPosition().getY());
            if (coordinateX == getPosition().getX() && coordinateY == getPosition().getY()) {
                setIsAntNextToQueen(true);

            }
            getPosition().setX(coordinateX);
            getPosition().setY(coordinateY);

        }
    }

    public int getLoveMakingWithQueen() {
        return loveMakingWithQueen;
    }

    public void setLoveMakingWithQueen(int loveMakingWithQueen) {
        this.loveMakingWithQueen = loveMakingWithQueen;
    }

    private void timeLoveMakingWithQueen() {
        this.loveMakingWithQueen = loveMakingWithQueen + 1;
    }

    private int setCoordinate(int boardSize, int currentPosition) {
        int middle = boardSize / 2;
        int newPosition;
        if (currentPosition < middle - 1) {
            newPosition = currentPosition + 1;
        } else if (currentPosition > middle + 1) {
            newPosition = currentPosition - 1;
        } else {
            newPosition = currentPosition;
        }
        return newPosition;
    }


}
