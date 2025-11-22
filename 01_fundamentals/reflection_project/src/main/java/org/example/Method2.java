/** Invoking Methods by Name **/
package org.example;

import java.lang.reflect.Method;

public class Method2 {
    public int add(int a, int b)
    {
        return a + b;
    }

    public static void main(String args[])
    {
        try {
            Class cls = Class.forName("org.example.Method2");

            Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Method meth = cls.getMethod("add", partypes); // find a method in the class by name and parameters

            Method2 methobj = new Method2();
            Object arglist[] = new Object[2];
            arglist[0] = 37;
            arglist[1] = 47;

            Object retobj = meth.invoke(methobj, arglist);
            Integer retval = (Integer)retobj;
            System.out.println(retval.intValue());
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}
