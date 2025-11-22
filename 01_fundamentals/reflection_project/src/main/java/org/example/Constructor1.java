/** Obtaining Information About Constructors **/
package org.example;

import java.lang.reflect.*;

public class Constructor1 {
    public Constructor1() {
    }

    protected Constructor1(int i, double d) {
    }

    public static void main(String args[]) {
        try {
            Class cls = Class.forName("org.example.Constructor1");

            Constructor ctorlist[] = cls.getDeclaredConstructors();

            for (int i = 0; i < ctorlist.length; i++) {
                Constructor ct = ctorlist[i];
                System.out.println("name = " + ct.getName());
                System.out.println("decl class = " + ct.getDeclaringClass());

                Class pvec[] = ct.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);

                Class evec[] = ct.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);

                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
