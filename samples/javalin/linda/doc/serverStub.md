# Models:

All models are already implemented and you should NOT touch those files.

The model has different structures depending on that if the model is a class or an enumeration.

If the model is an enumeration it contains:
- All its possible values;
- Methods used to obtain the value of a variable of this enumeration and its string representation.

If the model is a class it contains:
- Inner enumeration (with the same structure as specified before) if some variables have enumeration types;
- All variables of the model represented by the "fields" of this class;
- Empty constructor;
- For each variable its setter and getter methods;
- toString, equals and hashCode methods;


# APIs:

Each api generated is an abstract class to be extended that contains base implementation which includes:

1) Registration of all specified routes. The routes will be created for the schemes specified globally.
For *http/https* schemes a route will be created for each path.
For *ws/wss* schemes a single WebSocket route will be created for the path defined by the *tag* value. Each message received (unless changed) MUST begin with the specified path, followed by '>:' that is needed to recognise the request made by the client.
Because WebSocket can communicate only by messages, if some routes need the sending of files that are not plain text, it is provided the receiving of binary messages that must be managed and implemented by the user.

If no GLOBAL scheme was specified the stub will contain ONLY *http* routes and respective methods.

2) For each http/https route a method containing code that extracts data sent by the client. The extracted data include:
- Information needed to authenticate the user for this path;
- Path parameters;
- Query parameters;
- Form parameters;
- Headers of the request;
- Body of the request;
- Call of the associated abstract method (which should contain the behaviour);

At the end for each possible response the stub sets status code and corresponding result, basing on the code that would be set by the user in associated implementation of the abstract method.

3) For each ws/wss route a method containing code that extracts data sent by the client. Till WebSocket interface can send only messages the amount of extracted information is less:
- Message sent;
- Path parameters;
- Query parameter;
- Headers;

At the end the response is sent back to the client.

## TODO:

Each abstract method relative to a path the behaviour that the server must have in response to the request of the client must be implemented.

# Tests:

For each *tag* a test class is generated.
Each class creates a local instance of Javalin server and a client that performs some requests to the server.
It also instantiates the API as anonymous class with empty implementation of each abstract method and registers its routes on server.

For each operation, the class contains a method that defines the parameters for the request without initializing them.
The method also sets the Uri on which the request is performed, adding query and path parameters, serializing them. Then it builds the request depending on the HTTP method.
It sends the request asynchronously to the server. If the response isn't a simple message, after checking the status code, the method deserializes the response into the corresponding class type.

If a WebSocket is provided, it redefines the Uri and then it creates a listener without implementation to handle the messages.
At the end it builds the websocket asynchronously.

There are other private methods to create requests based on the uri field. They allow adding form and body parameters, serializing them.

Serialization and deserialization utility methods use Javalin's json mapper.