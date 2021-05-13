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

import model.Pet.StatusEnum;
import utils.Utilities;
import io.javalin.http.UnauthorizedResponse;

public class PetAPI {

    private final String basePath;

    public PetAPI(final String basePath) {
        this.basePath = Objects.requireNonNull(basePath);
    }

    public void registerRoutes(Javalin server) {
        server.post(this.basePath + "/pet".replace("{",":").replace("}",""), this::addPet);
        server.delete(this.basePath + "/pet/{petId}".replace("{",":").replace("}",""), this::deletePet);
        server.get(this.basePath + "/pet/findByStatus".replace("{",":").replace("}",""), this::findPetsByStatus);
        server.get(this.basePath + "/pet/findByTags".replace("{",":").replace("}",""), this::findPetsByTags); // TODO endpoint should be deleted.
        server.get(this.basePath + "/pet/{petId}".replace("{",":").replace("}",""), this::getPetById);
        server.put(this.basePath + "/pet".replace("{",":").replace("}",""), this::updatePet);
        server.post(this.basePath + "/pet/{petId}".replace("{",":").replace("}",""), this::updatePetWithForm);
        server.post(this.basePath + "/pet/{petId}/uploadImage".replace("{",":").replace("}",""), this::uploadFile);
        server.ws(this.basePath + "/Pet", ws -> {
            ws.onConnect(ctx -> System.out.println("Connected"));
            ws.onMessage(msgContext -> {
                String request = msgContext.message().split(">:")[0];
                switch (request){ 
                    case "POST/pet": addPet(msgContext);
                        break;    
                    case "DELETE/pet/{petId}": deletePet(msgContext);
                        break;    
                    case "GET/pet/findByStatus": findPetsByStatus(msgContext);
                        break;    
                    case "GET/pet/findByTags": findPetsByTags(msgContext);
                        break;    
                    case "GET/pet/{petId}": getPetById(msgContext);
                        break;    
                    case "PUT/pet": updatePet(msgContext);
                        break;    
                    case "POST/pet/{petId}": updatePetWithForm(msgContext);
                        break;    
                    case "POST/pet/{petId}/uploadImage": uploadFile(msgContext);
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
    * Add a new pet to the store
    *
    * 
    * 
    */
    public void addPet(Context context) {
        int code = 200;
        
        // Check request content type
        String contentType = context.contentType();
        if (contentType == null || !contentType.contains("application/json") || !contentType.contains("application/xml"))
            throw new BadRequestResponse();

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        
        
        
        
        // Body
        Pet body = context.bodyValidator(Pet.class).get();
        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");


        switch (code) {
            case 405:
                context.result("Invalid input");
                context.status(405);
                break;
            default: 
        }
    }

    /**
    * Deletes a pet
    *
    * 
    * 
    * PathParams:
    * petId: Pet id to delete
    * 
    * HeaderParams:
    * api_key: 
    * 
    */
    public void deletePet(Context context) {
        int code = 200;
        
        

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        
        // Headers
        String api_key = context.header("api_key", String.class).getOrNull();

        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");


        switch (code) {
            case 400:
                context.result("Invalid ID supplied");
                context.status(400);
                break;
            case 404:
                context.result("Pet not found");
                context.status(404);
                break;
            default: 
        }
    }

    /**
    * Finds Pets by status
    *
    * Multiple status values can be provided with comma separated strings
    * 
    * QueryParams:
    * status: Status values that need to be considered for filter
    * 
    */
    public void findPetsByStatus(Context context) {
        int code = 200;
        
        

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        
        // Query params
        List<String> status = context.queryParams("status");
        List<StatusEnum> statusenumlist = new ArrayList<>();
        for (String value : status)
            statusenumlist.add(StatusEnum.fromValue(value));
        

        
        
        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");
        CompletableFuture<List<Pet>> result = new CompletableFuture<>();
        

        switch (code) {
            
            case 400:
                context.result("Invalid status value");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeMany));
        }
    }

    /**
    * Finds Pets by tags
    *
    * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    * 
    * QueryParams:
    * tags: Tags to filter by
    * 
    */
    @Deprecated
    public void findPetsByTags(Context context) {
        int code = 200;
        
        

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        
        // Query params
        List<String> tags = context.queryParams("tags");
        

        
        
        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");
        CompletableFuture<List<Pet>> result = new CompletableFuture<>();
        

        switch (code) {
            
            case 400:
                context.result("Invalid tag value");
                context.status(400);
                break;
            default: context.result(result.thenApply(Utilities::serializeMany));
        }
    }

    /**
    * Find pet by ID
    *
    * Returns a single pet
    * 
    * PathParams:
    * petId: ID of pet to return
    * 
    */
    public void getPetById(Context context) {
        int code = 200;
        
        

        // Authentication
        if (!context.headerMap().containsKey("api_key"))
            throw new UnauthorizedResponse();
        

        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        
        
        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");
        CompletableFuture<Pet> result = new CompletableFuture<>();
        

        switch (code) {
            
            case 400:
                context.result("Invalid ID supplied");
                context.status(400);
                break;
            case 404:
                context.result("Pet not found");
                context.status(404);
                break;
            default: context.result(result.thenApply(Utilities::serializeOne));
        }
    }

    /**
    * Update an existing pet
    *
    * 
    * 
    */
    public void updatePet(Context context) {
        int code = 200;
        
        // Check request content type
        String contentType = context.contentType();
        if (contentType == null || !contentType.contains("application/json") || !contentType.contains("application/xml"))
            throw new BadRequestResponse();

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        
        
        
        
        // Body
        Pet body = context.bodyValidator(Pet.class).get();
        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");


        switch (code) {
            case 400:
                context.result("Invalid ID supplied");
                context.status(400);
                break;
            case 404:
                context.result("Pet not found");
                context.status(404);
                break;
            case 405:
                context.result("Validation exception");
                context.status(405);
                break;
            default: 
        }
    }

    /**
    * Updates a pet in the store with form data
    *
    * 
    * 
    * PathParams:
    * petId: ID of pet that needs to be updated
    * 
    * 
    * FormParams:
    * name: Updated name of the pet
    * status: Updated status of the pet
    * 
    */
    public void updatePetWithForm(Context context) {
        int code = 200;
        
        // Check request content type
        String contentType = context.contentType();
        if (contentType == null || !contentType.contains("application/x-www-form-urlencoded"))
            throw new BadRequestResponse();

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        // Form params
        String name = context.formParam("name", String.class).getOrNull();
        
        String status = context.formParam("status", String.class).getOrNull();
        
        
        

        //TODO Implement Behaviour

        context.contentType("application/json; application/xml");


        switch (code) {
            case 405:
                context.result("Invalid input");
                context.status(405);
                break;
            default: 
        }
    }

    /**
    * uploads an image
    *
    * 
    * 
    * PathParams:
    * petId: ID of pet to update
    * 
    * 
    * FormParams:
    * additionalMetadata: Additional data to pass to server
    * file: file to upload
    * 
    */
    public void uploadFile(Context context) {
        int code = 200;
        final String filePath = ""; // TODO set uploadFilePath
        // Check request content type
        String contentType = context.contentType();
        if (contentType == null || !contentType.contains("multipart/form-data"))
            throw new BadRequestResponse();

        // Authentication
        
        final String flow = "implicit";
        final String authorizationURL = "https://petstore.swagger.io/oauth/authorize";
        final List<Map<String,String>> scopes = new ArrayList<>();
        Map<String, String> scope;
        scope = new HashMap<>();
        scope.put("write:pets", "modify pets in your account");
        scopes.add(scope);
        scope = new HashMap<>();
        scope.put("read:pets", "read your pets");
        scopes.add(scope);
        

        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        // Form params
        String additionalMetadata = context.formParam("additionalMetadata", String.class).getOrNull();
        UploadedFile file = context.uploadedFile("file");
        if (file != null)
            FileUtil.streamToFile(file.getContent(), filePath + file.getFilename());

        
        

        //TODO Implement Behaviour

        context.contentType("application/json");
        CompletableFuture<ApiResponse> result = new CompletableFuture<>();
        

        switch (code) {
            
            default: context.result(result.thenApply(Utilities::serializeOne));
        }
    }
    
    /**
    * Add a new pet to the store
    *
    * 
    * 
    */
    public void addPet(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        
        
        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * Deletes a pet
    *
    * 
    * 
    * PathParams:
    * petId: Pet id to delete
    * 
    * HeaderParams:
    * api_key: 
    * 
    */
    public void deletePet(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        // Headers
        String api_key = context.header("api_key");

        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * Finds Pets by status
    *
    * Multiple status values can be provided with comma separated strings
    * 
    * QueryParams:
    * status: Status values that need to be considered for filter
    * 
    */
    public void findPetsByStatus(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        
        // Query params
        List<String> status = context.queryParams("status");
        List<StatusEnum> statusenumlist = new ArrayList<>();
        for (String value : status)
        statusenumlist.add(StatusEnum.fromValue(value));
        

        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * Finds Pets by tags
    *
    * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    * 
    * QueryParams:
    * tags: Tags to filter by
    * 
    */
    @Deprecated
    public void findPetsByTags(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        
        // Query params
        List<String> tags = context.queryParams("tags");
        

        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * Find pet by ID
    *
    * Returns a single pet
    * 
    * PathParams:
    * petId: ID of pet to return
    * 
    */
    public void getPetById(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * Update an existing pet
    *
    * 
    * 
    */
    public void updatePet(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        
        
        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * Updates a pet in the store with form data
    *
    * 
    * 
    * PathParams:
    * petId: ID of pet that needs to be updated
    * 
    */
    public void updatePetWithForm(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }

    /**
    * uploads an image
    *
    * 
    * 
    * PathParams:
    * petId: ID of pet to update
    * 
    */
    public void uploadFile(WsMessageContext context) {

        String message = context.message();
        String request = message.split(">:")[0];
        String requestMessage = "";
        String[] parts = message.split(">:");
        for (String el : parts)
            requestMessage = requestMessage.concat(el);
        String response = "";
        // Path params
        Long petId = context.pathParam("petId", Long.class).get();

        
        
        //TODO Implement Behaviour


        //Response
        context.send(response);
    }
}
