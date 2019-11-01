class ParseAF {
    static final Integer AIRPORT_ID = 0;
    static final Integer F_FIRST_AIR_ID = 11;
    static final Integer F_SECOND_AIR_ID = 14;
    static final Integer DELAY = 18;
    static final Integer AIRPORT_NAME = 1;
    static final Integer CANCEL = 19;
    static final String IS_CANCEL = "1.00";
    static final String NOT_DELAY = "0.00";
    private static final String DELIMITER_FLY = ",";
    private static final String DELIMITER_AIR = "\",\"";
    private static final String COMMA = "\"";

    private static String[] deleteCommas(String[] s) {
        for(int i = 0; i < s.length; i++) {
            s[i] = s[i].replaceAll(COMMA, "");
        }
        return s;
    }

    static String[] parseAir(String s) {
        String[] lines = s.split(DELIMITER_AIR);
        return deleteCommas(lines);
    }

    static String[] parseFly(String s) {
        String[] lines = s.split(DELIMITER_FLY);
        return deleteCommas(lines);
    }
}
