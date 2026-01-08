package srk1;

public class PatientAppointment extends Appointment{
    private String patientName;

    public PatientAppointment(int appointmentId, String date, String status, String patientName){
        super(appointmentId, date, status);
        this.patientName= patientName;

    }
    public String getPatientName(){
        return patientName;
    }
    public void setAppointmentId(int appointmentId) {
        super.setAppointmentId(appointmentId);
    }

    @Override
    public void conductAppointment(){
        System.out.println("Patient appointment for " + patientName + " is in progress.");
    }


    public boolean hasValidDate() {
        return date != null && !date.trim().isEmpty();
    }


    private static void equalsIgnoreCase(String emergency) {
    }

    @Override
    public String toString() {
        return super.toString() + ", Patient: " + patientName;
    }


}
