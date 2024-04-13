package controllers;

import java.awt.*;
import java.util.*;

import enums.*;
import models.Sanctuary;
import views.*;

public class SanctuaryController implements SanctuaryControllerInterface {

  View view;
  Sanctuary model;

  public SanctuaryController(JFrameView view, Sanctuary model) {
    this.view = view;
    this.model = model;
    view.addFeatures(this);
  }

  @Override
  public void register(String name, Sex sex, Species species, String size, String weight, String age,
                       Food favoriteFood) {
    try {
      double w = Double.parseDouble(weight);
      int a = Integer.parseInt(age);
      model.register(name, sex, species, size, w, a, favoriteFood);
      view.setOutput("Successfully registered " + name, Color.blue);
      loadStats();
      loadAllPrimates();
      loadIsolationList();
    } catch (NumberFormatException e) {
      view.setOutput("Please input valid numbers for weight and age", Color.red);
    } catch (IllegalStateException | IllegalArgumentException e) {
      view.setOutput(e.getMessage(), Color.red);
    }
    view.resetAllInputs();
  }

  @Override
  public void loadStats() {
    view.setStats(String.format("Isolation: %d/%d, Enclosure: %d/%d",
            model.getIsolationNum(),
            model.getIsolationCapacity(),
            model.getEnclosureNum(),
            model.getEnclosureCapacity()
    ));
  }

  @Override
  public void loadAllPrimates() {
    view.setAllPrimates(model.getAll().toString());
  }

  @Override
  public void loadIsolationList() {
    String[] primates = model.getIsolation();
    view.setIsolationList(primates);
    view.setTreatSelection(primates);
    view.setMoveToEnclosureSelection(primates);
//    view.setIsolationList("a", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b");
  }

  @Override
  public void loadEnclosureList() {
    // set enclosureList
    String allEnclosure = model.getEnclosureInStr();
    String[] speciesAndPrimates = allEnclosure.split("[\\n]");
    view.setEnclosureList(speciesAndPrimates);

    // set selection list in enclosure section
    java.util.List<String> allPrimates = new ArrayList<>();
    for (java.util.List<String> group : model.getEnclosure()) {
      allPrimates.addAll(group);
    }
    String[] primates = allPrimates.toArray(String[]::new);
    view.setMedicalCareSelection(primates);
//    view.setEnclosureList("bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger", "bdscfsdfvdgvfdgvfdgvfdgvregvrevrfvergvregregreger");
  }

  @Override
  public void treat(String selectedItem) {
    String name = selectedItem.substring(0, selectedItem.indexOf('['));
    try {
      model.treat(name);
      loadStats();
      loadIsolationList();
      loadEnclosureList();
      view.setOutput("Successfully cured " + selectedItem, Color.blue);
    } catch (IllegalArgumentException e) {
      view.setOutput(e.getMessage(), Color.red);
    }
  }

  @Override
  public void moveToEnclosure(String selectedItem) {
    String name = selectedItem.substring(0, selectedItem.indexOf('['));
    try {
      model.finishIsolation(name);
      loadStats();
      loadIsolationList();
      loadEnclosureList();
      view.setOutput("Successfully moved " + selectedItem + "to enclosure", Color.blue);
    } catch (IllegalArgumentException | IllegalStateException e) {
      view.setOutput(e.getMessage(), Color.red);
    }
  }

  @Override
  public void moveToIsolation(String selectedItem) {
    String name = selectedItem.substring(0, selectedItem.indexOf('['));
    try {
      model.medicalCare(name);
      loadStats();
      loadIsolationList();
      loadEnclosureList();
      view.setOutput(selectedItem + " is receiving medical care in isolation right now", Color.blue);
    } catch (IllegalArgumentException | IllegalStateException e) {
      view.setOutput(e.getMessage(), Color.red);
    }
  }

  @Override
  public void go() {
    loadStats();
    loadAllPrimates();
    loadIsolationList();
    loadEnclosureList();
  }
}
