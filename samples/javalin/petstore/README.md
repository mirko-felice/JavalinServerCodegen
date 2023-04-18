# 

Swagger Petstore
- API version: 1.0.5

This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.

*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*

## Requirements

Building the server API stub requires:
1. Java 11+
2. Gradle

## Getting Started

To start the server run the main file located in main folder which will start the javalin server on localhost

## Documentation for API


*Pet* -> [doc/API/Pet.md](./doc/API/Pet.md) 

*Store* -> [doc/API/Store.md](./doc/API/Store.md) 

*User* -> [doc/API/User.md](./doc/API/User.md) 


## Documentation for Model

*ApiResponse* -> [doc/model/ApiResponse.md](./doc/model/ApiResponse.md)

*Category* -> [doc/model/Category.md](./doc/model/Category.md)

*Order* -> [doc/model/Order.md](./doc/model/Order.md)

*Pet* -> [doc/model/Pet.md](./doc/model/Pet.md)

*Tag* -> [doc/model/Tag.md](./doc/model/Tag.md)

*User* -> [doc/model/User.md](./doc/model/User.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### api_key

- **Type**: API key
- **API key parameter name**: api_key
- **Location**: HTTP header

### petstore_auth

- **Type**: OAuth
- **Flow**: implicit
- **Authorization URL**: https://petstore.swagger.io/oauth/authorize
- **Scopes**: 
  - read:pets: read your pets
  - write:pets: modify pets in your account


## Documentation for Server Stub

[Server Stub Documentation](./doc/ServerStub.md)

## Author

apiteam@swagger.io