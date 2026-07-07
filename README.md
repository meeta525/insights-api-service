# Campaign Insights API

A Spring Boot 3 (Java 21) microservice that provides campaign insights for an AdTech platform. The service supports both real-time and historical queries, demonstrates multi-tenancy, retry handling for transient failures, and uses a containerized Cassandra instance for the realtime data store.

---

# Technology Stack

| Component                         | Technology |
|-----------------------------------|------------|
| Language                          | Java 21 |
| Framework                         | Spring Boot 3 |
| Database                          | Apache Cassandra |
| Historical Analytics Store (Demo) | JSON File (represents BigQuery in production) |
| API Documentation                 | Swagger / OpenAPI |
| Resilience                        | Resilience4j Retry |
| Build Tool                        | Maven |
| Containerization                  | Docker Compose |

---

# Architecture

```
                    Client
                       │
                       ▼
               Insights API Service
                       │
             ┌─────────┴─────────┐
             ▼                   ▼
   RealtimeMetricsService   HistoricalMetricsService
             │                   │
             ▼                   ▼
        Cassandra       historical-data.json
                       (BigQuery in Production)
```

---

# Features

- Real-time campaign insights
- Historical campaign insights
- Multi-tenant support
- Retry for transient Cassandra failures
- Global exception handling
- Swagger API documentation
- Dockerized Cassandra setup

---

# Project Structure

```
src
├── controller
├── service
│   └── impl
├── repository
├── entity
├── model
├── exception
├── constant
└── config

docker
├── schema.cql
└── data.cql

docker-compose.yml
README.md
```

---

# Prerequisites

- Java 21
- Maven
- Docker Desktop

---

# Running the Project

### Start Cassandra

```bash
docker compose up -d
```

### Run Spring Boot

```bash
mvn spring-boot:run
```

or run `InsightsApiApplication` from IntelliJ.

---

# Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

# Demo APIs

## Realtime

Header

```
X-Tenant-Id: amazon
```

Request

```
GET /ad/CAMP1001/clicks
```

---

## Historical

Header

```
X-Tenant-Id: amazon
```

Request

```
GET /ad/CAMP1001/clicks?from=2026-07-01&to=2026-07-07
```

---

# Sample Demo Data

| Tenant | Campaign |
|---------|----------|
| amazon | CAMP1001 |
| amazon | CAMP1002 |
| flipkart | CAMP1001 |
| flipkart | CAMP1002 |

---

# Retry Demo

Stop Cassandra

```bash
docker stop cassandra
```

Invoke

```
GET /ad/CAMP1001/clicks
```

The application retries three times before returning

```
HTTP 503 Service Unavailable
```

Restart Cassandra

```bash
docker start cassandra
```

---

# Design Decisions

## Why Cassandra?

- High write throughput
- Horizontal scalability
- Low-latency reads
- Well suited for real-time campaign metrics

## Why separate Realtime and Historical services?

Keeps responsibilities isolated.

- Realtime service reads live metrics from Cassandra.
- Historical service reads aggregated analytics from a JSON file (BigQuery in production).

## Why JSON?

The assignment focuses on service design rather than cloud integration.

The JSON file simulates historical analytics while keeping the project easy to run locally.

## Why Multi-tenancy?

Each request contains an `X-Tenant-Id` header to isolate retailer data.

---

# Future Improvements

- Replace JSON with BigQuery
- Add Circuit Breaker
- Kubernetes deployment

---

# Author

Meeta Srivastava