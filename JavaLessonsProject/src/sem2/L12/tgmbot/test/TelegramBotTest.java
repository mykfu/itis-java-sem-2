import com.google.gson.*;
import dao.CSVFileMessageDAO;
import dao.DAO;
import dao.CSVFileDAOManager;
import model.Update;
import model.User;
import org.junit.Test;

public class TelegramBotTest {

    @Test
    public void getMeJson() {
        String json = "{\"ok\":true,\"result\":{\"id\":1120467643,\"is_bot\":true,\"first_name\":\"githubparser\",\"username\":\"githubparser_bot\",\"can_join_groups\":true,\"can_read_all_group_messages\":false,\"supports_inline_queries\":false}}";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(UserResponse.class, new ResponseDeserializer<>())
                .create();

        Response response = gson.fromJson(json, UserResponse.class);
        System.out.println(response);
        User user = (User) response.getResult();
        System.out.println(user);
        CSVFileDAOManager daoManager = new CSVFileDAOManager();
        DAO dao = CSVFileDAOManager.getDAO(user.getClass());
        dao.add(user);
        dao.close();
    }

    @Test
    public void getUpdatesJson() {
        String json = "{\"ok\":true,\"result\":[{\"update_id\":664568126,\n" +
                "\"message\":{\"message_id\":37,\"from\":{\"id\":163686622,\"is_bot\":false,\"first_name\":\"Shamil\",\"last_name\":\"K.\",\"username\":\"kshamil\",\"language_code\":\"ru\"},\"chat\":{\"id\":163686622,\"first_name\":\"Shamil\",\"last_name\":\"K.\",\"username\":\"kshamil\",\"type\":\"private\"},\"date\":1586951505,\"text\":\"adf\"}},{\"update_id\":664568127,\n" +
                "\"message\":{\"message_id\":38,\"from\":{\"id\":163686622,\"is_bot\":false,\"first_name\":\"Shamil\",\"last_name\":\"K.\",\"username\":\"kshamil\",\"language_code\":\"ru\"},\"chat\":{\"id\":163686622,\"first_name\":\"Shamil\",\"last_name\":\"K.\",\"username\":\"kshamil\",\"type\":\"private\"},\"date\":1586951505,\"text\":\"asdf\"}},{\"update_id\":664568128,\n" +
                "\"message\":{\"message_id\":39,\"from\":{\"id\":163686622,\"is_bot\":false,\"first_name\":\"Shamil\",\"last_name\":\"K.\",\"username\":\"kshamil\",\"language_code\":\"ru\"},\"chat\":{\"id\":163686622,\"first_name\":\"Shamil\",\"last_name\":\"K.\",\"username\":\"kshamil\",\"type\":\"private\"},\"date\":1586951506,\"text\":\"asfd\"}}]}";

        Class<UpdatesResponse> clazz = UpdatesResponse.class;
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(clazz, new ResponseDeserializer<>())
                .create();
        Response response = gson.fromJson(json, clazz);
        Update[] updates = (Update[]) response.getResult();
        System.out.println(response);

        CSVFileMessageDAO messageDAO = new CSVFileMessageDAO();
        for (Update update : updates) {
            messageDAO.add(update.getMessage());
        }
        messageDAO.close();
    }
}