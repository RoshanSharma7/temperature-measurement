import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Temperature: ");
        double temperature = sc.nextDouble();

        System.out.println("Select The Unit To Convert From");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();

        double convertedTemperature;

        switch(choice){
            case 1:
                convertedTemperature = celsiusToFahrenheit(temperature);
                System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
                convertedTemperature = celsiusToKelvin(temperature);
                System.out.println("Temperature in Kelvin: " + convertedTemperature);
                break;

            case 2:
                convertedTemperature = fahrenheitToCelsius(temperature);
                System.out.println("Temperature in Celsius: " + convertedTemperature);
                convertedTemperature = fahrenheitToKelvin(temperature);
                System.out.println("Temperature in Kelvin: " + convertedTemperature);
                break;

            case 3:
                convertedTemperature = kelvinToCelsius(temperature);
                System.out.println("Temperature in Celsius: " + convertedTemperature);
                convertedTemperature = kelvinToFahrenheit(temperature);
                System.out.println("Temperature in Fatrenheit: " + convertedTemperature);
                break;

            default:
                System.out.println("Invalid Choice!");        
        }

        sc.close();
    }

    public static double celsiusToFahrenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius){
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}