# Pet

All URIs are relative to *http://localhost/v2*

## HTTP Interaction
Operation | HTTP Method | **path** | Description
------------- | ------------- | ------------- | -------------
*addPet* | POST | **/pet** | Add a new pet to the store
*deletePet* | DELETE | **/pet/{petId}** | Deletes a pet
*findPetsByStatus* | GET | **/pet/findByStatus** | Finds Pets by status
*findPetsByTags* | GET | **/pet/findByTags** | Finds Pets by tags
*getPetById* | GET | **/pet/{petId}** | Find pet by ID
*updatePet* | PUT | **/pet** | Update an existing pet
*updatePetWithForm* | POST | **/pet/{petId}** | Updates a pet in the store with form data
*uploadFile* | POST | **/pet/{petId}/uploadImage** | uploads an image



## **addPet** 

### Summary
Add a new pet to the store

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Body | body | [Pet](../model/Pet.md) | Pet object that needs to be added to the store | 

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: application/json, application/xml
- **Accept**: application/json, application/xml

## **deletePet** 

### Summary
Deletes a pet

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | Pet id to delete | 

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **findPetsByStatus** 

### Summary
Finds Pets by status

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | status | List\<[String](../model/List.md)> | Status values that need to be considered for filter | Multiple status values can be provided with comma separated strings

### Return type

List<[**Pet**](../model/Pet.md)>

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **findPetsByTags**  (Deprecated) 

### Summary
Finds Pets by tags

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | tags | List\<[String](../model/List.md)> | Tags to filter by | Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Return type

List<[**Pet**](../model/Pet.md)>

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **getPetById** 

### Summary
Find pet by ID

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | ID of pet to return | Returns a single pet

### Return type

[**Pet**](../model/Pet.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## **updatePet** 

### Summary
Update an existing pet

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Body | body | [Pet](../model/Pet.md) | Pet object that needs to be added to the store | 

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: application/json, application/xml
- **Accept**: application/json, application/xml

## **updatePetWithForm** 

### Summary
Updates a pet in the store with form data

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | ID of pet that needs to be updated | 
Form | name | String | Updated name of the pet | 
Form | status | String | Updated status of the pet | 

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded
- **Accept**: application/json, application/xml

## **uploadFile** 

### Summary
uploads an image

### Parameters

Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | ID of pet to update | 
Form | additionalMetadata | String | Additional data to pass to server | 
Form | file | [File](../model/File.md) | file to upload | 

### Return type

[**ApiResponse**](../model/ApiResponse.md)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json



## WS Interaction:

## Path: **/Pet**

## addPet 

### Summary
Add a new pet to the store

### Message
**POST/pet>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: application/json, application/xml
- **Accept**: application/json, application/xml

## deletePet 

### Summary
Deletes a pet

### Message
**DELETE/pet/{petId}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | Pet id to delete | 

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## findPetsByStatus 

### Summary
Finds Pets by status

### Message
**GET/pet/findByStatus>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | status | List\<[String](../model/List.md)> | Status values that need to be considered for filter | Multiple status values can be provided with comma separated strings

### Return type

List<[**Pet**](../model/Pet.md)>

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## findPetsByTags  (Deprecated) 

### Summary
Finds Pets by tags

### Message
**GET/pet/findByTags>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Query | tags | List\<[String](../model/List.md)> | Tags to filter by | Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Return type

List<[**Pet**](../model/Pet.md)>

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## getPetById 

### Summary
Find pet by ID

### Message
**GET/pet/{petId}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | ID of pet to return | Returns a single pet

### Return type

[**Pet**](../model/Pet.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml

## updatePet 

### Summary
Update an existing pet

### Message
**PUT/pet>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: application/json, application/xml
- **Accept**: application/json, application/xml

## updatePetWithForm 

### Summary
Updates a pet in the store with form data

### Message
**POST/pet/{petId}>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | ID of pet that needs to be updated | 

### Return type

null (empty response body)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded
- **Accept**: application/json, application/xml

## uploadFile 

### Summary
uploads an image

### Message
**POST/pet/{petId}/uploadImage>:[message]**

### Parameters


Param type | Name | Type | Description | Notes
------------- | ------------- | ------------- | ------------- | -------------
Path | petId | Long | ID of pet to update | 

### Return type

[**ApiResponse**](../model/ApiResponse.md)

### Authorization

[petstore_auth](../../README.md#petstore_auth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

