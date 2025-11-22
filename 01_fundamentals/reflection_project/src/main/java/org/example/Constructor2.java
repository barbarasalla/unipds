/** Creating New Objects **/
package org.example;

import java.lang.reflect.Constructor;

public class Constructor2 {

    public Constructor2() {}

    public Constructor2(int a, int b) {
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main(String args[])
    {
        try {
            Class cls = Class.forName("org.example.Constructor2");
            Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Constructor ct = cls.getConstructor(partypes);

            Object arglist[] = new Object[2];
            arglist[0] = 37;
            arglist[1] = 47;

            Object retobj = ct.newInstance(arglist);
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}
