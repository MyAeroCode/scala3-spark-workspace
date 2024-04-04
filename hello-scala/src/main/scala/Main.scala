import org.apache.spark.sql.SparkSession

// export JAVA_OPTS='--add-exports java.base/sun.nio.ch=ALL-UNNAMED'

@main def hello(): Unit = {
  val spark = SparkSession.builder
      .master("local")
      .appName("HelloWorld")
      .getOrCreate()
      
    println("First SparkContext:")
    println("APP Name :"+spark.sparkContext.appName);
    println("Deploy Mode :"+spark.sparkContext.deployMode);
    println("Master :"+spark.sparkContext.master);

    // val df = List("hello", "world").toDF  
    // df.show()                             

    spark.stop()
}
