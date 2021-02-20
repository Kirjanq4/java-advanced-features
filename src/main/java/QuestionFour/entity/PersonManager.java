package QuestionFour.entity;

import QuestionFour.constants.Constants;


import java.time.LocalDate;

public class PersonManager extends Person {


    public PersonManager(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }


    public void typeAndDateOfPurchase(Vehicle vehicle) {

        setVehicle(vehicle);
        setVehiclePurchaseDate(LocalDate.now());

        displayPersonPurchase();
    }

    public void displayPersonPurchase() {
        System.out.println(getFirstName() +
                Constants.SPACE +
                getLastName() +
                Constants.SPACE +
                getDateOfBirth());
        System.out.println("Bought "
                + getVehicle().getType().name()
                + " on " + getVehiclePurchaseDate(LocalDate.now()));
    }
}
