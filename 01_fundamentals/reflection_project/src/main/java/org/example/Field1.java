/** Finding Out About Class Fields **/
package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Field1 {
    private double d;
    public static final int i = 37;
    String s = "testing";

    public static void main(String args[]) {
        try {
            Class cls = Class.forName("org.example.Field1");

            Field fieldlist[]
                    = cls.getDeclaredFields(); // For get information about public fields of superclasses use "getFields()" (just public fields)

            for (int i = 0; i < fieldlist.length; i++) {

                Field fld = fieldlist[i];
                System.out.println("name = " + fld.getName());
                System.out.println("decl class = " + fld.getDeclaringClass());
                System.out.println("type = " + fld.getType());

                int mod = fld.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));

                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
