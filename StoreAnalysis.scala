import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object StoreAnalysis {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("SparkSQL")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", "file:///C:/temp")
      .getOrCreate()

    val schema = StructType(
      Array(
        StructField("StoreID", IntegerType, nullable = true),
        StructField("StoreArea", IntegerType, nullable = true),
        StructField("ItemsAvailable", IntegerType, nullable = true),
        StructField("Daily_Customer_Count", IntegerType, nullable = true),
        StructField("StoreSales", LongType, nullable = true)

      )
    )
    val Store = spark.read
      .format("csv")
      .option("header", true)
      .schema(schema)
      .load("../Stores.csv").toDF()

    println("Here is our schema")
    Store.printSchema()
    Store.show()

    println("Lets see the Store Area column")
    Store.select("StoreArea").show()

    println("The store ID with max Sales: ")
    Store.createTempView("temp")
    spark.sql("Select StoreID, StoreSales from temp t where t.StoreSales = (Select max(t2.StoreSales) from temp t2)").show()

    println("The correlation between StoreSales and StoreArea:")
    spark.sql("Select StoreArea, StoreSales from temp Order by 2 DESC").show()

    println("Store with the largest number of daily customers:")
    spark.sql("Select StoreID, Daily_Customer_count as Max_Customer_Count from temp t1 where t1.Daily_Customer_Count = (Select max(t2.Daily_Customer_Count) from temp t2)").show()

    println("The number of items available at each store:")
    Store.select("StoreID", "ItemsAvailable").show()

    println("The correlation between StoreSales and Items Available")
    Store.select("StoreSales", "ItemsAvailable").orderBy(col("StoreSales").desc).show(false)

    println("Correlation between items available and Store area:")
    Store.select("StoreArea", "ItemsAvailable").sort(desc("ItemsAvailable")).show()


  }
}
