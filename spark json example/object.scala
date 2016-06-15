import org.apache.spark._

object JsonData extends App {

  val conf = new SparkConf().setMaster("local[2]").setAppName("Analytics3")
  val sc = new SparkContext(conf)
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)

  val files = sc.wholeTextFiles("comment.json")
  val jsonData = files.map(x => x._2)
  sqlContext.jsonRDD(jsonData).registerTempTable("youtube")

  val allrecords = sqlContext.sql("SELECT * FROM youtube")
  allrecords.show()

  val filteredrecords = sqlContext.sql("SELECT items[0].snippet.canReply FROM youtube")
  filteredrecords.show()

  val firstrecords = sqlContext.sql("SELECT kind,pageInfo.totalResults, pageInfo.resultsPerPage, etag, items[0].id FROM youtube")
  firstrecords.show()
  firstrecords.printSchema()

  val secondrecords = sqlContext.sql("SELECT items[0].id,items[0].etag,items[0].kind,items[0].snippet.canReply,items[0].snippet.totalReplyCount,items[0].snippet.topLevelComment.snippet.authorProfileImageUrl,items[0].snippet.topLevelComment.snippet.textDisplay,items[0].snippet.topLevelComment.snippet.canRate,items[0].snippet.topLevelComment.snippet.publishedAt,items[0].snippet.topLevelComment.snippet.authorChannelUrl,items[0].snippet.topLevelComment.snippet.authorChannelId.value,items[0].snippet.topLevelComment.snippet.videoId,items[0].snippet.topLevelComment.snippet.likeCount,items[0].snippet.topLevelComment.snippet.authorDisplayName,items[0].snippet.topLevelComment.snippet.authorGoogleplusProfileUrl,items[0].snippet.topLevelComment.snippet.viewerRating,items[0].snippet.topLevelComment.snippet.updatedAt FROM youtube")
  secondrecords.show()
  secondrecords.printSchema()

val items = allrecords.select(explode(col("items")) as "col")
items.show()


val itemrecords = sqlContext.sql("SELECT col.id,col.etag,col.kind,col.snippet.canReply,col.snippet.totalReplyCount,col.snippet.topLevelComment.snippet.authorProfileImageUrl,col.snippet.topLevelComment.snippet.textDisplay,col.snippet.topLevelComment.snippet.canRate,col.snippet.topLevelComment.snippet.publishedAt,col.snippet.topLevelComment.snippet.authorChannelUrl,col.snippet.topLevelComment.snippet.authorChannelId.value,col.snippet.topLevelComment.snippet.videoId,col.snippet.topLevelComment.snippet.likeCount,col.snippet.topLevelComment.snippet.authorDisplayName,col.snippet.topLevelComment.snippet.authorGoogleplusProfileUrl,col.snippet.topLevelComment.snippet.viewerRating,col.snippet.topLevelComment.snippet.updatedAt  FROM items")

itemrecords.saveAsTable("Itemlaod")

  val url: String = "jdbc:mysql://localhost:3306/kalyan"
  val driver: String = "com.mysql.jdbc.Driver"
  val props = new java.util.Properties()

  props.setProperty("user", "root")
  props.setProperty("password", "hadoop")
  props.setProperty("driver", driver);

  firstrecords.write.mode("append").jdbc(url, "youtube_master", props)
  secondrecords.write.mode("append").jdbc(url, "youtube_item_details", props)

  sc.stop()
}
