package utilities;

import containers.Colony;
import containers.ants.AntCasts;
import enums.UnicodeRepresentation;
import model.Position;

public class DisplayBoard {

    //TODO should not this class be converted to an object? What is the advantage of that?
    //ANSI codes
    private static final String FOREGROUND_BLACK = "\u001b[38;2;0;0;0m";
    private static final String FRAMED = "\u001b[51m";
    private static final String BOLD = "\u001b[1m";
    private static final String BACKGROUND_GRAY = "\u001b[48;2;128;128;128m";
    private static final String RESET_ANSI = "\033[0m";

    //Narrow Spaces
    public static final String s0_ZERO_WIDTH_SPACE = "\u200B";
    public static final String s1_7_HAIR_SPACE = "\u200A";
    public static final String s1_6_SIX_PER_EM_SPACE = "\u2006";
    public static final String s1_5_SIX_PER_EM_SPACE = "\u2009";   //sometimes identical with 1_6
    public static final String s1_4_SIX_PER_EM_SPACE = "\u2005";
    public static final String s1_3_SIX_PER_EM_SPACE = "\u2004";
    public static final String s1_2_SIX_PER_EM_SPACE = "\u2002";
    public static final String s1_1_SIX_PER_EM_SPACE = "\u2001";  //equivalent to font height

    //Combined ANSI and UNICODE to create appropriate squares
    public static final String GRAY_SQUARE_BLACK_PERIMETER = FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY + "  " + s1_6_SIX_PER_EM_SPACE.repeat(2) + RESET_ANSI + s0_ZERO_WIDTH_SPACE;
    private static final char[] alphabet20 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};




    public static void print(Colony colony) {
        checkForMultipleAntsOnSquare(colony);
        System.out.println(boardToString(colony));
        printKey(colony.getColony().length);
    }
    private static void checkForMultipleAntsOnSquare(Colony colony) {
        resetAllFieldsToEmpty(colony);
        for (AntCasts ant : colony.getAntsList()) {
            int x = ant.getPosition().getX();
            int y = ant.getPosition().getY();
            UnicodeRepresentation unicodeRepresentation = ant.getPosition().getUnicodeRepresentation();
            if (colony.getColony()[x][y].getUnicodeRepresentation() == UnicodeRepresentation.emptySPACE) {
                colony.getColony()[x][y].setUnicodeRepresentation(unicodeRepresentation);
            } else {
                colony.getColony()[x][y].setUnicodeRepresentation(UnicodeRepresentation.multipleANTS);
            }
        }
    }
    private static String boardToString(Colony colony){
        return createAlphabetAxis(colony) + createNumbersAxisAndSquares(colony);
    }
    private static String createAlphabetAxis(Colony colony) {
        StringBuilder colonyToPrint = new StringBuilder();
        colonyToPrint.append("\n").append(s1_6_SIX_PER_EM_SPACE.repeat(14));  //empty square
        int colonyWidth = colony.getColony().length;
        for (int i = 0; i < colonyWidth; i++) {
            colonyToPrint.append(FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY + BOLD + s1_3_SIX_PER_EM_SPACE).append(alphabet20[i]).append(s1_2_SIX_PER_EM_SPACE).append(RESET_ANSI).append(s0_ZERO_WIDTH_SPACE);
        }
        colonyToPrint.append("\n");
        return colonyToPrint.toString();
    }
    private static String createNumbersAxisAndSquares(Colony colony){
        StringBuilder colonyToPrint = new StringBuilder();
        int colonyWidth = colony.getColony().length;
        for (int i = 0; i < colonyWidth; i++) {
            // numbers axis
            colonyToPrint.append(FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY + BOLD + s1_3_SIX_PER_EM_SPACE + (String.format("%2d", i + 1)) + s1_2_SIX_PER_EM_SPACE + RESET_ANSI + s0_ZERO_WIDTH_SPACE);
            for (int j = 0; j < colonyWidth; j++) {
                // print squares
                if (colony.getColony()[i][j].getUnicodeRepresentation() == UnicodeRepresentation.emptySPACE) {
                    colonyToPrint.append(GRAY_SQUARE_BLACK_PERIMETER);
                } else {
                    colonyToPrint.append(FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY + s1_5_SIX_PER_EM_SPACE + colony.getColony()[i][j].toString() + s1_7_HAIR_SPACE + RESET_ANSI + s0_ZERO_WIDTH_SPACE);
                }
            }
            colonyToPrint.append("\n");
        }
        return colonyToPrint.toString();
    }
    private static void printKey(int colonyWidth) {
        String spaceFormat = "%4s";
//        String spaceFormat = "%" + Integer.toString((2 * colonyWidth) - 9) + "s";

        StringBuilder key = new StringBuilder();
        key.append(String.format(spaceFormat, UnicodeRepresentation.QUEEN.getUnicodeRepresentation()) + " - Queen - symbolised by enticing dancing lady " + "\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.DRONE.getUnicodeRepresentation()) + " - Drone - symbolised by gentleman in white tie " + "\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.SOLDIER.getUnicodeRepresentation()) + " - Soldier - symbolised by policeman" + "\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.WORKER.getUnicodeRepresentation()) + " - Worker - symbolised by construction worker" + "\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.multipleANTS.getUnicodeRepresentation()) + " - Multiple ants in one square - symbolised by multiple people" + "\n");

        System.out.println(key);
    }
    public static void resetAllFieldsToEmpty(Colony colony) {
        for (int x = 0; x < colony.getColony().length; x++) {
            for (int y = 0; y < colony.getColony().length; y++) {
                colony.getColony()[x][y] = new Position(x, y, UnicodeRepresentation.emptySPACE);
            }
        }
    }


}
