#/bin/bash

executable=./modules/swagger-codegen-cli/target/swagger-codegen-cli.jar

if [ ! -e ${executable} ]; then
	./mvnw clean package
fi

#REM set JAVA_OPTS=%JAVA_OPTS% -Xmx1024M
ags="generate -i linda.yaml -l javalin -o samples/javalin/linda"

rm -r samples/javalin/linda

java -jar ${executable} ${ags}

cd samples/javalin/linda

chmod +x gradlew

./gradlew assemble
