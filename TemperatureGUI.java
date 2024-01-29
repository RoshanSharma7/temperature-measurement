import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureGUI extends JFrame{
    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JLabel resultLabel1;
    private JLabel resultLabel2;

    public TemperatureGUI(){
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // input Field
        JLabel inputLabel = new JLabel("Enter The Temperature: ");
        inputField = new JTextField(10);

        //Unit Combobox
        JLabel unitLabel = new JLabel("Convert From: ");
        unitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        // Convert Button
        JButton convertButton = new JButton("Convert");

        //Result Label
        resultLabel1 = new JLabel("Converted Temperature ");
        resultLabel2 = new JLabel("Will Be Displayed Here!");

        // Add components to the frame
        add (inputLabel);
        add (inputField);

        add (unitLabel);
        add (unitComboBox);

        add ( convertButton);
        add (resultLabel1);
        add (resultLabel2);

        // Event listener for the convert button
        convertButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                convertTemperature();
            }
        });
    }

    private void convertTemperature(){
        double temperature;
        try{
            temperature = Double.parseDouble(inputField.getText());
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid temperature value!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedUnit = (String) unitComboBox.getSelectedItem();
        double convertTemperature;

        switch(selectedUnit){
            case "Celsius":
                convertTemperature = celsiusToFahrenheit(temperature);
                resultLabel1.setText("Temperature in Fahrenheit: " + convertTemperature);
                convertTemperature = celsiusToKelvin(temperature);
                resultLabel2.setText("Temperature in Kelvin: " + convertTemperature);
                break;

            case "Fahrenheit":
                convertTemperature = fahrenheitToCelsius(temperature);
                resultLabel1.setText("Temperature in Celsius: " + convertTemperature);
                convertTemperature = fahrenheitToKelvin(temperature);
                resultLabel2.setText("Temperature in Kelvin: " + convertTemperature);
                break;

            case "Kelvin":
                convertTemperature = kelvinToCelsius(temperature);
                resultLabel1.setText("Temperature in Celsius: " + convertTemperature);
                convertTemperature = kelvinToFahrenheit(temperature);
                resultLabel2.setText("Temperature in Fahrenheit: " + convertTemperature);
                break;

            default:
                JOptionPane.showMessageDialog(this, "Invalid unit!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    // Conversion methods
    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius){
        return celsius + 273.15;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TemperatureGUI converter = new TemperatureGUI();
                converter.pack();
                converter.setVisible(true);
            }
        });
    }
}