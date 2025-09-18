import java.util.*;

class Student {
    private int rollNo;
    private String name;
    private int[] marks = new int[3];

    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    @Override
    public String toString() {
        return String.format("%-7d | %-10s | %-3d %-3d %-3d | %-5d | %-6.2f",
                rollNo, name, marks[0], marks[1], marks[2], getTotal(), getAverage());
    }
}

public class Assignment1 {
    private static final int MAX_STUDENTS = 50;
    private HashMap<Integer, Student> students = new HashMap<>();
    private Scanner input = new Scanner(System.in);

    // 1. Add Student
    public void addStudent() {
        if (students.size() >= MAX_STUDENTS) {
            System.out.println("Cannot add more students (limit reached).");
            return;
        }
        System.out.print("Enter Roll No: ");
        int rollNo = input.nextInt();
        if (students.containsKey(rollNo)) {
            System.out.println("Error: Roll number already exists!");
            return;
        }
        input.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = input.nextLine();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter Marks in Subject " + (i + 1) + ": ");
                int mark = input.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Marks must be between 0 and 100.");
                }
            }
        }
        students.put(rollNo, new Student(rollNo, name, marks));
        System.out.println("Student added successfully!");
    }

    // 2. Update Marks
    public void updateMarks() {
        System.out.print("Enter Roll No to update: ");
        int rollNo = input.nextInt();
        if (!students.containsKey(rollNo)) {
            System.out.println("Error: Student not found!");
            return;
        }
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter New Marks in Subject " + (i + 1) + ": ");
                int mark = input.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Marks must be between 0 and 100.");
                }
            }
        }
        students.get(rollNo).setMarks(marks);
        System.out.println("Marks updated successfully!");
    }

    // 3. Remove Student
    public void removeStudent() {
        System.out.print("Enter Roll No to remove: ");
        int rollNo = input.nextInt();
        if (students.remove(rollNo) != null) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Error: Student not found!");
        }
    }

    // 4. View All Students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\nRoll No | Name       | Marks         | Total | Average");
        System.out.println("-----------------------------------------------------");
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }

    // 5. Search Student
    public void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int rollNo = input.nextInt();
        if (!students.containsKey(rollNo)) {
            System.out.println("Error: Student not found!");
            return;
        }
        Student s = students.get(rollNo);
        System.out.println("\nStudent Found:");
        System.out.println(s);
    }

    // 6. Highest inputorer
    public void highestinputorer() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        Student top = Collections.max(students.values(), Comparator.comparingInt(Student::getTotal));
        System.out.println("\nHighest inputorer:");
        System.out.println(top);
    }

    // 7. Class Average
    public void classAverage() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        int totalMarks = students.values().stream().mapToInt(Student::getTotal).sum();
        int totalSubjects = students.size() * 3;
        double avg = totalMarks / (double) totalSubjects;
        System.out.printf("Class Average Marks: %.2f\n", avg);
    }
}
