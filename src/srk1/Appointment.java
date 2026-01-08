package srk1;

public class Appointment {
    protected int appointmentId;
    protected String date;
    protected String status;

    public Appointment(int appointmentId, String date, String status){
        this.appointmentId= appointmentId;
        this.date= date;
        this.status= status;
    }

    public int getAppointmentId(){
        return appointmentId;
    }
    public String getDate(){
        return date;
    }
    public String getStatus(){
        return status;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void conductAppointment(){
        System.out.println("Appointment is being conducted.");
    }

    @Override
    public String toString(){
        return "Appointment ID: " + appointmentId +
                ", Date: " + date +
                ", Status: " + status;
    }

}
