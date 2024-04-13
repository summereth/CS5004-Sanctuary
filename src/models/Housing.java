package models;

import java.util.List;

/**
 * A class representing housing of sanctuary, basically a group of primates. There are different
 * types of housing, each with different capacity. But all of them are capable of add and remove
 * models.Primate from it, and return a list or a String representing all primates inside the housing.
 */
public interface Housing<T> {
  /**
   * Add a primate into this housing. Capacity will be checked before adding. IllegalStateException
   * will be thrown if capacity is not allowed to do such addition.
   *
   * @param p models.Primate to be added
   */
  void add(Primate p) throws IllegalStateException;

  /**
   * Remove the given primate from the housing. IllegalArgumentException will be thrown if there's
   * no such a primate.
   *
   * @param p Given primate to be removed from the housing.
   */
  void remove(Primate p) throws IllegalArgumentException;

  /**
   * Get a list of primates that is currently housed there. If the housing is isolation, it returns
   * a list of models.Primate, while models.Enclosure returns a list of Set of models.Primate
   *
   * @return A list of String representing all primates housed there
   */
  List<T> getPrimates();

  /**
   * Get a list of primates that is currently housed there. The list only includes the name of
   * primates.
   *
   * @return A list of name of all primates housed there.
   */
  List<String> getPrimatesName();

  /**
   * Get all primates that is currently housed there in String, which contains information of the
   * housing(type, species, etc) and primates' name, sex and favorite food.
   *
   * @return a String representing all primates housed there
   */
  String getPrimatesStr();

  /**
   * Returns ture if current housing contains the given primate. Otherwise, returns false
   *
   * @param p Given primate to check if it's housed by current housing
   * @return if the given primate is housed by current housing
   */
//  boolean contains(Primate p);

  Primate find(String name);
}
