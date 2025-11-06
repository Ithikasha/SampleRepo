# Use the official Eclipse Temurin JDK image
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy all files from the repo into the container
COPY . .

# Build the project using Maven
RUN mvn clean package -DskipTests

# Set the entrypoint to run your main Java class
CMD ["java", "-cp", "target/classes:target/dependency/*", "com.Sitemonitoring.SiteMonitoring"]
