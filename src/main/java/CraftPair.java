import scala.Tuple2;

class CraftPair {
    
    private static final bool INTIME = 1;

    static Tuple2<Integer, String> airPair(String s) {
        String[] pair = ParseAF.parseAir(s);
        return new Tuple2<>(Integer.parseInt(pair[ParseAF.AIRPORT_ID]), pair[ParseAF.AIRPORT_NAME]);
    }

    static Tuple2<Tuple2<Integer, Integer>, Tuple2<Double, Double>> flyPair(String s) {
        String[] rows = ParseAF.parseFly(s);
        if (rows[ParseAF.CANCEL].equals(ParseAF.IS_CANCEL)) {
            return new Tuple2<>(new Tuple2<>(Integer.parseInt(rows[ParseAF.F_FIRST_AIR_ID]), Integer.parseInt(rows[ParseAF.F_SECOND_AIR_ID])), new Tuple2<>(0, 1));
        }





        return null;
    }

}
