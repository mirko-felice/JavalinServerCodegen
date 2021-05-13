package api;

import utils.*;
import java.util.ArrayList;
import io.javalin.http.BadRequestResponse;
import java.util.concurrent.CompletableFuture;
import io.javalin.http.Context;
import java.util.HashMap;
import org.json.JSONArray;
import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJson;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import model.User;
import io.javalin.websocket.WsMessageContext;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.regex.Pattern;
import java.util.concurrent.CompletionStage;
import java.nio.ByteBuffer;

/**
* API tests for UserAPI
*/
public class UserAPITest {

    private static final String BASE_PATH = "/v2";
    private static final String BASE_URI = "http://localhost:7000" + BASE_PATH;
    private static final UserAPI API = new UserAPI(BASE_PATH);
    private static final Javalin SERVER = Javalin.create().start();
    private final HttpClient client = HttpClient.newHttpClient();
    private String uri;

    @BeforeClass
    public static void setUp() {
        API.registerRoutes(SERVER);
    }

    @AfterClass
    public static void tearDown() {
        SERVER.stop();
    }

    /**
    * Create user
    *
    * This can only be done by the logged in user.
    */
    @Test
    public void createUserTest() {
        User body = null;

        uri = BASE_URI + "/user";
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Creates list of users with given input array
    *
    * 
    */
    @Test
    public void createUsersWithArrayInputTest() {
        List<User> body = null;

        uri = BASE_URI + "/user/createWithArray";
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Creates list of users with given input array
    *
    * 
    */
    @Test
    public void createUsersWithListInputTest() {
        List<User> body = null;

        uri = BASE_URI + "/user/createWithList";
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Delete user
    *
    * This can only be done by the logged in user.
    */
    @Test
    public void deleteUserTest() {
        String username = null;

        uri = BASE_URI + "/user/{username}".replaceFirst(Pattern.quote("{" + "username" + "}"), String.valueOf(username));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = delete(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Get user by user name
    *
    * 
    */
    @Test
    public void getUserByNameTest() {
        String username = null;

        uri = BASE_URI + "/user/{username}".replaceFirst(Pattern.quote("{" + "username" + "}"), String.valueOf(username));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<User> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(User.class));
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Logs user into the system
    *
    * 
    */
    @Test
    public void loginUserTest() {
        String username = null;
        String password = null;

        uri = BASE_URI + "/user/login".concat("?" + "username" + "=" + String.valueOf(username)).concat("&" + "password" + "=" + String.valueOf(password));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<String> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(String.class));
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Logs out current logged in user session
    *
    * 
    */
    @Test
    public void logoutUserTest() {

        uri = BASE_URI + "/user/logout";
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }

    /**
    * Updated user
    *
    * This can only be done by the logged in user.
    */
    @Test
    public void updateUserTest() {
        String username = null;
        User body = null;

        uri = BASE_URI + "/user/{username}".replaceFirst(Pattern.quote("{" + "username" + "}"), String.valueOf(username));
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json");
        
        
        HttpRequest request = put(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/User";

        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {}

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return null;
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) { }
            };

        CompletableFuture<WebSocket> webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener);

    }


    private CompletableFuture<HttpResponse<String>> sendAsync(HttpRequest request) {
        return client.sendAsync(request, BodyHandlers.ofString());
    }

    private HttpRequest.Builder createRequest(){
        return HttpRequest.newBuilder().uri(URI.create(this.uri));
    }

    private HttpRequest get(HttpRequest.Builder builder){
        return builder.GET().build();
    }

    private HttpRequest post(HttpRequest.Builder builder, Object object){
        return builder.POST(BodyPublishers.ofString(object instanceof List ? Utilities.serializeMany((List<?>) object) : object instanceof Map ? Utilities.serializeMap((Map<?,?>)object) : Utilities.serializeOne(object))).build();
    }

    private HttpRequest post(HttpRequest.Builder builder, Object... objects){
        var request = builder.header("Content-Type", "multipart/form-data");
        for (Object o: objects)
            request.POST(BodyPublishers.ofString(Utilities.serializeOne(o)));
        return request.build();
    }

    private HttpRequest put(HttpRequest.Builder builder, Object object){
        return builder.PUT(BodyPublishers.ofString(object instanceof List ? Utilities.serializeMany((List<?>) object) : object instanceof Map ? Utilities.serializeMap((Map<?,?>)object) : Utilities.serializeOne(object))).build();
    }

    private HttpRequest put(HttpRequest.Builder builder, Object... objects){
        var request = builder.header("Content-Type", "multipart/form-data");
        for (Object o: objects)
            request.PUT(BodyPublishers.ofString(Utilities.serializeOne(o)));
        return request.build();
    }

    private HttpRequest delete(HttpRequest.Builder builder){
        return builder.DELETE().build();
    }
}