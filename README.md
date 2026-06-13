# Product CRUD API

REST API built with Spring Boot.

## Endpoints

GET /products
GET /products/{id}
POST /products
PUT /products/{id}
DELETE /products/{id}

## Run

mvn spring-boot:run
## Sample Requests

### Get All Products

```bash
curl -X GET http://localhost:8080/products
```

### Get Product By ID

```bash
curl -X GET http://localhost:8080/products/1
```

### Create Product

```bash
curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{
  "name":"Laptop",
  "description":"Gaming Laptop",
  "price":75000,
  "quantity":5
}'
```
