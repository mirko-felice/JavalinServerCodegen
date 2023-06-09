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

import io.javalin.Javalin;
import api.TupleSpacesAPI;

public class Main {
    public static void main(String[] args) {
        String host = "localhost:8080".split(":")[0];
        int port = 7000;
        if ("localhost:8080".contains(":"))
            port = Integer.parseInt("localhost:8080".split(":")[1]);
        Javalin server = Javalin.create().start(host, port);

        TupleSpacesAPI tupleSpacesAPI; // TODO Instantiate class that extends TupleSpacesAPI like 'new TupleSpacesAPIImpl("/linda/v2")'

//        tupleSpacesAPI.registerRoutes(server);

        
    }
}
