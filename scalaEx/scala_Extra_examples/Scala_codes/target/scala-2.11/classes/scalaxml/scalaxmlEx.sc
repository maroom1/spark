import scala.xml._

val xml1 = <hoge>ddddd</hoge>

val abc=xml1 ++ <moge>dddd</moge> ;



val ab= <visitor> </visitor> ;
for(a<-abc) {
  println(a)
  println(ab.copy(child = ab.child ++ a))

}
println(ab)



def proc(node: scala.xml.Node): String =
  node match {
    case <a>{contents}</a> => "It's an a: "+ contents
    case <b>{contents}</b> => "It's a b: "+ contents
    case _ => "It's something else."
  }

proc(<a>apple</a>)
proc(<b>banana</b>)

proc(<c>cherry</c>)
proc(<a>a <em>red</em> apple</a>)

proc(<a/>)

def proc1(node: scala.xml.Node): String =
  node match {
    case <a>{text @ _*}</a> => "It's an a: "+ text
    case <b>{contents @ _*}</b> => "It's a b: "+ contents
    case _ => "It's something else."
  }


proc1(<a>a <em>red</em> apple</a>)

proc1(<a/>)

val catalog =
  <catalog>
    <cctherm>
      <description>hot dog #5</description>
      <yearMade>1952</yearMade>
      <dateObtained>March 14, 2006</dateObtained>
      <bookPrice>2199</bookPrice>
      <purchasePrice>500</purchasePrice>
      <condition>9</condition>
    </cctherm>
    <cctherm>
      <description>Sprite Boy</description>
      <yearMade>1964</yearMade>
      <dateObtained>April 28, 2003</dateObtained>
      <bookPrice>1695</bookPrice>
      <purchasePrice>595</purchasePrice>
      <condition>5</condition>
    </cctherm>
  </catalog>

catalog match {
  case <catalog>{therms @ _*}</catalog> =>
    //println(therms)
     for (therm <- therms){
     //  if(therm.text.length>5){ //this is for debugging optimisation
   //      println("length "+therm.text.length)
      println("---->"+therm)
      println("processing: "+
        (therm \ "description").text)
      // }
    }
}

catalog match {
  case <catalog>{therms @ _*}</catalog> => //@ pattern of  _* sequence of elements
    for (therm @ <cctherm>{_*}</cctherm>  <-  therms) // for individual node we have only _* seq of elements
      println("processing: "+
        (therm \ "description").text)
}


<a>
  This is some XML.
  Here is a tag: <atag/>
</a>


val x= <a> {"hello"+", world"} </a>
x.text

val yearMade = 1955

<a> { if (yearMade < 2000) <old>{yearMade}</old>
else xml.NodeSeq.Empty }
</a>

  <a> {3 + 4} </a>

  <a> {"</a>potential security hole<a>"} </a>

val joe = <employee
  name="Joe"
  rank="code monkey"
  serial="123"><sal type="1">20000</sal></employee>


joe \ "@name"

joe \ "@serial"

joe \"@rank"

//joe \ "employee" text
//joe \\ "employee" text


joe \ "sal" text

joe \ "sal" \ "@type"






  <a><b><c>hello</c></b></a> \ "b"
<a><b><c>hello</c></b></a> \ "c"

<a><b><c>hello</c></b></a> \\ "c"

<a><b><c>hello</c></b></a> \ "a"

<a><b><c>hello</c></b></a> \\ "a"






