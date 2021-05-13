#/bin/bash

executable=./modules/swagger-codegen-cli/target/swagger-codegen-cli.jar

if [ ! -e ${executable} ]; then
	./mvnw clean package
fi

#REM set JAVA_OPTS=%JAVA_OPTS% -Xmx1024M
ags="generate -i petstore.json -l javalin -o samples/javalin/petstore"

rm -r samples/javalin/petstore

java -jar ${executable} ${ags}

cd samples/javalin/petstore

chmod +x gradlew

./gradlew assemble
