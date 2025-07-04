# Utilise une image Java officielle
FROM openjdk:17-jdk-alpine

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le JAR généré dans le conteneur
COPY target/*.jar app.jar

# Expose le port utilisé par Spring Boot (par défaut 8080)
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"] 