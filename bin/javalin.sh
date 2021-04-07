#/bin/bash

executable=./modules/swagger-codegen-cli/target/swagger-codegen-cli.jar

if [ ! -e ${executable} ]; then
	./mvnw clean package
fi

#REM set JAVA_OPTS=%JAVA_OPTS% -Xmx1024M
ags="generate -i petstore.json -l javalin -o samples/javalin -DdateLibrary=java.util.Date -DhideGenerationTimestamp=true"

rm -r samples/

java -jar ${executable} ${ags}

cd samples/javalin

chmod +x gradlew

./gradlew assemble
