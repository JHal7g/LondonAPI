# LondonAPI

## To run:

Download and unzip project,

In terminal navigate in to unzipped folder and run commands:
`mvn install`

`java -jar target/demo-0.0.1-SNAPSHOT.jar`

If the program returns 'None found!!!' this is most likely due to a ZScaler issue, which can be resolved by going to `com.example.demo.service.getConnection` and using the alternateive URL which has been commented out.

go to localhost:8080
