import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirJoin {
    public static void main(String[] args) {
        SparkConf conf  = new SparkConf().setAppName("L3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flights = sc.textFile("TIME3.csv");

        JavaRDD<String> airports = sc.textFile("AIR3.csv");


    }
}
