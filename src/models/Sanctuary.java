package models;

import java.util.*;

import enums.Food;
import enums.Sex;
import enums.Species;

/**
 * A class representing sanctuary, which provides different types of housing for primates.
 */
public class Sanctuary {
  private Isolation isolation;
  private Enclosure enclosure;

  public Sanctuary(int isolationSize, int enclosureSize) {
    isolation = new Isolation(isolationSize);
    enclosure = new Enclosure(enclosureSize);
  }

  /**
   * Create a primate object and put it in isolation. Throws IllegalArgumentException if trying to
   * register a primate with the same name. Throws IllegalArgumentException if given parameters
   * are not valid. Throws IllegalStateException if isolation is full.
   *
   * @param name         A String of primate's name
   * @param sex          sex of the primate
   * @param species      species of the primate
   * @param size         size of the primate
   * @param weight       weight of the primate
   * @param age          age of the primate
   * @param favoriteFood favorite food of the primate
   */
  public void register(String name, Sex sex, Species species, String size, double weight, int age,
                       Food favoriteFood) {
    if (getAll().contains(name))
      throw new IllegalArgumentException("There is already a primate with the same name in the sanctuary");
    Primate p = new Primate(name, sex, species, size, weight, age, favoriteFood);
    isolation.add(p);
  }

  /**
   * Give medical care to a given primate, which will be housed in isolation housing. Throw
   * IllegalArgumentException if the given primate is not found or is already in isolation. Throw
   * IllegalStateException if the isolation is full.
   *
   * @param name The name of given primate to receive medical care
   */
  public void medicalCare(String name) throws IllegalArgumentException, IllegalStateException {
    if (enclosure.find(name) == null && isolation.find(name) == null)
      throw new IllegalArgumentException(name + " is not housed in our sanctuary");
    Primate p = isolation.find(name);
    if (p != null) {
      p.sick();
      throw new IllegalArgumentException(name + " is already in isolation cage and ready for medical care!");
    }

    p = enclosure.find(name);
    p.sick();
    isolation.add(p);
    enclosure.remove(p);
  }

  /**
   * Cure a primate which is already housed inside isolation. Throw IllegalArgumentException if the
   * given primate is not found
   *
   * @param name The name of given primate to receive medical care
   */
  public void treat(String name) {
    if (enclosure.find(name) == null && isolation.find(name) == null)
      throw new IllegalArgumentException(name + " is not housed in our sanctuary");
    Primate p = enclosure.find(name) == null ? isolation.find(name) : enclosure.find(name);
    if (p.isHealthy())
      throw new IllegalArgumentException(name + " is healthy! No need any more treatment");
    p.cure();
  }

  /**
   * Finish medical care or isolation to the given primate. The primate will be freed from isolation
   * cage and accommodated into enclosure cage. Throw IllegalArgumentException if the given primate
   * is not found or the given primate is already in enclosure. Throw IllegalArgumentException if
   * the given primate is unhealthy and thus not allowed to move in enclosure. Throw
   * IllegalStateArgument if the enclosure is full.
   *
   * @param name The name of given primate who finished his isolation/medical care
   */
  public void finishIsolation(String name) {
    if (enclosure.find(name) != null)
      throw new IllegalArgumentException(name + "has already finished isolation!");
    Primate p = isolation.find(name);
    if (p == null)
      throw new IllegalArgumentException(name + "is not housed in our sanctuary");
    enclosure.add(p);
    isolation.remove(p);
  }

  /**
   * Get a list of all primates in each enclosure housing, containing information of their name, sex
   * and favorite food
   *
   * @return a list of all primates in the enclosure housing
   */
  public List<List<String>> getEnclosure() {
    List<List<String>> primates = new ArrayList<>();
    List<Set<Primate>> fromAllEnclosure = enclosure.getPrimates();
    for (Set<Primate> singleEnclosure : fromAllEnclosure) {
      List<String> primatesInEnclosure = singleEnclosure.stream().map(Primate::toString).toList();
      primates.add(primatesInEnclosure);
    }
    return primates;
  }

  /**
   * Get a string of all primates in the enclosure housing, containing information of their name,
   * sex and favorite food
   *
   * @return a string of all primates in the enclosure housing
   */
  public String getEnclosureInStr() {
    return enclosure.getPrimatesStr();
  }

  /**
   * Get a list of all primates in the isolation housing, containing information of their name, sex
   * and favorite food
   *
   * @return a array of all primates in the isolation housing
   */
  public String[] getIsolation() {
    List<Primate> primates = isolation.getPrimates();
    return primates.stream().map(Primate::toString).toArray(String[]::new);
  }

  /**
   * Get a string of all primates in the isolation housing, containing information of their name,
   * sex and favorite food
   *
   * @return a string of all primates in the isolation housing
   */
  public String getIsolationInStr() {
    return isolation.getPrimatesStr();
  }

  /**
   * Produce an alphabetical list (by name) of all of the monkeys housed in the models.Sanctuary.
   *
   * @return a list of names of all housed primates
   */
  public List<String> getAll() {
    List<String> all = new ArrayList<>();
    all.addAll(isolation.getPrimatesName());
    all.addAll(enclosure.getPrimatesName());
    Collections.sort(all);
    return all;
  }

  /**
   * @return the number of primates currently stayed in isolation
   */
  public int getIsolationNum() {
    return isolation.primatesNum();
  }

  /**
   * @return the number of primates currently stayed in enclosure
   */
  public int getEnclosureNum() {
    return enclosure.primatesNum();
  }

  /**
   * @return the capacity of isolation
   */
  public int getIsolationCapacity() {
    return isolation.capacity;
  }

  /**
   * @return the capacity of enclosure, which means how many species the enclosure could accommodate
   */
  public int getEnclosureCapacity() {
    return enclosure.capacity;
  }
}
