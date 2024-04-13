package views;


import java.awt.*;

/**
 * The GUI view interface for Sanctuary Application. The view provides functions to allows
 * controller to manipulate some of its components to display information given by Model.
 */
public interface View {

  /**
   * reset all inputs in register section.
   */
  void resetAllInputs();

  /**
   * Set output and display to user, which is basically a label. You can display feedback to user's
   * interaction here.
   *
   * @param text  feedback in String to users
   * @param color color of the text to be displayed
   */
  void setOutput(String text, Color color);

  /**
   * Set statistic section with given text
   *
   * @param text Text containing statistical information to be displayed to users
   */
  void setStats(String text);

  /**
   * Set information in All Primate section
   *
   * @param text information (Names of all primates in alphabetical order) to be displayed here
   */
  void setAllPrimates(String text);

  /**
   * Set information in isolation list section
   *
   * @param texts information (Names, Sex, Favorite food) of primates who is housed in isolation.
   */
  void setIsolationList(String... texts);

  /**
   * Set information in enclosure list section
   *
   * @param texts information (Species, Names, Sex, Favorite food) of primates who is housed in
   *              enclosure.
   */
  void setEnclosureList(String... texts);

  /**
   * Set the options in the JComboBox component, so that users can select a primate to be treated
   *
   * @param options Primates that is housed in isolation
   */
  void setTreatSelection(String... options);

  /**
   * Set the options in the JComboBox component, so that users can select a primate to be moved to
   * enclosure.
   *
   * @param options Primates that is housed in isolation
   */
  void setMoveToEnclosureSelection(String... options);

  /**
   * Set the options in the JComboBox component, so that users can select a primate to be moved to
   * isolation and ready for medical care.
   *
   * @param options Primates that is housed in enclosure
   */
  void setMedicalCareSelection(String... options);

}
