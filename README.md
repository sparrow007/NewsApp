# ChallengePhases Api

All URIs are relative to **CHALLENGE_API_URL** configuration variable.

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchChallengePhases**](ChallengeTypesApi.md#searchchallengetypes) | **GET** /challengephases | Search challengeTypes.
[**createChallengePhase**](ChallengeTypesApi.md#createchallengetype) | **POST** /challengephases | Create a challengeType.
[**getChallengePhase**](ChallengeTypesApi.md#getchallengetype) | **GET** /challengephases/:challengePhaseId | Get the challengeType.
[**updateChallengePhase**](ChallengeTypesApi.md#updatechallengetype) | **PUT** /challengephases/:challengePhaseId | Fully update challengeType.
[**patchChallengePhase**](ChallengeTypesApi.md#patchchallengetype) | **PATCH** /challengephases/:challengePhaseId | Partially update challengeType.
[**deleteChallengePhase**](ChallengeTypesApi.md#patchchallengetype) | **DELETE** /challengephases/:challengePhaseId | Delete the Challenge phase with provided challenge phase id.

<a name="searchChallengeTypes"></a>
# **searchChallengePhases**
> searchChallengePhases(reqQuery[, jwt])

Search challengePhase. Link headers are sent back and they have rel set to prev, next, first, last and contain the relevant URL.

### Example
```javascript
const challengeApi = require('topcoder-challenge-api-wrapper')
const challengeApiM2MClient = challengeApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'CHALLENGE_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const challengeApiUserCredentialsClient = challengeApi(_.pick(config,
      ['USERNAME', 'PASSWORD', 'TC_AUTHN_URL', 'TC_AUTHZ_URL', 'TC_CLIENT_ID',
       'TC_CLIENT_V2CONNECTION', 'CHALLENGE_API_URL']))

const challengeApiJwtMethodArgClient = challengeApi(_.pick(config,
      ['CHALLENGE_API_URL']))

const reqQuery = {
  page: 1,
  perPage: 10,
  name: 'test111'
}


// Promise model
challengeApiM2MClient
  .searchChallengePhases(reqQuery)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiUserCredentialsClient
  .searchChallengePhases(reqQuery)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))


challengeApiJwtMethodArgClient
  .searchChallengePhases(reqQuery, config.JWT)
// or
// challengeApiJwtMethodArgClient
//   .searchChallengeTypes(reqQuery)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await challengeApiM2MClient.searchChallengePhases(reqQuery)

await challengeApiUserCredentialsClient.searchChallengePhases(reqQuery)

await challengeApiJwtMethodArgClient.searchChallengePhases(reqQuery, config.JWT)
// or
// await challengeApiJwtMethodArgClient.searchChallengePhases(reqQuery)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqQuery** | [**SearchChallengePhasesCriteria**](SearchChallengePhasesCriteria.md)| the search challengePhases criteria
 **jwt**      | String | the optional json web token

### Return type

Array of [**ChallengePhase**](ChallengePhase.md)

### Authorization

**None**

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createChallengePhase"></a>
# **createChallengePhase**
> createChallengePhase(reqBody[, jwt])

Create a new challenge phase in the system. Only admins can access this endpoint.

### Example
```javascript
const challengeApi = require('topcoder-challenge-api-wrapper')
const challengeApiM2MClient = challengeApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'CHALLENGE_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const challengeApiUserCredentialsClient = challengeApi(_.pick(config,
      ['USERNAME', 'PASSWORD', 'TC_AUTHN_URL', 'TC_AUTHZ_URL', 'TC_CLIENT_ID',
       'TC_CLIENT_V2CONNECTION', 'CHALLENGE_API_URL']))

const challengeApiJwtMethodArgClient = challengeApi(_.pick(config, 'CHALLENGE_API_URL'))

const reqBody = {
  name: 'Code',
  description: 'Code',
  predecessor: 'code-string'
  isActive: true,
  duration: 15
}


// Promise model
challengeApiM2MClient
  .createChallengePhase(reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiUserCredentialsClient
  .createChallengePhase(reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiJwtMethodArgClient
  .createChallengePhase(reqBody, config.JWT)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await challengeApiM2MClient.createChallengePhase(reqBody)

await challengeApiUserCredentialsClient.createChallengePhase(reqBody)

await challengeApiJwtMethodArgClient.createChallengePhase(reqBody, config.JWT)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **reqBody** | [**ChallengePhaseData**](ChallengePhaseData.md)| the challengeType data
 **jwt**      | String | the optional json web token

### Return type

[**ChallengePhase**](ChallengePhase.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getChallengePhase"></a>
# **getChallengePhase**
> getChallengePhase(challengePhaseId[, jwt])

Get the challengePhase by id.

### Example
```javascript
const challengeApi = require('topcoder-challenge-api-wrapper')
const challengeApiM2MClient = challengeApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'CHALLENGE_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const challengeApiUserCredentialsClient = challengeApi(_.pick(config,
      ['USERNAME', 'PASSWORD', 'TC_AUTHN_URL', 'TC_AUTHZ_URL', 'TC_CLIENT_ID',
       'TC_CLIENT_V2CONNECTION', 'CHALLENGE_API_URL']))

const challengeApiJwtMethodArgClient = challengeApi(_.pick(config, 'CHALLENGE_API_URL'))

const challengePhaseId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
challengeApiM2MClient
  .getChallengePhase(challengePhaseId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiUserCredentialsClient
  .getChallengePhase(challengePhaseId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiJwtMethodArgClient
  .getChallengePhase(challengeTypeId, config.JWT)
// or
// challengeApiJwtMethodArgClient
//   .getChallengeType(challengePhaseId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await challengeApiM2MClient.getChallengeType(challengePhaseId)

await challengeApiUserCredentialsClient.getChallengePhase(challengePhaseId)

await challengeApiJwtMethodArgClient.getChallengePhase(challengePhaseId, config.JWT)
// or
// await challengeApiJwtMethodArgClient.getChallengePhase(challengePhaseId)

```
### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **challengePhaseId** | String | the challengePhase id
 **jwt**      | String | the optional json web token

### Return type

[**ChallengePhase**](ChallengePhase.md)

### Authorization

**None**

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateChallengePhase"></a>
# **updateChallengePhase**
> updateChallengePhase(challengePhaseId, reqBody[, jwt])

Fully update challenge phase.

### Example
```javascript
const challengeApi = require('topcoder-challenge-api-wrapper')
const challengeApiM2MClient = challengeApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'CHALLENGE_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const challengeApiUserCredentialsClient = challengeApi(_.pick(config,
      ['USERNAME', 'PASSWORD', 'TC_AUTHN_URL', 'TC_AUTHZ_URL', 'TC_CLIENT_ID',
       'TC_CLIENT_V2_CONNECTION', 'CHALLENGE_API_URL']))

const challengeApiJwtMethodArg = challengeApi(_.pick(config, 'CHALLENGE_API_URL'))

const challengePhaseId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const reqBody = {
 name: 'Code', 
 description : 'code string', 
 predecessor : 'valuetest', 
 isActive : false,
 duration : 112
}


// Promise model
challengeApiM2MClient
  .updateChallengePhase(challengePhaseId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiUserCredentialsClient
  .updateChallengePhase(challengePhaseId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiJwtMethodArgClient
  .updateChallengePhase(challengePhaseId, reqBody, config.JWT)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await challengeApiM2MClient.updateChallengePhase(challengePhaseId, reqBody)

await challengeApiUserCredentialsClient.updateChallengePhase(challengePhaseId, reqBody)

await challengeApiJwtMethodArgClient.updateChallengePhase(challengePhaseId, reqBody, config.JWT)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **challengePhaseId** | String | the challengePhase id
 **reqBody** | [**ChallengePhaseData**](ChallengePhaseData.md)| the challengeType data
 **jwt**      | String | the optional json web token

### Return type

[**ChallengePhase**](ChallengePhase.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="patchChallengePhase"></a>
# **patchChallengePhase**
> patchChallengePhase(challengePhaseId, reqBody[, jwt])

Partially update challengePhase.

### Example
```javascript
const challengeApi = require('topcoder-challenge-api-wrapper')
const challengeApiM2MClient = challengeApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'CHALLENGE_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const challengeApiUserCredentialsClient = challengeApi(_.pick(config,
      ['USERNAME', 'PASSWORD', 'TC_AUTHN_URL', 'TC_AUTHZ_URL', 'TC_CLIENT_ID',
       'TC_CLIENT_V2_CONNECTION', 'CHALLENGE_API_URL']))

const challengeApiJwtMethodArg = challengeApi(_.pick(config, 'CHALLENGE_API_URL'))

const challengePhaseId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'
const reqBody = {
  name: 'BugTest',
  description: 'Bug test',
  isActive: false
}

// Promise model
challengeApiM2MClient
  .patchChallengePhase(challengePhaseId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiUserCredentialsClient
  .patchChallengePhase(challengePhaseId, reqBody)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiJwtMethodArgClient
  .patchChallengePhase(challengePhaseId, reqBody, config.JWT)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await challengeApiM2MClient.patchChallengePhase(challengePhaseId, reqBody)

await challengeApiUserCredentialsClient.patchChallengePhase(challengePhaseId, reqBody)

await challengeApiJwtMethodArgClient.patchChallengePhase(challengePhaseId, reqBody, config.JWT)
```

### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **challengePhaseId** | String | the challengePhaseId id
 **reqBody** | [**ChallengePhaseData**](ChallengePhaseData.md)| the challengeType data
 **jwt**      | String | the optional json web token

### Return type

[**ChallengePhase**](ChallengePhase.md)

### Authorization

[Bearer](../README.md#authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
 
<a name="deleteChallengePhase"></a>
# **deleteChallengePhase**
> deleteChallengePhase(challengePhaseId[, jwt])

delete the challengePhase by id.

### Example
```javascript
const challengeApi = require('topcoder-challenge-api-wrapper')
const challengeApiM2MClient = challengeApi(_.pick(config,
      ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
        'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'CHALLENGE_API_URL',
        'AUTH0_PROXY_SERVER_URL']))

const challengeApiUserCredentialsClient = challengeApi(_.pick(config,
      ['USERNAME', 'PASSWORD', 'TC_AUTHN_URL', 'TC_AUTHZ_URL', 'TC_CLIENT_ID',
       'TC_CLIENT_V2CONNECTION', 'CHALLENGE_API_URL']))

const challengeApiJwtMethodArgClient = challengeApi(_.pick(config, 'CHALLENGE_API_URL'))

const challengePhaseId = '8f4e8b6a-0ad2-4ff6-ab19-afeb102ff3b4'

// Promise model
challengeApiM2MClient
  .deleteChallengePhase(challengePhaseId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiUserCredentialsClient
  .deleteChallengePhase(challengePhaseId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

challengeApiJwtMethodArgClient
  .deleteChallengePhase(challengeTypeId, config.JWT)
// or
// challengeApiJwtMethodArgClient
//   .deleteChallengePhase(challengePhaseId)
  .then(result => console.log(result.body, result.status))
  .catch(err => console.log(err))

// Async / await model
await challengeApiM2MClient.deleteChallengePhase(challengePhaseId)

await challengeApiUserCredentialsClient.deleteChallengePhase(challengePhaseId)

await challengeApiJwtMethodArgClient.deleteChallengePhase(challengePhaseId, config.JWT)
// or
// await challengeApiJwtMethodArgClient.deleteChallengePhase(challengePhaseId)

```
### Parameters

Name | Type | Description
------------- | ------------- | -------------
 **challengePhaseId** | String | the challengePhase id
 **jwt**      | String | the optional json web token

### Return type

[**ChallengePhase**](ChallengePhase.md)

### Authorization

**None**

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
