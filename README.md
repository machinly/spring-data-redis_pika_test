# spring-lettuce-pika

## run pika
```shell
kubectl apply -f deploy.yaml
```

## run spring
```shell
./mvnw spring-boot:run
```

## test
```shell
## set
curl -X PUT http://127.0.0.1:8080/redis/set/a/b

## get
curl -X GET http://127.0.0.1:8080/redis/get/a
```