# TRA Platform (Spring Boot backend)

This repo is a Java / Spring Boot backend API for the TRA (Telehealth Readiness Assessment) tool.

It serves a REST API that:

- returns the questionnaire (domains + questions)
- creates a session
- saves / loads session answers

The app runs on port `9090` by default.

## What you need

- Java 8 (this project targets Java `1.8`)
- A MySQL database

This repo includes the Maven Wrapper (`mvnw`), so you do not need to install Maven.

## Setup (database)

By default the app uses the `loc` Spring profile:

- `src/main/resources/application.properties` sets `spring.profiles.active=loc`
- `src/main/resources/application-loc.properties` contains the local MySQL connection settings

### 1) Create a local database

Create a database named `tra_two` (that is what the local profile uses).

### 2) Create tables + seed data

Run these SQL scripts (in this order):

- `src/main/resources/tra.create-tables.sql`
- `src/main/resources/tra.insert-tables.sql`

## Run the project

### Option A: Run with Spring Boot (recommended for local dev)

```bash
./mvnw spring-boot:run
```

### Option B: Build a jar and run it

```bash
./mvnw clean package
java -jar target/*.jar
```

When the app starts, it should be available at:

- `http://localhost:9090`

## Quick test (API endpoints)

These endpoints are defined in `TraController`:

- `GET /domains`
- `GET /questionnaire`
- `GET /start`
- `POST /save-session-data`
- `GET /session-data?id=<SESSION_ID>`
- `POST /reset-session`

Example:

```bash
curl http://localhost:9090/domains
```

## Configuration

- The port is configured in `src/main/resources/application.properties` via `server.port=9090`.
- Database settings for local dev are in `src/main/resources/application-loc.properties`.

If you need different settings, you can:

- edit `application-loc.properties`, or
- set `spring.profiles.active` to a different profile when starting the app.

## Run tests

```bash
./mvnw test
```
