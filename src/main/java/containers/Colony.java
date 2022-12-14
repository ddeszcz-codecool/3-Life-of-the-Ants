package containers;

import containers.ants.*;
import enums.UnicodeRepresentation;
import model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {
    private final Position[][] colony;
    private final List<AntCasts> antsList = new ArrayList<>();
    private final int colonySize;


    public Colony(int colonySize) {
        this.colonySize = colonySize;
        this.colony = new Position[colonySize][colonySize];
    }







    public void generateAnts(int workers, int drones, int soldiers) {
        addQueen();
        addAnts(workers, UnicodeRepresentation.WORKER);
        addAnts(drones, UnicodeRepresentation.DRONE);
        addAnts(soldiers, UnicodeRepresentation.SOLDIER);
    }
    public Position[][] getColony() {
        return colony;

    }
    public List<AntCasts> getAntsList() {
        return antsList;
    }
    private void addQueen() {
        int center = (colonySize / 2);
        AntCasts queen = new Queen(new Position(center, center, UnicodeRepresentation.QUEEN));
        this.antsList.add(queen);
    }
    private void addAnts(int ants, UnicodeRepresentation unicodeRepresentation) {
        Random random = new Random();
        int x;
        int y;
        boolean selectedPlaceIsOccupied = true;
        for (int i = 0; i < ants; i++) {
            while (selectedPlaceIsOccupied) {
                x = random.nextInt(colonySize);
                y = random.nextInt(colonySize);
                if (isThisPlaceFree(x, y)) {
                    selectedPlaceIsOccupied = false;
                    AntCasts antCasts;
                    switch (unicodeRepresentation) {
                        case WORKER:
                            antCasts = new Worker(new Position(x, y, unicodeRepresentation));
                            break;
                        case DRONE:
                            antCasts = new Drone(new Position(x, y, unicodeRepresentation));
                            break;
                        case SOLDIER:
                            antCasts = new Soldier(new Position(x, y, unicodeRepresentation));
                            break;
                        default:
                            System.out.println("Error creating ants casts Colony.addAnts");
                            antCasts = new AntCasts((new Position(x, y, unicodeRepresentation)));
                            break;
                    }
                    this.antsList.add(antCasts);
                }
            }
            selectedPlaceIsOccupied = true;
        }
    }
    private boolean isThisPlaceFree(int x, int y) {
        for (AntCasts ant : antsList) {
            if (ant.getPosition().getX() == x && ant.getPosition().getY() == y) {
                return false;
//                return true;  // added for overlap check
            }
        }
        return true;
    }




}
