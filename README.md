# food-order-service
Example application for a food order microservice with an event driven architecture that is loosely based on CQRT and Saga.

Written in Java using Spring Boot. The main purpose of this project is to provide examples for using common Spring and Java technologies:

- Customized Spring Data Repositories for CQRS-like, event-based architecture
  - Handle persistence and firing of events in a generic and easy to use way (`MessagingAware` repositories)
  - `ReadOnly` repositories that have only read methods
  - Prevent Hibernates auto-save for "read-only-entities" while still enabling updates through messaging bus (viable solution still in progress)
  - Soft deletes with hibernate (in progress)
- Mapstruct in conjunction with Lombok (done in another project, need to apply in this one)
  - Mapping immutable Objects with unidirectional associations using `@Builder` (i.e. dtos) 
  - Mapping mutable Objects with bidirectional associations (i.e. Hibernate entities)
  - Mapping Dtos to Commands/Entities/Queries with asymetric relationships (i.e. bidirectional to unidirectional and vice versa)
- Kafka as a message broker with Ktables for microservice communication and Saga (yet to come)
  - Consumers that have exclusive write access on shared domain objects
  - Producers that are called under the hood by Repository abstractions
