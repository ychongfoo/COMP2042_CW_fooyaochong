# COMP2042 Software Maintenance Frogger Game

### ![Title](src/main/resources/title.png)

### Added
1. Main Menu
2. Info
3. Levels
4. Director
5. HighScores

### Changes made
1. Restructured the classes into packages of the same type.
2. Integrated _**Gradle**_ - Gradle Build files were added for easier 
  build process.
3. Simplified logic within classes:
    * if else -> switch statements.
    * Repetitive codes are refactored into constants such as path directory
      for better modifications.
    * Some classes such as Car and Truck with repetitive codes were abstracted into 
      separate methods in ***Obstacle class*** for easier modification.
4. ***Main.java*** no longer adds child nodes to the root node.
5. Uses of constant variables instead of hardcoded arbitrary numbers. Numbers such 
    as rows are stored into variables that specify the y-position of each row.
6. Highscores for each level are now stored as a permanent list in separate CSV files.
    ***SetHiScore*** sets the HighScore from the player who wins the specific level.
   ***DisplayHiScore*** displays a popup window that display the Player's name and highscore
   and all the previous highscores from different players of that level.
   
