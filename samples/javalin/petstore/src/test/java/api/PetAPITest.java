package api;

import utils.*;
import model.ApiResponse;
import java.util.ArrayList;
import io.javalin.http.BadRequestResponse;
import java.util.concurrent.CompletableFuture;
import io.javalin.http.Context;
import java.io.File;
import java.util.HashMap;
import io.javalin.Javalin;
import io.javalin.core.util.FileUtil;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import model.Pet;
import io.javalin.http.UploadedFile;
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
* API tests for PetAPI
*/
public class PetAPITest {

    private static final String BASE_PATH = "/v2";
    private static final String BASE_URI = "http://localhost:7000" + BASE_PATH;
    private static final PetAPI API = new PetAPI(BASE_PATH);
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
    * Add a new pet to the store
    *
    * 
    */
    @Test
    public void addPetTest() {
        Pet body = null;

        uri = BASE_URI + "/pet";
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json;application/xml");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * Deletes a pet
    *
    * 
    */
    @Test
    public void deletePetTest() {
        Long petId = null;
        String apiKey = null;

        uri = BASE_URI + "/pet/{petId}".replaceFirst(Pattern.quote("{" + "petId" + "}"), String.valueOf(petId));
        HttpRequest.Builder builder = createRequest();
        builder.header("apiKey", String.valueOf(apiKey));
        
        HttpRequest request = delete(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * Finds Pets by status
    *
    * Multiple status values can be provided with comma separated strings
    */
    @Test
    public void findPetsByStatusTest() {
        List<String> status = null;

        uri = BASE_URI + "/pet/findByStatus".concat("?" + "status" + "=" + String.valueOf(status));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<List<Pet>> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeMany(Pet.class));
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * Finds Pets by tags
    *
    * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    */
    @Test
    public void findPetsByTagsTest() {
        List<String> tags = null;

        uri = BASE_URI + "/pet/findByTags".concat("?" + "tags" + "=" + String.valueOf(tags));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<List<Pet>> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeMany(Pet.class));
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * Find pet by ID
    *
    * Returns a single pet
    */
    @Test
    public void getPetByIdTest() {
        Long petId = null;

        uri = BASE_URI + "/pet/{petId}".replaceFirst(Pattern.quote("{" + "petId" + "}"), String.valueOf(petId));
        HttpRequest.Builder builder = createRequest();
        
        builder.header("api_key", "");
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<Pet> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(Pet.class));
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * Update an existing pet
    *
    * 
    */
    @Test
    public void updatePetTest() {
        Pet body = null;

        uri = BASE_URI + "/pet";
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json;application/xml");
        
        
        HttpRequest request = put(builder /* TODO initialize params and uncomment ,body*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * Updates a pet in the store with form data
    *
    * 
    */
    @Test
    public void updatePetWithFormTest() {
        Long petId = null;
        String name = null;
        String status = null;

        uri = BASE_URI + "/pet/{petId}".replaceFirst(Pattern.quote("{" + "petId" + "}"), String.valueOf(petId));
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/x-www-form-urlencoded");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,name, status*/);

        CompletableFuture<HttpResponse<String>> response = sendAsync(request);
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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
    * uploads an image
    *
    * 
    */
    @Test
    public void uploadFileTest() {
        Long petId = null;
        String additionalMetadata = null;
        File file = null;

        uri = BASE_URI + "/pet/{petId}/uploadImage".replaceFirst(Pattern.quote("{" + "petId" + "}"), String.valueOf(petId));
        HttpRequest.Builder builder = createRequest().header("Content-Type", "multipart/form-data");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,additionalMetadata, file*/);

        CompletableFuture<ApiResponse> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(ApiResponse.class));
        // TODO: test validations

        uri = BASE_URI + "/Pet";

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