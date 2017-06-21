import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Lava on 20-Jun-2017.
 */

object SparkWordSort {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir","C:\\Users\\lavas\\winutils");
    val sparkConf = new SparkConf().setAppName("SparkWordSort").setMaster("local[*]")

    val sc=new SparkContext(sparkConf)

    val inputFileName = sc.textFile("output1.txt")

    val mNLP: MainNLPMethod = new MainNLPMethod
    val lemmaString:String = mNLP.lemmaMethod() ;

    val outputSortedWords = inputFileName.flatMap(line =>(line.split(" "))).map(word =>(word.charAt(0)+"=>",word+",")).cache().distinct()

    val output=outputSortedWords.reduceByKey(_+_)

    output.saveAsTextFile("output")

    val outputString=output.collect()

    var sortedWord:String="Words:Count \n"
    outputString.foreach{case(word,count)=>{

      sortedWord+=word+" : "+count+"\n"

    }}
  }
}
