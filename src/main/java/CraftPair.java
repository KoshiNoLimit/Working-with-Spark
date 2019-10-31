import scala.Tuple2;

class CraftPair {

    static Tuple2<Integer, String> airPair(String s) {
        String[] pair = ParseAF.parseAir(s);
        return new Tuple2<>(Integer.parseInt(pair[ParseAF.AIRPORT_ID]), pair[ParseAF.AIRPORT_NAME]);
    }

    static Tuple2<Tuple2<Integer, Integer>, Tuple2<Double, Double>> flyPair(String s) {
        String[] rows = ParseAF.parseFly(s);
        if (rows[ParseAF.CANCEL].equals(ParseAF.IS_CANCEL)) {
            return new Tuple2<>(new Tuple2<>(Integer.parseInt(rows[ParseAF.F_FIRST_AIR_ID]), Integer.parseInt(rows[ParseAF.F_SECOND_AIR_ID])), new Tuple2<>(0, 1));
        }
        if (rows[ParseAF.DELAY].equals(ParseAF.NOT_DELAY) || rows[ParseAF.DELAY].equals("")) {
            return new Tuple2<>(new Tuple2<>(Integer.parseInt(rows[ParseAF.F_FIRST_AIR_ID]), Integer.parseInt(rows[ParseAF.F_SECOND_AIR_ID])), new Tuple2<>(0, 0));
        }

        return 




        return null;
    }

}
