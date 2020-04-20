import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

class TelegramBotTest {
    public static void main(String[] args) throws Exception {
        System.out.println("TelegramBotTest.main");
        Path path = Paths.get("config.properties");
        TelegramBot bot = null;
        if (Files.exists(path)) {
            bot = new TelegramBot();
        } else if (args.length > 0) {
            for (String arg : args) {
                Properties properties = new Properties();
                properties.load(new StringReader(arg));
                bot = new TelegramBot(properties.getProperty("token"));
            }
        } else {
            throw new Exception("Token doesn't set!");
        }
        if (bot != null) {
            bot.getMe();
        }
//        bot.sendMessage(163686622, "Hello, world!");
//        bot.getUpdates();
//        bot.startUpdatesService();
    }
}
