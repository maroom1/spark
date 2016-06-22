-1 >>> 31
1 << 2
1 == 2
1 != 2
2 == 2
List(1, 2, 3) == List(1, 2, 3)
List(1, 2, 3) == List(4, 5, 6)
1 == 1.0
List(1, 2, 3) == "hello"
List(1, 2, 3) == null
null == List(1, 2, 3)
("he"+"llo") == "hello"
(2 + 2) * 7

2 << 2 + 2
2 + 2 << 2
//x *= y + 1
//{ val x = a; b.:::(x) }

-1 >> 31
1 & 2
1 | 2
1^3
~1
def salt() = { println("salt"); false }
def pepper() = { println("pepper"); true }
pepper() && salt()
salt() && pepper()
val toBe = true
val question = toBe || !toBe
val paradox = toBe && !toBe
val thisIsBoring = !true
!thisIsBoring
'a' >= 'A'
3.5f >= 3.6f
1.0 <= 1.0
1 < 2
1 > 2
val y = +3
val neg = 1 + -3
-neg

val m=11-(4*Math.round(11/4))
val m1=11-4*3 // 3 is the nearest value where 11 can be divided to 0
Math.IEEEremainder(11, 4)
Math.IEEEremainder(11.0, 4.0)
11.0 % 4.0
11.0f / 4.0f
11 % 4
11 / 4
2L * 3L
'b' - 'a'
3 - 13 - 1
1.2 + 2.3
val s2 = "Hello, world!"
s2.toLowerCase
//s2 toLowerCase
s2.length
//s2 toUpperCase
1<3
(1).<(3)
(1).##
(1).unary_~
(1).unary_+
(1).unary_-
(2.0).unary_-
-2.0                  // Scala invokes (2.0).unary_-
val s1 = "Hello, world!"
s1 indexOf 'o'     // Scala invokes s.indexOf('o')
s1 indexOf ('o', 5) // Scala invokes s.indexOf('o', 5)
val longSum = 1 + 2L    // Scala invokes (1).+(2L)
val sumMore = (1).+(2)
val sum = 1 + 2    // Scala invokes (1).+(2)
val fool = false
val bool = true
val s = 'aSymbol;
val hex = 0x5
val hex2 = 0x00Ff
val magic = 0xcafebabe
val hex3=0x100
val hex4=0x198e
val oct =1
val nov = 77 //octal number is removed from scala 2.11
val prog = 0XCAFEBABEL
val tower = 35L
val of = 31l
val little: Short = 3673 //36734- error
val total=Short.MaxValue
val total1=Short.MinValue
val littler: Byte = 38
val littler1: Byte = 38 //387 - error
val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45
val little1 = 1.2345F
val littleBigger1 = 3e5f
val anotherDouble = 3e5
val yetAnother = 3e5D
val a = 'A'
val c = '\101'
val d = '\u0041'
val f = '\u0044'
//val B\u0041\u0044 = 1 // now it is not working
val backslash = '\\'
val hello = "hello"
val escapes = "\\\"\'"
println("""Welcome to Ultamix 3000.
             Type "HELP" for help.""")


















