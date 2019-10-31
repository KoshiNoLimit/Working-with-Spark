import scala.Tuple2;

class CraftPair {
    static Tuple2<Integer, String> airPair(String s) {
        String[] pair = ParseAF.parseAir(s);
        return new Tuple2<>(Integer.parseInt(pair[ParseAF.AIRPORT_ID]), pair[ParseAF.AIRPORT_NAME]);
    }

    static Tuple2<Tuple2<Integer, Integer>, Tuple2<Double, Double>> flyPair(String s) {
        String[] rows = ParseAF.parseFly(s);
        




    }

}
