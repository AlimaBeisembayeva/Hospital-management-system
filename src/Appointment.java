public class Appointment {
    private int appointmentID;
    private String patientName;
    private String doctorName;
    private String date;


    public Appointment(int appointmentID, String patientName, String doctorName, String date) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;

    }


    public int getAppointmentID() {
        return appointmentID;
    }
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }


    public void reschedule(String newDate) {
        this.date = newDate;
    }


    public void cancel() {
        this.date = "Cancelled";
    }

    @Override
    public String toString() {
        return "Appointment{ID=" + appointmentID +
                ", patient='" + patientName +
                "', doctor='" + doctorName +
                "', date='" + date + "'}";
    }



}
