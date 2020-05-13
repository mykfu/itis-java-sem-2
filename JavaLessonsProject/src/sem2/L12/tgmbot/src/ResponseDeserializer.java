import com.google.gson.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ResponseDeserializer<T extends Response> implements JsonDeserializer<T> {

    public static boolean isFieldContains(Class clazz, String fieldName) {
        return Arrays.stream(clazz.getDeclaredFields())
                .anyMatch(f -> f.getName().equals(fieldName));
    }

    @Override
    public T deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        boolean ok = jsonObject.get("ok").getAsBoolean();
        Object result = null;
        if (jsonObject.get("result").isJsonObject()) {
            result = jsonObject.get("result").getAsJsonObject();
        } else if (jsonObject.get("result").isJsonArray()) {
            result = jsonObject.get("result").getAsJsonArray();
        }

        Field resultField = null;
        try {
            final Class<?> typeClass = Class.forName(type.getTypeName());
//            System.out.println(Arrays.toString(typeClass.getDeclaredFields()));
            if (isFieldContains(typeClass, "result"))
                resultField = typeClass.getDeclaredField("result");
            else {
                resultField = typeClass.getSuperclass().getDeclaredField("result");
            }
//            System.out.println(Arrays.toString(typeClass.getConstructors()));

            assert resultField != null;
            Constructor constructor =  typeClass.getConstructor(boolean.class, resultField.getType());

            assert result != null;
            Object fromJson = new Gson().fromJson(jsonObject.get("result"), resultField.getType());
            Object object = constructor.newInstance(ok, fromJson);
            return (T) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
