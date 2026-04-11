# Desarrollo Local con Kafka

## 🚀 Inicio Rápido

### 1. Iniciar Kafka para desarrollo
```bash
# Opción 1: Batch script
./start-kafka-dev.bat

# Opción 2: PowerShell
./start-kafka-dev.ps1
```

### 2. Ejecutar el microservicio
```bash
cd apps/microservice-app-notification
mvn spring-boot:run
```

## 📋 Configuración

### Desarrollo Local
- **Kafka**: `localhost:9092`
- **Perfil**: default (sin perfil específico)

### Docker
- **Kafka**: `kafka:9092`
- **Perfil**: `docker` (activado automáticamente en Dockerfile)

## 🛑 Detener Kafka
```bash
docker-compose -f docker-compose.dev.yml down
```

## 🔧 Solución de Problemas

### Error: "UnknownHostException: kafka"
- **Causa**: El microservicio está intentando conectarse a `kafka:9092` pero Kafka no está corriendo o no es accesible
- **Solución**: Ejecuta `./start-kafka-dev.bat` para iniciar Kafka localmente

### Error: "Connection refused"
- **Causa**: Kafka no está corriendo en localhost:9092
- **Solución**: Verifica que Kafka esté corriendo con `docker ps | findstr kafka`

### Verificar Kafka
```bash
# Ver contenedores corriendo
docker ps

# Ver logs de Kafka
docker logs kafka-dev

# Probar conexión
docker exec -it kafka-dev kafka-console-producer --bootstrap-server localhost:9092 --topic test
```
