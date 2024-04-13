package models;

import enums.Food;
import enums.Sex;
import enums.Species;

/**
 * A class representing a primate. A primate can have different name, sex, species, size, weight,
 * age and favorite food.
 */
public class Primate {
  private String name;
  private Sex sex;
  private Species species;
  private String size;
  private double weight;
  private int age;
  private Food favoriteFood;
  private boolean isHealthy;

  public Primate(String name, Sex sex, Species species, String size, double weight, int age,
                 Food favoriteFood) {
    if (weight < 0 || age < 0) {
      throw new IllegalArgumentException("Weight and age should be non-negative numbers");
    }
    if (name.equals("") || size.equals(""))
      throw new IllegalArgumentException("All fields must not be empty");
    this.name = name;
    this.sex = sex;
    this.species = species;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favoriteFood = favoriteFood;
    isHealthy = true;
  }

  @Override
  public String toString() {
    return String.format(
            "%s[%s][%s]",
            name,
            sex.toString().toLowerCase(),
            favoriteFood.toString().toLowerCase()
    );
  }

  public String getName() {
    return name;
  }

  public Species getSpecies() {
    return species;
  }

  public void sick() {
    isHealthy = false;
  }

  public void cure() {
    isHealthy = true;
  }

  public boolean isHealthy() {
    return isHealthy;
  }
}
