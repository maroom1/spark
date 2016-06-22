/**
 * Created by Goduguluri on 6/20/2016.
 */
import com.sun.org.apache.xpath.internal.SourceTree;
import scala.Predef;
class JavaArrays
{

        private String[] toppings = {"Cheese", "Pepperoni", "Black Olives"};

        // our constructor; print out the String array here
        public JavaArrays()
        {
            // old `for` loop
            int size = toppings.length;
            for (int i=0; i<size; i++)
            {
                Predef.println(toppings[i]);
            }

            Predef.println(toppings[0]);
        }

        // main kicks everything off.
        // create a new instance of our class here.
        public static void main(String[] args)
        {
            new JavaArrays();
        }
}