package io.swagger.codegen.languages;

import io.swagger.codegen.*;
import io.swagger.codegen.mustache.LowercaseLambda;
import io.swagger.models.Model;
import io.swagger.models.Operation;
import io.swagger.models.Swagger;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class JavalinServerCodegen extends DefaultCodegen implements CodegenConfig {

    protected String projectFolder = "src" + File.separator + "main";
    protected String sourceFolder = projectFolder + File.separator + "java";
    protected String gradleWrapperPackage = "gradle.wrapper";
    protected String testFolder = "src" + File.separator + "test" + File.separator + "java";

    public JavalinServerCodegen(){
        super();
        supportsInheritance = true;
        outputFolder = "generated-code/javalin";
        embeddedTemplateDir = templateDir = "javalin";
        apiTemplateFiles.put("api.mustache", ".java");
        apiTestTemplateFiles.put("api_test.mustache", ".java");
        apiPackage = "api";
        setReservedWordsLowerCase(
                Arrays.asList(
                        "abstract", "continue", "for", "new", "switch", "assert",
                        "default", "if", "package", "synchronized", "boolean", "do", "goto", "private",
                        "this", "break", "double", "implements", "protected", "throw", "byte", "else",
                        "import", "public", "throws", "case", "enum", "instanceof", "return", "transient",
                        "catch", "extends", "int", "short", "try", "char", "final", "interface", "static",
                        "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "list",
                        "native", "super", "while", "null")
        );
        languageSpecificPrimitives = new HashSet<String>(
                Arrays.asList(
                        "String",
                        "boolean",
                        "Boolean",
                        "Double",
                        "Integer",
                        "Long",
                        "Float",
                        "Object",
                        "byte[]")
        );
        defaultIncludes.addAll(Arrays.asList(
                "string",
                "integer",
                "object"));
        instantiationTypes.put("array", "ArrayList");
        instantiationTypes.put("map", "HashMap");
        typeMapping.put("date", "Date");
        typeMapping.put("file", "File");
        typeMapping.put("string", "String");
        typeMapping.put("object", "Object");

        supportingFiles.add(new SupportingFile("main.mustache", sourceFolder, "Main.java"));
        writeOptional(outputFolder, new SupportingFile("README.mustache", "", "README.md"));
        writeOptional(outputFolder, new SupportingFile("build.gradle.kts.mustache", "", "build.gradle.kts"));
        //writeOptional(outputFolder, new SupportingFile("settings.gradle.mustache", "", "settings.gradle"));
        //writeOptional(outputFolder, new SupportingFile("gradle.properties.mustache", "", "gradle.properties"));
        supportingFiles.add(new SupportingFile( "gradlew.mustache", "", "gradlew") );
        supportingFiles.add(new SupportingFile( "gradlew.bat.mustache", "", "gradlew.bat") );
        supportingFiles.add(new SupportingFile( "gradle-wrapper.properties.mustache",
                gradleWrapperPackage.replace( ".", File.separator ), "gradle-wrapper.properties") );
        supportingFiles.add(new SupportingFile( "gradle-wrapper.jar",
                gradleWrapperPackage.replace( ".", File.separator ), "gradle-wrapper.jar") );
    }

    @Override
    public void processOpts() {
        super.processOpts();
        importMapping.put("Javalin", "io.javalin.Javalin");
        importMapping.put("List", "java.util.List");
        importMapping.put("File", "java.io.File");
        //importMapping.put("Deprecated", "");
        additionalProperties.put("lowercase", new LowercaseLambda());
    }

    @Override
    public String apiFileFolder() {
        return outputFolder + "/" + sourceFolder + "/" + apiPackage().replace('.', '/');
    }

    @Override
    public String apiTestFileFolder() {
        return outputFolder + "/" + testFolder + "/" + apiPackage().replace('.', '/');
    }

    @Override
    public String toApiName(String name) {
        if (name.length() == 0) {
            return "DefaultApi";
        }
        return camelize(name) + "API";
    }

    @Override
    public String toApiFilename(String name) {
        return toApiName(name);
    }

    @Override
    public String toApiVarName(String name) {
        return snakeCase(name) + "API";
    }

    @Override
    public String toVarName(String name) {
        name = sanitizeName(name); // FIXME: a parameter should not be assigned. Also declare the methods parameters as 'final'.

        if (name.toLowerCase().matches("^_*class$")) {
            return "propertyClass";
        }

        if("_".equals(name)) {
            name = "_u";
        }

        // if it's all uppper case, do nothing
        if (name.matches("^[A-Z_]*$")) {
            return name;
        }

        if(startsWithTwoUppercaseLetters(name)){
            name = name.substring(0, 2).toLowerCase() + name.substring(2);
        }

        // camelize (lower first character) the variable name
        // pet_id => petId
        name = camelize(name, true);

        // for reserved word or word starting with number, append _
        if (isReservedWord(name) || name.matches("^\\d.*")) {
            name = escapeReservedWord(name);
        }

        return name;
    }

    private boolean startsWithTwoUppercaseLetters(String name) {
        boolean startsWithTwoUppercaseLetters = false;
        if(name.length() > 1) {
            startsWithTwoUppercaseLetters = name.substring(0, 2).equals(name.substring(0, 2).toUpperCase());
        }
        return startsWithTwoUppercaseLetters;
    }

    public String escapeUnsafeCharacters(String input) {
        return input.replace("*/", "*_/").replace("/*", "/_*");
    }

    @Override
    public String escapeQuotationMark(String input) {
        // remove " to avoid code injection
        return input.replace("\"", "");
    }

    @Override
    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    @Override
    public String getName() {
        return "javalin";
    }

    @Override
    public String getHelp() {
        return "Generates a Javalin Server library.";
    }

    @Override
    public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, Map<String, Model> definitions, Swagger swagger) {
        CodegenOperation codegenOperation = super.fromOperation(path, httpMethod, operation, definitions, swagger);
        codegenOperation.imports.add("List");
        codegenOperation.imports.add("Javalin");
        //if (codegenOperation.isDeprecated)
        //    codegenOperation.imports.add("Deprecated");
        return codegenOperation;
    }
}
