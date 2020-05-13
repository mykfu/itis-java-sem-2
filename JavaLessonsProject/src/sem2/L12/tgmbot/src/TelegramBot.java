import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import dao.CSVFileUserDAO;
import model.*;

public class TelegramBot {
    private final String TELEGRAM_BOT = "https://api.telegram.org/bot";
    private String token;
    private long offset = 0;

    public TelegramBot() throws IOException {
        loadProp();
    }

    public TelegramBot(String token) {
        this.token = token;
        System.out.println(token);
    }

    void loadProp() throws IOException {
        Properties properties = new Properties(); // Map<String, String>
        final Path path = Paths.get("config.properties");
        BufferedReader br = Files.newBufferedReader(path);
        properties.load(br);
        token = properties.getProperty("bot_token");
        if (Files.exists(Paths.get("offset.bin")) && Files.size(Paths.get("offset.bin")) > 0) {
            DataInputStream in = new DataInputStream(new
                    BufferedInputStream(new FileInputStream("offset.bin")));
            offset = in.readLong();
        }
    }

    public <T extends Response> T getResponse(String link, Class<T> clazz) {
        ReadableByteChannel channel;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        Response response = null;
        int counter = 0;
        do {
            try {
                System.out.println("Connecting... " + ++counter);
                URL url = new URL(link);
                System.out.println(link);
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("5.183.150.174", 8080));
                URLConnection connection = url.openConnection(proxy);
                connection.connect();
                inputStream = connection.getInputStream();
                if (inputStream.available() > 0) {
                    System.out.println("Reading...");
                    channel = Channels.newChannel(inputStream);
                    bufferedReader = new BufferedReader(Channels.newReader(channel, StandardCharsets.UTF_8.name()));
                    Gson gson = new Gson();

                    response = gson.fromJson(bufferedReader, clazz);

                    channel.close();
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } while (inputStream == null);
//        System.out.println(clazz);
        return clazz.cast(response);
    }

    public void getMe() {
        String link = TELEGRAM_BOT + token + "/getMe";
        UserResponse response = getResponse(link, UserResponse.class);
        System.out.println(response);
    }

    public boolean sendMessage(long chat_id, String text) {
        String link = null;
        try {
            link = TELEGRAM_BOT + token + String.format("/sendMessage?chat_id=%d&text=%s", chat_id, URLEncoder.encode(text, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getResponse(link, DefaultResponse.class).isOk();
    }


    public Update[] getUpdates(boolean longPolling) {
        UpdatesResponse updatesResponse = null;
        String link = TELEGRAM_BOT + token + String.format("/getUpdates?offset=%d", offset);
        if (longPolling) {
            link += "&timeout=10";
        }
        updatesResponse = (UpdatesResponse) getResponse(link, UpdatesResponse.class);
        Update[] updates = updatesResponse.getResult();

        for (Update update : updates) {
            System.out.println(update);
            offset = update.getUpdate_id() + 1;
        }

        try {
            DataOutputStream out = new DataOutputStream(Files.newOutputStream(Paths.get("offset.bin")));
            out.writeLong(offset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updates;
    }

    String answer(String text) {
        text.startsWith("/");
        switch (text) {
            case "hw":

        }
        return "";
    }

    void startUpdatesService() {
        while (true) {
            System.out.println("Running");
            Update[] updates = getUpdates(true);
            if (updates.length > 0) {
                for (Update update : updates) {
                    System.out.println(update);
                    if (update.getMessage() != null)
                        sendMessage(
                                update.getMessage().getChat().getId(),
                                "Hello, @" + update.getMessage().getFrom().getUsername() + "!"
                        );

                    CSVFileUserDAO dao = new CSVFileUserDAO();
                    dao.add(update.getMessage().getFrom());
                    dao.close();
                }
            } else {
                System.out.println("No updates.");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}

