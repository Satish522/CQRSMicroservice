To run this application required database and kafka

Database
-----------
You can find PostgresSQL database from application from application.properties. In case you want to change database can modify datasource in properties file

Kafka
-----------
Kafka start with Kraft

$ KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

$ bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

$ bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

Get the Docker image:

$ docker pull apache/kafka:3.9.0
Start the Kafka Docker container:

$ docker run -p 9092:9092 apache/kafka:3.9.0
