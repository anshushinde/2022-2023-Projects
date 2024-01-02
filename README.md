# Epic Quest: Adventuring Around Town
> I want to make a kingdom-wide treasure/scavenger hunt.  It will involve having people go through several locations to reach a winner spot before they reach a losing spot.  There will be certain limitations on the direction that can be moved from each location.  I need some help getting all the locations and implementing these types of rules.

### Objectives to complete
The Location and MainGame code you already have will be modified for this project.  A design plan will always be helpful.  The default map that must be started with is pictured on Schoology.

We should start by removing the `Q` exit ability from our `MainGame` code.

- Add this `Q` exit direction to the `Location` constructor, not as a parameter as code only
    - Each new location will have the `Q` location automatically coded to it
    - Remember since we are inside the `Location` class we don't need to `addExit` we can directly `put` an exit into the HashMap

We should modify our code to include the other locations being correctly added to the locations map.  We will be adding 7 new locations in total.
- Create 5 brand new locations.
- Add these to the `location` Map
    - provide them each with a valid id and description
- Create a winning location
    - if the user makes it here they have won the adventure
- Create a losing location
    - if the user enters here they have lost the adventure

Present the user with a welcome message describing the game.  It is a location choosing adventure where the user is trying to find the winning location to escape.  I don't know come up with some little story for this.

We should explain the rules to the user
- They will only be presented with directions they are allowed to leave when entering an area
- They only have so many movements to reach the winning location or else they lose (pick a number between 10-20)
    - They lose automatically if they ever enter the losing location

Inside the `while loop` from the starter code we should do the following
- Create a Map that shows the available exits at any given location
    - Think about how you can retrieve the added exits for any given Location, you have all the methods needed to do this, but will need to call them correctly
- Print out the available exits once retrieved and stored into the Map
    -  Can be done like we printed out the movie plots (using the keySet method)

Once we have displayed the exits for a given location we need to have the user start making choices.  This is still happening inside that `while loop`
- Allow the user to select a direction to go in
    - The user should be allowed to select a direction in either uppercase or lowercase
    - You should check to see if the location direction exists in the Map
        - If it does not let the user know
        - This can be done by updating the `if statement` from our example
        - You should remain in the same location if you cannot move in a particular direction
    - If the direction does exist (this is tied to updating that `if statement`)
        - Move the user to that location
        - You still want to keep the `location` variable except instead of assigning it to a Scanner input you will instead be assigning it the Integer value retrieved from the matching direction the user asked to go in

We should make a vocabulary Map above our loop that has the compass directions as the key and their single letters are the value.  This will allow the last requirement to be more easily implemented.

We want to provide more flexible movement for our user so instead of only typing single letter cardinal directions.  Allow the user to type in phrases and pull the direction from that phrase.
- You will need to use the `.split()` method to accomplish this easily
    - Split method creates an array out of the implicit parameter using the argument you pass in
        - `"The quick brown dog".split(" ")` would return a String[] with 4 items one for each word

The player should be allowed to say something like "run south" or "Go West" or just "North"
- Single-letter commands should still be available
