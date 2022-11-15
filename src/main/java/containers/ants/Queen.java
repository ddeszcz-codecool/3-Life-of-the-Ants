package containers.ants;

import enums.Direction;
import model.Position;
import containers.ants.AntCasts;

import java.util.Random;

public class Queen extends AntCasts {
    private int matingMood;


    public Queen(Position position) {
        super( position);
        reSetMatingMood();
    }


    @Override
    public void move(int boardSize) {
        lowerMatingMoodByOne();
    }

    public int getMatingMood() {
        return matingMood;
    }

    public void lowerMatingMoodByOne() {
        if (this.matingMood > 0) {
            this.matingMood = matingMood - 1;
        } else {
            reSetMatingMood();
        }
    }
    private void reSetMatingMood() {
        Random random = new Random();
//        this.matingMood = random.nextInt(5);
        this.matingMood = random.nextInt(49)+51;
    }
}
