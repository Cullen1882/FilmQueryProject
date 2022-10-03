# FilmQueryProject

## Description
The Film Query Project presents a user with a menu that allows them to search for a film in a database by its ID or by a keyword in the title or film's description. The user will continue to have access to the menu and its database until the user chooses to exit the menu.

##Lessons Learned
Two of the biggest lessons I learned during this project had to do with instantiating an object inside of another object. The actor and film class both had information about actors and film but also had lists of other objects inside them. An example of this is that while a film has an id, title, length etc it also has a list of Actor objects that represent its cast. Up until this project, I wasn't completely sure how this relationship worked but through this project, I feel I have solidified my understanding of it.
The second lesson I learned had to do with avoiding recursion in my method calls. Because my Actor objects or partially made up of lists of films in which they've starred and my film objects are partially made up of a list of Actors (cast) I needed to make sure that my methods that provided the two didnt require input that would ultimately put itself in a loop.

##Technologies Used
Git, GitHub, Eclipse, mySql
