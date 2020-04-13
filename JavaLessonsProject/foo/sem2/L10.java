package sem2;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class L10 {
    public static void main(String[] args) throws NoSuchMethodException {
        // Reflection API
        Hero ironMan = new Hero("Iron Man", "iron", "IM comics");
        Class<Hero> cls = Hero.class;
//        Class cls2 = ironMan.getClass();
//        try {
//            Class cls3 = Class.forName(ironMan.getClass().getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Class<Hero> cls4 = Hero.class;
//        try {
//            Hero hero = (Hero) cls.newInstance();
//            Hero hero2 = cls4.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        try {
//            Hero heroTest = cls.newInstance();
            Hero heroTest = cls.getConstructor(String.class, String.class, String.class).newInstance("Test Hero", "test", "bookTest");
            System.out.println("heroTest = " + heroTest);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("parameter = " + parameter);
                System.out.println("parameter.getName() = " + parameter.getName());
                System.out.println("parameter.getType() = " + parameter.getType());
            }
        }

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
            System.out.println("method.getModifiers() = " + Modifier.toString(method.getModifiers()));
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("  parameter.getName() = " + parameter.getName());
                System.out.println("  parameter.getType() = " + parameter.getType());
                System.out.println("  parameter.getModifiers() = " + Modifier.toString(parameter.getModifiers()));
            }
        }

        try {
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("field = " + field);
                field.setAccessible(true);
                System.out.println(field.get(ironMan));
            }

            Field fieldName = cls.getField("name");
            System.out.println(fieldName.get(ironMan));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("\nInvoke");
        Method fight = cls.getDeclaredMethod("fight", Hero.class);
        fight.setAccessible(true);
        Hero spiderMan = new Hero("Spider Man", "web", "IM3");
        try {
            fight.invoke(ironMan, spiderMan);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // Annotations
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Testing.class)) {
                System.out.print("Testing: ");
                System.out.println(annotation);
            }
            System.out.println("annotation.annotationType() = " + annotation.annotationType());
        }

        if (cls.isAnnotationPresent(Testing.class)) {
            Testing testing = cls.getAnnotation(Testing.class);
            if (testing.status().equals(Testing.Status.PRODUCTION)) {
                System.out.println("Prod.");
            }
        }
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
//@Inherited
@interface Testing {
    String value() default "Test";

    enum Status {DEBUG, PRODUCTION}

    Deprecated dpr() default @Deprecated;

    String[] params() default {"adf", "asdfas"};

    Class<Hero> hero() default Hero.class;

    Status status() default Status.DEBUG;
}