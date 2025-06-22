# Movie-Streem-Backend

A Spring Boot backend for a movie streaming platform. It manages movies, user ratings, and content metadata, supporting polymorphic content types.

## Features

- Add, update, and retrieve movies and other content
- Store movie details: title, genre, duration, language, release year, thumbnail, video URL, and ratings
- Polymorphic content model using JPA inheritance
- RESTful API endpoints for content management
- User ratings and featured content support

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- H2/MySQL/PostgreSQL (configurable)
- Lombok
- Jackson (for JSON serialization/deserialization)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven or Gradle
- (Optional) MySQL/PostgreSQL database

### Setup

1. Clone the repository:

2. Configure database in `src/main/resources/application.properties`.

3. Build and run:
   or

### API Usage

#### Add a Movie

POST `/api/content`

**Request Body:**

#### Get All Content

GET `/api/content`

#### Example cURL


### Project Structure

- `model/` - JPA entities (`Content`, `Movie`, `Rating`, etc.)
- `controller/` - REST controllers
- `repository/` - Spring Data repositories
- `service/` - Business logic

### Polymorphic Content Model

The `Content` class is abstract and uses Jackson annotations for polymorphic deserialization. Add `"type": "movie"` in your JSON to specify the subclass.

### License

MIT

---

For more details, see the source code and API documentation.
