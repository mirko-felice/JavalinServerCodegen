

set executable=.\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar

If Not Exist %executable% (
  mvn clean package
)

REM set JAVA_OPTS=%JAVA_OPTS% -Xmx1024M
set ags=generate -i linda.yaml -l javalin -o samples\javalin\linda

rmdir /S "samples\javalin\linda"

java %JAVA_OPTS% -jar %executable% %ags%

cd samples\javalin\linda

gradlew assemble
