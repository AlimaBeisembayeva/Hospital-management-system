package srk1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<PatientAppointment> patientAppointments = new ArrayList<>();
    private static ArrayList<DoctorAppointment> doctorAppointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===Hospital Management System===");
        System.out.println();

        appointments.add(new Appointment(251027, "08.01.26", "in progress"));
        patientAppointments.add(new PatientAppointment(251028, "09.01.26", "accepted", "Alima Beisembayeva"));
        doctorAppointments.add(new DoctorAppointment(251029, "10.01.26", "rejected", "Yeldana Sailuaubek", "ophthalmologist"));

        boolean run = true;
        while (run) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAppointment();
                    break;
                case 2:
                    addPatientAppointment();
                    break;
                case 3:
                    addDoctorAppointment();
                    break;
                case 4:
                    viewAppointment();
                    break;
                case 5:
                    workAppointment();
                    break;
                case 6:
                    viewPatientAppointment();
                    break;
                case 7:
                    viewDoctorAppointment();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid number");

            }

            if (run) {
                System.out.println("Press to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }



    private static void displayMenu() {
        System.out.println("================================");
        System.out.println("     HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Add Appointment");
        System.out.println("2. Add Patient Appointment");
        System.out.println("3. Add Doctor Appointment");
        System.out.println("4. View all Appointments");
        System.out.println("5. Make all Appointments work");
        System.out.println("6. View Patient Appointment only");
        System.out.println("7. View Doctor Appointment only");
        System.out.println("0. Exit");
        System.out.println("=================================");
        System.out.println("Enter your choice: ");
    }

    private static void addAppointment() {
        System.out.println("------ADD APPOINTMENT------");
        System.out.println("Enter appointment Id: ");
        int appointmentId = scanner.nextInt();

        System.out.println("Enter date: ");
        String date= scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter status: ");
        String status = scanner.nextLine();
        scanner.nextLine();

        Appointment appointment = new Appointment(appointmentId, date, status);
        appointments.add(appointment);

        System.out.println("Appointment added successfully!");
    }

    private static void addPatientAppointment() {
        System.out.println("------ADD PATIENT APPOINTMENT------");
        System.out.println("Enter appointment Id: ");
        int appointmentId = scanner.nextInt();

        System.out.println("Enter date: ");
        String date = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter status: ");
        String status = scanner.nextLine();

        System.out.println("Enter Patient name: ");
        String patientName = scanner.nextLine();
        scanner.nextLine();

        Appointment appointment = new PatientAppointment(appointmentId, date, status, patientName);
        appointments.add(appointment);

        System.out.println("Patient Appointment added successfully!");
    }

    private static void addDoctorAppointment() {
        System.out.println("------ADD DOCTOR APPOINTMENT------");
        System.out.println("Enter appointment Id: ");
        int appointmentId = scanner.nextInt();

        System.out.println("Enter date: ");
        String date = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter status: ");
        String status= scanner.nextLine();

        System.out.println("Enter Doctor name: ");
        String doctorName = scanner.nextLine();

        System.out.println("Enter specialization: ");
        String specialization = scanner.nextLine();
        scanner.nextLine();


        Appointment appointment = new Appointment(appointmentId, date, status);
        appointments.add(appointment);

        System.out.println("Doctor appointment added successfully!");
    }

    private static void viewAppointment() {
        System.out.println("===========================");
        System.out.println("     VIEW ALL APPOINTMENTS");
        System.out.println("===========================");

        if (appointments.isEmpty()) {
            System.out.println("No appointments found");
            return;
        }

        System.out.println("Total appointments: " + appointments.size());
        System.out.println();

        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);

            System.out.println((i + 1) + ". " + a);

            if (a instanceof PatientAppointment) {
                PatientAppointment patientAppointment = (PatientAppointment) a;
                if (patientAppointment.hasValidDate()) {
                    System.out.println("Appointment date is valid.");
                } else {
                    System.out.println("Appointment date is missing.");
                }

            } else if (a instanceof DoctorAppointment) {
                DoctorAppointment doctorAppointment = (DoctorAppointment) a;
                if (doctorAppointment.isSpecialistAppointment()) {
                    System.out.println("Doctor is specialist");
                }
            }
            System.out.println();
        }
    }

    private static void workAppointment() {
        System.out.println("====================================");
        System.out.println("    POLYMORPHISM DEMONSTRATION");
        System.out.println("====================================");
        System.out.println("Calling work() on all appointments: ");
        System.out.println();

        for (Appointment a : appointments) {
            a.conductAppointment();

        }

        System.out.println();
        System.out.println("Notice: Same method name (work), different output!");
        System.out.println("This is POLYMORPHISM in action!");
    }


    private static void viewPatientAppointment() {
        System.out.println("===================================");
        System.out.println("       PATIENT APPOINTMENTS ONLY");
        System.out.println("===================================");

        int patientCount = 0;

        for (PatientAppointment p : patientAppointments) {
            if (p instanceof PatientAppointment) {
                PatientAppointment patientAppointment = (PatientAppointment) p;
                patientCount++;

                System.out.println(patientCount + ". " + patientAppointment.getPatientName());
                System.out.println("ID: " + patientAppointment.getAppointmentId());
                System.out.println("Date: " + patientAppointment.getDate());
                System.out.println("Status: " + patientAppointment.getStatus());

                if (patientAppointment.hasValidDate()) {
                    System.out.println("Valid date of appointment");
                }
                System.out.println();
            }
        }
        if (patientCount == 0) {
            System.out.println("No patient found");
        }

    }

    private static void viewDoctorAppointment() {
        System.out.println("===================================");
        System.out.println("       DOCTOR APPOINTMENTS ONLY");
        System.out.println("===================================");

        int doctorCount = 0;

        for (DoctorAppointment d : doctorAppointments) {
            if (d instanceof DoctorAppointment) {
                DoctorAppointment doctorAppointment = (DoctorAppointment) d;
                doctorCount++;

                System.out.println(doctorCount + ". " + doctorAppointment.isSpecialistAppointment());
                System.out.println("ID: " + doctorAppointment.getAppointmentId());
                System.out.println("Date: " + doctorAppointment.getDate());

                if (doctorAppointment.isSpecialistAppointment()) {
                    System.out.println("Doctor is specialist");
                }
                System.out.println();
            }
        }
        if (doctorCount == 0) {
            System.out.println("No doctors found.");
        }
    }
}
