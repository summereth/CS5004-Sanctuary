package controllers;


import enums.*;

/**
 * Controller of Sanctuary Application, which calls methods in Model to execute function and fetch
 * data, and tells views to change display accordingly.
 */
public interface SanctuaryControllerInterface {

  /**
   * Register a primate in sanctuary and house it in isolation.
   *
   * @param name         Name of the primate. Name should be unique in sanctuary
   * @param sex          Sex of the primate.
   * @param species      Species of the primate.
   * @param size         Size of the primate
   * @param weight       Weight of the primate
   * @param age          Age of the primate
   * @param favoriteFood Favorite food of the primate
   */
  void register(String name, Sex sex, Species species, String size, String weight, String age,
                Food favoriteFood);

  /**
   * Fetch statistical data from Model and display data accordingly in GUI.
   */
  void loadStats();

  /**
   * Fetch a list of names of all primates from Model and display data accordingly in GUI.
   */
  void loadAllPrimates();

  /**
   * Fetch a list of primates housed in Isolation from Model and display data accordingly in GUI.
   */
  void loadIsolationList();

  /**
   * Fetch a list of primates housed in Enclosure from Model and display data accordingly in GUI.
   */
  void loadEnclosureList();

  /**
   * Call Model to treat a primate and update views accordingly. After treated, the primate will
   * become healthy again.
   *
   * @param name Name of the given primate
   */
  void treat(String name);

  /**
   * Call Model to move a primate to enclosure and update views accordingly.
   *
   * @param name Name of the given primate
   */
  void moveToEnclosure(String name);

  /**
   * Call Model to move a primate to isolation and update views accordingly.
   *
   * @param name Name of the given primate
   */
  void moveToIsolation(String name);

  /**
   * Start the application
   */
  void go();

}
