/*
 * Linda Web Service
 * - The Linda-WS application consists of an HTTP service functioning a central hub for multiple clients willing to interact through LINDA tuple spaces

- Clients may interact through Linda-WS by issuing LINDA operations in the form of HTTP methods invocations directed towards the _**textual** spaces_ wrapped by Linda-WS. In particular:
  + tuple spaces are referenced through URLs in the form `/linda/v2/tuple-spaces/{tupleSpaceName}`
  + tuples are JSON in the form `{ "tuple": "<string tuple>"}`
  + templates are query parameters in the form `template=`_`urlEncode(`_`{ "template": "<regex template>"}`_`)`_
  + primitives are mapped into HTTP methods as follows:
    * `rd` -> `GET`
    * `out` -> `POST`
    * `in` -> `DELETE`
    * `get` -> `GET`
    * `count` -> `GET`

 *
 * OpenAPI spec version: 2
 * 
 *
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 */

package api;

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

import utils.Utilities;
import io.javalin.http.UnauthorizedResponse;

public abstract class TupleSpacesAPI {

    private final String basePath;
    private int code = 200;

    public TupleSpacesAPI(final String basePath) {
        this.basePath = Objects.requireNonNull(basePath);
    }

    protected final void setCode(final int code) {
        this.code = code;
    }

    public void registerRoutes(Javalin server) {
        server.delete(this.basePath + "/tuple-spaces/{tupleSpaceName}".replace("{",":").replace("}",""), this::deleteTuple);
        server.get(this.basePath + "/tuple-spaces/{tupleSpaceName}".replace("{",":").replace("}",""), this::getTuple);
        server.get(this.basePath + "/tuple-spaces".replace("{",":").replace("}",""), this::getTupleSpaces);
        server.post(this.basePath + "/tuple-spaces/{tupleSpaceName}".replace("{",":").replace("}",""), this::postTuple);
    
    }
    
    /**
    * Consumes tuples from the tuple space
    *
    * Performs an `in` operation over the template provided within URL query
    * 
    * PathParams:
    * tupleSpaceName: The name of the textual space upon which the method will operate
    * 
    * QueryParams:
    * template: [URL-encoded](https://en.wikipedia.org/wiki/Percent-encoding) regex template 
    * 
    */
    public final void deleteTuple(Context context) {
        
        

        
        // Path params
        String tupleSpaceName = context.pathParam("tupleSpaceName", String.class).get();

        // Query params
        String template = context.queryParam("template", String.class).get();
        

        
        
        

        context.contentType("application/json");
        
        CompletableFuture<Tuple> result = this.deleteTupleLogic(tupleSpaceName, template);



        switch (this.code) {
            
            case 400:
                context.result("Some parameter is not well formed or missing");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<Tuple> deleteTupleLogic(String tupleSpaceName, String template); // TODO The method should set the responding status code by calling setCode()

    /**
    * Get or count tuples from the tuple space
    *
    * Get or count tuples from the tuple space. The actual behaviour depends on the provided paramenters: - the presence of the `count` parameter makes this method behave as the `count` primitive, assuming the value of the parameter is `true` - if the `count` parameter is absent or `false`, the presence of the `template` parameter makes this method behave as the `rd` primitive - if the `count` parameter is absent or `false`, and the `template` parameter is absent, then this method behave as the `get` primitive  Notice that in case of `rd`-like behaviour, the operation is suspensive, meaning that the reponse from the server will be produced only after one tuple matching the behaviour is available on the tuple space. In any other case, the server response will be produced ASAP 
    * 
    * PathParams:
    * tupleSpaceName: The name of the textual space upon which the method will operate
    * 
    * 
    * QueryParams:
    * count: States whether this method should behave as the `count` primitive or not
    * template: States whether this method should behave as the `rd` primitive (if present) or not, and, in that case it carries an [URL-encoded](https://en.wikipedia.org/wiki/Percent-encoding) JSON object wrapping a regex template
    * 
    */
    public final void getTuple(Context context) {
        
        

        
        // Path params
        String tupleSpaceName = context.pathParam("tupleSpaceName", String.class).get();

        // Query params
        Boolean count = context.queryParam("count", Boolean.class, "false").getOrNull();
        

        String template = context.queryParam("template", String.class).getOrNull();
        

        
        
        

        context.contentType("application/json");
        
        CompletableFuture<Object> result = this.getTupleLogic(tupleSpaceName, count, template);



        switch (this.code) {
            
            case 400:
                context.result("Some parameter is not well formed");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<Object> getTupleLogic(String tupleSpaceName, Boolean count, String template); // TODO The method should set the responding status code by calling setCode()

    /**
    * Get the names of all the currently instantiated tuple spaces
    *
    * Retrieve all the names to all tuple spaces 
    * 
    * 
    * 
    * QueryParams:
    * skip: Optional parameter stating the amount of sub-resources to be skipped in a bulk query. Defaults to 0
    * limit: Optional parameter stating the maximum amount of sub-resources to be returned by a bulk query. Defaults to 10
    * filter: Optional parameter constraining the bulk query to return only those sub-resources whose representation contains this value. Defaults to the empty string
    * 
    */
    public final void getTupleSpaces(Context context) {
        
        

        
        
        // Query params
        Integer skip = context.queryParam("skip", Integer.class, "0").getOrNull();
        

        Integer limit = context.queryParam("limit", Integer.class, "10").getOrNull();
        

        String filter = context.queryParam("filter", String.class, "<empty string>").getOrNull();
        

        
        
        

        context.contentType("application/json");
        
        CompletableFuture<ListOfNames> result = this.getTupleSpacesLogic(skip, limit, filter);



        switch (this.code) {
            
            case 400:
                context.result("Bad request. The provided `skip` and/or `limit` parameters are not valid integers");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<ListOfNames> getTupleSpacesLogic(Integer skip, Integer limit, String filter); // TODO The method should set the responding status code by calling setCode()

    /**
    * Insert a tuple into the tuple space
    *
    * Performs an `out` operation over the tuple provided within the request body
    * 
    * PathParams:
    * tupleSpaceName: The name of the textual space upon which the method will operate
    * 
    */
    public final void postTuple(Context context) {
        
        // Check request content type
        String contentType = context.contentType();
        if (contentType == null || !contentType.contains("application/json"))
            throw new BadRequestResponse();

        
        // Path params
        String tupleSpaceName = context.pathParam("tupleSpaceName", String.class).get();

        
        
        
        // Body
        Tuple tuple = context.bodyValidator(Tuple.class).get();
        

        context.contentType("application/json");
        
        CompletableFuture<Tuple> result = this.postTupleLogic(tupleSpaceName, tuple);



        switch (this.code) {
            
            case 400:
                context.result("Some parameter is not well formed");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<Tuple> postTupleLogic(String tupleSpaceName, Tuple tuple); // TODO The method should set the responding status code by calling setCode()
    







}
