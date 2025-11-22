/** Simulating the instanceof Operator **/
package org.example;

public class Instance1 {
    public static void main(String args[])
    {
        try {
            Class cls = Class.forName("org.example.Example");
            boolean b1 = cls.isInstance(new String());
            System.out.println(b1);
            boolean b2 = cls.isInstance(new Example());
            System.out.println(b2);
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}

class Example {
}