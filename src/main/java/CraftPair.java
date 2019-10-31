import scala.Tuple2;

public class CraftPair {
    public static Tuple2<Integer, String> airPair(String s) {
        String[] pair = ParseAF.parseAir(s);
        return new Tuple2<>(Integer.parseInt(pair[ParseAF.AIRPORT_ID]), pair[ParseAF.AIRPORT_NAME]);
    }

    public static Tuple2<Tuple2<Integer, Integer>, >

}
