# Use lightweight Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/ProductFiltering-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render/Railway uses PORT env)
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]