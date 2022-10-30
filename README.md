# springboot-microservice-boilerplate
Microservice boilerplate application developed with Spring Boot
### Technologies
* Spring Boot
* Spring Data
* Spring Cloud
* Spring Cloud Gateway
* Discovery Server ( Netflix Eureka Server )
* Apache Kafka / Zookeeper / Kafdrop
* Load Balancer
* Circuit Breaker ( resilience4j )
* MongoDB / Postgresql / Mysql
* Docker / Docker Compose

### Diagram
<img width="647" alt="microservice diagram ss" src="https://user-images.githubusercontent.com/47754791/197885552-e96a194c-9e9f-47ef-b241-05a502f49773.png">

### Setup
* Enter folder path
* Run commands orderly:

```sh
mvn clean install
```

```sh
docker-compose up -d
```

### Pages and Rest APIs
* Spring Eureka: http://localhost:8761/
* Kafdrop (Visualize the Apache Kafka): http://localhost:9000/

| Route                                  | HTTP Verb	 | POST body	                                                                                                                                                                                    | Description	          |
|----------------------------------------|-----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------|
| http://localhost:8080/api/products     | `GET`     |                                                                                                                                                                                               | Get all products.     |
| http://localhost:8080/api/products/{id}| `GET`     |                                                                                                                 | Get product by id.    |
| http://localhost:8080/api/products     | `POST`    | { "name": "product-1", "price": 2750.50, "inStock": true, "stockCount": 100 }                                                                                                                 | Create a new product. |
| http://localhost:8080/api/orders       | `POST`    | { "orderItemDtoList":[ { "ref": "abb8087b-9b84-4a61-a260-6faabcb97c98", "price": 5500, "quantity": 34 }, { "ref": "abb8087b-9b84-4a61-a260-6faabcb97123", "price": 5500, "quantity": 34 } ] } | Create a new order.   |
