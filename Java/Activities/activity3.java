package activities;

import java.util.Scanner;

public class activity3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please keyin your age in seconds: ");
//        double seconds = 1000000000;
        double userAge = input.nextInt();

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;

        System.out.println("Age on Mercury: " + userAge / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + userAge / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + userAge / EarthSeconds);
        System.out.println("Age on Mars: " + userAge / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + userAge / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + userAge / EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + userAge / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + userAge / EarthSeconds / NeptuneSeconds);
    }
}
