/**
  * Created by Goduguluri on 6/18/2016.
  */
object Basics4 extends  App{

  println(
    """ hello
      | world jere dunew
      |           kay kur   fkjdshajfh kjfnsdkfjhskdj fhksjdfh kjsdh f
      |           f sdfjsd fkjsf sf
      |      fsdfsfsd
      |   sdfsdfsdfsd
      |fdsfsdfsdfsdf
    """)
  println("""|Welcome to Ultamix 3000.
             |Type "HELP" for help.""".stripMargin)

  def updateRecordByName(r:Symbol, value: Any) {
       // code goes here
     }
  //updateRecordByName(favoriteAlbum, "OK Computer") //error
  updateRecordByName('favoriteAlbum , "OK Computer")

  val s = 'aSymbol
s.name






}
