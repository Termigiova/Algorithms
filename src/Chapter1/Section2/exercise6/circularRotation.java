package Chapter1.Section2.exercise6;

import edu.princeton.cs.introcs.StdOut;

public class circularRotation {

    static boolean isRotation(String s1, String s2){

        return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);

    }

    public static void main (String args[]) {

        String s = "ACTGACG";
        String t = "TGACGAC";

        if (isRotation(s,t))
            StdOut.println("The string '" + s + "' is a circular rotation of '" + t + "'");

    }

}
