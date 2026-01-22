package model;

public class DoctorAppointment extends Appointment{
    private String doctorName;
    private String specialization;

    public DoctorAppointment(int appointmentId, String date, String status, String doctorName, String specialization) {
        super(appointmentId, date, status);
        this.doctorName= doctorName;
        this.specialization= specialization;
    }

    @Override
    public void conductAppointment() {
        System.out.println("Assignment1.Doctor " + doctorName + " is conducting an appointment in " + specialization + ".");

    }


    public boolean isSpecialistAppointment() {
        return specialization.equalsIgnoreCase("Surgeon");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Assignment1.Doctor: " + doctorName +
                ", Specialization: " + specialization;
    }

}
