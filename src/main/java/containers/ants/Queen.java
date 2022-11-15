package containers.ants;

import model.Position;
import containers.ants.AntCasts;

import java.util.Random;

public class Queen extends AntCasts {
    private int matingMood;
    private Random random;
    public Queen(Position position) {
        super( position);
        this.random = new Random();
        this.matingMood = random.nextInt(51,100);
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
        this.matingMood = random.nextInt(51,100);
    }
}
