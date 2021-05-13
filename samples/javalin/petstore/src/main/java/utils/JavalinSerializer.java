package utils;

import java.util.*;
import java.util.stream.Collectors;
import io.javalin.plugin.json.JavalinJson;

public class JavalinSerializer {

    private JavalinSerializer(){ }

    public static <T> String serializeOne(T toBeSerialized) {
        return JavalinJson.toJson(toBeSerialized);
    }

    public static <T> String serializeMany(List<T> toBeSerialized) {
        return "[" + toBeSerialized.stream().map(JavalinJson::toJson).collect(Collectors.joining(",")) + "]";
    }

    public static <T,U> String serializeMap(Map<T,U> toBeSerialized) {
        return "[" + toBeSerialized.entrySet().stream().map(JavalinJson::toJson).collect(Collectors.joining(",")) + "]";
    }
}
