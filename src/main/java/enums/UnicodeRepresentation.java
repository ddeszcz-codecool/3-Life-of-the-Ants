package enums;

public enum UnicodeRepresentation {


    WORKER("\ud83d\udc77"),
    SOLDIER("\ud83d\udc6e"),
    DRONE("\ud83e\udd35"),
    QUEEN("\ud83d\udc83"),
    emptySPACE(" "),
    multipleANTS("\ud8ee\udd3c");




    private String unicodeRepresentation;

    UnicodeRepresentation(String unicodeRepresentation) {
        this.unicodeRepresentation = unicodeRepresentation;
    }

    public String getUnicodeRepresentation() {
        return unicodeRepresentation;
    }


}
