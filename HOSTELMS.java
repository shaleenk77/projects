import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }
    
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    
    public String toString() {
        return "Student [Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks + "]";
    }
}

class Warden {
    private String name;
    private String designation;

    public Warden(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation( String designation ){
        this.designation = designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String toString() {
        return "Warden [Name: " + name + ", Designation: " + designation + "]";
    }
}

class Staff {
    private String name;
    private String role;

    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public String toString() {
        return "Staff [Name: " + name + ", Role: " + role + "]";
    }
}

public class HOSTELMS{
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Warden> wardens = new ArrayList<>();
    private static ArrayList<Staff> staffMembers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice=0;
            try{
            choice = scanner.nextInt();
            scanner.nextLine();}catch(InputMismatchException i){
                System.out.println("The input is invalid the program will be exiting now..");
                System.exit(0);

            } 

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    addWarden();
                    break;

                case 3:
                    addStaffMember();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    removeWarden();
                    break;

                case 6:
                    removeStaffMember();
                    break;

                case 7:
                    listStudents();
                    break;

                case 8:
                    listWardens();
                    break;

                case 9:
                    listStaffMembers();
                    break;

                case 10:
                    updateStudentDetails();
                    break;

                case 11:
                    updateWardenDetails();
                    break;

                case 12:
                    updateStaffDetails();
                    break;

                case 13:
                    selectTopStudentsByMarks();
                break;
                
                case 14:
                    selectTopStudentsForAdmission();
                    break;

                case 15:
                    System.out.println("Exiting Hostel Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayMenu() {

        System.out.println( "\n   +" + String.format("%129s", "+").replace( " ", "-"));
        System.out.println( "   |" + String.format("%128s", " ") + "|" );
        System.out.println( "   +" + String.format("%129s", "+").replace( " ", "-"));
        System.out.println( "   |" + String.format("%128s", " ") + "|" );
        System.out.println( "   |" + String.format("%48s", " ")+ ": HOSTEL MANAGEMENT SYSTEM MENU :" + String.format("%48s", "|") );
        System.out.println( "   |" + String.format("%128s", " ") + "|" );
        System.out.println( "   +" + String.format("%129s", "+").replace( " ", "-"));
        System.out.println( "   |" + String.format("%128s", " ") + "|" );
        System.out.println( "   |" + String.format("%56s", " ")+ "1. ADD STUDENT" + String.format("%59s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "2. ADD WARDEN" + String.format("%60s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "3. ADD STAFF MEMBER" + String.format("%54s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "4. REMOVE STUDENT" + String.format("%56s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "5. REMOVE WARDEN" + String.format("%57s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "6. REMOVE STAFF MEMBER" + String.format("%51s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "7. LIST STUDENTS" + String.format("%57s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "8. LIST WARDENS" + String.format("%58s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "9. LIST STAFF MEMBERS" + String.format("%52s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "10. UPDATE STUDENT DETAILS" + String.format("%47s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "11. UPDATE WARDEN DETAILS" + String.format("%48s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "12. UPDATE STAFF DETAILS" + String.format("%49s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "13. SEE TOPPERS" + String.format("%58s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "14. ADMISSION BY MARKS" + String.format("%51s", "|") );
        System.out.println( "   |" + String.format("%56s", " ")+ "15. EXIT" + String.format("%65s", "|") );
        System.out.println( "   |" + String.format("%128s", " ") + "|" );
        System.out.println( "   +" + String.format("%129s", "+").replace( " ", "-"));
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        students.add(new Student(studentName, rollNumber, marks));
        System.out.println("Student added successfully.");
    }

    private static void addWarden() {
        System.out.print("Enter warden name: ");
        String wardenName = scanner.nextLine();
        System.out.print("Enter warden designation: ");
        String designation = scanner.nextLine();
        wardens.add(new Warden(wardenName, designation));
        System.out.println("Warden added successfully.");
    }

    private static void addStaffMember() {
        System.out.print("Enter staff member name: ");
        String staffName = scanner.nextLine();
        System.out.print("Enter staff member role: ");
        String role = scanner.nextLine();
        staffMembers.add(new Staff(staffName, role));
        System.out.println("Staff member added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student roll number to remove: ");
        int rollToRemove = scanner.nextInt();
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getRollNumber() == rollToRemove) {
                studentIterator.remove();
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found with the specified roll number.");
    }
    
    
    private static void removeWarden() {
        System.out.print("Enter warden name to remove: ");
        String wardenToRemove = scanner.nextLine();
        Iterator<Warden> wardenIterator = wardens.iterator();
        while (wardenIterator.hasNext()) {
            Warden warden = wardenIterator.next();
            if (warden.getName().equals(wardenToRemove)) {
                wardenIterator.remove();
                System.out.println("Warden removed successfully.");
                return;
            }
        }
        System.out.println("Warden not found with the specified name.");
    }
    
    
    private static void removeStaffMember() {
        System.out.print("Enter staff member name to remove: ");
        String staffToRemove = scanner.nextLine();
        Iterator<Staff> staffIterator = staffMembers.iterator();
        while (staffIterator.hasNext()) {
            Staff staff = staffIterator.next();
            if (staff.getName().equals(staffToRemove)) {
                staffIterator.remove();
                System.out.println("Staff member removed successfully.");
                return;
            }
        }
        System.out.println("Staff member not found with the specified name.");
    }

    private static void selectTopStudentsByMarks() {
        System.out.print("Enter the number of top students to select: ");
        int topN = scanner.nextInt();

        if (topN > students.size()) {
            System.out.println("Error: Not enough students in the list to select " + topN + " students.");
            return;
        }

        Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());

        System.out.println("Top " + topN + " Students by Marks:");
        for (int i = 0; i < topN; i++) {
            System.out.println(students.get(i));
        }
    }
    
    private static void listStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    private static void listWardens() {
        System.out.println("List of Wardens:");
        for (Warden warden : wardens) {
            System.out.println(warden);
        }
    }
    
    private static void listStaffMembers() {
        System.out.println("List of Staff Members:");
        for (Staff staff : staffMembers) {
            System.out.println(staff);
        }
    }

private static void updateStudentDetails() {
    System.out.print("Enter student roll number to update details: ");
    int rollToUpdate = scanner.nextInt();
    scanner.nextLine(); 

    for (Student student : students) {
        if (student.getRollNumber() == rollToUpdate) {
            System.out.println("Current details for student with roll number " + rollToUpdate + ":");
            System.out.println(student);

            System.out.print("Enter new student name (press Enter to keep it unchanged): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                student.setName(newName);
            }

            System.out.print("Enter new student marks (press Enter to keep it unchanged): ");
            String marksInput = scanner.nextLine();
            if (!marksInput.isEmpty()) {
                double newMarks = Double.parseDouble(marksInput);
                student.setMarks(newMarks);
            }

            System.out.println("Student details updated successfully.");
            return;
        }
    }

    System.out.println("Student with roll number " + rollToUpdate + " not found.");
}

private static void updateStaffDetails() {
    System.out.print("Enter staff member name to update details: ");
    String nameToUpdate = scanner.nextLine();

    for (Staff staff : staffMembers) {
        if (staff.getName().equalsIgnoreCase(nameToUpdate)) {
            System.out.println("Current details for staff member with name " + nameToUpdate + ":");
            System.out.println(staff);

            System.out.print("Enter new staff member role (press Enter to keep it unchanged): ");
            String newRole = scanner.nextLine();
            if (!newRole.isEmpty()) {
                staff.setRole(newRole);
            }

            System.out.println("Staff member details updated successfully.");
            return;
        }
    }

    System.out.println("Staff member with name " + nameToUpdate + " not found.");
}

private static void updateWardenDetails() {
    System.out.print("Enter warden name to update details: ");
    String nameToUpdate = scanner.nextLine();

    for (Warden warden : wardens) {
        if (warden.getName().equalsIgnoreCase(nameToUpdate)) {
            System.out.println("Current details for warden with name " + nameToUpdate + ":");
            System.out.println(warden);

            System.out.print("Enter new warden designation (press Enter to keep it unchanged): ");
            String newDesignation = scanner.nextLine();
            if (!newDesignation.isEmpty()) {
                warden.setDesignation(newDesignation);
            }

            System.out.println("Warden details updated successfully.");
            return;
        }
    }

    System.out.println("Warden with name " + nameToUpdate + " not found.");
}

    
private static void selectTopStudentsForAdmission() {
    System.out.println("Enter student data (or type 'done' to finish):");
    
    ArrayList<Student> studentData = new ArrayList<>();
    while (true) {
        System.out.print("Enter student name (or 'done' to finish entering students): ");
        String studentName = scanner.nextLine();
        
        if (studentName.equalsIgnoreCase("done")) {
            break;
        }
        
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.println("Enter student marks :");
        double marks = scanner.nextDouble();
        scanner.nextLine();
        
        studentData.add(new Student(studentName, rollNumber, marks));
    }
    
    System.out.print("Enter the number of top students to admit: ");
    int topN = scanner.nextInt();
    
    if (topN > studentData.size()) {
        System.out.println("Error: Not enough students entered to admit " + topN + " students.");
        return;
    }
    
    Collections.sort(studentData, Comparator.comparingInt(Student::getRollNumber));
    
    for (int i = 0; i < topN; i++) {
        students.add(studentData.get(i));
    }
    
    System.out.println("Selected top " + topN + " students for admission.");
}
   
}