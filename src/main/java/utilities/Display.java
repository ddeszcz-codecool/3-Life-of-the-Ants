package utilities;

import containers.Colony;
import containers.ants.AntCasts;
import enums.UnicodeRepresentation;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Display {
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
    public static final String GRAY_SQUARE_BLACK_PERIMETER = FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY + "  "+s1_6_SIX_PER_EM_SPACE.repeat(2) + RESET_ANSI + s0_ZERO_WIDTH_SPACE;

    private static final char[] alphabet20 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};


    public static void wrongArgumentEntered() {
        System.out.println("Input arguments not validated correctly, please make sure that size is larger than 5 and smaller than 20!");


    }

    public static void board(Colony colony) {
        for (AntCasts ant: colony.getAntsList()) {
            int x = ant.getPosition().getX();
            int y = ant.getPosition().getY();
            UnicodeRepresentation unicodeRepresentation = ant.getPosition().getUnicodeRepresentation();
            colony.getColony()[x][y].setUnicodeRepresentation(unicodeRepresentation);
        }
        StringBuilder colonyToPrint = new StringBuilder();
        colonyToPrint.append("\n"+s1_6_SIX_PER_EM_SPACE.repeat(10));
        int colonyWidth = colony.getColony().length;
        for (int i = 0; i < colonyWidth; i++) {
            colonyToPrint.append(FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY +BOLD+ s1_3_SIX_PER_EM_SPACE+alphabet20[i] + s1_2_SIX_PER_EM_SPACE+ RESET_ANSI + s0_ZERO_WIDTH_SPACE);
        }
        colonyToPrint.append("\n");
        for (int i = 0; i < colonyWidth; i++) {
            colonyToPrint.append(FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY +BOLD+ s1_3_SIX_PER_EM_SPACE+i + s1_2_SIX_PER_EM_SPACE+ RESET_ANSI + s0_ZERO_WIDTH_SPACE);
            for (int j = 0; j < colonyWidth; j++) {
                if (colony.getColony()[i][j].getUnicodeRepresentation() == UnicodeRepresentation.emptySPACE) {
                    colonyToPrint.append(GRAY_SQUARE_BLACK_PERIMETER);
                }else {
                    colonyToPrint.append(FOREGROUND_BLACK + FRAMED + BACKGROUND_GRAY +s1_5_SIX_PER_EM_SPACE+colony.getColony()[i][j].toString()+s1_7_HAIR_SPACE+RESET_ANSI + s0_ZERO_WIDTH_SPACE);
                }
            }
            colonyToPrint.append("\n");
        }
        System.out.println(colonyToPrint);
        printKey(colonyWidth);



    }


    private static void printKey(int colonyWidth){
        String spaceFormat = "%" + Integer.toString((2*colonyWidth)-9) + "s";

        StringBuilder key = new StringBuilder();
        key.append(String.format(spaceFormat, UnicodeRepresentation.QUEEN.getUnicodeRepresentation())+ " - Queen"+"\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.DRONE.getUnicodeRepresentation())+ " - Drone"+"\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.SOLDIER.getUnicodeRepresentation())+ " - Soldier"+"\n");
        key.append(String.format(spaceFormat, UnicodeRepresentation.WORKER.getUnicodeRepresentation())+ " - Worker"+"\n");

        System.out.println(key);
    }
}
