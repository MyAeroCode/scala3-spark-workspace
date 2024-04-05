import org.apache.spark.sql.SparkSession

@main def hello(): Unit = {
  val spark = SparkSession.builder
      .master("local")
      .appName("001-hello-spark")
      .getOrCreate()
      
    println("First SparkContext:")
    println("APP Name :"+spark.sparkContext.appName);
    println("Deploy Mode :"+spark.sparkContext.deployMode);
    println("Master :"+spark.sparkContext.master);

    val df = spark.read.option("header", true).csv("./users.csv")
    df.show()

    spark.stop()
}
