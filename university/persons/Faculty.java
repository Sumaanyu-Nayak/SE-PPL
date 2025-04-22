package university.persons;

import university.services.Role;

public class Faculty extends Person implements Role {
    private String facultyId;
    private String subject;

    public Faculty(String name, int age, String facultyId, String subject) {
        super(name, age);
        this.facultyId = facultyId;
        this.subject = subject;
    }

    @Override
    public void showRole() {
        System.out.println("I am a faculty member.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Subject: " + subject);
    }
}