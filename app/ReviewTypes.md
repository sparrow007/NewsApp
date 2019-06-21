# Submissions Api

All URIs are relative to **SUBMISSION_API_URL** configuration variable.

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchSubmissions**](SubmissionsApi.md#searchSubmissions) | **GET** /submissions | Search submissions.
[**headSubmissions**](SubmissionsApi.md#headSubmissions) | **HEAD** /submissions | Same to search submissions, but only response status and headers information return.
[**createSubmission**](SubmissionsApi.md#createSubmission) | **POST** /submissions | Create a submission.
[**getSubmission**](SubmissionsApi.md#getSubmission) | **GET** /submissions/{submissionId} | Get the submission.
[**headSubmission**](SubmissionsApi.md#headSubmission) | **HEAD** /submissions/{submissionId} | Same to get submission, but only response status and headers information return.
[**updateSubmission**](SubmissionsApi.md#updateSubmission) | **PUT** /submissions/{submissionId} | Fully update submission.
[**patchSubmission**](SubmissionsApi.md#patchSubmission) | **PATCH** /submissions/{submissionId} | Partially update submission.
[**deleteSubmission**](SubmissionsApi.md#deleteSubmission) | **DELETE** /submissions/{submissionId} | Delete the submission.
[**downloadSubmission**](SubmissionsApi.md#downloadSubmission) | **GET** /submissions/{submissionId}/download | Download the Submission from S3.
[**createArtifact**](SubmissionsApi.md#createArtifact) | **POST** /submissions/{submissionId}/artifacts | Create artifact for the given submission ID.
[**listArtifacts**](SubmissionsApi.md#listArtifacts) | **GET** /submissions/{submissionId}/artifacts | List artifacts for given Submission ID from S3.
[**downloadArtifact**](SubmissionsApi.md#downloadArtifact) | **GET** /submissions/{submissionId}/artifacts/{file}/download} | Download artifact from S3 using Submission ID and Artifact ID.

<a name="searchSubmissions"></a>
# **searchSubmissions**
> searchSubmissions(reqQuery)

Search searchSubmissions. Link headers are sent back and they have rel set to prev, next, first, last and contain the relevant URL.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reqQuery = {
  page: 1,
  perPage: 3,
  type": 'ContestSubmission',
  url: 'https://software.topcoder.com/review/actions/DownloadContestSubmission?uid=123456',
  memberId: 'b24d4180-65aa-42ec-a945-5fd21dec0501',
  challengeId: 'c3564180-65aa-42ec-a945-5fd21dec0502'
}

// Promise model
submissionApiClient
  .searchSubmissions(reqQuery)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.searchSubmissions(reqQuery)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqQuery** | [**SearchReviewSummationsCriteria**](SearchReviewSummationsCriteria.md) | the search review summations criteria 

### Return type

Array of [**Submissions**](Submissions.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="headSubmissions"></a>

# **headSubmissions**
> headSubmissions(reqQuery)

Same to search submissions, but only response status and headers information return.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reqQuery = {
  page: 1,
  perPage: 3,
  type": 'ContestSubmission',
  url: 'https://software.topcoder.com/review/actions/DownloadContestSubmission?uid=123456',
  memberId: 'b24d4180-65aa-42ec-a945-5fd21dec0501',
  challengeId: 'c3564180-65aa-42ec-a945-5fd21dec0502'
}

// Promise model
submissionApiClient
  .headSubmissions(reqQuery)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// Async / await model
await submissionApiClient.headSubmissions(reqQuery)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqQuery** | [**SearchReviewSummationsCriteria**](SearchReviewSummationsCriteria.md) | the search reviews criteria

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createSubmission"></a>

# **createSubmission**
> createSubmission(reqBody)

Create a submission.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const reqBody = {
  submission: './test/common/fileToUpload.zip',
  challengeId: 'c3564180-65aa-42ec-a945-5fd21dec0502',
  type: 'ContestSubmission',
  memberId: 'b24d4180-65aa-42ec-a945-5fd21dec0501',
  fileType: 'zip',
  submissionPhaseId: 1245
}

// Promise model
submissionApiClient
  .createSubmission(reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.createSubmission(reqBody)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqBody** | [**ReviewSummationData**](ReviewSummationData.md) | the review summation data 

### Return type

[**Submissions**](Submissions.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getSubmission"></a>

# **getSubmission**
> getSubmission(submissionId)

Get the submission by id.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .getSubmission(submissionId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.getSubmission(submissionId)
```
### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id 

### Return type

[**Submissions**](Submissions.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="headSubmission"></a>

# **headSubmission**
> headSubmission(submissionId)

Same to get submission, but only response status and headers information return.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .headSubmission(submissionId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.headSubmission(submissionId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id 

### Return type

[**Submissions**](Submissions.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateSubmission"></a>

# **updateSubmission**
> updateSubmission(submissionId, reqBody)

Fully update review summation.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const reqBody = {
  challengeId: 'c3564180-65aa-42ec-a945-5fd21dec0502',
  type: 'ContestSubmission',
  memberId: 'b24d4180-65aa-42ec-a945-5fd21dec0501',
  url: 'https://software.topcoder.com/review/actions/DownloadContestSubmission?uid=123456'
}

// Promise model
submissionApiClient
  .updateReviewSummation(submissionId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.updateReviewSummation(submissionId, reqBody)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id 
 **reqBody** | [**Submissions**](Submissions.md) | the submission data 

### Return type

[**Submissions**](Submissions.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="patchSubmission"></a>

# **patchSubmission**
> patchSubmission(submissionId, reqBody)

Partially update submission.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const reqBody = {
  challengeId: 30049360,
  memberId: 'b24d4180-65aa-42ec-a945-5fd21dec0501'
}

// Promise model
submissionApiClient
  .patchSubmission(submissionId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.patchSubmission(submissionId, reqBody)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the review summation id 
 **reqBody** | [**ReviewSummationData**](ReviewSummationData.md) | the review summation data 

### Return type

[**Submissions**](Submissions.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteReviewSummation"></a>

# **deleteSubmission**
> deleteSubmission(submissionId)

Delete submission by id.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .deleteSubmission(submissionId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.deleteSubmission(submissionId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id 

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="downloadSubmission"></a>

# **downloadSubmission**
> downloadSubmission(submissionId)

Download the submission from S3 using id.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .downloadSubmission(submissionId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.downloadSubmission(submissionId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id 

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


<a name="createArtifact"></a>

# **createArtifact**
> createArtifact(submissionId, artifact, typeId)

Create artifact in S3.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const artifact = './test/common/fileToUpload.zip'
const typeId = 'c3564180-65aa-42ec-a945-5fd21dec0502'
// Promise model
submissionApiClient
  .createArtifact(submissionId, artifact, typeId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.createArtifact(submissionId, artifact, typeId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id 
 **artifact** | file / form-data / String | Artifact to be uploaded
 **typeId** | String | 

### Return type

null (empty response body) //artifact response

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listArtifacts"></a>

# **listArtifacts**
> listArtifacts(submissionId)

List artifacts for given Submission ID from S3.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
submissionApiClient
  .createArtifact(submissionId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.createArtifact(submissionId)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id  

### Return type

null (empty response body) //array artifact response

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
 
 # **downloadArtifact**
> downloadArtifact(submissionId, file)

Download artifact from S3 using Submission ID and Artifact ID.

### Example
```javascript
const submissionApi = require('tc-submission-api-wrapper')
const submissionApiClient = submissionApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const submissionId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const file = '6da98d0f-e663-4539-8507-cd6c9e0e56d8.zip'
// Promise model
submissionApiClient
  .createArtifact(submissionId, artifactId)
  .then(result => console.log(result.status))
  .catch(err => console.log(err))

// async / await model
await submissionApiClient.createArtifact(submissionId, file)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **submissionId** | String | the submission id  
 **file** | String | the artifact id 

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
