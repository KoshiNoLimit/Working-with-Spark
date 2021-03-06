import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;
import scala.Tuple3;

import java.util.Map;

public class AirJoin {
    public static void main(String[] args) {
        SparkConf conf  = new SparkConf().setAppName("L3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flights = sc.textFile("TIME3.csv");
        JavaPairRDD<Tuple2<Integer, Integer>, Tuple3<Double, Double, Double>> flightPairs = flights
                .mapToPair(CraftPair::flyPair);
        JavaPairRDD<Tuple2<Integer, Integer>, Tuple3<Double, Double, Double>> keyFlightPairs = flightPairs
                .reduceByKey((a, b)-> new Tuple3<>(Math.max(a._1(), b._1()), a._2() + b._2(), a._3() + b._3()));
        JavaPairRDD<Tuple2<Integer, Integer>, Tuple2<Double, Double>> sameFlightsResults = keyFlightPairs
                .mapToPair(k -> new Tuple2<>(k._1(), new Tuple2<>(k._2()._1(), 100 * (k._2()._2() / k._2()._3()))));

        JavaRDD<String> airports = sc.textFile("AIR3.csv");
        JavaPairRDD<Integer, String> airPairs = airports.mapToPair(CraftPair::airPair);

        Map<Integer, String> stringAirportDataMap = airPairs.collectAsMap();

        final Broadcast<Map<Integer, String>> airportsBroadcasted = sc.broadcast(stringAirportDataMap);

        JavaPairRDD<Tuple2<Integer, Integer>, Tuple2<Tuple2<String, String>, Tuple2<Double, Double>>> result = sameFlightsResults
                .mapToPair(s ->
                        new Tuple2<>(s._1(),
                                new Tuple2<>(
                                        new Tuple2<>(
                                                airportsBroadcasted.value().get(s._1()._1()),
                                                airportsBroadcasted.value().get(s._1()._2())),
                                        s._2())));
        result.saveAsTextFile("result");
    }
}

