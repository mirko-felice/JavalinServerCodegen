# User

All URIs are relative to *http://localhost/v2*

## HTTP Interaction
Operation | HTTP Method | **path** | Description
------------- | ------------- | ------------- | -------------
*createUser* | POST | **/user** | Create user
*createUsersWithArrayInput* | POST | **/user/createWithArray** | Creates list of users with given input array
*createUsersWithListInput* | POST | **/user/createWithList** | Creates list of users with given input array
*deleteUser* | DELETE | **/user/{username}** | Delete user
*getUserByName* | GET | **/user/{username}** | Get user by user name
*loginUser* | GET | **/user/login** | Logs user into the system
*logoutUser* | GET | **/user/logout** | Logs out current logged in user session
*updateUser* | PUT | **/user/{username}** | Updated user



## **createUser** 

### Summary
Create user

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Body | body | [User](../model/User.md) | Created user object | This can only be done by the logged in user.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

## **createUsersWithArrayInput** 

### Summary
Creates list of users with given input array

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Body | body | List\<[User](../model/List.md)> | List of user object | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

## **createUsersWithListInput** 

### Summary
Creates list of users with given input array

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Body | body | List\<[User](../model/List.md)> | List of user object | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

## **deleteUser** 

### Summary
Delete user

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | username | String | The name that needs to be deleted | This can only be done by the logged in user.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **getUserByName** 

### Summary
Get user by user name

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | username | String | The name that needs to be fetched. Use user1 for testing.  | 

### Return type

[**User**](../model/User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **loginUser** 

### Summary
Logs user into the system

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | username | String | The user name for login | 
Query | password | String | The password for login in clear text | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **logoutUser** 

### Summary
Logs out current logged in user session

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **updateUser** 

### Summary
Updated user

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | username | String | name that need to be updated | This can only be done by the logged in user.
Body | body | [User](../model/User.md) | Updated user object | This can only be done by the logged in user.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml



## WS Interaction:

## Path: **/User**

## createUser 

### Summary
Create user

### Message
**POST/user>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

## createUsersWithArrayInput 

### Summary
Creates list of users with given input array

### Message
**POST/user/createWithArray>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

## createUsersWithListInput 

### Summary
Creates list of users with given input array

### Message
**POST/user/createWithList>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

## deleteUser 

### Summary
Delete user

### Message
**DELETE/user/{username}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | username | String | The name that needs to be deleted | This can only be done by the logged in user.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## getUserByName 

### Summary
Get user by user name

### Message
**GET/user/{username}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | username | String | The name that needs to be fetched. Use user1 for testing.  | 

### Return type

[**User**](../model/User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## loginUser 

### Summary
Logs user into the system

### Message
**GET/user/login>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | username | String | The user name for login | 
Query | password | String | The password for login in clear text | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## logoutUser 

### Summary
Logs out current logged in user session

### Message
**GET/user/logout>:[message]**

### Parameters



### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## updateUser 

### Summary
Updated user

### Message
**PUT/user/{username}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | username | String | name that need to be updated | This can only be done by the logged in user.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

