package vn.javaoop;

import java.util.List;
import java.util.Scanner;

/**
 * StudentManager class
 * 
 * @author ADMIN
 */
public class lecturersManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<lecturers> lecturersList;
    private lecturersDao lecturersDao;

    public lecturersManager() {
       lecturersDao = new lecturersDao();
        lecturersList = lecturersDao.read();
    }

    /**
     * add lecturers to lecturersList
     * 
     * @param lecturers
     */
    public void add() {
        int id = (lecturersList.size() > 0) ? (lecturersList.size() + 1) : 1;
        System.out.println("lecturers id = " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        
        lecturers lecturers = new lecturers(id, name, age, address );
        lecturersList.add(lecturers);
        lecturersDao.write(lecturersList);
    }

    /**
     * edit lecturers by id
     * 
     * @param id
     */
    public void edit(int id) {
        boolean isExisted = false;
        int size = lecturersList.size();
        for (int i = 0; i < size; i++) {
            if (lecturersList.get(i).getId() == id) {
                isExisted = true;
                lecturersList.get(i).setName(inputName());
                lecturersList.get(i).setAge(inputAge());
                lecturersList.get(i).setAddress(inputAddress());
                
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            lecturersDao.write(lecturersList);
        }
    }

    /**
     * delete lecturers  by id
     * 
     * @param id: lecturers  id
     */
    public void delete(int id) {
        lecturers lecturers = null;
        int size = lecturersList.size();
        for (int i = 0; i < size; i++) {
            if (lecturersList.get(i).getId() == id) {
                lecturers = lecturersList.get(i);
                break;
            }
        }
        if (lecturers != null) {
            lecturersList.remove(lecturers);
            lecturersDao.write(lecturersList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }
     /**
     * search lecturers  by id
     * 
     * @param id: lecturers  id
     */

    public void search(String id) {
        lecturers n = this.lecturersList.stream()
            .filter(StudentList->StudentList.getid().equals(id))
            .findFirst().orElse(null);
            if (n == null) {
                System.out.println("has no student with this id");
            }
            else{
                this.lecturersList.forEach(students -> System.out.println(lecturersList.toString()));
            }
    }
    

    
   

    /**
     * show list student to screen
     */
    public void show() {
        for (lecturers lecturers : lecturersList) {
            System.out.format("%5d | ", lecturers .getId());
            System.out.format("%20s | ", lecturers .getName());
            System.out.format("%5d | ", lecturers .getAge());
            System.out.format("%20s | ", lecturers .getAddress());
           
        }
    }
   

    /**
     * input student id
     * 
     * @return student id
     */
    public int inputId() {
        System.out.print("Input lecturers id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input lecturers id again: ");
            }
        }
    }
    
    /**
     * input lecturers name
     * 
     * @return lecturers  name
     */
    private String inputName() {
        System.out.print("Input lecturers name: ");
        return scanner.nextLine();
    }

    /**
     * input lecturers  address
     * 
     * @return lecturers  address
     */
    private String inputAddress() {
        System.out.print("Input lecturers address: ");
        return scanner.nextLine();
    }

    /**
     * input lecturers  age
     * 
     * @return lecturers  age
     */
    private byte inputAge() {
        System.out.print("Input lecturers age: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input lecturers  id again: ");
            }
        }
    }

 

    // getter && setter
    public List<lecturers> getlecturersList() {
        return lecturersList;
    }

    public void setlecturersList(List<lecturers> lecturersList) {
        this.lecturersList = lecturersList;
    }
}
