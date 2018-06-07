//  Give the type and value of each of the following expressions:
//        a. (1 + 2.236)/2
//        b. 1 + 2 + 3 + 4.0
//        c. 4.1 >= 4
//        d. 1 + 2 + "3"

package Chapter1.Section1.exercise2;

public class Exercise2 {


    public static void a (Typetester t) {

        System.out.println("a. Value is: " + (1 + 2.236)/2);
        t.printType( (1 + 2.236)/2 );

    }

    public static void b (Typetester t) {

        System.out.println("b. Value is: " + (1 + 2 + 3 + 4.0));
        t.printType( 1 + 2 + 3 + 4.0 );

    }

    public static void c (Typetester t) {

        System.out.println("b. Value is: " + (4.1 >= 4));
        t.printType( 4.1 >= 4 );

    }

    public static void d (Typetester t) {

        System.out.println("d. Value is: " + (1 + 2 + "3"));
        t.printType( 1 + 2 + "3" );

    }


    public static void main (String args[]) {

        Typetester t = new Typetester();

        a(t);
        b(t);
        c(t);
        d(t);

    }


}


class Typetester {


    void printType (byte x)      { System.out.println(x + " is a byte"); }

    void printType (int x)       { System.out.println(x + " is an int"); }

    void printType (float x)     { System.out.println(x + " is a float"); }

    void printType (double x)    { System.out.println(x + " is a double"); }

    void printType (char x)      { System.out.println(x + " is a char"); }

    void printType (String x)    { System.out.println(x + " is a string"); }

    void printType (boolean x)   { System.out.println(x + " is a boolean"); }


}
