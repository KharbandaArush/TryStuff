import org.apache.spark.SparkContext
//import org.apache.spark.streaming.{Seconds, StreamingContext}


object Try {
  def main(args: Array[String]): Unit ={


    System.setProperty("spark.cleaner.ttl","600")

    val sc = new SparkContext("local[2]","Dataflow")


    //val ssc = new StreamingContext(sc, Seconds(1))
    //val lines = ssc.socketTextStream("localhost", 9999)
    val lines=sc.textFile("/home/ubuntu/data",2)
    lines.map(extractIp)
    lines.foreach(println)

    //ssc.start()
    //ssc.awaitTermination()


  }
  def extractIp(line: String): Array[String] =
  {
    line.split(' ')
  }
}
