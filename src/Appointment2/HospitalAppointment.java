package Appointment2;

import java.util.ArrayList;
import java.util.Scanner;
import model.DoctorAppointment;
import model.PatientAppointment;
import model.PatientData;
import Exception.InvalidInputException;




public class HospitalAppointment implements Appointment2{
    private final ArrayList<Appointment2> allAppointments;
    private final ArrayList<PatientData> allPatientData;
    public Scanner scanner;

    public HospitalAppointment() {
        this.allAppointments = new ArrayList<>();
        this.allPatientData = new ArrayList<>();
        this.scanner = new Scanner(System.in);


        try {
            allAppointments.add(new DoctorAppointment(251027, "23.01.2026", "in progress", "Alima Beisembayeva", "surgeon"));
            allAppointments.add(new PatientAppointment(261027, "23.01.2026", "accepted", "Yeldana Sailaubek"));

            allPatientData.add(new PatientData("Aiasem Bekbolat", 17, "emergency"));
            allPatientData.add(new PatientData("Laura Tursynbek", 17, "stable"));
            allPatientData.add(new PatientData("Dannar Erezhep", 17, "accepted"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayAppointment() {
        System.out.println("================================");
        System.out.println("     HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Add Doctor Appointment");
        System.out.println("2. Add Patient Appointment");
        System.out.println("3. View all Appointments");
        System.out.println("4. View Patient Appointment only");
        System.out.println("5. View Doctor Appointment only");
        System.out.println("6. Make all Appointments work");
        System.out.println("7. Add Appointment Data");
        System.out.println("8. View All Patient Data");
        System.out.println("9. Accept PAtient Data");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayAppointment();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addDoctorAppointment();
                        break;
                    case 2:
                        addPatientAppointment();
                        break;
                    case 3:
                        viewAllAppointments();
                        break;
                    case 4:
                        viewDoctorAppointment();
                        break;
                    case 5:
                        viewPatientAppointment();
                        break;
                    case 6:
                        demonstratePolymorphism();
                        break;
                    case 7:
                        addPatientData();
                        break;
                    case 8:
                        viewPatientData();
                        break;
                    case 9:
                        acceptPatientData();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Thank you for using Hospital Management System!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! PLease select 0-9.");

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }


        }
        scanner.close();
    }

    private void addDoctorAppointment() {
        try {
            System.out.println("------ADD DOCTOR APPOINTMENT------");

            System.out.println("Enter appointment Id: ");
            int appointmentId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter date: ");
            String date = scanner.nextLine();

            System.out.println("Enter status: ");
            String status = scanner.nextLine();

            System.out.println("Enter Doctor name: ");
            String doctorName = scanner.nextLine();

            System.out.println("Enter specialization: ");
            String specialization = scanner.nextLine();


            DoctorAppointment doctorAppointment = new DoctorAppointment(appointmentId, date, status, doctorName, specialization);
            allAppointments.add(doctorAppointment);
            System.out.println("Doctor Appointment added successfully!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Validation Error: " + e.getMessage());
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addPatientAppointment() {
        try {
            System.out.println("------ADD PATIENT APPOINTMENT------");

            System.out.println("Enter appointment Id: ");
            int appointmentId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter date: ");
            String date = scanner.nextLine();

            System.out.println("Enter status: ");
            String status = scanner.nextLine();


            System.out.println("Enter Patient name: ");
            String patientName = scanner.nextLine();


            PatientAppointment patientAppointment = new PatientAppointment(appointmentId, date, status, patientName);
            allAppointments.add(patientAppointment);
            System.out.println("Patient Appointment added succesfully!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }



    private void viewAllAppointments() {
        System.out.println("===========================");
        System.out.println("     VIEW ALL APPOINTMENTS");
        System.out.println("===========================");

        if (allAppointments.isEmpty()) {
            System.out.println("No appointments found");
            return;
        }

        for (int i = 0; i < allAppointments.size(); i++) {
            Appointment2 a = allAppointments.get(i);
            System.out.println((i + 1) + ". ");

            if (a instanceof DoctorAppointment) {
                System.out.println("[DOCTOR]");
                DoctorAppointment doctorAppointment = (DoctorAppointment) a;
                if (doctorAppointment.isSpecialistAppointment()) {
                    System.out.println("Doctor is specialist");
                }
            } else if (a instanceof PatientAppointment) {
                System.out.println("[PATIENT]");
                PatientAppointment patientAppointment = (PatientAppointment) a;
                if (patientAppointment.isFirstVisit()) {
                    System.out.println(" First Visit");
                }
            }

            System.out.println(a.toString());

        }
    }

    private void viewDoctorAppointment() {
        System.out.println("===================================");
        System.out.println("       DOCTOR APPOINTMENTS ONLY");
        System.out.println("===================================");

        boolean foundDoctor = false;

        for (Appointment2 a : allAppointments) {
            if (a instanceof DoctorAppointment) {
                DoctorAppointment doctorAppointment = (DoctorAppointment) a;
                System.out.println(doctorAppointment.toString());
                if(doctorAppointment.isSpecialistAppointment()) {
                    System.out.println(" Doctor is specialist");
                }
                System.out.println();
                foundDoctor=true;

            }
        }
        if (!foundDoctor) {
            System.out.println("No doctors found.");
        }
    }

    private void viewPatientAppointment() {
        System.out.println("===================================");
        System.out.println("       PATIENT APPOINTMENTS ONLY");
        System.out.println("===================================");

        boolean foundPatient = false;

        for (Appointment2 a : allAppointments) {
            if (a instanceof PatientAppointment) {
                PatientAppointment patientAppointment = (PatientAppointment) a;
                System.out.println(patientAppointment.toString());
                if (patientAppointment.isFirstVisit()) {
                    System.out.println("The first visit");
                }
                System.out.println();
                foundPatient = true;
            }
        }
        if(!foundPatient){
            System.out.println("No patient found.");
        }
    }

    private void demonstratePolymorphism(){
        System.out.println("========================================");
        System.out.println("    POLYMORPHISM: All Appointments Conducted");
        System.out.println("========================================");

        if(allAppointments.isEmpty()){
            System.out.println("No appointments to demonstrate.");
            return;
        }
        for (Appointment2 a: allAppointments){
            a.displayAppointment();
        }

        System.out.println("As you can see same method but different behavior");
        System.out.println("This is POLYMOROHISM in action");
    }
    private void addPatientData(){
        try{
            System.out.println(" Add Patient Data");

            System.out.println("Enter name: ");
            String name= scanner.nextLine();

            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter state: ");
            String state= scanner.nextLine();

            PatientData data= new PatientData(name, age, state);
            allPatientData.add(data);
            System.out.println("Patient data added succesfully");
        }catch (java.util.InputMismatchException e){
            System.out.println("Error: invalid input type");
            scanner.nextLine();
        }catch (IllegalArgumentException e){
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewPatientData(){
        System.out.println("\\n========================================");
        System.out.println("              PATIENT DATA                ");
        System.out.println("==========================================");

        if(allPatientData.isEmpty()){
            System.out.println("No patient data found");
            return;
        }

        for (int i=0; i<allPatientData.size();i++){
            System.out.println((i+1) + ". " + allPatientData.get(i).toString());
        }
    }

    private void acceptPatientData(){
        System.out.println("\n--- Accept Patient Data ---");

        if(allPatientData.isEmpty()){
            System.out.println("No data available to be accepted");
            return;
        }

        System.out.println("Available data: ");
        for(int i=0; i<allPatientData.size(); i++){
            System.out.println((i+1) + ". " + allPatientData.get(i).getName());
        }

        try{
            System.out.println("Select data number to check: ");
            int choice=scanner.nextInt();

            if(choice<1 || choice>allPatientData.size()){
                throw new InvalidInputException("Invalid data number");
            }

            PatientData data= allPatientData.get(choice - 1);
            data.accept();
            System.out.println("Data: " + data.getData());
        } catch (java.util.InputMismatchException e){
            System.out.println("Eror: PLease enter a valid number");
            scanner.nextLine();
        }catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}







