# Quiz App

A simple Java console quiz application backed by an SQLite database. The application displays available quiz categories, lets the user choose a category, presents its questions, and prints the final score.

## Requirements

- Java 26 or newer
- Maven
- An SQLite database configured through `.env`

The database should contain:

- A `Category` table with a `Cate` column
- A `Quiz_qustions` table with `Cate_ID`, `Qustion`, `Option_1`, `Option_2`, `Option_3`, `Option_4`, and `Answer` columns

## Run

From the project directory, run:

```bash
mvn clean compile
mvn exec:java
```

Alternatively, run the `com.mycompany.quiz_app.Quiz_App` main class from your IDE.

When prompted, enter a category ID and then the number of the answer for each question.

## Project Structure

```text
src/main/java/
└── com/mycompany/
    ├── quiz_app/Quiz_App.java       # Application entry point
    └── Quiz_DataBase/ConnDB.java    # SQLite connection and quiz logic
```

## Configuration

Create a `.env` file in the project root with the SQLite database URL:

```env
DATABASE_URL=jdbc:sqlite:/D:/SQLite/Quiz_Database.db
```

`.env` is ignored by Git because it contains local configuration. Use `.env.example` as a template when setting up the project on another machine.

## License

This project does not currently specify a license.