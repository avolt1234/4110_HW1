# 4110_HW1
First project of CEG 4110

<b>Random colors and drawing</b>

This application is my first attempt at the first homework for CEG 4110 at Wright State University. This project was meant to give the students a nice introductory lesson in working with a
mobile development environment. Additionally, this homework was to prepare the students for the semester long group project. The application is broken down into 2 parts. The first part
is an activity that allows users to enter specific text and change the color of that text to a random color. The second activity allows users to draw images on their screen in the color of their choice.
Additionally, the user can clear the drawing screen and save the drawing in their phone.  


# MainActivity (Activity 1: Text entry with random color change)

MainActivity is the initial driver program for this project

Users can input any specific text in the text area in the top of the screen, selecting "COLOR CHANGE" will change the color of the text to a randomly generated color. Underneath the "CHANGE COLOR" button, the new RGB and hex values will display what random color was generated

The random color is generated by the chooseColor(), which creates an int array and String array both of length 3. Inside chooseColor(), a random number is generated 3 times and put into the int array, these will become our R, G, and B values. The hexidecimal String is created by calling Integer.toHexString(), where the integers are cast into hex values. These hex values are then put into a single string

The creation of the displayed color values are set by calling changeColorText(int[] colors2, String hexNum). This creates the string of RGB values by utilizing Integer.toString(), it then sets the TextView to the values created in changeColorText.

To change activities to drawing, selecting the "Scribbles" button will create Intent intent = new Intent(this, Main3Activity.class); and startActivity(intent) to transition into the second activity.

# Main3Activity (Activity 2: Drawing on screen)

Main3Activity is the second activity of the application that allows users to draw on the screen, change the color of the drawing, clear the drawing, and save the drawing. 

The drawing canvas implements a pre-existing library from https://github.com/ByoxCode/DrawView which allows users to draw on the screen. The screen is portioned off so that approximately 3/4 of the screen can be drawn on, the rest of the screen contains the buttons for manipulating the draw view. Instructions on how to include the library will be included below.

When a user presses the "COLOR" button, OpenColorPicker(boolean) is called. The color picker was utilized from another github library https://github.com/yukuku/ambilwarna, the library allows users to pick a color from a color palette. When the user selects the "OK" button on the color pallete, the variable DefaultColor is set to the color that the user has chosen. This color will be displayed when the user draws on the drawview.