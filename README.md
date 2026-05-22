# spring-boot-togglz-maven-java
## Features
```shell
curl -GET http://localhost:8080/actuator/togglz | jq
```
```shell
curl --request POST \
  --url http://localhost:8080/actuator/togglz/TOGGLE \
  --header 'content-type: application/json' \
  --data '{
  "name": "TOGGLE",
  "enabled": "false"
}'
```