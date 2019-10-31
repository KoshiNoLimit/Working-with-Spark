import scala.Tuple2;

public class craftPair {
    public static Tuple2<Integer, String> airPair(String s) {
        String[] pair = ParseAF.parseAir(s);
        return new Tuple2<>(Integer.parseInt(pair[]), pair[])
    }

}
