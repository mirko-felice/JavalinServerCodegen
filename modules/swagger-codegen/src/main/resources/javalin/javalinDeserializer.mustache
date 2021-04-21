package utils;

import java.util.*;
import org.json.*;
import io.javalin.plugin.json.JavalinJson;

public class JavalinDeserializer {

    private JavalinDeserializer(){ }

    public static <T> T deserializeOne(String toBeDeserialized, Class<T> klass) {
        return JavalinJson.fromJson(toBeDeserialized, klass);
    }

    public static <T> List<T> deserializeMany(String toBeDeserialized, Class<T> klass) {
        List<T> result = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(toBeDeserialized);
        for (int i = 0; i < jsonArray.length(); i++)
            result.add(deserializeOne(jsonArray.getJSONObject(i).toString(), klass));
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <U,T> Map<U,T> deserializeMap(String toBeDeserialized, Class<U> klassU, Class<T> klassT) {
        Map<U,T> result = new HashMap<>();
        JSONArray jsonArray = new JSONArray(toBeDeserialized);
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String key = jsonObject.keys().next();
            result.put((U) key, jsonObject.optJSONObject(key) == null ? (T) jsonObject.get(key) : deserializeOne(jsonObject.get(key).toString(), klassT));
        }
        return result;
    }
}
