package chapter002

import org.apache.spark.sql.SparkSession
import com.amazonaws.services.glue.util.GlueArgParser
import com.amazonaws.services.glue.{DynamicFrame, GlueContext, DataSink, DataSource}
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.{SQLContext}


object HelloJob {
  def main(args: Array[String]) = {
    val spark = SparkSession.builder().appName("HelloJob").getOrCreate()
    val sparkContext: SparkContext = new SparkContext(spark.conf)
    val sqlContext: SQLContext = new SQLContext(sparkContext)
    val glueContext: GlueContext = new GlueContext(sparkContext)
  }
}