# TupleSpaces

All URIs are relative to *https://localhost:8080/linda/v2*

## HTTP Interaction
Operation | HTTP Method | **path** | Description
------------- | ------------- | ------------- | -------------
*deleteTuple* | DELETE | **/tuple-spaces/{tupleSpaceName}** | Consumes tuples from the tuple space
*getTuple* | GET | **/tuple-spaces/{tupleSpaceName}** | Get or count tuples from the tuple space
*getTupleSpaces* | GET | **/tuple-spaces** | Get the names of all the currently instantiated tuple spaces
*postTuple* | POST | **/tuple-spaces/{tupleSpaceName}** | Insert a tuple into the tuple space



## **deleteTuple** 

### Summary
Consumes tuples from the tuple space

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | tupleSpaceName | String | The name of the textual space upon which the method will operate | Performs an &#x60;in&#x60; operation over the template provided within URL query
Query | template | String | [URL-encoded](https://en.wikipedia.org/wiki/Percent-encoding) regex template  | Performs an &#x60;in&#x60; operation over the template provided within URL query

### Return type

[**Tuple**](../model/Tuple.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

## **getTuple** 

### Summary
Get or count tuples from the tuple space

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | tupleSpaceName | String | The name of the textual space upon which the method will operate | Get or count tuples from the tuple space. The actual behaviour depends on the provided paramenters: - the presence of the &#x60;count&#x60; parameter makes this method behave as the &#x60;count&#x60; primitive, assuming the value of the parameter is &#x60;true&#x60; - if the &#x60;count&#x60; parameter is absent or &#x60;false&#x60;, the presence of the &#x60;template&#x60; parameter makes this method behave as the &#x60;rd&#x60; primitive - if the &#x60;count&#x60; parameter is absent or &#x60;false&#x60;, and the &#x60;template&#x60; parameter is absent, then this method behave as the &#x60;get&#x60; primitive  Notice that in case of &#x60;rd&#x60;-like behaviour, the operation is suspensive, meaning that the reponse from the server will be produced only after one tuple matching the behaviour is available on the tuple space. In any other case, the server response will be produced ASAP 
Query | count | Boolean | States whether this method should behave as the `count` primitive or not | Get or count tuples from the tuple space. The actual behaviour depends on the provided paramenters: - the presence of the &#x60;count&#x60; parameter makes this method behave as the &#x60;count&#x60; primitive, assuming the value of the parameter is &#x60;true&#x60; - if the &#x60;count&#x60; parameter is absent or &#x60;false&#x60;, the presence of the &#x60;template&#x60; parameter makes this method behave as the &#x60;rd&#x60; primitive - if the &#x60;count&#x60; parameter is absent or &#x60;false&#x60;, and the &#x60;template&#x60; parameter is absent, then this method behave as the &#x60;get&#x60; primitive  Notice that in case of &#x60;rd&#x60;-like behaviour, the operation is suspensive, meaning that the reponse from the server will be produced only after one tuple matching the behaviour is available on the tuple space. In any other case, the server response will be produced ASAP 
Query | template | String | States whether this method should behave as the `rd` primitive (if present) or not, and, in that case it carries an [URL-encoded](https://en.wikipedia.org/wiki/Percent-encoding) JSON object wrapping a regex template | Get or count tuples from the tuple space. The actual behaviour depends on the provided paramenters: - the presence of the &#x60;count&#x60; parameter makes this method behave as the &#x60;count&#x60; primitive, assuming the value of the parameter is &#x60;true&#x60; - if the &#x60;count&#x60; parameter is absent or &#x60;false&#x60;, the presence of the &#x60;template&#x60; parameter makes this method behave as the &#x60;rd&#x60; primitive - if the &#x60;count&#x60; parameter is absent or &#x60;false&#x60;, and the &#x60;template&#x60; parameter is absent, then this method behave as the &#x60;get&#x60; primitive  Notice that in case of &#x60;rd&#x60;-like behaviour, the operation is suspensive, meaning that the reponse from the server will be produced only after one tuple matching the behaviour is available on the tuple space. In any other case, the server response will be produced ASAP 

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

## **getTupleSpaces** 

### Summary
Get the names of all the currently instantiated tuple spaces

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | skip | Integer | Optional parameter stating the amount of sub-resources to be skipped in a bulk query. Defaults to 0 | Retrieve all the names to all tuple spaces 
Query | limit | Integer | Optional parameter stating the maximum amount of sub-resources to be returned by a bulk query. Defaults to 10 | Retrieve all the names to all tuple spaces 
Query | filter | String | Optional parameter constraining the bulk query to return only those sub-resources whose representation contains this value. Defaults to the empty string | Retrieve all the names to all tuple spaces 

### Return type

[**ListOfNames**](../model/ListOfNames.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

## **postTuple** 

### Summary
Insert a tuple into the tuple space

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | tupleSpaceName | String | The name of the textual space upon which the method will operate | Performs an &#x60;out&#x60; operation over the tuple provided within the request body
Body | tuple | [Tuple](../model/Tuple.md) |  | Performs an &#x60;out&#x60; operation over the tuple provided within the request body

### Return type

[**Tuple**](../model/Tuple.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json



