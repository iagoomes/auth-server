# Build stage
FROM maven:3.9.9-amazoncorretto-21 AS build

# Copia o arquivo pom.xml e o código-fonte para o container
COPY pom.xml /app/
COPY src /app/src

# Executa o build do projeto, ignorando os testes
RUN ["mvn", "-f", "/app/pom.xml", "clean", "package", "-Dmaven.test.skip=true"]

# Run stage
FROM amazoncorretto:21

# Define o nome do JAR gerado
ARG JAR_NAME="auth-server-0.0.1-SNAPSHOT.jar"

# Copia o JAR gerado para o container
COPY --from=build /app/target/${JAR_NAME} /app/${JAR_NAME}

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/auth-server-0.0.1-SNAPSHOT.jar"]