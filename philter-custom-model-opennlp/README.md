# Philter Example Custom Model using OpenNLP and Spring Boot

## Build and Run 

```
mvn clean install
java -jar ./target/philter-custom-model-opennlp-1.0-SNAPSHOT.jar 
```

## Verifying the Service Implementation

Execute a sample request to verify that the service interface is implemented correctly.

```
curl -X POST http://localhost:8080/process --data "Abraham Lincoln was president." -H "Content-Type: text/plain"
```

Verify the response:

```
[{"text":"Abraham Lincoln","score":0.8004037929465879,"start":0,"end":15,"tag":"person"}]
```

Check the status.

```
curl http://localhost:8080/status
```

Verify the response:

```
healthy
```