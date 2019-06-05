# Topcoder Submission API Review Types Wrapper

Wrapper library for Topcoder Submission API ReviewTypes endpoint

## How to use this Wrapper

1. Include the wrapper in package.json as follows

    ```bash
    "tc-submission-api-wrapper": "topcoder-platform/tc-submission-api-wrapper.git"
    ```

2. Create an instance of this wrapper with the configuration variables listed below

    ```bash
    const submissionApi = require('tc-submission-api-review-types-wrapper')
    const submissionApiClient = reviewTypesApi(_.pick(config,
          ['AUTH0_URL', 'AUTH0_AUDIENCE', 'TOKEN_CACHE_TIME',
            'AUTH0_CLIENT_ID', 'AUTH0_CLIENT_SECRET', 'SUBMISSION_API_URL',
            'AUTH0_PROXY_SERVER_URL']))
    ```

    **Configuration / Environment variables:**

    - AUTH0_URL - the auth0 url
    - AUTH0_AUDIENCE - the auth0 audience
    - TOKEN_CACHE_TIME - (optional) the token cache time
    - AUTH0_CLIENT_ID - the auth0 client id, used as credential
    - AUTH0_CLIENT_SECRET - the auth0 client secret, used as credential
    - AUTH0_PROXY_SERVER_URL - (optional) the auth0 proxy server url
    - SUBMISSION_API_URL - Topcoder V5 Submission API URL. E.g. `https://api.topcoder-dev.com/v5`

3. Every function in this wrapper will return a promise, Handling promises is at the caller end. Call the functions with appropriate arguments


Refer `index.js` for the list of available wrapper functions

## Documentation for different resource wrapper methods

All URIs are relative to **SUBMISSION_API_URL** configuration variable.

* Review Types resource wrapper methods [getReview](app/ReviewTypes.md)

* Reviews resource wrapper methods 

## Authorization

Review Types wrapper and Reviews wrapper both internally generates a **JWT token using Auth0 credentials** and pass it in the `Authorization` header.

## Running tests

Following environment variables need to be set up before running the tests

```bash
- TEST_AUTH0_URL
- TEST_AUTH0_AUDIENCE
- TEST_AUTH0_CLIENT_ID
- TEST_AUTH0_CLIENT_SECRET
- TEST_SUBMISSION_API_URL
```

Refer to Step # 2 in [this section](#how-to-use-this-wrapper) to learn more about the configuration variables.

To run the tests alone, execute the command

```bash
npm run test
```

To run tests with coverage report, execute the command

```bash
npm run cov
```
