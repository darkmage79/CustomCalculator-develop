# Statistics Calculator
########################################################################################################
###############################  What do each of these files do  #######################################
########################################################################################################

# Java files:

	CalcBase.java 
		- stores all the different functions for Math, displaying calculations, and showing history

	Calculations.java
		- gets the calculation by the title of the calculation
		- creates the constructor for the fragments
		- returns the fragment that is being used
	
	*Fragment.java
		- Fragments are what we use to create different functions that do different things
		- "A Fragment is a piece of an application's user interface or behavior that can be placed in an Activity"
	

# XML files:
	
	activity_home_drawer.xml
		- this is the menu that shows all of the fragments to the user
	
	fragment_*.xml
		- xml fragments are what the java fragments uses as a front end. This is what you see on the screen
			when you click on the different functions.
	
	
	strings.xml
		- stores the names of all of the strings so it is a centralized location to store names of everything.
			(This keeps things consistent and easy)
			
	arrays.xml	
		- keeps the item arrays for the selector menus inside each of the fragments, can be used for more too
		
		
		
########################################################################################################
###############################     Once you add a Fragment      #######################################
########################################################################################################

				(You need to add a fragment_(FRAG_NAME).xml as well as the java fragment)

# Java files:
	
	1. Calculations.java
		- Add the import for the file
		- Add the enum name to the enum "Calculations"
		- Add the if statement to get the calculation by the title of the calculation
		- Add the if statement to get the fragment by the name of the calculation

	
	
# XML files:
	
	2. strings.xml
		- Add a string name for the fragment you created, so we can refer to this if we want to change any string names
		- If you made a new category entirely for the fragment, also add the string name for that too so we can use it to 
			separate the categories in the activity_home_drawer.xml

	3. activity_home_drawer.xml
		- Add the fragment item to the menu so that it shows up with the rest of the functions on the drawer along with the send button
		
