# Topcoder - Challenge Vanilla Forum Integration Processor Validation

- start the xampp server and at first time create database for vanilla forums that might found in (http://localhost/vanilla) (make admin creds)
- start the kafka server
- start the processor by npm start or node src/app.js
- either use local mongodb or mLab (set config using MONGODB_URL)

#### Note We are supposing that all the user will added to vanilla forums as member role, in my case i added dok as userhandle with member role permission


#### Note If you are using the host url please add the KAFKA_CLIENT_CERT and KAFKA_CLIENT_CERT_KEY

## Challenge Create || Vanilla forums corresponding category created

#### For local setup
- start kafka-console-producer to write messages to `challenge.notification.create` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.notification.create`

- write message of `Create Challenge` in the corresponding producer:

`{"topic":"challenge.notification.create","originator":"topcoder-challenges-api","timestamp":"2019-11-25T23:49:55.247Z","mime-type":"application/json","payload":{"id":"8d0708ad-1737-47aa-b27d-e53682228925","created":"2019-11-25T23:49:55.241Z","createdBy":"TonyJ","phases":[{"description":"Registration Phase","duration":72,"id":"a93544bc-c165-4af4-b55e-18f3593b457a","isActive":true,"name":"Registration"},{"description":"Submission Phase","duration":72,"id":"6950164f-3c5e-4bdc-abc8-22aaf5a1bd49","isActive":true,"name":"Submission","predecessor":"a93544bc-c165-4af4-b55e-18f3593b457a"},{"description":"Review Phase","duration":"48","id":"aa5a3f78-79e0-4bf7-93ff-b11e8f5b398b","isActive":true,"name":"Review","predecessor":"6950164f-3c5e-4bdc-abc8-22aaf5a1bd49"},{"description":"Appeals Phase","duration":24,"id":"1c24cfb3-5b0a-4dbd-b6bd-4b0dff5349c6","isActive":true,"name":"Appeals","predecessor":"aa5a3f78-79e0-4bf7-93ff-b11e8f5b398b"},{"description":"Appeals Response Phase","duration":24,"id":"797a6af7-cd3f-4436-9fca-9679f773bee9","isActive":true,"name":"Appeals Response","predecessor":"1c24cfb3-5b0a-4dbd-b6bd-4b0dff5349c6"}],"typeId":"45415132-79fa-4d13-a9ac-71f50020dc10","track":"DEVELOP","name":"Topcoder Vanilla Challenge Forum v1","description":"Jhons news","reviewType":"community","tags":["Twilio"],"groups":[],"prizeSets":[{"type":"Challenge prizes","prizes":[{"type":"money","value":100}]}],"startDate":"2019-11-26T00:49:22.517Z","timelineTemplateId":"a93544bc-c165-4af4-b55e-18f3593b457a","projectId":127,"status":"Active"}}`
  
- consumer listen to challenge.notification.create will give the output
`Kafka message payload `
`info: Sucessfully challenge forum created`
`info: Data stored sucessfully`

you can login to vanilla forums with your admin configuration and then output will be 

#### Note : you can also set the configuration for kafka host url and go to `https://challenges.topcoder-dev.com/` for launch the new challenge

#### Note : In my localhost my category url is at  `http://localhost/vanilla/categories/Topcoder_Vanilla_Challenge_Forum_v1` my category name is Topcoder Vanilla Challenge Forum v1

![1 issue](https://user-images.githubusercontent.com/22986571/75087252-dca2c700-5563-11ea-82b1-fb48cead4de9.png)

#### Challenge description 
You can see that challenge documents category has already one discussion which is challenge overview and when you click on the code documents then output will be

![2 subcategory](https://user-images.githubusercontent.com/22986571/75087313-a0bc3180-5564-11ea-80e2-a90de6c546fc.png)

## User registration and Unregistration

#### For user registration || local setup 

#### NOTE: I am using userId `132456` in kafka payload and this userId is exist on topcoder with handle name dok so i created a user with same userHandle on vanilla forum in add user section.

Now login with dok userHandle in vanilla forum then you see that there is not "Topcoder Vanilla Challenge Forum v1" category in all category section at right side

![3 permission](https://user-images.githubusercontent.com/22986571/75087487-04dff500-5567-11ea-9bf9-702a94c7c89f.png)

After this,

- start kafka-console-producer to write messages to `challenge.notification.events` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.notification.events`
  
- write message of `Challenge event` for user registration in the corresponding producer:  

`{   "topic": "challenge.notification.events",   "originator": "topcoder-challenges-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {     "type": "USER_REGISTRATION",     "data": {       "challengeId": "8d0708ad-1737-47aa-b27d-e53682228925",       "userId": 132456     }   } }`

When above message is produce with dok userID `132456`, Now see the all categories section on right side there is a category with name "Topcoder Vanilla Challenge Forum v1"

![4 given permission](https://user-images.githubusercontent.com/22986571/75087557-f3e3b380-5567-11ea-8202-aa94dc1c2aa6.png)

#### For user Unregistration

Now ,
- write message of `Challenge event` for user unregistration in the corresponding producer: 
`{   "topic": "challenge.notification.events",   "originator": "topcoder-challenges-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {     "type": "USER_UNREGISTRATION",     "detail": {       "challengeId": "8d0708ad-1737-47aa-b27d-e53682228925",       "userId": 132456     }   } }`

When above message is produce with dok userID , Now see the all categories section on right side there is no a category with name "Topcoder Vanilla Challenge Forum v1" (Referesh the site if needed)

![3 permission](https://user-images.githubusercontent.com/22986571/75087487-04dff500-5567-11ea-9bf9-702a94c7c89f.png)


## Mongodb for mapping

Used the mongodb for storing the challengeId and roleID 
#### local setup

- After creating the challenge (issue1) you can use the robomongo tool for database

#### Mlab setup

- You can also use mLab and store the uri of mLab db in MONGODB_URL in config see the README.MD

##  TC env values for validation

 AUTH0_URL = 'https://topcoder-dev.auth0.com/oauth/token'
 AUTH0_AUDIENCE = 'https://m2m.topcoder-dev.com/'
 AUTH0_CLIENT_ID = 'LU2Nt7YPHQ3lxrFNKitJ82syB4wIMR7G'
 AUTH0_CLIENT_SECRET= 'O8S2YOb-0lI4NS3smR4d4uf0VM9BN0y1Ra4ABRktGUPOXc34mUO25uJrCpU-TBAT'
 AUTH0_PROXY_SERVER_URL= 'https://auth0proxy.topcoder-dev.com/token'
