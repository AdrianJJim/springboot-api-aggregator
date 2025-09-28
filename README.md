# 🔀 API Aggregator

API Aggregator es un backend desarrollado con **Spring Boot** que consume varias APIs públicas (clima, noticias y Wikipedia) y expone una única API REST limpia.

---

## 📦 Estructura del Proyecto

| Carpeta      | Descripción                                      |
| ------------ | ------------------------------------------------ |
| `/config`    | Configuración de seguridad, cache y Feign Clients |
| `/controller`| Endpoints REST                                   |
| `/service`   | Lógica de negocio y agregación                   |
| `/client`    | Feign Clients de APIs externas                   |
| `/dto`       | Objetos de transferencia de datos                |

---

## 🚀 Cómo ejecutar el proyecto

### ✅ Requisitos previos

Antes de ejecutar la aplicación asegúrate de tener instalado:
- Java 17 o superior
- Maven
- Docker y Docker Compose

### 🔧 Configuración paso a paso

1. Clonar el repositorio

```
git clone https://github.com/AdrianJJim/springboot-api-aggregator
cd api-aggregator
Configurar las variables en src/main/resources/application.properties:

properties
Copiar código
# Claves de APIs externas
api.weather.key=YOUR_WEATHER_API_KEY
api.news.key=YOUR_NEWS_API_KEY
api.wiki.url=https://en.wikipedia.org/api/rest_v1/page/summary/

Ejecutar el backend


./mvnw spring-boot:run
💡 El backend estará disponible en: http://localhost:8080

📖 API Reference
📰 News API
Método	Endpoint	Parámetros	Descripción
GET	/api/news	city (query, string, requerido)	Devuelve las últimas noticias de la ciudad

Ejemplo:

GET http://localhost:8080/api/news?city=Madrid
☀️ Weather API
Método	Endpoint	Parámetros	Descripción
GET	/api/weather	city (query, string, requerido)	Devuelve el clima actual de la ciudad

📚 Wikipedia API
Método	Endpoint	Parámetros	Descripción
GET	/api/wiki	city (query, string, requerido)	Devuelve datos básicos de Wikipedia sobre la ciudad

🔀 Aggregator API
Método	Endpoint	Parámetros	Descripción
GET	/api/aggregate	city (query, string, requerido)	Devuelve clima, noticias y wiki en una sola respuesta
