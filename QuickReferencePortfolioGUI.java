package QuickReferencePortfolio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// this is the main class
public class QuickReferencePortfolioGUI extends JFrame {
    private ArrayList<String> testArrayList;

    public QuickReferencePortfolioGUI() {
        setTitle("Java Quick Reference");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        testArrayList = new ArrayList<>();
        testArrayList.add("Java");
        testArrayList.add("is");
        testArrayList.add("the");
        testArrayList.add("best");
        testArrayList.add("programming");
        testArrayList.add("language");

        JPanel menuPanel = createMenuPanel();
        add(menuPanel, BorderLayout.WEST);

        JPanel contentPanel = new JPanel(new CardLayout());
        add(contentPanel, BorderLayout.CENTER);

        setupFunctionality(contentPanel);

        setVisible(true);
    }

    public JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new GridLayout(6, 1));

        String[] options = {
                "String Class", "Integer Class", "Double Class",
                "Math Class", "ArrayList Class", "Object Class"
        };
        for (String option : options) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            menuPanel.add(button);
        }

        return menuPanel;
    }

    public void setupFunctionality(JPanel contentPanel) {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();

        // ---------------------------------------------------------------------------------------
        JPanel stringClassPanel = createStringClassPanel();
        contentPanel.add(stringClassPanel, "String Class");
        /* (1) */JPanel string1stOptPanel = createString1stOptPanel();
        contentPanel.add(string1stOptPanel, "String(String str)");
        /* (2) */JPanel string2ndOptPanel = createString2ndOptPanel();
        contentPanel.add(string2ndOptPanel, "int length()");
        /* (3) */JPanel string3rdOptPanel = createString3rdOptPanel();
        contentPanel.add(string3rdOptPanel, "String substring(int from, int to)");
        /* (4) */JPanel string4thOptPanel = createString4thOptPanel();
        contentPanel.add(string4thOptPanel, "String substring(int from)");
        /* (5) */JPanel string5thOptPanel = createString5thOptPanel();
        contentPanel.add(string5thOptPanel, "int indexOf(String str)");
        /* (6) */JPanel string6thOptPanel = createString6thOptPanel();
        contentPanel.add(string6thOptPanel, "boolean equals(String other)");
        /* (7) */JPanel string7thOptPanel = createString7thOptPanel();
        contentPanel.add(string7thOptPanel, "int compareTo(String other)");
        // ---------------------------------------------------------------------------------------

        JPanel integerClassPanel = createIntegerClassPanel();
        contentPanel.add(integerClassPanel, "Integer Class");
        /* (1) */JPanel integer1stOptPanel = createInteger1stOptPanel();
        contentPanel.add(integer1stOptPanel, "Integer(int value)");
        /* (2) */JPanel integer2ndOptPanel = createInteger2ndOptPanel();
        contentPanel.add(integer2ndOptPanel, "Integer.MIN_VALUE");
        /* (3) */JPanel integer3rdOptPanel = createInteger3rdOptPanel();
        contentPanel.add(integer3rdOptPanel, "Integer.MAX_VALUE");
        /* (4) */JPanel integer4thOptPanel = createInteger4thOptPanel();
        contentPanel.add(integer4thOptPanel, "int intValue()");
        // ---------------------------------------------------------------------------------------

        JPanel doubleClassPanel = createDoubleClassPanel();
        contentPanel.add(doubleClassPanel, "Double Class");
        /* (1) */JPanel double1stOptPanel = createDouble1stOptPanel();
        contentPanel.add(double1stOptPanel, "Double(double value)");
        /* (2) */JPanel double2ndOptPanel = createDouble2ndOptPanel();
        contentPanel.add(double2ndOptPanel, "double doubleValue()");
        // ---------------------------------------------------------------------------------------

        JPanel mathClassPanel = createMathClassPanel();
        contentPanel.add(mathClassPanel, "Math Class");
        /* (1) */JPanel math1stOptPanel = createMath1stOptPanel();
        contentPanel.add(math1stOptPanel, "static int abs(int x)");
        /* (2) */JPanel math2ndOptPanel = createMath2ndOptPanel();
        contentPanel.add(math2ndOptPanel, "static double abs(double x)");
        /* (3) */JPanel math3rdOptPanel = createMath3rdOptPanel();
        contentPanel.add(math3rdOptPanel, "static double pow(double base, double exponent)");
        /* (4) */JPanel math4thOptPanel = createMath4thOptPanel();
        contentPanel.add(math4thOptPanel, "static double sqrt(double x)");
        /* (5) */JPanel math5thOptPanel = createMath5thOptPanel();
        contentPanel.add(math5thOptPanel, "static double random()");
        // ---------------------------------------------------------------------------------------

        JPanel arrayListClassPanel = createArrayListClassPanel();
        contentPanel.add(arrayListClassPanel, "ArrayList Class");
        /* (1) */JPanel arrayList1stOptPanel = createArrayList1stOptPanel();
        contentPanel.add(arrayList1stOptPanel, "int size()");
        /* (2) */JPanel arrayList2ndOptPanel = createArrayList2ndOptPanel();
        contentPanel.add(arrayList2ndOptPanel, "boolean add(E obj)");
        /* (3) */JPanel arrayList3rdOptPanel = createArrayList3rdOptPanel();
        contentPanel.add(arrayList3rdOptPanel, "void add(int index, E obj)");
        /* (4) */JPanel arrayList4thOptPanel = createArrayList4thOptPanel();
        contentPanel.add(arrayList4thOptPanel, "E get(int index)");
        /* (5) */JPanel arrayList5thOptPanel = createArrayList5thOptPanel();
        contentPanel.add(arrayList5thOptPanel, "E set(int index, E obj)");
        /* (6) */JPanel arrayList6thOptPanel = createArrayList6thOptPanel();
        contentPanel.add(arrayList6thOptPanel, "E remove(int index)");
        // ---------------------------------------------------------------------------------------

        JPanel objectClassPanel = createObjectClassPanel();
        contentPanel.add(objectClassPanel, "Object Class");
        /* (1) */JPanel object1stOptPanel = createObject1stOptPanel();
        contentPanel.add(object1stOptPanel, "boolean equals(Object other)");
        /* (2) */JPanel object2ndOptPanel = createObject2ndOptPanel();
        contentPanel.add(object2ndOptPanel, "String toString()");
        // ---------------------------------------------------------------------------------------

        for (Component c : ((JPanel) getContentPane().getComponent(0)).getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "String Class":
                            cardLayout.show(contentPanel, "String Class");
                            break;
                        case "Integer Class":
                            cardLayout.show(contentPanel, "Integer Class");
                            break;
                        case "Double Class":
                            cardLayout.show(contentPanel, "Double Class");
                            break;
                        case "Math Class":
                            cardLayout.show(contentPanel, "Math Class");
                            break;
                        case "ArrayList Class":
                            cardLayout.show(contentPanel, "ArrayList Class");
                            break;
                        case "Object Class":
                            cardLayout.show(contentPanel, "Object Class");
                            break;
                    }
                });
            }
        }
        // ---------------------------------------------------------------------------------------------

        for (Component c : stringClassPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "String(String str)":
                            cardLayout.show(contentPanel, "String(String str)");
                            break;
                        case "int length()":
                            cardLayout.show(contentPanel, "int length()");
                            break;
                        case "String substring(int from, int to)":
                            cardLayout.show(contentPanel, "String substring(int from, int to)");
                            break;
                        case "String substring(int from)":
                            cardLayout.show(contentPanel, "String substring(int from)");
                            break;
                        case "int indexOf(String str)":
                            cardLayout.show(contentPanel, "int indexOf(String str)");
                            break;
                        case "boolean equals(String other)":
                            cardLayout.show(contentPanel, "boolean equals(String other)");
                            break;
                        case "int compareTo(String other)":
                            cardLayout.show(contentPanel, "int compareTo(String other)");
                            break;
                    }
                });
            }
        }
        // ---------------------------------------------------------------------------------------------

        for (Component c : integerClassPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "Integer(int value)":
                            cardLayout.show(contentPanel, "Integer(int value)");
                            break;
                        case "Integer.MIN_VALUE":
                            cardLayout.show(contentPanel, "Integer.MIN_VALUE");
                            break;
                        case "Integer.MAX_VALUE":
                            cardLayout.show(contentPanel, "Integer.MAX_VALUE");
                            break;
                        case "int intValue()":
                            cardLayout.show(contentPanel, "int intValue()");
                            break;
                    }
                });
            }
        }
        // ---------------------------------------------------------------------------------------------

        for (Component c : doubleClassPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "Double(double value)":
                            cardLayout.show(contentPanel, "Double(double value)");
                            break;
                        case "double doubleValue()":
                            cardLayout.show(contentPanel, "double doubleValue()");
                            break;
                    }
                });
            }
        }
        // ---------------------------------------------------------------------------------------------

        for (Component c : mathClassPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "static int abs(int x)":
                            cardLayout.show(contentPanel, "static int abs(int x)");
                            break;
                        case "static double abs(double x)":
                            cardLayout.show(contentPanel, "static double abs(double x)");
                            break;
                        case "static double pow(double base, double exponent)":
                            cardLayout.show(contentPanel, "static double pow(double base, double exponent)");
                            break;
                        case "static double sqrt(double x)":
                            cardLayout.show(contentPanel, "static double sqrt(double x)");
                            break;
                        case "static double random()":
                            cardLayout.show(contentPanel, "static double random()");
                            break;
                    }
                });
            }
        }
        // ---------------------------------------------------------------------------------------------

        for (Component c : arrayListClassPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "int size()":
                            cardLayout.show(contentPanel, "int size()");
                            break;
                        case "boolean add(E obj)":
                            cardLayout.show(contentPanel, "boolean add(E obj)");
                            break;
                        case "void add(int index, E obj)":
                            cardLayout.show(contentPanel, "void add(int index, E obj)");
                            break;
                        case "E get(int index)":
                            cardLayout.show(contentPanel, "E get(int index)");
                            break;
                        case "E set(int index, E obj)":
                            cardLayout.show(contentPanel, "E set(int index, E obj)");
                            break;
                        case "E remove(int index)":
                            cardLayout.show(contentPanel, "E remove(int index)");
                            break;
                    }
                });
            }
        }
        // ---------------------------------------------------------------------------------------------

        for (Component c : objectClassPanel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(e -> {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "boolean equals(Object other)":
                            cardLayout.show(contentPanel, "boolean equals(Object other)");
                            break;
                        case "String toString()":
                            cardLayout.show(contentPanel, "String toString()");
                            break;
                    }
                });
            }
        }
    }
    // End of setupFunctionality method
    // ---------------------------------------------------------------------------------------------

    // StringClassPanel and options
    public JPanel createStringClassPanel() {
        JPanel stringClassPanel = new JPanel(new GridLayout(7, 1));

        String[] stringClassOptions = {
                "String(String str)", "int length()", "String substring(int from, int to)",
                "String substring(int from)", "int indexOf(String str)", "boolean equals(String other)",
                "int compareTo(String other)"
        };
        for (String option : stringClassOptions) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            stringClassPanel.add(button);
        }
        return stringClassPanel;
    }

    public JPanel createString1stOptPanel() {
        JPanel string1stOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea(
                "Java Definition: Constructs a new String object that represents the same sequence of characters as str"
                        + "\n"
                        + "\nSimple Definition: Creates a new String that is a copy of the String in parenthesis");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        string1stOptPanel.add(javaDef);
        return string1stOptPanel;
    }

    public JPanel createString2ndOptPanel() {
        JPanel string2ndOptPanel = new JPanel(new GridBagLayout());
        // Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();

        JTextArea javaDef = new JTextArea("Java Definition: Returns the number of characters in a String object"
                + "\n"
                + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "string.length():" + textField.getText().length());
        });

        constr.gridwidth = 3;
        constr.gridy = 0;
        string2ndOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        string2ndOptPanel.add(label, constr);
        constr.gridx = 1;
        constr.gridwidth = 2;
        string2ndOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        string2ndOptPanel.add(button, constr);

        return string2ndOptPanel;
    }

    public JPanel createString3rdOptPanel() {
        JPanel string3rdOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();

        JTextArea javaDef = new JTextArea(
                "Java Definition: Returns the substring beginning at index from and ending at index to - 1"
                        + "\n"
                        + "\nSimple Definition: Returns the part of the String that starts at 1st arguement and ends at 2nd arguement - 1"
                        + "\n"
                        + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel labelInput = new JLabel("Enter a string: ");
        JLabel labelStart = new JLabel("Enter the starting index: ");
        JLabel labelEnding = new JLabel("Enter the ending index: ");
        JTextField inputField = new JTextField(20);
        JTextField startTextField = new JTextField(20);
        JTextField endingTextField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int startIndex = Integer.parseInt(startTextField.getText());
            int endingIndex = Integer.parseInt(endingTextField.getText());
            JOptionPane.showMessageDialog(null, "string.substring(" + startIndex + ", " + endingIndex + "): "
                    + inputField.getText().substring(startIndex, endingIndex));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        string3rdOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        string3rdOptPanel.add(labelInput, constr);
        constr.gridx = 1;
        string3rdOptPanel.add(inputField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        string3rdOptPanel.add(labelStart, constr);
        constr.gridx = 1;
        string3rdOptPanel.add(startTextField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        string3rdOptPanel.add(labelEnding, constr);
        constr.gridx = 1;
        string3rdOptPanel.add(endingTextField, constr);
        constr.gridy = 4;
        constr.gridx = 0;
        constr.gridwidth = 3;
        string3rdOptPanel.add(button, constr);
        return string3rdOptPanel;
    }

    public JPanel createString4thOptPanel() {
        JPanel string4thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns substring(from, length())"
                + "\n"
                + "\nSimple Definition: Returns the part of the String that starts at the arguement and includes everything until the end"
                + "\n"
                + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JLabel labelStart = new JLabel("Enter a starting index: ");
        JTextField startField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int startIndex = Integer.parseInt(startField.getText());
            JOptionPane.showMessageDialog(null, "string.substring(" + startIndex + "): "
                    + textField.getText().substring(startIndex));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        string4thOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        string4thOptPanel.add(label, constr);
        constr.gridx = 1;
        string4thOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        string4thOptPanel.add(labelStart, constr);
        constr.gridx = 1;
        string4thOptPanel.add(startField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        string4thOptPanel.add(button, constr);

        return string4thOptPanel;
    }

    public JPanel createString5thOptPanel() {
        JPanel string5thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea(
                "Java Definition: Returns the index of the first occurrence of str; returns -1 if not found"
                        + "\n"
                        + "\nSimple Definition: Returns the index of where str starts; returns -1 if not found"
                        + "\n"
                        + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JLabel labelSearch = new JLabel("Enter a search term: ");
        JTextField searchField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "string.indexOf(" + searchField.getText() + "): "
                    + textField.getText().indexOf(searchField.getText()));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        string5thOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        string5thOptPanel.add(label, constr);
        constr.gridx = 1;
        string5thOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        string5thOptPanel.add(labelSearch, constr);
        constr.gridx = 1;
        string5thOptPanel.add(searchField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        string5thOptPanel.add(button, constr);

        return string5thOptPanel;
    }

    public JPanel createString6thOptPanel() {
        JPanel string6thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea(
                "Java Definition: Returns true if this is equal to other; returns false otherwise"
                        + "\n"
                        + "\nSimple Definition: Returns true if the string is equal to the arguement; returns false otherwise"
                        + "\n"
                        + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JLabel labelSearch = new JLabel("Enter another string: ");
        JTextField searchField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            boolean result = textField.getText().equals(searchField.getText());
            JOptionPane.showMessageDialog(null,
                    "\"" + textField.getText() + "\".equals(\"" + searchField.getText() + "\"): " + result);

        });

        constr.gridy = 0;
        constr.gridwidth = 3;
        string6thOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        constr.gridwidth = 1;
        string6thOptPanel.add(label, constr);
        constr.gridx = 1;
        string6thOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        string6thOptPanel.add(labelSearch, constr);
        constr.gridx = 1;
        string6thOptPanel.add(searchField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        string6thOptPanel.add(button, constr);

        return string6thOptPanel;
    }

    public JPanel createString7thOptPanel() {
        JPanel string7thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea(
                "Java Definition: Returns a value <0 if this is less than other; returns zero if this is equal to other; returns a value >0 if this is greater than other"
                        + "\n"
                        + "\nSimple Definition: Returns a value <0 if the string is less than the arguement; returns zero if the string is equal to the arguement; returns a value >0 if the string is greater than the arguement"
                        + "\n"
                        + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 15));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JLabel labelSearch = new JLabel("Enter another string: ");
        JTextField searchField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "string.compareTo(" + searchField.getText() + "): "
                    + textField.getText().compareTo(searchField.getText()));
        });

        constr.gridwidth = 3;
        string7thOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        constr.gridwidth = 1;
        string7thOptPanel.add(label, constr);
        constr.gridx = 1;
        string7thOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        string7thOptPanel.add(labelSearch, constr);
        constr.gridx = 1;
        string7thOptPanel.add(searchField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        string7thOptPanel.add(button, constr);

        return string7thOptPanel;
    }
    // --------------------------------------------------------------------------

    // IntegerClassPanel and options
    public JPanel createIntegerClassPanel() {
        JPanel integerClassPanel = new JPanel(new GridLayout(4, 1));

        String[] integerClassOptions = {
                "Integer(int value)", "Integer.MIN_VALUE",
                "Integer.MAX_VALUE", "int intValue()"
        };
        for (String option : integerClassOptions) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            integerClassPanel.add(button);
        }
        return integerClassPanel;
    }

    public JPanel createInteger1stOptPanel() {
        JPanel integer1stOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea(
                "Java Definition: Constructs a new Integer object that represents the specified int value"
                        + "\n"
                        + "\nSimple Definition: Creates a new Integer that is a copy of the int in parenthesis (Clarification: Integer is an object, int is a number)");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        integer1stOptPanel.add(javaDef);
        return integer1stOptPanel;
    }

    public JPanel createInteger2ndOptPanel() {
        JPanel integer2ndOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea("Java Definition: The minimum value represented by an int or Integer"
                + "\n"
                + "\nSimple Definition: Stores the smallest value that an int can be, which is -2147483648");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        integer2ndOptPanel.add(javaDef);
        return integer2ndOptPanel;
    }

    public JPanel createInteger3rdOptPanel() {
        JPanel integer3rdOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea("Java Definition: The maximum value represented by an int or Integer"
                + "\n"
                + "\nSimple Definition: Stores the largest value that an int can be, which is 2147483647");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        integer3rdOptPanel.add(javaDef);
        return integer3rdOptPanel;
    }

    public JPanel createInteger4thOptPanel() {
        JPanel integer4thOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea("Java Definition: Returns the value of this Integer as an int"
                + "\n"
                + "\nExample:"
                + "\nInteger intObject = 10;"
                + "\nint regularInt = intObject.intValue();"
                + "\nSystem.out.println(regularInt);"
                + "\n"
                + "\nOutput: 10");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        integer4thOptPanel.add(javaDef);
        return integer4thOptPanel;
    }
    // --------------------------------------------------------------------------

    // DoubleClassPanel and options
    public JPanel createDoubleClassPanel() {
        JPanel doubleClassPanel = new JPanel(new GridLayout(2, 1));

        String[] doubleClassOptions = {
                "Double(double value)", "double doubleValue()"
        };
        for (String option : doubleClassOptions) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            doubleClassPanel.add(button);
        }
        return doubleClassPanel;
    }

    public JPanel createDouble1stOptPanel() {
        JPanel double1stOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea("Java Definition: Constructs a new Double object that represents the specified double value"
                + "\n"
                + "\nSimple Definition: Creates a new Double that is a copy of the double in parenthesis (Clarification: Double is an object, double is a number)");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        double1stOptPanel.add(javaDef);
        return double1stOptPanel;
    }

    public JPanel createDouble2ndOptPanel() {
        JPanel double2ndOptPanel = new JPanel(new BorderLayout());
        JTextArea javaDef = new JTextArea("Java Definition: Returns the value of this Double as a double"
                + "\n"
                + "\nExample:"
                + "\ndouble doubleObject = 10.7;"
                + "\nint regularDouble = doubleObject.doubleValue();"
                + "\nSystem.out.println(regularDouble);"
                + "\n"
                + "\nOutput: 10.7");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        double2ndOptPanel.add(javaDef);
        return double2ndOptPanel;
    }
    // --------------------------------------------------------------------------

    // MathClassPanel and options
    public JPanel createMathClassPanel() {
        JPanel mathClassPanel = new JPanel(new GridLayout(5, 1));

        String[] mathClassOptions = {
                "static int abs(int x)", "static double abs(double x)",
                "static double pow(double base, double exponent)",
                "static double sqrt(double x)", "static double random()"
        };
        for (String option : mathClassOptions) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            mathClassPanel.add(button);
        }
        return mathClassPanel;
    }

    public JPanel createMath1stOptPanel() {
        JPanel math1stOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns the absolute value of an int value"
                + "\n"
                + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter an integer: ");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int value;

            try {
                value = Integer.parseInt(textField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer");
                return;
            }

            JOptionPane.showMessageDialog(null, "Math.abs(" + value + "): " + Math.abs(value));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        math1stOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        math1stOptPanel.add(label, constr);
        constr.gridx = 1;
        math1stOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        constr.gridwidth = 3;
        math1stOptPanel.add(button, constr);

        return math1stOptPanel;
    }

    public JPanel createMath2ndOptPanel() {
        JPanel math2ndOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns the absolute value of a double value"
                + "\n"
                + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a double: ");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            double value;

            try {
                value = Double.parseDouble(textField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid double");
                return;
            }

            JOptionPane.showMessageDialog(null, "Math.abs(" + value + "): " + Math.abs(value));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        math2ndOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        math2ndOptPanel.add(label, constr);
        constr.gridx = 1;
        math2ndOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        constr.gridwidth = 3;
        math2ndOptPanel.add(button, constr);

        return math2ndOptPanel;
    }

    public JPanel createMath3rdOptPanel() {
        JPanel math3rdOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns the value of the first parameter raised to the power of the second parameter"
                + "\n"
                + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel labelBase = new JLabel("Enter the base: ");
        JTextField baseField = new JTextField(20);
        JLabel labelExponent = new JLabel("Enter the exponent: ");
        JTextField exponentField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            double base;
            double exponent;

            try {
                base = Double.parseDouble(baseField.getText());
                exponent = Double.parseDouble(exponentField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                return;
            }

            JOptionPane.showMessageDialog(null,
                    "Math.pow(" + base + ", " + exponent + "): " + Math.pow(base, exponent));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        math3rdOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        math3rdOptPanel.add(labelBase, constr);
        constr.gridx = 1;
        math3rdOptPanel.add(baseField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        math3rdOptPanel.add(labelExponent, constr);
        constr.gridx = 1;
        math3rdOptPanel.add(exponentField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        math3rdOptPanel.add(button, constr);

        return math3rdOptPanel;
    }

    public JPanel createMath4thOptPanel() {
        JPanel math4thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns the positive square root of a double value"
                + "\n"
                + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JLabel label = new JLabel("Enter a double: ");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            double value;

            try {
                value = Double.parseDouble(textField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid double");
                return;
            }

            JOptionPane.showMessageDialog(null, "Math.sqrt(" + value + "): " + Math.sqrt(value));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        math4thOptPanel.add(javaDef, constr);
        constr.gridwidth = 1;
        constr.gridy = 1;
        math4thOptPanel.add(label, constr);
        constr.gridx = 1;
        math4thOptPanel.add(textField, constr);
        constr.gridy = 2;
        constr.gridx = 0;
        constr.gridwidth = 3;
        math4thOptPanel.add(button, constr);

        return math4thOptPanel;
    }

    public JPanel createMath5thOptPanel() {
        JPanel math5thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns a double value greater than or equal to 0.0 and less than 1.0"
                    + "\n"
                    + "\nSimple Definition: Returns a double value: 0.0 <= x < 1.0"
                    + "\n"
                    + "\nTry it: ");
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Math.random(): " + Math.random());
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        math5thOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        constr.gridx = 0;
        constr.gridwidth = 3;
        math5thOptPanel.add(button, constr);

        return math5thOptPanel;
    }
    // --------------------------------------------------------------------------

    // ArrayListClassPanel and options
    public JPanel createArrayListClassPanel() {
        JPanel arrayListClassPanel = new JPanel(new GridLayout(6, 1));

        String[] arrayListClassOptions = {
                "int size()", "boolean add(E obj)", "void add(int index, E obj)",
                "E get(int index)", "E set(int index, E obj)", "E remove(int index)"
        };
        for (String option : arrayListClassOptions) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            arrayListClassPanel.add(button);
        }
        return arrayListClassPanel;
    }

    private String displayArray() {
        String result = "Array: {";

        for (String str : testArrayList) {
            result += "\"" + str + "\", ";
        }

        result = result.substring(0, result.length() - 2);

        result += "}";

        return result;
    }

    public JPanel createArrayList1stOptPanel() {
        JPanel arrayList1stOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Returns the number of elements in the list"
                + "\n"
                + "\nTry it: ");
        JTextArea array = new JTextArea(displayArray());
        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        array.setLineWrap(true);
        array.setWrapStyleWord(true);
        array.setFont(new Font("Default", Font.PLAIN, 20));
        array.setSize(400, 20);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> {
            array.setText(displayArray());
        });

        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "arrayList.size(): " + testArrayList.size());
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        arrayList1stOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        arrayList1stOptPanel.add(array, constr);
        constr.gridy = 2;
        constr.gridwidth = 3;
        arrayList1stOptPanel.add(button, constr);
        constr.gridy = 3;
        arrayList1stOptPanel.add(refresh, constr);

        return arrayList1stOptPanel;
    }

    public JPanel createArrayList2ndOptPanel() {
        JPanel arrayList2ndOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea("Java Definition: Appends obj to end of list; returns true"
                + "\n"
                + "\nSimple Definition: Adds an element to the end of the list; returns true if successful"
                + "\n"
                + "\nTry it: ");
        JTextArea array = new JTextArea(displayArray());

        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        array.setLineWrap(true);
        array.setWrapStyleWord(true);
        array.setFont(new Font("Default", Font.PLAIN, 20));
        array.setSize(400, 20);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> {
            array.setText(displayArray());
        });

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            testArrayList.add(textField.getText());
            array.setText(displayArray());
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        arrayList2ndOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        arrayList2ndOptPanel.add(array, constr);
        constr.gridy = 2;
        constr.gridwidth = 1;
        arrayList2ndOptPanel.add(label, constr);
        constr.gridx = 1;
        arrayList2ndOptPanel.add(textField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        arrayList2ndOptPanel.add(button, constr);
        constr.gridy = 4;
        arrayList2ndOptPanel.add(refresh, constr);

        return arrayList2ndOptPanel;
    }

    public JPanel createArrayList3rdOptPanel() {
        JPanel arrayList3rdOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        JTextArea javaDef = new JTextArea(
                "Java Definition: Inserts obj at position index (0 <= index <= size), moving elements at position index and higher to the right (adds 1 to their indices) and adds 1 to size"
                        + "\n"
                        + "\nSimple Definition: Adds an element to the list at the specified index; moves elements to the right to make room for the new element and increases size of list by 1"
                        + "\n"
                        + "\nTry it: ");
        JTextArea array = new JTextArea(displayArray());

        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 15));
        javaDef.setSize(400, 100);

        array.setLineWrap(true);
        array.setWrapStyleWord(true);
        array.setFont(new Font("Default", Font.PLAIN, 15));
        array.setSize(400, 20);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> {
            array.setText(displayArray());
        });

        JLabel label = new JLabel("Enter a string: ");
        JTextField textField = new JTextField(20);
        JLabel labelIndex = new JLabel("Enter an index: ");
        JTextField indexField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int index;

            try {
                index = Integer.parseInt(indexField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer");
                return;
            }

            testArrayList.add(index, textField.getText());
            array.setText(displayArray());
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        arrayList3rdOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        arrayList3rdOptPanel.add(array, constr);
        constr.gridy = 2;
        constr.gridwidth = 1;
        arrayList3rdOptPanel.add(label, constr);
        constr.gridx = 1;
        arrayList3rdOptPanel.add(textField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        arrayList3rdOptPanel.add(labelIndex, constr);
        constr.gridx = 1;
        arrayList3rdOptPanel.add(indexField, constr);
        constr.gridy = 4;
        constr.gridx = 0;
        constr.gridwidth = 3;
        arrayList3rdOptPanel.add(button, constr);
        constr.gridy = 5;
        arrayList3rdOptPanel.add(refresh, constr);

        return arrayList3rdOptPanel;
    }

    public JPanel createArrayList4thOptPanel() {
        JPanel arrayList4thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();

        JTextArea javaDef = new JTextArea("Java Definition: Returns the element at position index in the list"
                + "\n"
                + "\nSimple Definition: Returns the element at the specified index in the list"
                + "\n"
                + "\nTry it: ");
        JTextArea array = new JTextArea(displayArray());

        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 20));
        javaDef.setSize(400, 100);

        array.setLineWrap(true);
        array.setWrapStyleWord(true);
        array.setFont(new Font("Default", Font.PLAIN, 20));
        array.setSize(400, 20);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> {
            array.setText(displayArray());
        });

        JLabel label = new JLabel("Enter an index: ");
        JTextField indexField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int index;

            try {
                index = Integer.parseInt(indexField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer");
                return;
            }

            JOptionPane.showMessageDialog(null, "arrayList.get(" + index + "): " + testArrayList.get(index));
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        arrayList4thOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        arrayList4thOptPanel.add(array, constr);
        constr.gridy = 2;
        constr.gridwidth = 1;
        arrayList4thOptPanel.add(label, constr);
        constr.gridx = 1;
        arrayList4thOptPanel.add(indexField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        arrayList4thOptPanel.add(button, constr);
        constr.gridy = 4;
        arrayList4thOptPanel.add(refresh, constr);

        return arrayList4thOptPanel;
    }

    public JPanel createArrayList5thOptPanel() {
        JPanel arrayList5thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();

        JTextArea javaDef = new JTextArea(
                "Java Definition: Replaces the element at position index with obj; returns the element formerly at position index"
                        + "\n"
                        + "\nSimple Definition: Replaces the element at the specified index with the new specified element; returns the element that was replaced"
                        + "\n"
                        + "\nTry it: ");
        JTextArea array = new JTextArea(displayArray());

        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 15));
        javaDef.setSize(400, 100);

        array.setLineWrap(true);
        array.setWrapStyleWord(true);
        array.setFont(new Font("Default", Font.PLAIN, 15));
        array.setSize(400, 20);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> {
            array.setText(displayArray());
        });

        JLabel label = new JLabel("Enter an index: ");
        JTextField indexField = new JTextField(20);
        JLabel labelString = new JLabel("Enter a string: ");
        JTextField stringField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int index;

            try {
                index = Integer.parseInt(indexField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer");
                return;
            }

            String replaced = testArrayList.set(index, stringField.getText());
            array.setText(displayArray());
            JOptionPane.showMessageDialog(null, "arrayList.set(" + index + ", \"" + stringField.getText() + "\"): "
                    + replaced);
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        arrayList5thOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        arrayList5thOptPanel.add(array, constr);
        constr.gridy = 2;
        constr.gridwidth = 1;
        arrayList5thOptPanel.add(label, constr);
        constr.gridx = 1;
        arrayList5thOptPanel.add(indexField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        arrayList5thOptPanel.add(labelString, constr);
        constr.gridx = 1;
        arrayList5thOptPanel.add(stringField, constr);
        constr.gridy = 4;
        constr.gridx = 0;
        constr.gridwidth = 3;
        arrayList5thOptPanel.add(button, constr);
        constr.gridy = 5;
        arrayList5thOptPanel.add(refresh, constr);

        return arrayList5thOptPanel;
    }

    public JPanel createArrayList6thOptPanel() {
        JPanel arrayList6thOptPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();

        JTextArea javaDef = new JTextArea("Java Definition: Removes element from position index, moving elements at position index + 1 and higher to the left (subtracts 1 from their indices) and subtracts 1 from size; returns the element formerly at position index"
                + "\n"
                + "\nSimple Definition: Removes the element at the specified index; moves elements to the left to fill the gap and decreases size of list by 1; returns the element that was removed"
                + "\n"
                + "\nTry it: ");
        JTextArea array = new JTextArea(displayArray());

        javaDef.setLineWrap(true);
        javaDef.setWrapStyleWord(true);
        javaDef.setFont(new Font("Default", Font.PLAIN, 15));
        javaDef.setSize(400, 100);

        array.setLineWrap(true);
        array.setWrapStyleWord(true);
        array.setFont(new Font("Default", Font.PLAIN, 15));
        array.setSize(400, 20);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> {
            array.setText(displayArray());
        });

        JLabel label = new JLabel("Enter an index: ");
        JTextField indexField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            int index;

            try {
                index = Integer.parseInt(indexField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer");
                return;
            }

            String removed = testArrayList.remove(index);
            array.setText(displayArray());
            JOptionPane.showMessageDialog(null, "arrayList.remove(" + index + "): " + removed);
        });

        constr.gridwidth = GridBagConstraints.REMAINDER;
        arrayList6thOptPanel.add(javaDef, constr);
        constr.gridy = 1;
        arrayList6thOptPanel.add(array, constr);
        constr.gridy = 2;
        constr.gridwidth = 1;
        arrayList6thOptPanel.add(label, constr);
        constr.gridx = 1;
        arrayList6thOptPanel.add(indexField, constr);
        constr.gridy = 3;
        constr.gridx = 0;
        constr.gridwidth = 3;
        arrayList6thOptPanel.add(button, constr);
        constr.gridy = 4;
        arrayList6thOptPanel.add(refresh, constr);

        return arrayList6thOptPanel;
    }
    // --------------------------------------------------------------------------

    // ObjectClassPanel and options
    public JPanel createObjectClassPanel() {
        JPanel objectClassPanel = new JPanel(new GridLayout(2, 1));

        String[] objectClassOptions = {
                "boolean equals(Object other)", "String toString()"
        };
        for (String option : objectClassOptions) {
            JButton button = new JButton(option);
            button.setActionCommand(option);
            objectClassPanel.add(button);
        }
        return objectClassPanel;
    }

    public JPanel createObject1stOptPanel() {
        JPanel object1stOptPanel = new JPanel(new GridLayout());
        return object1stOptPanel;
    }

    public JPanel createObject2ndOptPanel() {
        JPanel object2ndOptPanel = new JPanel(new GridLayout());
        return object2ndOptPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuickReferencePortfolioGUI::new);
    }
}
