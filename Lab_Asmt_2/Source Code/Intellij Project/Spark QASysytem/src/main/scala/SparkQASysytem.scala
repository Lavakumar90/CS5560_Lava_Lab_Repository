import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by Lava on 20-Jun-2017.
  */


object SparkQASysytem {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir","C:\\Users\\lavas\\winutils");

    val sparkConf = new SparkConf().setAppName("SparkQASysytem").setMaster("local[*]")

    val sc=new SparkContext(sparkConf)

    val input=sc.textFile("output.txt")

    val mNLP: MainNLPMethod = new MainNLPMethod
    mNLP.processMethod() ;

    println("Type your Question:")
    val inputValue:String = scala.io.StdIn.readLine()

    var outputValue:String = mNLP.qaMethod(inputValue) ;
    println("Answer to your question is:" + outputValue)

  }

}
