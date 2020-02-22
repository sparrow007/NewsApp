# Topcoder - Challenge Forum Processor Verification

- start the kafka server
- start the processor by npm start or node src/app.js
- either use local mongodb or mLab (set config using MONGODB_URL)

#### Note If you are using the host url please add the KAFKA_CLIENT_CERT and KAFKA_CLIENT_CERT_KEY

## Issue 1

#### For local setup
- start kafka-console-producer to write messages to `challenge.notification.create` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.notification.create`

- write message of `Create Challenge` in the corresponding producer:

`{"topic":"challenge.notification.create","originator":"topcoder-challenges-api","timestamp":"2019-11-25T23:49:55.247Z","mime-type":"application/json","payload":{"id":"5d9618ad-1937-47aa-b27d-e53680228925","created":"2019-11-25T23:49:55.241Z","createdBy":"TonyJ","phases":[{"description":"Registration Phase","duration":72,"id":"a93544bc-c165-4af4-b55e-18f3593b457a","isActive":true,"name":"Registration"},{"description":"Submission Phase","duration":72,"id":"6950164f-3c5e-4bdc-abc8-22aaf5a1bd49","isActive":true,"name":"Submission","predecessor":"a93544bc-c165-4af4-b55e-18f3593b457a"},{"description":"Review Phase","duration":"48","id":"aa5a3f78-79e0-4bf7-93ff-b11e8f5b398b","isActive":true,"name":"Review","predecessor":"6950164f-3c5e-4bdc-abc8-22aaf5a1bd49"},{"description":"Appeals Phase","duration":24,"id":"1c24cfb3-5b0a-4dbd-b6bd-4b0dff5349c6","isActive":true,"name":"Appeals","predecessor":"aa5a3f78-79e0-4bf7-93ff-b11e8f5b398b"},{"description":"Appeals Response Phase","duration":24,"id":"797a6af7-cd3f-4436-9fca-9679f773bee9","isActive":true,"name":"Appeals Response","predecessor":"1c24cfb3-5b0a-4dbd-b6bd-4b0dff5349c6"}],"typeId":"45415132-79fa-4d13-a9ac-71f50020dc10","track":"DEVELOP","name":"Rodeo_23","description":"Jhons news","reviewType":"community","tags":["Twilio"],"groups":[],"prizeSets":[{"type":"Challenge prizes","prizes":[{"type":"money","value":100}]}],"startDate":"2019-11-26T00:49:22.517Z","timelineTemplateId":"a93544bc-c165-4af4-b55e-18f3593b457a","projectId":127,"status":"Active"}}`
  
- consumer listen to challenge.notification.create will give the output
`Rocket chat is ready
info: Private group / room created:
info: Data stored sucessfully`

you can login to rocket chat with your admin configuration and then output will be 

#### Note : you can also set the configuration for kafka host url and go to `https://challenges.topcoder-dev.com/` for launch the new challenge

![issue1](https://user-images.githubusercontent.com/53591918/69792620-f8a8fd80-11ec-11ea-897a-300f651023a3.png)

## Issue 2

#### local setup 

- start kafka-console-producer to write messages to `challenge.notification.events` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.notification.events`
  
- write message of `Challenge event` for user registration in the corresponding producer:  

`{   "topic": "challenge.notification.events",   "originator": "topcoder-challenges-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {     "type": "USER_REGISTRATION",     "data": {       "challengeId": "b0b96d7f-2e7b-4a1d-a894-165e55b01d2d",       "userId": 40158988     }   } }`

For checking the output of adding the user whose register to challenge go to rocket chat and login.

- write message of `Challenge event` for user unregistration in the corresponding producer: 
`{   "topic": "challenge.notification.events",   "originator": "topcoder-challenges-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {     "type": "USER_UNREGISTRATION",     "detail": {       "challengeId": "b0b96d7f-2e7b-4a1d-a894-165e55b01d2d",       "userId": 40158988     }   } }`

both output will be 

![issue 2](https://user-images.githubusercontent.com/53591918/69793790-1f683380-11ef-11ea-8f8c-343681cacbc8.png)

## Issue 3

Used the mongodb for storing the challengeId and groupId 
#### local setup

- After creating the challenge (issue1) you can use the robomongo tool for database

#### Mlab setup

- You can also view the data in mlab

![issue3](https://user-images.githubusercontent.com/53591918/69794366-1f1c6800-11f0-11ea-9fd3-2fbb440711fe.png)


## Issue 4

#### local setup 

- start kafka-console-producer to write messages to `challenge.action.resource.create` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.action.resource.create`
  
- write message of `Challenge Resource create` for adding user in the corresponding producer: 

`{   "topic": "challenge.action.resource.create,   "originator": "topcoder-resource-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {   "id": "47749b23-0e8c-44e0-b180-ae9364ffec37",   "challengeId": "5d9618ad-1937-47aa-b27d-e53680228925",   "memberId": "40154012",   "memberHandle": "tonyj",   "roleId": "cfe12b3f-2a24-4639-9d8b-ec86726f76bd" } }`


- start kafka-console-producer to write messages to `challenge.action.resource.delete` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.action.resource.delete`
  
- write message of `Challenge Resource delete` for removing user in the corresponding producer: 

`{   "topic": "challenge.action.resource.delete,   "originator": "topcoder-resource-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {   "id": "47749b23-0e8c-44e0-b180-ae9364ffec37",   "challengeId": "5d9618ad-1937-47aa-b27d-e53680228925",   "memberId": "40154012",   "memberHandle": "tonyj",   "roleId": "cfe12b3f-2a24-4639-9d8b-ec86726f76bd" } }`

#### Note you can also use kafka host url in config and go to `https://lauscher.topcoder-dev.com/` and select the topic and send the message

![issue 2](https://user-images.githubusercontent.com/53591918/69793790-1f683380-11ef-11ea-8f8c-343681cacbc8.png)
