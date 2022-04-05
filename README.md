# Autovermietung-PRG3

Autovermietung JavaFX-Desktop-Anwendung auf Basis von Maven

## Hintergrund

Dieses Projekt begann als Hochschulprojekt während unseres Bachelorstudiums im Rahmen der Klasse *Programmierung 3* an der [Hochschule für Technik und Wirtschaft in Saarbrücken](https://www.htwsaar.de/). Das Ziel ist, sich mit der UI-Programmierung vertraut zu machen.

## Stack

- Java 17
- JavaFX
- Maven

## Getting Started

### Building from Source

We use Maven for building the source code. Run the following command to compile with tests:

```sh
mvn clean verify
```


### Running the Application

We can make use of JavaFX Maven plugin to start the application like so:

```sh
mvn javafx:run
```