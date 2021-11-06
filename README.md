# Event-Driven-Architecture-KAFKA-JAVA
## In this tuto i'm using RabbitMQ to implement Event-Driven PUB-SUB
  ### Ok let's start :grinning:

i'm creating three services :<br />

 1. producer service.
 2. processor service.
 3. consumer service.

####Producer : will accept the request via a REST endpoint.
Create a simple Controller that accepts a String and sends it to a topic.
the name for my topic is : "values-topic"

####Processor : is a pure Spring Cloud Stream application. It continuously listens to a topic and upon receiving a message, processes it and publishes to an output topic. As a result, this service requires only the Cloud Stream and Spring for RabbitMQ dependencies.

####Consumer : The list of dependencies for Consumers is same as Processor.

Finnaly I add a docker file docker-compose.yml that contains the configuration to expose RabbitMQ container in docker-hub