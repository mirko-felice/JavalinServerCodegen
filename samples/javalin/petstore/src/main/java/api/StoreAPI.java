/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.5
 * Contact: apiteam@swagger.io
 *
 * License: Apache 2.0 http://www.apache.org/licenses/LICENSE-2.0.html
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
import java.util.Map;
import java.util.Objects;
import model.Order;
import io.javalin.websocket.WsMessageContext;

import utils.Utilities;
import io.javalin.http.UnauthorizedResponse;

public abstract class StoreAPI {

    private final String basePath;
    private int code = 200;

    public StoreAPI(final String basePath) {
        this.basePath = Objects.requireNonNull(basePath);
    }

    protected final void setCode(final int code) {
        this.code = code;
    }

    public void registerRoutes(Javalin server) {
        server.delete(this.basePath + "/store/order/{orderId}".replace("{",":").replace("}",""), this::deleteOrder);
        server.get(this.basePath + "/store/inventory".replace("{",":").replace("}",""), this::getInventory);
        server.get(this.basePath + "/store/order/{orderId}".replace("{",":").replace("}",""), this::getOrderById);
        server.post(this.basePath + "/store/order".replace("{",":").replace("}",""), this::placeOrder);
        server.ws(this.basePath + "/Store", ws -> {
            ws.onConnect(ctx -> System.out.println("Connected"));
            ws.onMessage(msgContext -> {
                String request = msgContext.message().split(">:")[0];
                switch (request){ 
                    case "DELETE/store/order/{orderId}": deleteOrder(msgContext);
                        break;    
                    case "GET/store/inventory": getInventory(msgContext);
                        break;    
                    case "GET/store/order/{orderId}": getOrderById(msgContext);
                        break;    
                    case "POST/store/order": placeOrder(msgContext);
                        break;
                }
            });
            ws.onBinaryMessage(msgContext -> {
               byte[] data = msgContext.data();
               //TODO manage binary data
            });
            ws.onClose(ctx -> System.out.println("Connection Closed"));
            ws.onError(ctx -> System.out.println("Error occurred"));
        });
    }
    
    /**
    * Delete purchase order by ID
    *
    * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
    * 
    * PathParams:
    * orderId: ID of the order that needs to be deleted
    * 
    */
    public final void deleteOrder(Context context) {
        
        

        
        // Path params
        Long orderId = context.pathParam("orderId", Long.class).check(i -> i >= 1).get();

        
        
        
        

        context.contentType("application/json; application/xml");
        
        this.deleteOrderLogic(orderId);
        

        switch (this.code) {
            case 400:
                context.result("Invalid ID supplied");
                context.status(400);
                break;
            case 404:
                context.result("Order not found");
                context.status(404);
                break;
            default: 
        }

        this.code = 200;
    }

    public abstract void deleteOrderLogic(Long orderId); // TODO The method should set the responding status code by calling setCode()

    /**
    * Returns pet inventories by status
    *
    * Returns a map of status codes to quantities
    * 
    */
    public final void getInventory(Context context) {
        
        

        // Authentication
        if (!context.headerMap().containsKey("api_key"))
            throw new UnauthorizedResponse();
        

        
        
        
        
        

        context.contentType("application/json");
        
        CompletableFuture<Map<String, Integer>> result = this.getInventoryLogic();



        switch (this.code) {
            
            default: context.result(result.thenApply(Utilities::serializeMap));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<Map<String, Integer>> getInventoryLogic(); // TODO The method should set the responding status code by calling setCode()

    /**
    * Find purchase order by ID
    *
    * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions
    * 
    * PathParams:
    * orderId: ID of pet that needs to be fetched
    * 
    */
    public final void getOrderById(Context context) {
        
        

        
        // Path params
        Long orderId = context.pathParam("orderId", Long.class).check(i -> i >= 1).check(i -> i <= 10).get();

        
        
        
        

        context.contentType("application/json; application/xml");
        
        CompletableFuture<Order> result = this.getOrderByIdLogic(orderId);



        switch (this.code) {
            
            case 400:
                context.result("Invalid ID supplied");
                context.status(400);
                break;
            case 404:
                context.result("Order not found");
                context.status(404);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<Order> getOrderByIdLogic(Long orderId); // TODO The method should set the responding status code by calling setCode()

    /**
    * Place an order for a pet
    *
    * 
    * 
    */
    public final void placeOrder(Context context) {
        
        // Check request content type
        String contentType = context.contentType();
        if (contentType == null || !contentType.contains("application/json"))
            throw new BadRequestResponse();

        
        
        
        
        
        // Body
        Order body = context.bodyValidator(Order.class).get();
        

        context.contentType("application/json; application/xml");
        
        CompletableFuture<Order> result = this.placeOrderLogic(body);



        switch (this.code) {
            
            case 400:
                context.result("Invalid Order");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }

        this.code = 200;
    }

    public abstract CompletableFuture<Order> placeOrderLogic(Order body); // TODO The method should set the responding status code by calling setCode()
    
    /**
    * Delete purchase order by ID
    *
    * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
    * 
    * PathParams:
    * orderId: ID of the order that needs to be deleted
    * 
    */
    public final void deleteOrder(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = message.split(">:", 2)[1];
        // Path params
        Long orderId = context.pathParam("orderId", Long.class).check(i -> i >= 1).get();

        
        
        //Response
        context.send(this.deleteOrderWsLogic(requestMessage, orderId));
    }

    public abstract String deleteOrderWsLogic(String requestMessage, Long orderId);

    /**
    * Returns pet inventories by status
    *
    * Returns a map of status codes to quantities
    * 
    */
    public final void getInventory(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = message.split(">:", 2)[1];
        
        
        
        //Response
        context.send(this.getInventoryWsLogic(requestMessage));
    }

    public abstract String getInventoryWsLogic(String requestMessage);

    /**
    * Find purchase order by ID
    *
    * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions
    * 
    * PathParams:
    * orderId: ID of pet that needs to be fetched
    * 
    */
    public final void getOrderById(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = message.split(">:", 2)[1];
        // Path params
        Long orderId = context.pathParam("orderId", Long.class).check(i -> i >= 1).check(i -> i <= 10).get();

        
        
        //Response
        context.send(this.getOrderByIdWsLogic(requestMessage, orderId));
    }

    public abstract String getOrderByIdWsLogic(String requestMessage, Long orderId);

    /**
    * Place an order for a pet
    *
    * 
    * 
    */
    public final void placeOrder(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = message.split(">:", 2)[1];
        
        
        
        //Response
        context.send(this.placeOrderWsLogic(requestMessage));
    }

    public abstract String placeOrderWsLogic(String requestMessage);
}
