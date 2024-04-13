# README

## Overview

Following MVC architectural pattern, we are required to design an application with GUI, which
helps a sanctuary with its daily primates record demands.

## Features

1. Register a new primates with basic information (including name, sex, species, weight, size, age,
   favorite food), and allocate them into isolation.
2. Move a primate into the correct enclosure (grouped by species) after it finishes its isolation.
   Unhealthy primates can't be moved into enclosure without treatment.
3. Primates can receive treatment in isolation.
4. Primates can be moved to isolation when medical care is required.
5. There are 20 isolation cage and 8 enclosure cage. Each isolation cage accommodate 1 primate,
   while
   each enclosure cage accommodate as many as primates of the same species. Users are not allowed to
   register a new primate or move primates from enclosure to isolation if isolation cages are all
   full.
6. Display statistic data of housing occupancy.
7. Display a list of all primates in alphabetical order.
8. Display a list of all primates housed in isolation and enclosure (grouped by species)
   respectively.

## Instruction to Run the JAR File

### Create a run configuration

1. Press `⌘ Сmd` `⇧ Shift` `A` , find and run the **Edit Configurations** action. Or open the menu
   on the top right of the toolbar shown in the following picture and select **Edit Configurations
   **.
2. In the **Run/Debug Configurations** dialog, click + (the add button) and select **JAR Application
   **.
3. Add a name for the new configuration.
4. In the **Path to JAR** field, click 📁 (the Browse/File button) and specify the path to the JAR
   file on your computer, which should be "/thePlaceYouDownloadMyFolder/res/project06.jar"
5. Under **Before launch**, click + (the Add button), select **Build Artifacts** in the dialog that
   opens.
   Doing this means that the JAR is built automatically every time you execute the run
   configuration.

### Execute the run configuration

- On the toolbar, select the created configuration and click the Run button to the right of the run
  configuration selector. Alternatively, press `⌃Ctrl` `R` if you prefer shortcuts.

As before, the **Run** tool window opens and shows you the application output.

## Interaction

1. Register: Fill in the information in register form and click `Register` button. Your primate will
   be created and allocated into isolation. You can check it in `List of All Primates`
   and `Isolation
   section`.
   ![img_1.png](assets%2Fimg_1.png)
2. List of primates housed in isolation will be displayed in `Isolation section`. You can also
   select
   a primate to treat it or move it to Enclosure. Please note that **unhealthy primate can't be
   moved to
   Enclosure without treatment**. Basically you need to treat it first before moving it to enclosure
   if
   the primate is receiving medical care. **You can move newly-registered primate to Enclosure
   without
   treatment**.
3. List of primates housed in enclosure will be displayed in `Enclosure section`. Primates housed in
   different enclosure cage (different species) will be displayed separately. You can give medical
   care
   to a primate by selecting it and click the `Medical Care` button, which would move the primate to
   isolation.
   ![img_2.png](assets%2Fimg_2.png)

## Changes of MVC vs Original Design

### Model

1. Instead of directly print out feedback to users with `System.out`, Model doesn't consider on
   information display anymore, but simply returns data and throws exception.
2. `Primate` Class: remove constructors no longer in use
3. `Housing` Interface: deprecated `contains(Primate p)` method and add `find(String name)` method
4. `Sanctuary` Class: add some methods to return data. Methods are modifies based on Item 1.

### Controller

1. Add a controller to interact between Model and View. It calls methods in Model to execute
   functionality and tells View to display accordingly.
2. It contains 2 types of methods. One is event-handlers for buttons, and the other one is data
   loading and displaying.

### View

1. Set up a view by the use of Java Swing. The view contains sections:
    - Display statistic data
    - Display feedback to users. Similar to a message dialogue
    - A form to register a primate
    - A list of all primates housed in the sanctuary
    - A list of all primates in isolation. And interaction area with those primates
    - A list of all primates in enclosure. And interaction area with those primates
2. Methods to update certain components according to data provided by controller. A method to add
   features (event handlers from controller) to buttons.

## Assumption

1. Primates can't be removed from the sanctuary once registered
2. Primates must be treated first before the end of isolation
3. All information must be provided (without left empty) when users register a primate

## Limitation

- Feature-wise, the program doesn't allow different primates housed in sanctuary use the same name.
  The reason is that we basically use the `name` attribute of `Primate` to find the correct object
  to manipulate.

- And this implementation also adds some limitation on the scalability of this program, since linear
  search (Time Complexity `O(n)`) is involved.

- An improvement on this would be to utilize the `getSelectedItemIndex()` method and directly fetch
  the object by the index.

## Citation

- [Markdown Cheat Sheet](https://www.markdownguide.org/cheat-sheet/)