import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> student = new HashMap<>();
        Map<String, Map<String,Integer>> studentResults =new HashMap<>();
        Map<String,String> claims =new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("EXAMINATION MANAGEMENT SYSTEM");
        int loginChoice;
        do {
            System.out.println("Please login \n 1.Login As Admin \n 2.Login As student");
            loginChoice = scanner.nextInt();
            switch (loginChoice) {
                case 1:
                    System.out.println("Enter your username");
                    String username = scanner.next();
                    System.out.println("Enter password");
                    String password = scanner.next();
                    System.out.println("Login successful");
                    int adminMenuChoice;
                    System.out.println("***WELCOME***");
                    do {
                        System.out.println("1.Add new student \n 2.Input student results \n 3.check student results \n 4.Remove student from the system \n 5.claims \n 6.Exit ");
                        adminMenuChoice = scanner.nextInt();

                        switch (adminMenuChoice) {
                            case 1:
                                System.out.println("Enter student name");
                                String name = scanner.next();
                                System.out.println("Enter student id");
                                String studentId = scanner.next();
                                student.put(studentId, name);
                                System.out.println("Student added successful");
                                System.out.println("back to the menu \n 1.yes \n 2.no");
                                int backMenu = scanner.nextInt();
                                if(backMenu == 2){
                                    exit(backMenu);
                                }

                                break;
                            case 2:
                                System.out.println("Enter student id");
                                studentId = scanner.next();
                                if (student.containsKey(studentId)) {
                                    String Name = student.get(studentId);
                                    System.out.println("student found");
                                    System.out.println("Enter the marks ");
                                    Map<String, Integer> subjectMarks = new HashMap<>();
                                    System.out.print("web dev: ");
                                    int webMarks = scanner.nextInt();
                                    subjectMarks.put("Web dev", webMarks);
                                    System.out.print("java: ");
                                    int javaMarks = scanner.nextInt();
                                    subjectMarks.put("java", javaMarks);
                                    System.out.print("c: ");
                                    int cMarks = scanner.nextInt();
                                    subjectMarks.put("c", cMarks);
                                    System.out.print("c++: ");
                                    int cppMarks = scanner.nextInt();
                                    subjectMarks.put("C++", cppMarks);
                                    System.out.print("python: ");
                                    int pythonMarks = scanner.nextInt();
                                     subjectMarks.put("python", pythonMarks);
                                    studentResults.put(studentId, subjectMarks);
                                    System.out.println("Results saved for " + student.get(studentId));
                                    System.out.println("back to the menu \n 1.yes \n 2.no");
                                     backMenu = scanner.nextInt();
                                    if(backMenu == 2){
                                        exit(backMenu);
                                    }


                                } else {
                                    System.out.println("student not found");
                                    System.out.println("back to the menu \n 1.yes \n 2.no");
                                    backMenu = scanner.nextInt();
                                    if(backMenu == 2){
                                        exit(backMenu);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Enter student id");
                                studentId = scanner.next();
                                if (studentResults.containsKey(studentId)) {
                                    System.out.println("Results for " + student.get(studentId) + ":");
                                    Map<String, Integer> results = studentResults.get(studentId);
                                    for (Map.Entry<String, Integer> entry : results.entrySet()) {
                                        System.out.println(entry.getKey() + ": " + entry.getValue());
                                    }
                                    System.out.println("back to the menu \n 1.yes \n 2.no");
                                    backMenu = scanner.nextInt();
                                    if(backMenu == 2){
                                        exit(backMenu);
                                    }
                                } else {
                                    System.out.println("Results not found for the student");
                                    System.out.println("back to the menu \n 1.yes \n 2.no");
                                    backMenu = scanner.nextInt();
                                    if(backMenu == 2){
                                        exit(backMenu);
                                    }
                                }

                                break;
                            case 4:
                                System.out.println("remove student");
                                System.out.println("Enter student id");
                                studentId = scanner.next();
                                String removedStudentName = student.get(studentId);
                                if (student.containsKey(studentId)) {
                                    student.remove(studentId);
                                    studentResults.remove(studentId);
                                    System.out.println(studentId + " Removed successfully");
                                    System.out.println("back to the menu \n 1.yes \n 2.no");
                                    backMenu = scanner.nextInt();
                                    if(backMenu == 2){
                                        exit(backMenu);
                                    }
                                } else {
                                    System.out.println(studentId + " not found");
                                    System.out.println("back to the menu \n 1.yes \n 2.no");
                                    backMenu = scanner.nextInt();
                                    if(backMenu == 2){
                                        exit(backMenu);
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("claims");
                                System.out.println("Claims:");
                                for (Map.Entry<String, String> claimEntry : claims.entrySet()) {
                                     studentId = claimEntry.getKey();
                                    String claim = claimEntry.getValue();
                                    System.out.println("Student ID: " + studentId + " \n Claim: " + claim);
                                }
                                System.out.println("back to the menu \n 1.yes \n 2.no");
                                backMenu = scanner.nextInt();
                                if(backMenu == 2){
                                    exit(backMenu);
                                }
                                break;
                            default:
                                System.out.println("Invalid input");
                        }
                    }
                    while (adminMenuChoice != 6);

                    break;
                case 2:
                    System.out.println("student");
                    int studentLoginMenu;
                    do {
                        System.out.println("1.Check Results \n 2. Claims \n 3.Exit");
                        studentLoginMenu =scanner.nextInt();
                        switch (studentLoginMenu){
                            case 1:
                                System.out.println("Enter student id");
                                String studentId  = scanner.next();
                                if (studentResults.containsKey(studentId)) {
                                    System.out.println("Results for " + student.get(studentId) + ":");
                                    Map<String, Integer> results = studentResults.get(studentId);
                                    for (Map.Entry<String, Integer> entry : results.entrySet()) {
                                        System.out.println(entry.getKey() + ": " + entry.getValue());
                                    }
                                } else {
                                    System.out.println("Results not found for the student");
                                }

                                break;
                            case 2:
                                Scanner scanner1 =new Scanner(System.in);
                                System.out.println("Claims");
                                System.out.println("Enter your id");
                                studentId = scanner.next();
                                System.out.println("Enter your claim");
                                String claim = scanner1.nextLine();
                                claims.put(studentId, claim);
                                if(true) {
                                    System.out.println("claim sent successful");
                                }
                                else {
                                    System.out.println("failed try again!!");
                                }
                                break;
                            default:
                                System.out.println("invalid input");


                        }

                    }
                    while (studentLoginMenu != 3);



            }
        }
        while (loginChoice == 1 || loginChoice==2);
    }
}
