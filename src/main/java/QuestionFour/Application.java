package QuestionFour;

import QuestionFour.constants.Constants;
import QuestionFour.entity.*;
import QuestionFour.exception.DatePatternMismatchException;
import QuestionFour.exception.IncorrectCommandException;
import QuestionFour.utils.DateParserUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        //“John Smith born 03/24/1984”
        String[] userInfoArray = userInput.split(Constants.SPACE);

        if (userInfoArray.length == 4) {
            LocalDate dateOfBirth;
            if (DateParserUtils.matches(userInfoArray[3])) {
                dateOfBirth = DateParserUtils.formatDateFromString(userInfoArray[3]);
            } else {
                throw new DatePatternMismatchException();
            }

            String firstName = userInfoArray[0];
            String lastName = userInfoArray[1];
            PersonManager person = new PersonManager(
                    firstName,
                    lastName,
                    dateOfBirth);

            System.out.println("Profile Created");
            System.out.println("Choose the vehicle you need to buy: \n 1. Car \n 2. Bike");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    person.typeAndDateOfPurchase(new Car());
                    break;
                case 2:
                    person.typeAndDateOfPurchase(new Bike());
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        } else {
            throw new IncorrectCommandException();
        }
    }
}
