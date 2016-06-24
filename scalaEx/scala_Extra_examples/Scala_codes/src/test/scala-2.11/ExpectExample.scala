/**
 * Created by Goduguluri on 6/24/2016.
 */
class ExpectExample extends org.scalatest.Suite {
    def testAssertFailure() {
        expect(2, "Unexpected List size") { List().size }
// The above exception is wrong
    }
}
(new ExpectExample).execute()


