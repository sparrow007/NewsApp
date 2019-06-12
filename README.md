# Review Summation Api

All URIs are relative to **SUBMISSION_API_URL** configuration variable.

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchReviewSummations**](ReviewSummationApi.md#searchReviews) | **GET** /reviewsummations | Search review summations..
[**headReviewSummations**](ReviewSummationApi.md#headReviews) | **HEAD** /reviewsummations | Same to search review summations, but only response status and headers information return.
[**createReviewSummation**](ReviewSummationApi.md#createReview) | **POST** /reviewsummations | Create a review summation.
[**getReviewSummation**](ReviewSummationApi.md#getReview) | **GET** /reviewsummations/{reviewSummationId} | Get the review summation.
[**headReviewSummation**](ReviewSummationApi.md#headReview) | **HEAD** /reviewsummations/{reviewSummationId} | Same to get review summation, but only response status and headers information return.
[**updateReviewSummation**](ReviewSummationApi.md#updateReview) | **PUT** /reviewsummations/{reviewSummationId} | Fully update review summation.
[**patchReviewReviewSummation**](ReviewSummationApi.md#patchReview) | **PATCH** /reviewsummations/{reviewSummationId} | Partially update review summation.
[**deleteReviewSummation**](ReviewSummationApi.md#deleteReview) | **DELETE** /reviewsummations/{reviewSummationId} | Delete the review summation.

<a name="searchReviewSummations"></a>
# **searchReviewSummations**
> searchReviewSummations(reqQuery)

Search review summations. Link headers are sent back and they have rel set to prev, next, first, last and contain the relevant URL.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reqQuery = {
  page: 1,
  perPage: 10,
  submissionId": a12a4180-65aa-42ec-a945-5fd21dec1567
}

// Promise model
submissionApiClient
  .searchReviewSummations(reqQuery)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.searchReviewSummations(reqQuery)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqQuery** | [**SearchReviewsCriteria**](SearchReviewsCriteria.md)| the search reviews criteria

### Return type

Array of [**ReviewSummation**](ReviewSummation.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="headReviewSummations"></a>
# **headReviews**
> headReviewSummations(reqQuery)

Same to search reviews, but only response status and headers information return.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reqQuery = {
  page: 1,
  perPage: 10,
  submissionId: a12a4180-65aa-42ec-a945-5fd21dec1567
}

// Promise model
submissionApiClient
  .headReviewSummations(reqQuery)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.headReviewSummations(reqQuery)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqQuery** | [**SearchReviewsCriteria**](SearchReviewsCriteria.md)| the search reviews criteria

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createReviewSummation"></a>
# **createReview**
> createReviewSummation(reqBody)

Create a review.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reqBody = {
   submissionId: a12bc180-43aa-42ec-a945-5fd21dec1567,
   aggregateScore: 97.8,
   scoreCardId: "a12bc180-65aa-42aa-a945-5fd21dec1567,
   isPassing : true,
   metadata: {abc: 'def'}
}

// Promise model
submissionApiClient
  .createReviewSummation(reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.createReviewSummation(reqBody)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqBody** | [**ReviewData**](ReviewData.md)| the review data

### Return type

[**ReviewSummationApi**](ReviewSummationApi.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getReview"></a>
# **getReviewSummation**
> getReviewSummation(reviewSummationId)

Get the review summation by id.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reviewSummationId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .getReviewSummation(reviewSummationId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.getReviewSummation(reviewSummationId)
```
### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reviewSummationId** | String | the review summation id

### Return type

[**ReviewSummationApi**](ReviewSummationApi.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="headReview"></a>
# **headReviewSummation**
> headReviewSummation(reviewSummationId)

Same to get review summation, but only response status and headers information return.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reviewSummationId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .headReviewSummation(reviewSummationId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.headReviewSummation(reviewSummationId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reviewSummationId** | String | the review summation id

### Return type

[**ReviewSummationApi**](ReviewSummationApi.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateReview"></a>
# **updateReviewSummation**
> updateReviewSummation(reviewSummationId, reqBody)

Fully update review summation.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reviewSummationId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const reqBody = {
   submissionId: a12bc180-43aa-42ec-a945-5fd21dec1567,
   aggregateScore: 97.8,
   scoreCardId: "a12bc180-65aa-42aa-a945-5fd21dec1567,
   isPassing : true,
   metadata: {abc: 'def'}
}

// Promise model
submissionApiClient
  .updateReviewSummation(reviewSummationId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.updateReviewSummation(reviewSummationId, reqBody)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reviewSummationId** | String | the review summation id
 **reqBody** | [**ReviewData**](ReviewData.md)| the review summation data

### Return type

[**ReviewSummationApi**](ReviewSummationApi.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="patchReview"></a>
# **patchReviewReviewSummation**
> patchReviewReviewSummation(reviewSummationId, reqBody)

Partially update review summation.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reviewSummationId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const reqBody = {
  submissionId: a12bc180-43aa-42ec-a945-5fd21dec1567,
   aggregateScore: 97.8,
   scoreCardId: "a12bc180-65aa-42aa-a945-5fd21dec1567,
   isPassing : true,
   metadata: {abc: 'def'}
}

// Promise model
submissionApiClient
  .patchReviewReviewSummation(reviewSummationId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.patchReviewReviewSummation(reviewSummationId, reqBody)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reviewSummationId** | String | the review summation id
 **reqBody** | [**ReviewData**](ReviewData.md)| the review summation data

### Return type

[**ReviewSummationApi**](ReviewSummationApi.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteReviewSummation"></a>
# **deleteReviewSummation**
> deleteReviewSummation(reviewSummationId)

Delete review summation by id.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reviewSummationId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .deleteReviewSummation(reviewSummationId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.deleteReviewSummation(reviewSummationId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reviewSummationId** | String | the review summation id

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
