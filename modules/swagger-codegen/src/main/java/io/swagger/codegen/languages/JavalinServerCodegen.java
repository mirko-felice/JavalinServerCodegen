package io.swagger.codegen.languages;

import io.swagger.codegen.*;
import io.swagger.codegen.mustache.LowercaseLambda;
import io.swagger.codegen.mustache.UppercaseLambda;
import io.swagger.models.*;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;

import java.io.File;
import java.util.*;

public class JavalinServerCodegen extends DefaultCodegen implements CodegenConfig {

    protected String projectFolder = "src" + File.separator + "main";
    protected String projectTestFolder = "src" + File.separator + "test";
    protected String sourceFolder = projectFolder + File.separator + "java";
    protected String testFolder = projectTestFolder + File.separator + "java";
    protected String gradleWrapperPackage = "gradle.wrapper";
    protected List<String> schemes = new ArrayList<>();

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
        languageSpecificPrimitives = new HashSet<>(
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
        String utilsFolder = sourceFolder + File.separator + "utils";
        supportingFiles.add(new SupportingFile("apiException.mustache", utilsFolder, "ApiException.java"));
        supportingFiles.add(new SupportingFile("remoteException.mustache", utilsFolder, "RemoteException.java"));
        supportingFiles.add(new SupportingFile("presentationException.mustache", utilsFolder, "PresentationException.java"));
        supportingFiles.add(new SupportingFile("presentation.mustache", utilsFolder, "Presentation.java"));
        supportingFiles.add(new SupportingFile("serializer.mustache", utilsFolder, "Serializer.java"));
        supportingFiles.add(new SupportingFile("deserializer.mustache", utilsFolder, "Deserializer.java"));
        supportingFiles.add(new SupportingFile("javalinDeserializer.mustache", utilsFolder, "JavalinDeserializer.java"));
        supportingFiles.add(new SupportingFile("utilities.mustache", utilsFolder, "Utilities.java"));
        supportingFiles.add(new SupportingFile("wrongExecutionSequenceException.mustache", utilsFolder, "WrongExecutionSequenceException.java"));
        modelPackage = "model";
        modelTemplateFiles.put("model.mustache", ".java");
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

        String authFolder = sourceFolder + File.separator + "auth";
        supportingFiles.add(new SupportingFile("auth/Authentication.mustache", authFolder, "Authentication.java"));
        supportingFiles.add(new SupportingFile("auth/HttpBasicAuth.mustache", authFolder, "HttpBasicAuth.java"));
        supportingFiles.add(new SupportingFile("auth/ApiKeyAuth.mustache", authFolder, "ApiKeyAuth.java"));
        supportingFiles.add(new SupportingFile("auth/OAuth.mustache", authFolder, "OAuth.java"));
        supportingFiles.add(new SupportingFile("auth/OAuthFlow.mustache", authFolder, "OAuthFlow.java"));
        supportingFiles.add(new SupportingFile("auth/Pair.mustache", authFolder, "Pair.java"));
    }

    @Override
    public void processOpts() {
        super.processOpts();
        importMapping.put("Context", "io.javalin.http.Context");
        importMapping.put("Javalin", "io.javalin.Javalin");
        importMapping.put("List", "java.util.List");
        importMapping.put("ArrayList", "java.util.ArrayList");
        importMapping.put("Map", "java.util.Map");
        importMapping.put("HashMap", "java.util.HashMap");
        importMapping.put("Objects", "java.util.Objects");
        importMapping.put("CompletableFuture", "java.util.concurrent.CompletableFuture");
        importMapping.put("BigDecimal", "java.math.BigDecimal");
        importMapping.put("JavalinFile", "io.javalin.core.util.FileUtil");
        importMapping.put("UploadedFile","io.javalin.http.UploadedFile");
        importMapping.put("BadRequest", "io.javalin.http.BadRequestResponse");
        importMapping.put("JavalinJson", "io.javalin.plugin.json.JavalinJson");
        importMapping.put("WSContext", "io.javalin.websocket.WsMessageContext");
        importMapping.put("WrongExecutionSequence", "utils.WrongExecutionSequenceException");
        importMapping.put("JSONArray", "org.json.JSONArray");
        additionalProperties.put("lowercase", new LowercaseLambda());
        additionalProperties.put("uppercase", new UppercaseLambda());
    }

    @Override
    public Map<String, Object> postProcessModels(Map<String, Object> objs) {
        return postProcessModelsEnum(objs);
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
        return camelize(name);
    }

    @Override
    public String toApiFilename(String name) {
        return toApiName(name) + "API";
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

    //From values creates valid Variable names for Java
    @Override
    public String toEnumVarName(String value, String datatype) {
        if (value.length() == 0) {
            return "EMPTY";
        }

        // for symbol, e.g. $, #
        if (getSymbolName(value) != null) {
            return getSymbolName(value).toUpperCase();
        }

        // number
        if ("Integer".equals(datatype) || "Long".equals(datatype) || "Float".equals(datatype) || "Double".equals(datatype)  || "BigDecimal".equals(datatype)) {
            String varName = "NUMBER_" + value;
            varName = varName.replaceAll("-", "MINUS_");
            varName = varName.replaceAll("\\+", "PLUS_");
            varName = varName.replaceAll("\\.", "_DOT_");
            return varName;
        }

        // string
        String var = value.replaceAll("\\W+", "_").toUpperCase();
        if (var.matches("\\d.*")) {
            return "_" + var;
        } else {
            return var;
        }
    }

    //Transform Swagger values to valid Java values
    @Override
    public String toEnumValue(String value, String datatype) {
        if ("Integer".equals(datatype) || "Double".equals(datatype) || "Boolean".equals(datatype)) {
            return value;
        } else if ("Long".equals(datatype)) {
            // add l to number, e.g. 2048 => 2048l
            return value + "l";
        } else if ("Float".equals(datatype)) {
            // add f to number, e.g. 3.14 => 3.14f
            return value + "f";
        } else if ("BigDecimal".equals(datatype)) {
            return "new BigDecimal(" + escapeText(value) + ")";
        } else {
            return "\"" + escapeText(value) + "\"";
        }
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
        codegenOperation.imports.addAll(Arrays.asList("Javalin", "Context", "Objects", "WSContext"));
        codegenOperation.imports.addAll(Arrays.asList("Map", "HashMap", "List", "ArrayList"));
        if (codegenOperation.allParams.stream().anyMatch(p -> p.isListContainer))
            codegenOperation.imports.add("List");
        if (codegenOperation.allParams.stream().anyMatch(p -> p.isFile))
            codegenOperation.imports.addAll(Arrays.asList("JavalinFile", "UploadedFile"));
        if (!codegenOperation.responses.isEmpty()) {
            codegenOperation.imports.add("CompletableFuture");
            if (codegenOperation.responses.stream().anyMatch(r -> r.isMapContainer))
                codegenOperation.imports.add("Map");
            if (codegenOperation.responses.stream().anyMatch(r -> r.isListContainer))
                codegenOperation.imports.add("List");
            if (codegenOperation.responses.stream().anyMatch(r -> r.dataType != null))
                codegenOperation.imports.add("WrongExecutionSequence");
        }
        if (codegenOperation.hasConsumes)
            codegenOperation.imports.add("BadRequest");
        if (codegenOperation.bodyParam != null && codegenOperation.bodyParam.isContainer)
            codegenOperation.imports.addAll(Arrays.asList("JavalinJson", "JSONArray"));
        codegenOperation.allParams.stream().filter(p -> p.isEnum).forEach(codegenParameter -> {
            /*importMapping.put("", String.format("%s.%s.%s", modelPackage, c codegenParameter.enumName));
            codegenOperation.imports.add("");*/
        });
        return codegenOperation;
    }

    @Override
    public CodegenModel fromModel(String name, Model model, Map<String, Model> allDefinitions) {
        CodegenModel codegenModel = super.fromModel(name, model, allDefinitions);
        if ((codegenModel.isArrayModel && codegenModel.parentContainer.isListContainer) || codegenModel.vars.stream().anyMatch(p -> p.isListContainer))
            codegenModel.imports.add("List");
        if ((codegenModel.isArrayModel && codegenModel.parentContainer.isMapContainer) || codegenModel.vars.stream().anyMatch(p -> p.isMapContainer))
            codegenModel.imports.add("Map");
        if (codegenModel.getIsNumber() || codegenModel.vars.stream().anyMatch(p -> p.isNumber))
            codegenModel.imports.add("BigDecimal");
        return codegenModel;
    }

    @Override
    public String modelFileFolder() {
        return outputFolder + File.separator + sourceFolder + File.separator + modelPackage.replace(".", File.separator);
    }

    @Override
    public String modelTestFileFolder() {
        return outputFolder + File.separator + testFolder + File.separator + modelPackage.replace(".", File.separator);
    }

    @Override
    public String toApiTestFilename(String name) {
        return toApiFilename(name) + "Test";
    }

    @Override
    public String getSwaggerType(Property p) {
        String swaggerType = super.getSwaggerType(p);

        swaggerType = getAlias(swaggerType);

        // don't apply renaming on types from the typeMapping
        if (typeMapping.containsKey(swaggerType)) {
            return typeMapping.get(swaggerType);
        }

        if (null == swaggerType) {
            LOGGER.error("No Type defined for Property " + p);
        }
        return toModelName(swaggerType);
    }

    @Override
    public void preprocessSwagger(Swagger swagger) {
        super.preprocessSwagger(swagger);
        for (Scheme scheme: swagger.getSchemes()){
            this.schemes.add(scheme.toValue());
        }
    }

    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        super.postProcessOperations(objs);
        Map<String, Object> operations = (Map<String, Object>) objs.get("operations");
        if (operations != null) {
            List<CodegenOperation> ops = (List<CodegenOperation>) operations.get("operation");
            for (CodegenOperation operation : ops) {
                if (this.schemes.contains("ws") || this.schemes.contains("wss"))
                    operation.hasWSScheme = true;
                if (this.schemes.contains("http") || this.schemes.contains("https"))
                    operation.hasHttpScheme = true;
                for (CodegenResponse response : operation.responses)
                    if (response.isMapContainer)
                        response.baseType = typeMapping.get(((MapProperty) response.schema).getAdditionalProperties().getType());
            }
        }
        return operations;
    }
}
