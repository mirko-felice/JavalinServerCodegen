set JAVA_OPTS=-DdebugModels

set executable=.\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar

If Not Exist %executable% (
  mvn clean package
)

REM set JAVA_OPTS=%JAVA_OPTS% -Xmx1024M
set ags=generate -i petstore.json -l javalin -o samples\javalin -DdateLibrary=java.util.Date -DhideGenerationTimestamp=true

rmdir /S "samples\"

java %JAVA_OPTS% -jar %executable% %ags%

cd samples\javalin

gradlew assemble

cd ..\..
