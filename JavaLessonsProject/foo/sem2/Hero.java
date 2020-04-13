package sem2;

import com.google.gson.annotations.SerializedName;

import java.io.*;

@Testing(status = Testing.Status.PRODUCTION)
@MyAnnotation
public class Hero implements Serializable {
    public static String test = "test";

    public String name;
    private transient String power;
    @Testing
    @SerializedName("MegaBook")
    private String book;

    public Hero(String name, String power, String book) {
        this.name = name;
        this.power = power;
        this.book = book;
        doJob();
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    private void doJob() {
        System.out.println("Hero.constructor");
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        if (!this.getClass().getName().equals("Hero")) throw new NotSerializableException("Not today!");
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        doJob();
    }


    @Deprecated
    void fight(Hero enemy) {
        if (name.equals(enemy.name)) throw new IllegalArgumentException("Cant fight with yourself.");
        System.out.printf("%s fight with %s.%n", name, enemy.name);
    }

    @Override
    public boolean equals(Object another) {
        return this.name.equals(((Hero) another).name);
    }

    @Testing
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", power='" + power + '\'' +
                ", book='" + book + '\'' +
                '}';
    }
}