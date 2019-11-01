#!/bin/bash
mvn package
hadoop fs -copyFromLocal AIR3.csv
hadoop fs -copyFromLocal TIME3.csv
spark-submit --class AirJoin --master yarn-client --num-executors 3 target/spark-examples-1.0-SNAPSHOT.jar
hadoop fs -copyToLocal result