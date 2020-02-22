# Topcoder - Challenge Forum Processor

## Dependencies

- [nodejs](https://nodejs.org/en/)
- [kafka](https://kafka.apache.org/)
- [Mongodb](https://www.mongodb.com/)
- [Rocket.chat](https://rocket.chat/)
- [vanillaforums](https://vanillaforums.com/)


## Configuration

Please set the following environment variables to configure the app.
For quick-setup while development, use a `.env` file, and run `docker-compose up -d`, and then start the processor.

| Name | Description | Default value |
| ---- | ----------- | ------------- |
| DISABLE_LOGGING | Whether to disable logging | `false` |
| LOG_LEVEL | Logging level | `debug` |
| KAFKA_URL | Kafka connection string | `localhost:9092` |
| KAFKA_CLIENT_CERT | Kafka client certificate (SSL). This gets precedence over the file path. | `undefined` |
| KAFKA_CLIENT_CERT_PATH | Path to kafka client certificate (SSL) file. | `./config/kafka_client.cer` |
| KAFKA_CLIENT_CERT | Kafka client key (SSL). This gets precedence over the file path. | `undefined` |
| KAFKA_CLIENT_KEY_PATH | Path to kafka client key (SSL) file. | `./config/kafka_client.key` |
| KAFKA_SSL_PASSPHRASE | Passphrase (for SSL) | `secret` |
| ROCKETCHAT_PROTOCOL | Rocketchat Protocol | `http` |
| ROCKETCHAT_HOST | Rocketchat Host | `127.0.0.1`
| ROCKETCHAT_PORT | Rocketchat Port | `3000` |
| ROCKETCHAT_USERNAME | Rocketchat Username | `rocket` |
| ROCKETCHAT_PASSWORD | Rocketchat Password | `rocket` |
| TOPCODER_AUTH0_AUDIENCE | Topcoder Auth0 Audience | `undefined` |
| TOPCODER_AUTH0_CLIENT_ID | Topcoder Auth0 client ID | `undefined` |
| TOPCODER_AUTH0_CLIENT_SECRET | Topcoder Auth0 Client Secret | `undefined` |
| TOPCODER_AUTH0_PROXY_SERVER_URL | Topcoder Auth0 Proxy Server URL | `https://auth0proxy.topcoder-dev.com/token` |
| TOPCODER_AUTH0_URL | Topcoder Auth0 URL | `undefined` |
| TOPCODER_API_URL | Topcoder API URL | `https://api.topcoder-dev.com` |
| TOPCODER_ROOT_URL | Topcoder Root URL | `https://topcoder-dev.com` |
| MONGODB_URL | Mongodb URL | `mongodb://localhost:27017/challengeForumDB` |
| VANILLAFORUM_ACCESS_TOKEN | Vanilla forum access token | |
| VANILLAFORUM_API_URL | Vanilla forum API URL | `localhost/vanilla/api/v2` |
| Processor_Type | Processor type either `Rocket.Chat` or `VanillaForum` | `VanillaForum` |

## Heroku deployment 

- Download and install the heroku CLI, download and installation link `https://devcenter.heroku.com/articles/getting-started-with-nodejs#set-up`
- Go to heroku and create new app.
- Login to heroku using your cli by typing "heroku login" and then enter your credentials
- Initialize a git repository in existing directory 
``` 
$ git init
$ heroku git:remote -a <your project> 
```
- Deploy your application Commit your code to the repository and deploy it to Heroku using Git.
``` 
$ git add .
$ git commit -am "make it better"
$ git push heroku master
```

Then, set the environment variables using the following commands, changing the values as necessary:

```bash
# Set the Kafka client certificate and client key
# Replace ./config/kafka_client.cer and ./config/kafka_client.key with the path to the certificate and key
$ heroku config:set -a <app_name> \
  KAFKA_CLIENT_CERT="$(cat ./config/kafka_client.cer)" \
  KAFKA_CLIENT_CERT_KEY="$(cat ./config/kafka_client.key)"

# Set the other environment variables
$ heroku config:set -a <app_name> \
  TOPCODER_AUTH0_PROXY_SERVER_URL="<value>" \
  TOPCODER_AUTH0_URL="<value>" \
  TOPCODER_API_URL="<value>" \
  TOPCODER_ROOT_URL="<value>" \
  KAFKA_URL="<value>" \
  ROCKETCHAT_PROTOCOL="<value>" \
  ROCKETCHAT_HOST="<value>" \
  ROCKETCHAT_PORT="<value>" \
  ROCKETCHAT_USERNAME="<value>" \
  ROCKETCHAT_PASSWORD="<value>" \
  MONGODB_URL="<value>" \
  VANILLAFORUM_ACCESS_TOKEN = "<value>" \
  VANILLAFORUM_API_URL="<value>" \
  Processor_Type= "<value>"
```
#### NOTE you should have Procfile in your root directory for running your node app and below code in the procfile

``` 
Worker : node src/app.js
```
#### NOTE
You can use the mongolab for your mongodb database and provide the mongodb uri using environment variable `MONGODB_URL`

## Local Kafka setup

- `http://kafka.apache.org/quickstart` contains details to setup and manage Kafka server,
  below provides details to setup Kafka server in Mac, Windows will use bat commands in bin/windows instead
- download kafka at `https://www.apache.org/dyn/closer.cgi?path=/kafka/1.1.0/kafka_2.11-1.1.0.tgz`
- extract out the downloaded tgz file
- go to extracted directory kafka_2.11-0.11.0.1
- start ZooKeeper server:
  `bin/zookeeper-server-start.sh config/zookeeper.properties`
- use another terminal, go to same directory, start the Kafka server:
  `bin/kafka-server-start.sh config/server.properties`
- note that the zookeeper server is at localhost:2181, and Kafka server is at localhost:9092
- Use another terminal, go to same directory, create some topics:
  `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic challenge.notification.create`
  `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic challenge.notification.events`
  `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic challenge.action.resource.create`
  `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic challenge.action.resource.delete`
- Verify that the topics are created:
  `bin/kafka-topics.sh --list --zookeeper localhost:2181`,
  it should list out the created topics
- run the producer and then write some message into the console to send to the `challenge.notification.events` topic:
  `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.notification.events`
  in the console, write message, one message per line:
  `{   "topic": "challenge.notification.events",   "originator": "topcoder-challenges-api",   "timestamp": "2019-11-24T23:26:28.926Z",   "mime-type": "application/json",   "payload": {     "type": "USER_UNREGISTRATION",     "data": {   "challengeId": "b0b96d7f-2e7b-4a1d-a894-165e55b01d2d",       "userId": 40158988     }   }`
- Optionally, use another terminal, go to same directory, start a consumer to view the messages:
  `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic challenge.notification.events --from-beginning`
- If the kafka don't allow to input long message you can use this script to write message from file:
  `path_to_kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic challenge.notification.events < our_project_root_directory/test/data/project/challenge.notification.events.json`
- Writing/reading messages to/from other topics are similar. All example for messages are in:
`our_project_root_directory/test/data`

## Local Mongodb setup
- download the mongodb from `https://www.mongodb.com/download-center/community`
- Install it in your os , for installing doc `https://docs.mongodb.com/manual/administration/install-community/`
- Run the mongodb localy , default mongodb runs on 27017 port

## Local deployment

- Install dependencies `npm i`
- Run code lint check `npm run lint`, running `npm run lint:fix` can fix some lint errors if any
- Start processor app `npm start`

## Verification
Refer to the verification document `Verification.md`
