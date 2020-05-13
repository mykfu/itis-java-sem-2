import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

class RunTgmUpdateService {
    public static void main(String[] args) throws Exception {
        System.out.println("RunTgmUpdateService.main");
        Path path = Paths.get("src/sem2/L12/tgmbot/resources/config.properties");
        TelegramBot bot = null;
        if (Files.exists(path)) {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(new FileInputStream(path.toFile())));
            bot = new TelegramBot(properties.getProperty("bot_token"));
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
            bot.startUpdatesService();
        }
    }
}
