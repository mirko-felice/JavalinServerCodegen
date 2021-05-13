package api;

import utils.*;
import java.util.ArrayList;
import io.javalin.http.BadRequestResponse;
import java.util.concurrent.CompletableFuture;
import io.javalin.http.Context;
import java.util.HashMap;
import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import model.Order;
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
* API tests for StoreAPI
*/
public class StoreAPITest {

    private static final String BASE_PATH = "/v2";
    private static final String BASE_URI = "http://localhost:7000" + BASE_PATH;
    private static final StoreAPI API = new StoreAPI(BASE_PATH);
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
    * Delete purchase order by ID
    *
    * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
    */
    @Test
    public void deleteOrderTest() {
        Long orderId = null;

        uri = BASE_URI + "/store/order/{orderId}".replaceFirst(Pattern.quote("{" + "orderId" + "}"), String.valueOf(orderId));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = delete(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/Store";

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
    * Returns pet inventories by status
    *
    * Returns a map of status codes to quantities
    */
    @Test
    public void getInventoryTest() {

        uri = BASE_URI + "/store/inventory";
        HttpRequest.Builder builder = createRequest();
        
        builder.header("api_key", "");
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<Map<String, Integer>> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeMap(String.class, Integer.class));
        // TODO: test validations

        uri = BASE_URI + "/Store";

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
    * Find purchase order by ID
    *
    * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions
    */
    @Test
    public void getOrderByIdTest() {
        Long orderId = null;

        uri = BASE_URI + "/store/order/{orderId}".replaceFirst(Pattern.quote("{" + "orderId" + "}"), String.valueOf(orderId));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<Order> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(Order.class));
        // TODO: test validations

        uri = BASE_URI + "/Store";

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
    * Place an order for a pet
    *
    * 
    */
    @Test
    public void placeOrderTest() {
        Order body = null;

        uri = BASE_URI + "/store/order";
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<Order> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(Order.class));
        // TODO: test validations

        uri = BASE_URI + "/Store";

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