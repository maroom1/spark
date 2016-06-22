package scalaxml

/**
  * Created by Goduguluri on 6/19/2016.
  */
class BookClass(val author:String,
val title : String,
val genre :String,
val price :String,
val publish_date:String,
val description:String) {

  def toXML =
     <book>
      <auth>{author}</auth>
      <tit>{title}</tit>
      <gen>{genre}</gen>
      <pri>{price}</pri>
      <date>{publish_date}</date>
      <desc>{description}</desc>
    </book>


}
