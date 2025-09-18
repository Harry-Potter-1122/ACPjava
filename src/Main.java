import java.util.*;

public class Main {
    public static void main(String[] args) {
        Assignment1 object = new Assignment1();
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\n ACP Assignment-1");
            System.out.println("1. Add Student");
            System.out.println("2. Update Marks");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student");
            System.out.println("6. Highest inputorer");
            System.out.println("7. Class Average");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();


            switch (choice) {
                case 1 -> object.addStudent();
                case 2 -> object.updateMarks();
                case 3 -> object.removeStudent();
                case 4 -> object.viewAllStudents();
                case 5 -> object.searchStudent();
                case 6 -> object.highestinputorer();
                case 7 -> object.classAverage();
                case 8 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Please choose From Given Options.");
            }
        }
    }
}
