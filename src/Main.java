public class Main {
    public static void main(String[] args) {
        System.out.println("--Hospital management system--\n");

        Patient p1= new Patient(251027, "Alima Beisembayeva", 17, "0+");
        Doctor d1= new Doctor(280208, "Yeldana Sailaubek", "ophthalmologist", 7);
        Appointment a1= new Appointment(261225, "Alima Beisembayeva", "Yeldana Sailaubek", "30.12.25");

        System.out.println("--Patient--");
        System.out.println(p1);

        System.out.println("\n--Doctors--");
        System.out.println(d1);

        System.out.println("\n--Patient--");
        System.out.println(a1);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println(p1.getFullName() + " is minor: " + p1.isMinor());

        System.out.println(d1.getFullName() + " experienced: " + d1.isExperienced());
        System.out.println(d1.getFullName() + " can perform surgery: " + d1.canPerformSurgery());

        a1.reschedule("28.12.25");
        System.out.println("Rescheduled appointment: " + a1);

        System.out.println("\n=== Program Complete ===");
    }

}

