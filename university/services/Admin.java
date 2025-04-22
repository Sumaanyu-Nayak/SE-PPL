package university.services;

public class Admin implements Role {
    private String department;

    public Admin(String department) {
        this.department = department;
    }

    @Override
    public void showRole() {
        System.out.println("I am an admin staff.");
    }

    public void displayInfo() {
        System.out.println("Department: " + department);
    }
}