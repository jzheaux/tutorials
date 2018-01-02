You can run this module in one of two ways:

1. You can run the integration test, e.g. mvn test -Dtest=com.baeldung.rmi.JavaRMIIntegrationTest

2. You can run the java classes directly:

```bash
mvn clean install

In one terminal:

java -cp target/java-rmi-0.0.1-SNAPSHOT.jar com.baeldung.rmi.MessengerServiceImpl

And in another terminal:

java -cp target/java-rmi-0.0.1-SNAPSHOT.jar com.baeldung.rmi.MessengerClientImpl
```

Enjoy!
