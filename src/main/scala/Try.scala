import org.apache.spark.SparkContext
//import org.apache.spark.streaming.{Seconds, StreamingContext}


object Try {
  def main(args: Array[String]): Unit ={


    try{
    System.setProperty("spark.cleaner.ttl","600")
    //System.setProperty("spark.executor.memory","8g")

    val sc = new SparkContext("local[2]","Dataflow")


    //val ssc = new StreamingContext(sc, Seconds(1))
    //val lines = ssc.socketTextStream("localhost", 9999)
    val lines=sc.textFile("/home/ubuntu/data",2)
    val ips=lines.map(extractIp)
    val start=System.currentTimeMillis()
    ips.collect()
    val stop=System.currentTimeMillis()
    /*val csv = sc.textFile("file.csv")  // original file
    val data = csv.map(line => line.split(",").map(elem => elem.trim)) //lines in rows
    val header = new SimpleCSVHeader(data.take(1)(0)) // we build our header with the first line
    val rows = data.filter(line => header(line,"user") != "user") // filter the header out
    val users = rows.map(row => header(row,"user")
    val usersByHits = rows.map(row => header(row,"user") -> header(row,"hits").toInt)*/
    //lines.foreach(println)
    sc.stop()
    //ssc.start()
    //ssc.awaitTermination()

      print("time taken = " + (stop-start))
    }
    catch {
      case e:Exception => e.printStackTrace()
    }

  }
  def extractIp(line: String): String =
  {
    val splits=line.split(' ')
    splits(0)

  }
}
