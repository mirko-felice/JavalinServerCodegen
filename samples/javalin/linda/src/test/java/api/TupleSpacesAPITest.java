package api;

import utils.*;
import java.util.ArrayList;
import io.javalin.http.BadRequestResponse;
import java.util.concurrent.CompletableFuture;
import io.javalin.http.Context;
import java.util.HashMap;
import io.javalin.Javalin;
import java.util.List;
import model.ListOfNames;
import java.util.Map;
import java.util.Objects;
import model.Tuple;
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
* API tests for TupleSpacesAPI
*/
public class TupleSpacesAPITest {

    private static final String BASE_PATH = "/linda/v2";
    private static final String BASE_URI = "http://localhost:7000" + BASE_PATH;
    private static final TupleSpacesAPI API = new TupleSpacesAPI(BASE_PATH);
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
    * Consumes tuples from the tuple space
    *
    * Performs an `in` operation over the template provided within URL query
    */
    @Test
    public void deleteTupleTest() {
        String tupleSpaceName = null;
        String template = null;

        uri = BASE_URI + "/tuple-spaces/{tupleSpaceName}".replaceFirst(Pattern.quote("{" + "tupleSpaceName" + "}"), String.valueOf(tupleSpaceName)).concat("?" + "template" + "=" + String.valueOf(template));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = delete(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<Tuple> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(Tuple.class));
        // TODO: test validations


    }

    /**
    * Get or count tuples from the tuple space
    *
    * Get or count tuples from the tuple space. The actual behaviour depends on the provided paramenters: - the presence of the `count` parameter makes this method behave as the `count` primitive, assuming the value of the parameter is `true` - if the `count` parameter is absent or `false`, the presence of the `template` parameter makes this method behave as the `rd` primitive - if the `count` parameter is absent or `false`, and the `template` parameter is absent, then this method behave as the `get` primitive  Notice that in case of `rd`-like behaviour, the operation is suspensive, meaning that the reponse from the server will be produced only after one tuple matching the behaviour is available on the tuple space. In any other case, the server response will be produced ASAP 
    */
    @Test
    public void getTupleTest() {
        String tupleSpaceName = null;
        Boolean count = null;
        String template = null;

        uri = BASE_URI + "/tuple-spaces/{tupleSpaceName}".replaceFirst(Pattern.quote("{" + "tupleSpaceName" + "}"), String.valueOf(tupleSpaceName)).concat("?" + "count" + "=" + String.valueOf(count)).concat("&" + "template" + "=" + String.valueOf(template));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<Object> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(Object.class));
        // TODO: test validations


    }

    /**
    * Get the names of all the currently instantiated tuple spaces
    *
    * Retrieve all the names to all tuple spaces 
    */
    @Test
    public void getTupleSpacesTest() {
        Integer skip = null;
        Integer limit = null;
        String filter = null;

        uri = BASE_URI + "/tuple-spaces".concat("?" + "skip" + "=" + String.valueOf(skip)).concat("&" + "limit" + "=" + String.valueOf(limit)).concat("&" + "filter" + "=" + String.valueOf(filter));
        HttpRequest.Builder builder = createRequest();
        
        
        HttpRequest request = get(builder /* TODO initialize params and uncomment ,*/);

        CompletableFuture<ListOfNames> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(ListOfNames.class));
        // TODO: test validations


    }

    /**
    * Insert a tuple into the tuple space
    *
    * Performs an `out` operation over the tuple provided within the request body
    */
    @Test
    public void postTupleTest() {
        String tupleSpaceName = null;
        Tuple tuple = null;

        uri = BASE_URI + "/tuple-spaces/{tupleSpaceName}".replaceFirst(Pattern.quote("{" + "tupleSpaceName" + "}"), String.valueOf(tupleSpaceName));
        HttpRequest.Builder builder = createRequest().header("Content-Type", "application/json");
        
        
        HttpRequest request = post(builder /* TODO initialize params and uncomment ,tuple*/);

        CompletableFuture<Tuple> response = sendAsync(request).thenApply(Utilities::responseChecker).thenCompose(Utilities.deserializeOne(Tuple.class));
        // TODO: test validations


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