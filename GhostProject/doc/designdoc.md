# Ghost: a game for Android 
#### Design document.
By: Paul Schrijver

This document is complementary to the [readme](https://github.com/pschrijver/appstudio/tree/master/GhostProject).

###Sketches with annotations

#### Initial startup (screen 1)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/initialstart.jpg)

Initial start requires entering the player names.
* Two text fields, one for each name.
* Usage of [autocomplete](http://developer.android.com/guide/topics/ui/controls/text.html) to suggest a name that has been entered before. No spinner will be used like described in the sketch.
* Autocomplete will use names entered before. Names will be stored in [SharedPreferences](http://developer.android.com/training/basics/data-storage/shared-preferences.html) and retrieved from SharedPreferences.
* Start game will use the general class for starting a new game.

#### Active game found on startup (screen 2)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/gamefound.jpg)

If the app was closed while a game was being still in progress it will ask on startup to continue that game.
* Game state will be both stored and retrieved from SharedPreferences.
* Game state will be stored as 'game session'.
* Check of SharedPreferences on startup: if game session is found this screen will appear. Otherwise screen 1 is displayed.
* Game session will be deleted after a game is done.
* Game session will be deleted if user chooses a new game.
* Upon choosing new game screen 1 will be displayed.

#### Game screen (screen 3)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/ghost.jpg)

* Displayed scorekeeping in sketch no longer relevant (won't be available).
* Textview with current player.
* Textview with letters that have been chosen.
* Textfield for picking new letter.
* Chosen letters and current player both stored in game session.

#### Options menu (screen 4)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/menu.jpg)

The options menu will be displayed at all the times in the upper right corner.
* Restart round starts a new game with current names.
* Choose language leads to screen 7.
* Higschores leads to screen 6.
* Change name leads to screen containing text fields with entered names.


#### Game finished (screen 5)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/gameover.jpg)

* Higscore is updated in SharedPreferences containing highscores.
* Winning word is displayed from the game session.
* Game session is destroyed.
* Highscores button leads to screen 6.

#### Highscores (screen 6)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/highscores.jpg)

Highscores are pairs of strings (names) and integers (score). Every name will have a score of 0 by default. After each win of a certain name the score is updated by +1.
* Highscores are stored in SharedPreferences.


#### Change language (screen 7)

![](https://raw.githubusercontent.com/pschrijver/appstudio/master/GhostProject/doc/changelanguage.jpg)

The language can be set in either Dutch or English. This setting controls the dictionary. Since the dictionary is built on startup changing will require restart.
* Language is stored in SharedPreferences.
* If no preference is set the default Android language is used.

### Data storage
All data is stored using [SharedPreferences](http://developer.android.com/training/basics/data-storage/shared-preferences.html). This will include:
* Names. A complete list of all previously entered names.
* Game session. This has all data needed to represent a game: player names, player turn, entered letters.
* Higscores. All names + scores.
* Language preference.

### Model classes
I will be using the following two default classes that are described [here](http://apps.mprog.nl/project/week-3-model-classes).
* Dictionary class.
    *filter: this method takes a string as input and filters the word list using this string. Because loading the dictionary takes quite a bit of time, this method should not destroy the base dictionary and thus allows it to be re-used.
    *count: this method returns the length of the words remaining in the filtered list.
    *result: this method returns the single remaining word in the list. Obviously, this method can only be called if count returns the number 1.
    *reset: to remove the filter and re-start with the original dictionary.

* Game class.
    *guess: this method takes a string as input, representing the letter that the current player has guessed. It uses the Dictionary instance to decide
    *turn: this method returns a boolean indicating which player is up for guessing.
    *ended: this method returns a boolean indicating if the game has ended.
    *winner: this method returns a boolean indicating which player has won the game. This method can obviously only make sense if ended returns true.

Others classes and methods will be:
* Game state ('session') saving.
	* Save following information:
	* Player names
	* Player turn
	* Entered letters.
* Game check. To check if a game is present.
	* Check game session presence (return true/false)
	* If present call activity screen 2
	* If not active call activity screen 1
* Name saving and retrieving.
* Highscore saving and retrieving.
* Language saving.
