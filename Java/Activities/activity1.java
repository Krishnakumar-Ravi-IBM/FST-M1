package activities;

public class activity1 {
    public static void main(String[] args) {
        Car KIA = new Car();
        KIA.iMake = 2014;
        KIA.sColor = "BLACK";
        KIA.sTransmission = "Manual";
        KIA.displayCharacteristics();
        KIA.accelarate();
        KIA.brake();
    }
}
