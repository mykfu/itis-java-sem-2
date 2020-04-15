package sem2.L12.tgmbot;

import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class TelegramBot {
    private final String TELEGRAM_BOT = "https://api.telegram.org/bot";
    private String token;
    private long offset = 0;

    public TelegramBot() {
        try {
            loadProp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TelegramBot(String token) {
        this.token = token;
    }

    void loadProp() throws IOException {
        Properties properties = new Properties(); // Map<String, String>
        BufferedReader br = Files.newBufferedReader(Paths.get("src/sem2/L12/tgmbot/config.properties"));
        properties.load(br);
        token = properties.getProperty("bot_token");
        if (Files.exists(Paths.get("sem2/L12/tgmbot/offset.bin")) && Files.size(Paths.get("src/sem2/L12/tgmbot/offset.bin")) > 0) {
            DataInputStream in = new DataInputStream(new
                    BufferedInputStream(new FileInputStream("offset.bin")));
            offset = in.readLong();
        }
    }

    private UserResponse getResponse(String link) {
        ReadableByteChannel channel;
        BufferedReader bufferedReader = null;
        UserResponse response = null;
        InputStream inputStream = null;
        int counter = 0;
        do {
            try {
                System.out.println("Connecting... " + ++counter);
                URL url = new URL(link);
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("5.183.150.174", 8080));
                URLConnection connection = url.openConnection(proxy);
                connection.connect();
                inputStream = connection.getInputStream();
                if (inputStream.available() > 0) {
                    System.out.println("Reading...");
                    channel = Channels.newChannel(inputStream);
                    bufferedReader = new BufferedReader(Channels.newReader(channel, StandardCharsets.UTF_8.name()));
                    Gson gson = new Gson();

                    response = gson.fromJson(bufferedReader, UserResponse.class);

                    channel.close();
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } while (inputStream == null);
        System.out.println(response);
        return response;
    }

    private Response getResponse(String link, Class<? extends Response> clazz) {
        ReadableByteChannel channel;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        Response response = null;
        int counter = 0;
        do {
            try {
                System.out.println("Connecting... " + ++counter);
                URL url = new URL(link);
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
        System.out.println(clazz);
        return response;
    }

    public void getMe() {
        String link = TELEGRAM_BOT + token + "/getMe";
        getResponse(link, UserResponse.class);
    }

    public boolean sendMessage(long chat_id, String text) {
        String link = null;
        try {
            link = TELEGRAM_BOT + token + String.format("/sendMessage?chat_id=%d&text=%s", chat_id, URLEncoder.encode(text, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getResponse(link).isOk();
    }


    public Update[] getUpdates(boolean longPolling) {
        UpdatesResponse updatesResponse = null;
        String link = TELEGRAM_BOT + token + String.format("/getUpdates?offset=%d", offset);
        if (longPolling) {
            link += "&timeout=10";
        }
        ReadableByteChannel channel;
        BufferedReader bufferedReader = null;
        UpdatesResponse response = null;
        InputStream inputStream = null;
        int counter = 0;
        do {
            try {
                System.out.println("Connecting... " + ++counter);
                URL url = new URL(link);
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("5.183.150.174", 8080));
                URLConnection connection = url.openConnection(proxy);
                connection.setConnectTimeout(15000);
                connection.connect();
                inputStream = connection.getInputStream();
                if (inputStream.available() > 0) {
                    System.out.println("Reading...");
                    channel = Channels.newChannel(inputStream);
                    bufferedReader = new BufferedReader(Channels.newReader(channel, StandardCharsets.UTF_8.name()));

                    Gson gson = new Gson();
                    response = gson.fromJson(bufferedReader, UpdatesResponse.class);

                    channel.close();
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } while (inputStream == null);
        Update[] updates = response.getResult();
        for (Update update : updates) {
            System.out.println(update);
            offset = update.getUpdate_id() + 1;
        }

        try {
            DataOutputStream out = new DataOutputStream(Files.newOutputStream(Paths.get("src/sem2/L12/tgmbot/offset.bin")));
            out.writeLong(offset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.getResult();

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

class TelegramBotTest {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
//        bot.getMe();
//        bot.sendMessage(163686622, "Hello, world!");
//        bot.getUpdates();
        bot.startUpdatesService();
    }
}