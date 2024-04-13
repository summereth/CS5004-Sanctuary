package models;

import java.util.*;

import enums.Species;

/**
 * A class representing models.Enclosure models.Housing, which has [capacity] cages. Each cage contains a troop of
 * primates of the same species.
 */
public class Enclosure implements Housing<Set<Primate>> {
  public final int capacity;
  private Map<Species, Set<Primate>> primates;

  public Enclosure(int capacity) {
    this.capacity = capacity;
    primates = new HashMap<>();
  }

  @Override
  public void add(Primate p) throws IllegalArgumentException, IllegalStateException {
    if (!p.isHealthy())
      throw new IllegalArgumentException("Unhealthy primate cannot be moved into enclosure!");
    if (primates.size() >= capacity && !primates.containsKey(p.getSpecies())) {
      throw new IllegalStateException("Enclosure is full! Failed to accommodate more species!");
    }
    Set<Primate> cage = primates.computeIfAbsent(p.getSpecies(), key -> new HashSet<>());
    cage.add(p);
  }

  @Override
  public void remove(Primate p) {
    Set<Primate> cage = primates.get(p.getSpecies());
    cage.remove(p);
    if (cage.isEmpty())
      primates.remove(p.getSpecies());
  }

// [DEPRECATED]
//  @Override
//  public boolean contains(Primate p) {
//    Species s = p.getSpecies();
//    return primates.containsKey(s) && primates.get(s).contains(p);
//  }

  @Override
  public Primate find(String name) {
    for (Set<Primate> cage : primates.values()) {
      Primate p = cage.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
      if (p != null)
        return p;
    }
    return null;
  }

  @Override
  public List<Set<Primate>> getPrimates() {
    List<Set<Primate>> primatesCopy = new ArrayList<>();
    // make copy of sets in primates, instead of using original sets
    for (Set<Primate> cage : primates.values()) {
      primatesCopy.add(new HashSet<>(cage));
    }
    return primatesCopy;
  }

  @Override
  public List<String> getPrimatesName() {
    List<String> list = new ArrayList<>();
    for (Set<Primate> cage : primates.values()) {
      for (Primate p : cage) {
        list.add(p.getName());
      }
    }
    return list;
  }

  @Override
  public String getPrimatesStr() {
    if (primates.isEmpty())
      return "Enclosure is empty!";
    StringBuilder sb = new StringBuilder();
    for (Species species : primates.keySet()) {
      sb.append("\nSpecies ").append(species.toString().toLowerCase()).append(": ");
      for (Primate p : primates.get(species)) {
        sb.append(p.toString()).append(", ");
      }
      sb.deleteCharAt(sb.length() - 2);
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }

  public int primatesNum() {
    return primates.values().stream().map(Set::size).reduce(0, Integer::sum);
  }
}
