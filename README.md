# Quiz App

A simple Java console quiz application backed by an SQLite database. The application displays available quiz categories, lets the user choose a category, presents its questions, and prints the final score.

## Requirements

- Java 26 or newer
- Maven
- An SQLite database at `D:/SQLite/Quiz_Database.db`

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

The SQLite database path is currently defined in `ConnDB.java` as:

```text
jdbc:sqlite:/D:/SQLite/Quiz_Database.db
```

Update that path in `ConnDB.java` if your database is stored elsewhere.

## License

This project does not currently specify a license.