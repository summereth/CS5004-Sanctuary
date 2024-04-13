package models;

import java.util.*;

/**
 * A class representing models.Isolation models.Housing, which has [capacity] cages. Each cage only contains
 * 1 primate
 */
public class Isolation implements Housing<Primate> {
  public final int capacity;
  private final Set<Primate> primates;

  public Isolation(int capacity) {
    this.capacity = capacity;
    primates = new HashSet<>();
  }

  @Override
  public void add(Primate p) throws IllegalArgumentException, IllegalStateException {
    if (primates.size() >= capacity) {
      throw new IllegalStateException("Isolation is full! Failed to accommodate given primate");
    }
    primates.add(p);
  }

  @Override
  public void remove(Primate p) throws IllegalArgumentException {
    primates.remove(p);
  }

  // [DEPRECATED]
//  @Override
//  public boolean contains(Primate p) {
//    return primates.contains(p);
//  }

  @Override
  public Primate find(String name) {
    return primates.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
  }

  @Override
  public List<Primate> getPrimates() {
    return new ArrayList<>(primates);
  }

  @Override
  public List<String> getPrimatesName() {
    List<String> list = new ArrayList<>();
    for (Primate p : primates) {
      list.add(p.getName());
    }
    return list;
  }

  @Override
  public String getPrimatesStr() {
    if (primates.size() == 0)
      return "Isolation is empty.";
    StringBuilder sb = new StringBuilder();
    sb.append("Isolation contains: ");
    for (Primate p : primates) {
      sb.append(p.toString()).append(", ");
    }
    return sb.substring(0, sb.length() - 2);
  }

  public int primatesNum() {
    return primates.size();
  }
}
