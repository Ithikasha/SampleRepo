# -------- Stage 1: Build with Maven --------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside the builder container
WORKDIR /app

# Copy all files to the container
COPY . .

# Build the project and skip tests for faster build
RUN mvn clean package -DskipTests

# -------- Stage 2: Run the built JAR --------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built files from the builder image
COPY --from=build /app/target /app/target

# Default command to run your main class
CMD ["java", "-cp", "target/classes:target/dependency/*", "com.SiteMonitoring.SiteMonitoring"]
