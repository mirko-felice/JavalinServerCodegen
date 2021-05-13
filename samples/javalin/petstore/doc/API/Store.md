# Store

All URIs are relative to *http://localhost/v2*

## HTTP Interaction
Operation | HTTP Method | **path** | Description
------------- | ------------- | ------------- | -------------
*deleteOrder* | DELETE | **/store/order/{orderId}** | Delete purchase order by ID
*getInventory* | GET | **/store/inventory** | Returns pet inventories by status
*getOrderById* | GET | **/store/order/{orderId}** | Find purchase order by ID
*placeOrder* | POST | **/store/order** | Place an order for a pet



## **deleteOrder** 

### Summary
Delete purchase order by ID

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | orderId | Long | ID of the order that needs to be deleted | For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **getInventory** 

### Summary
Returns pet inventories by status

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

**Map**

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

## **getOrderById** 

### Summary
Find purchase order by ID

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | orderId | Long | ID of pet that needs to be fetched | For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions

### Return type

[**Order**](../model/Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **placeOrder** 

### Summary
Place an order for a pet

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Body | body | [Order](../model/Order.md) | order placed for purchasing the pet | 

### Return type

[**Order**](../model/Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml



## WS Interaction:

## Path: **/Store**

## deleteOrder 

### Summary
Delete purchase order by ID

### Message
**DELETE/store/order/{orderId}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | orderId | Long | ID of the order that needs to be deleted | For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## getInventory 

### Summary
Returns pet inventories by status

### Message
**GET/store/inventory>:[message]**

### Parameters



### Return type

**Map**

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

## getOrderById 

### Summary
Find purchase order by ID

### Message
**GET/store/order/{orderId}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | orderId | Long | ID of pet that needs to be fetched | For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions

### Return type

[**Order**](../model/Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## placeOrder 

### Summary
Place an order for a pet

### Message
**POST/store/order>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

[**Order**](../model/Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/xml

