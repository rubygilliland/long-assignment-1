# music library
Music library app for long assignment #1

This program simulates a music streaming app from a user perspective using a string-based UI.

HOW TO RUN PROGRAM:
1. Project -> Clean... -> Clean
2. Open LA1/view/Main.java
3. Run as Java Application

Saved Data:
- users.txt contains user login info (salted and hashed) as well as user library data.
- albums.txt contains names of all albums and their artists'
- all other txt files contain the songs, year, title, and artist for each album available in the app.

HOW TO USE PROGRAM:
1. Run the program and type "sign up" to create your user login.
2. Enter in your username and password. Press enter to successfully create a login.
   - Remember username and password to re-access music library after logging out.
3. Enter in a number (1-17) to perform any of the various commands listed.
  - "Search songs", "Search albums", and "Browse" can be done for the whole app music library or in your user library.
  - You can search by title, genre, or artist under any search command.
  - "Rate songs" allows you to rate songs in your library. Songs rated 5 stars are automatically added to "Favorites" playlist.
  - "Top Rated" playlist contains all songs rated 4 and 5 stars.
  - "Recently Played" and "Frequently Played" playlists are automatically created and contain 10 most recent/frequently played songs.
  - Genre playlists are automatically created when 10+ songs of the same genre are added to the users library.
  - After command is completed, hit Enter to return to the main menu.
  - Albums can be added to app music library by the creation of a txt file in the same format as all other album files and its addition to the albums.txt file.
  - Words must be spelled correctly in order for the program to properly function.
  - After exiting the program, you can type "login" to re-access your music library.
