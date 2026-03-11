# TMDB CLI Movie App

A simple **Command Line Interface (CLI)** application built using **Java** that fetches movie data from **The Movie Database API** and displays movie titles in the terminal.

This project demonstrates working with:

* REST APIs
* JSON data parsing
* Java HTTP Client
* Building a simple CLI application

---

# Features

* Fetch movies from TMDB API
* Display only **movie titles**
* Support multiple movie categories
* Simple command-line interaction
* Basic error handling for network/API failures

---

# Supported Movie Categories

| Input    | Description        |
| -------- | ------------------ |
| playing  | Now playing movies |
| popular  | Popular movies     |
| top      | Top rated movies   |
| upcoming | Upcoming movies    |

---

# Technologies Used

* Java 11+
* HTTP Client (java.net.http)
* JSON parsing using **Gson**
* TMDB REST API

---

# Project Structure

```
tmdb-cli-app
│
├── src
│   └── org.example
│        └── Main.java
│
├── pom.xml
└── README.md
```

---

# Prerequisites

Before running the project make sure you have:

* Java 11 or higher installed
* Maven installed
* A TMDB API key

---

# Getting TMDB API Key

1. Visit the **The Movie Database website
2. Create an account
3. Go to **Account Settings**
4. Generate your **API Key (v3 auth)**

Paste the API key inside the `Main.java` file.

Example:

```java
private static final String API_KEY = "YOUR_API_KEY";
```

---

# How to Run the Application

### 1 Clone the repository

```bash
git clone https://github.com/yourusername/tmdb-cli-app.git
cd tmdb-cli-app
```

---

### 2 Build the project

```bash
mvn clean install
```

---

### 3 Run the program

```bash
java -jar target/tmdb-cli-app.jar
```

---

# Example Usage

When the program runs, it will ask for the movie type:

```
Choose movie type:
playing | popular | top | upcoming
Enter type:
```

Example input:

```
popular
```

---

# Example Output

```
Movies:

1. Dune: Part Two
2. Oppenheimer
3. Spider-Man: Across the Spider-Verse
4. The Batman
5. Avatar: The Way of Water
```

---

# Error Handling

The application handles the following errors:

* Invalid movie type input
* API request failures
* Network connection problems
* Invalid API key

Example error:

```
Network Error: Unable to connect to the server.
```

---

# Possible Improvements

* Display movie ratings
* Show release dates
* Add pagination support
* Improve CLI formatting
* Add search functionality

---
