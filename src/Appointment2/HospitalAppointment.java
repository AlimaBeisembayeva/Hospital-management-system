package Appointment2;

import model.*;
import Exception.InvalidInputException;
import database.*;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;



public class HospitalAppointment implements Appointment2{
    private Scanner scanner;
    private AppointmentDAO appointmentDAO;

    public HospitalAppointment() {
        this.scanner = new Scanner(System.in);
        this.appointmentDAO=new AppointmentDAO();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  HOSPITAL MANAGEMENT SYSTEM v2.0    ║");
        System.out.println("║  Week 8: Fully Database-Driven 🗄️     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("All data is stored in PostgreSQL");
        System.out.println("No in-memory ArrayLists");
        System.out.println("Complt=ete CRUD operations");
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
        System.out.println("6. Update Appointment");
        System.out.println("7. Delete appointment");
        System.out.println("8. Search by date");
        System.out.println("9. Search by Status");
        System.out.println("10. Polymorphism Demo");
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
                        updateAppointment();
                        break;
                    case 7:
                        deleteAppointment();
                        break;
                    case 8:
                        searchByDate();
                        break;
                    case 9:
                        searchByStatus();
                        break;
                    case 10:
                        demonstratePolymorphism();
                    case 0:
                        running = false;
                        System.out.println("Thank you for using Hospital Management System!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! PLease select 0-11.");

                }

                if (choice!=0){
                    pressEnterToContinue();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
                pressEnterToContinue;
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
            appointmentDAO.insertDoctorAppointment(doctorAppointment);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid Input type!");
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
            appointmentDAO.insertPatientAppointment(patientAppointment);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }



    private void viewAllAppointments() {
        appointmentDAO.displayAllAppointment();
    }

    private void viewDoctorAppointment() {
        List<DoctorAppointment> doctorAppointments=appointmentDAO.getAllDoctorAppointment();

        System.out.println("===================================");
        System.out.println("       DOCTOR APPOINTMENTS ONLY");
        System.out.println("===================================");

        if (doctorAppointments.isEmpty()) {
            System.out.println("No doctor appointment in database");
        }else{
            for (int i=0; i<doctorAppointments.size(); i++){
                DoctorAppointment doctorAppointment= doctorAppointments.get(i);
                System.out.println((i+1) + ". " + doctorAppointment.toString());
                System.out.println(" Specialization" + doctorAppointment.getSpecialization());
                if (doctorAppointment.isSpecialistAppointment()){
                    System.out.println("Specialist");
                }
                System.out.println();
            }
            System.out.println("Total Doctor Appointments: " + doctorAppointments.size());
        }
    }

    private void viewPatientAppointment() {
        List<PatientAppointment> patientAppointments= appointmentDAO.getAllPatientAppointments();
        System.out.println("===================================");
        System.out.println("       PATIENT APPOINTMENTS ONLY");
        System.out.println("===================================");

        if(patientAppointments.isEmpty()){
            System.out.println("No patient appointments in database");
        }else{
            for (int i=0; i<patientAppointments.size(); i++){
                PatientAppointment patientAppointment= patientAppointments.get(i);
                System.out.println((i+1) + ". " + patientAppointment.toString());
                System.out.println(" First visit: " + patientAppointment.isFirstVisit());
                if (patientAppointment.isFirstVisit()){
                    System.out.println("First Visit");
                }
                System.out.println();
            }
            System.out.println("Total Patient Appointments: " + patientAppointments.size());
        }
    }

    private void updateAppointment(){
        System.out.println("\\n┌─ UPDATE APPOINTMENT ─────────────────────────┐");
        System.out.println("│ Enter Staff ID to update: ");

        try{
            int appointmentId=scanner.nextInt();
            scanner.nextLine();

            Appointment existingAppointment= appointmentDAO.getAppointmentById(appointmentId);

            if (existingAppointment==null){
                System.out.println("No appointment found with ID: " + appointmentId);
                return;
            }

            System.out.println("Current info: ");
            System.out.println(" " + existingAppointment.toString());
            System.out.println("└────────────────────────────────────────┘");

            System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
            System.out.println("│ (Press Enter to keep current value)   │");

            System.out.println("│ New Date [" + existingAppointment.getDate() + "]: ");
            String newDate= scanner.nextLine();
            if(newDate.trim().isEmpty()){
                newDate=existingAppointment.getDate();
            }

            System.out.println(" New Status [" + existingAppointment.getStatus()+ "]:" );
            String newStatus= scanner.nextLine();
            if(newStatus.trim().isEmpty()){
                newStatus=existingAppointment.getStatus();
            }

            if (existingAppointment instanceof DoctorAppointment){
                DoctorAppointment doctorAppointment=(DoctorAppointment) existingAppointment;
                System.out.println("New Name [" + doctorAppointment.getDoctorName() + "]: ");
                String newName=scanner.nextLine();
                if (newName.trim().isEmpty()){
                    newName=doctorAppointment.getDoctorName();
                }

                System.out.println("New specialization[" + doctorAppointment.getSpecialization() + "]: ");
                String newSpec=scanner.nextLine();
                if (newSpec.trim().isEmpty()){
                    newSpec=doctorAppointment.getSpecialization();
                }

                DoctorAppointment updatedDoctor= new DoctorAppointment(appointmentId, newDate, newStatus, newName, newSpec);
                appointmentDAO.updateDoctorAppointments(updatedDoctor);
            }else if (existingAppointment instanceof PatientAppointment){
                PatientAppointment patientAppointment=(PatientAppointment) existingAppointment;
                System.out.println(" New Name [" + patientAppointment.getPatientName() + "]: ");
                String newPatName=scanner.nextLine();
                if (newPatName.trim().isEmpty()){
                    newPatName=patientAppointment.getPatientName();

                PatientAppointment updatePatient= new PatientAppointment(appointmentId, newDate, newStatus, newPatName);
                appointmentDAO.updatePatientAppointment(updatePatient);
                }
                System.out.println("└────────────────────────────────────────┘");
            }
            }catch(IllegalArgumentException e){
                System.out.println("Validation Error: " + e.getMessage());
        }
    }


    private void deleteAppointment(){

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







