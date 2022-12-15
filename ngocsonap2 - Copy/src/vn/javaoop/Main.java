package vn.javaoop;

import java.util.Scanner;

/**
 * Main class
 * 
 * @author ADMIN
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        lecturersManager lecturersManager = new lecturersManager();
        int studentId;
        int lecturersId;

        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
                studentManager.add();
                break;
            case "2":
                studentId = studentManager.inputId();
                studentManager.edit(studentId);
                break;
            case "3":
                studentId = studentManager.inputId();
                studentManager.delete(studentId);
                break;
        
            case "4":
                studentManager.show();
                break;
            case "5":
                String id = scanner.nextLine();
                studentManager.search(id);
                break;
            
             //THIS IS LECTURERS MANAGER

            case "6":
                lecturersManager.add();
                break;

            case "7":
                lecturersId =  lecturersManager.inputId();
                lecturersManager.edit(lecturersId);
                break;
            case "8":
                lecturersId = lecturersManager.inputId();
                lecturersManager.delete(lecturersId);
                break;
            case "9":
                lecturersManager.show();
                break;
            case "10":
                String id1 = scanner.nextLine();
                lecturersManager.search(id1);
                break;

            case "0":
                System.out.println("exited!");
                exit = true;
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }

    }
 

    /**
     * create menu 
     */
    // edit sinh vien
    public static void showMenu() {
        System.out.println("-----------MENU BTEC STUDENT MANAGER------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Show student.");
        System.out.println("5. search.");
        System.out.println("-----------MENU BTEC LECTURERS MANAGER------------");
        System.out.println("6. Add lecturers.");
        System.out.println("7. Edit lecturers");
        System.out.println("8. Delete lecturers");
        System.out.println("9. shows lecturers");
        System.out.println("10. search.");
        
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
