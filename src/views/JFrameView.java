package views;

import java.awt.*;

import javax.swing.*;

import controllers.SanctuaryControllerInterface;
import enums.*;

/**
 * Sanctuary GUI implemented by Java Swing
 */
public class JFrameView extends JFrame implements View {

  private JLabel nameLabel;
  private JTextField nameIn;
  private JLabel speciesLabel;
  private JComboBox<Species> speciesIn;
  private JLabel sexLabel;
  private JComboBox<Sex> sexIn;
  private JLabel sizeLabel;
  private JTextField sizeIn;
  private JLabel weightLabel;
  private JTextField weightIn;
  private JLabel ageLabel;
  private JTextField ageIn;
  private JLabel foodLabel;
  private JComboBox<Food> foodIn;
  private JButton registerButton;
  private JLabel stats;
  private JLabel output;
  private JLabel allPrimates;
  private JPanel isolationList;
  private JComboBox<String> treatSelection;
  private JButton treatButton;
  private JComboBox<String> moveToEnclosureSelection;
  private JButton moveToEnclosureButton;
  private JPanel enclosureList;
  private JComboBox<String> medicalCareSelection;
  private JButton medicalCareButton;

  public JFrameView() {
    super("Sanctuary");
    setSize(500, 1000);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(7, 1));

    // Output Section
    JPanel outputPanel = new JPanel(new GridLayout(2, 1));
    this.add(outputPanel);
    this.stats = new JLabel("");
    this.output = new JLabel("");
    outputPanel.add(stats);
    outputPanel.add(output);

    // Register Section
    JPanel registerPanel = new JPanel(new GridLayout(4, 8));
    this.add(registerPanel);
    this.nameLabel = new JLabel("Name");
    registerPanel.add(nameLabel);
    this.nameIn = new JTextField(10);
    registerPanel.add(nameIn);

    this.speciesLabel = new JLabel("Species");
    registerPanel.add(speciesLabel);
    speciesIn = new JComboBox<>(Species.values());
    registerPanel.add(speciesIn);

    this.sexLabel = new JLabel("Sex");
    registerPanel.add(sexLabel);
    sexIn = new JComboBox<>(Sex.values());
    registerPanel.add(sexIn);

    this.sizeLabel = new JLabel("Size");
    registerPanel.add(sizeLabel);
    this.sizeIn = new JTextField(10);
    registerPanel.add(sizeIn);

    this.weightLabel = new JLabel("Weight");
    registerPanel.add(weightLabel);
    this.weightIn = new JTextField(10);
    registerPanel.add(weightIn);

    this.ageLabel = new JLabel("Age");
    registerPanel.add(ageLabel);
    this.ageIn = new JTextField(10);
    registerPanel.add(ageIn);

    this.foodLabel = new JLabel("Food");
    registerPanel.add(foodLabel);
    foodIn = new JComboBox<>(Food.values());
    registerPanel.add(foodIn);

    this.registerButton = new JButton("Register");
    this.registerButton.setActionCommand("Register Button");
    registerPanel.add(registerButton);

    // All primates section
    JPanel allPrimatesSection = new JPanel(new GridLayout(2, 1));
    this.add(allPrimatesSection);
    allPrimatesSection.add(new JLabel("<html><b>List of All Primates</b></html>"));
    allPrimates = new JLabel("");
    allPrimatesSection.add(allPrimates);

    // Isolation section
    this.add(new JLabel("<html><b>Isolation section</b></html>"));
    JPanel isolationSection = new JPanel(new GridLayout(2, 1));
    this.add(isolationSection);
    // input area in isolation section
    JPanel interactIsolation = new JPanel(new GridLayout(2, 2));
    isolationSection.add(interactIsolation);
    treatSelection = new JComboBox<>();
    interactIsolation.add(treatSelection);
    treatButton = new JButton("Treat");
    treatButton.setActionCommand("Treat Button");
    interactIsolation.add(treatButton);
    moveToEnclosureSelection = new JComboBox<>();
    interactIsolation.add(moveToEnclosureSelection);
    moveToEnclosureButton = new JButton("Move to Enclosure");
    moveToEnclosureButton.setActionCommand("Move to Enclosure Button");
    interactIsolation.add(moveToEnclosureButton);
    // isolation list
    isolationList = new JPanel(new GridLayout(5, 4));
    isolationSection.add(isolationList);

    // Enclosure section
    this.add(new JLabel("<html><b>Enclosure section</b></html>"));
    JPanel enclosureSection = new JPanel(new GridBagLayout());
    this.add(enclosureSection);

    // interaction area in enclosure section
    JPanel interactEnclosure = new JPanel();
    interactEnclosure.setLayout(new BoxLayout(interactEnclosure, BoxLayout.X_AXIS));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weighty = 0.01; // Give less weight to interactEnclosure
    enclosureSection.add(interactEnclosure, gbc);

    medicalCareSelection = new JComboBox<>();
    interactEnclosure.add(medicalCareSelection);
    medicalCareButton = new JButton("Medical Care");
    medicalCareButton.setActionCommand("Medical Care Button");
    interactEnclosure.add(medicalCareButton);

    // enclosure list
    enclosureList = new JPanel(new GridLayout(8, 1));
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weighty = 1.0; // Allow enclosureList to take up more vertical space
    gbc.weightx = 1.0; // Give more weight to enclosureList
    enclosureSection.add(enclosureList, gbc);

    this.pack();
    this.setVisible(true);
  }

  public void addFeatures(SanctuaryControllerInterface features) {
    this.registerButton.addActionListener(evt -> features.register(
            nameIn.getText(),
            (Sex) sexIn.getSelectedItem(),
            (Species) speciesIn.getSelectedItem(),
            sizeIn.getText(),
            weightIn.getText(),
            ageIn.getText(),
            (Food) foodIn.getSelectedItem()
    ));
    this.treatButton.addActionListener(e -> {
      features.treat((String) treatSelection.getSelectedItem());
    });
    this.moveToEnclosureButton.addActionListener(e -> {
      features.moveToEnclosure((String) moveToEnclosureSelection.getSelectedItem());
    });
    this.medicalCareButton.addActionListener(e -> {
      features.moveToIsolation((String) medicalCareSelection.getSelectedItem());
    });
//        this.exitButton.addActionListener(evt -> features.exitProgram());
  }

  @Override
  public void resetAllInputs() {
    this.nameIn.setText("");
    this.speciesIn.setSelectedIndex(0);
    this.sexIn.setSelectedIndex(0);
    this.sizeIn.setText("");
    this.weightIn.setText("");
    this.ageIn.setText("");
    this.foodIn.setSelectedIndex(0);
  }

  @Override
  public void setOutput(String text, Color color) {
    this.output.setText(text);
    this.output.setForeground(color);
  }

  @Override
  public void setStats(String text) {
    this.stats.setText(String.format("<html><b>%s</b></html>", text));
  }

  @Override
  public void setAllPrimates(String text) {
    this.allPrimates.setText(text);
  }

  private void setListWithTexts(JComponent panel, String... texts) {
    panel.removeAll(); // Remove layout constraints
    panel.revalidate(); // Revalidate the container

    // Remove all components
    Component[] components = panel.getComponents();
    for (Component component : components) {
      panel.remove(component);
    }

    // Add new components
    for (String text : texts) {
      if (!text.equals("")) {
        panel.add(new JLabel(text));
      }
    }

    panel.revalidate(); // Revalidate the container
    panel.repaint(); // Repaint the container
  }

  @Override
  public void setIsolationList(String... texts) {
    setListWithTexts(isolationList, texts);
  }

  @Override
  public void setEnclosureList(String... texts) {
    setListWithTexts(enclosureList, texts);
  }

  @Override
  public void setTreatSelection(String... options) {
    treatSelection.removeAllItems();
    for (String option : options) {
      treatSelection.addItem(option);
    }
  }

  @Override
  public void setMoveToEnclosureSelection(String... options) {
    moveToEnclosureSelection.removeAllItems();
    for (String option : options) {
      moveToEnclosureSelection.addItem(option);
    }
  }

  @Override
  public void setMedicalCareSelection(String... options) {
    medicalCareSelection.removeAllItems();
    for (String option : options) {
      medicalCareSelection.addItem(option);
    }
  }

  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

}
