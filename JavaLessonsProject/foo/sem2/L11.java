package sem2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class L11 {
    public static void main(String[] args) {
        Hero ironMan = new Hero("Iron Man", "iron", "IM comics");
        System.out.println("ironMan = " + ironMan);
        try {
            FileOutputStream fos = new FileOutputStream(URLEncoder.encode(ironMan.name, StandardCharsets.UTF_8.toString()) + ".hero");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ironMan);
            oos.reset();

            ironMan.setBook("another");
            System.out.println("  changed ironMan = " + ironMan);

            oos.writeObject(ironMan);
            oos.close();

//            BestHero bestHero = new BestHero("Best Hero", "test", "Best Book");
//            FileOutputStream fos2 = new FileOutputStream(
//                    URLEncoder.encode(
//                            ironMan.getClass().getSimpleName(),
//                            StandardCharsets.UTF_8.toString()
//                    ) + ".hero");
//            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
//            oos2.writeObject(bestHero);
//            oos2.close();

            FileInputStream fis = new FileInputStream("Iron+Man.hero");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Hero hero = (Hero) ois.readObject();
            ois.close();
            System.out.println("hero after deserialize = " + hero);



            Gson gson = new Gson();
            String json = gson.toJson(ironMan);
            System.out.println("json = " + json);

            Hero afterJson = gson.fromJson(json, Hero.class);
            System.out.println("afterJson = " + afterJson);

            Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter("hero.json");
            gson1.toJson(ironMan, writer);
            writer.close();

            Hero hero12 = gson1.fromJson(new FileReader("hero.json"), Hero.class);
            System.out.println("hero12 = " + hero12);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}
