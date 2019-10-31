import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class AirJoin {
    public static void main(String[] args) {
        SparkConf conf  = new SparkConf().setAppName("L3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flights = sc.textFile("TIME3.csv");
        JavaPairRDD<Tuple2<Integer, Integer>, Tuple2<Double, Double>> flightPairs = flights.mapToPair(CraftPair::flyPair);
        JavaPairRDD<Tuple2<Integer, Integer>, Tuple2<Double, Double>> keyFlightPairs = flightPairs.reduceByKey(())

        JavaRDD<String> airports = sc.textFile("AIR3.csv");
        JavaPairRDD<Integer, String> airPairs = airports.mapToPair(CraftPair::airPair);


    }
}
