package utils;

import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class Utilities {

    private Utilities(){ }

    public static String responseChecker(HttpResponse<String> response) {
        if (response.statusCode() == 200)
            return response.body();
        else
            throw new RemoteException(String.format("Unexpected response while %s %s: %d", response.request().method(), response.uri(), response.statusCode()));
    }

    public static <T> Function<String, CompletableFuture<T>> deserializeOne(Class<T> klass) {
        return toBeDeserialized -> {
            var promise = new CompletableFuture<T>();
            promise.complete(JavalinDeserializer.deserializeOne(toBeDeserialized, klass));
            return promise;
        };
    }

    public static <T> Function<String, CompletableFuture<List<T>>> deserializeMany(Class<T> klass) {
        return toBeDeserialized -> {
            var promise = new CompletableFuture<List<T>>();
            promise.complete(JavalinDeserializer.deserializeMany(toBeDeserialized, klass));
            return promise;
        };
    }

    public static <U,T> Function<String, CompletableFuture<Map<U,T>>> deserializeMap(Class<U> klassU, Class<T> klassT) {
        return toBeDeserialized -> {
           var promise = new CompletableFuture<Map<U, T>>();
           promise.complete(JavalinDeserializer.deserializeMap(toBeDeserialized, klassU, klassT));
           return promise;
        };
    }

    public static <T> String serializeOne(T object) {
        return JavalinSerializer.serializeOne(object);
    }

    public static <T> String serializeMany(List<T> objects) {
        return JavalinSerializer.serializeMany(objects);
    }

    public static <U,T> String serializeMap(Map<U,T> map) {
        return JavalinSerializer.serializeMap(map);
    }
}
