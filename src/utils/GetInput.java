package utils;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class GetInput {

    static Scanner scanner = new Scanner(System.in);
    public static String getIdUser(String code) {
        String id;
        String regex = "^" + code + "-\\d{4}";
        do {
            id = scanner.nextLine();
            if (!id.matches(regex)) {
                System.out.println("Re-enter: " + code + "-XXXX");
            }
        } while (!id.matches(regex));
        return id;
    }
    public static String getNameUser() {
        String name;
        String regex = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";
        do {
            name = scanner.nextLine();
            if (!name.matches(regex)){
                System.out.println("You must capitalize the first letters!!!");
            }
        } while (!name.matches(regex));
        return name;
    }
    public static String getDate(boolean checkAge) {
        boolean correct;
        String date = "";
        do {
            try {
                date = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(date, formatter);
                correct = true;
                if (checkAge) {
                    LocalDate today = LocalDate.now();
                    Period age = Period.between(localDate, today);
                    if (age.getYears() < 18) {
                        System.out.println("Under 18 years old!");
                        correct = false;
                    }
                }
            } catch (DateTimeException e) {
                System.out.println("The date you just entered is incorrect!!!: dd/MM/yyyy");
                correct = false;
            }
        } while (!correct);
        return date;
    }
    public static String getCMND() {
        String idCard;
        String regex = "^\\d{9}(\\d{3})?$";
        do {
            idCard = scanner.nextLine();
            if (!idCard.matches(regex)) {
                System.out.println("Error!!!Please, includes 9 or 12 numbers");
            }
        } while (!idCard.matches(regex));
        return idCard;
    }
    public static String getPhoneNumber() {
        String phonenumber;
        String regex = "^0\\d{9}";
        do {
            phonenumber = scanner.nextLine();
            if (!phonenumber.matches(regex)) {
                System.out.println("Re-enter: 0XXXXXXXXX");
            }
        } while (!phonenumber.matches(regex));
        return phonenumber;
    }

    public static String getIdService() {
        String regex = "^(SVVL|SVHO|SVRO)-[0-9]{4}$";
        String idService;
        do {
            idService = scanner.nextLine();
            if (!idService.matches(regex)) {
                System.out.println("Please re-enter: SVVL-XXXX or SVHO-XXXX or SVRO-XXXX");
            }
        } while (!idService.matches(regex));
        return idService;
    }
    public static String getIdService(String code) {
        String regex = "^SV" + code + "-\\d{4}";
        String id;
        do {
            id = scanner.nextLine();
            if (!id.matches(regex)) {
                System.out.println("Wrong format, re-enter: SV" + code + "-XXXX");
            }
        } while (!id.matches(regex));
        return id;
    }
    public static String getText() {
        String regex = "^[A-Z][a-z]*[0-9]*(\\s+[a-z]*[0-9]*)*$";
        String text;
        do {
            text = scanner.nextLine();
            if (!text.matches(regex)) {
                System.out.println("You must capitalize the first letters!!!");
            }
        } while (!text.matches(regex));
        return text;
    }

    public static double getAcreage() {
        boolean correct;
        double acreage = 0;
        do {
            try {
                acreage = Double.parseDouble(scanner.nextLine());
                if (acreage > 30) {
                    correct = true;
                } else {
                    correct = false;
                    System.out.println("The acreage must be greater than 30m2");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                correct = false;
                System.out.println("Error!!! Please re-enter ");
            }
        } while (!correct);
        return acreage;
    }

    public static double getExpense() {
        boolean correct;
        double expense = 0;
        do {
            try {
                expense = Double.parseDouble(scanner.nextLine());
                if (expense > 0) {
                    correct = true;
                } else {
                    correct = false;
                    System.out.println("The salary must be greater than 0");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                correct = false;
                System.out.println("Error!!! Please re-enter ");
            }
        } while (!correct);
        return expense;
    }

    public static int getNumber() {
        int number = 0;
        boolean correct;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    correct = true;
                } else {
                    correct = false;
                    System.out.println("You must enter a number greater than 0!!!");
                }
            } catch (NumberFormatException e) {
                correct = false;
                System.out.println("You must enter a number greater than 0!!!");
            }
        } while (!correct);
        return number;
    }

    public static int getNumberPerson() {
        int number = 0;
        boolean correct;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 20) {
                    correct = true;
                } else {
                    correct = false;
                    System.out.println("You must enter a number greater than 0 and less than 20!!!");
                }
            } catch (NumberFormatException e) {
                correct = false;
                System.out.println("You must enter a number greater than 0 and less than 20!!!");
            }
        } while (!correct);
        return number;
    }
    public static int getUserChoice(int min, int max) {
        int choice;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + " !!!");
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between " + min + " and " + max + " !!!");
            }
        } while (true);
    }
}
