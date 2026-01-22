package model;

public abstract class Appointment {
    protected int appointmentId;
    protected String date;
    protected String status;

    public Appointment(int appointmentId, String date, String status){
       setAppointmentId(appointmentId);
       setDate(date);
       setStatus(status);
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
        if(appointmentId<=0){
            throw new IllegalArgumentException("Appointment iD must be positive");
        }
        this.appointmentId = appointmentId;
    }

    public void setDate(String date) {
        if (date==null || date.trim().isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty.");
        }
        this.date = date;
    }

    public void setStatus(String status) {
        if(status==null || status.trim().isEmpty()){
            throw new IllegalArgumentException("Status parameters cannot be empty.");
        }
        if(status.length()<2){
            throw new IllegalArgumentException("Status name must be at least 2 charachters");
        }
        this.status = status;
    }

    public void displayInfo(){
        System.out.println("ID: " + appointmentId);
        System.out.println("Date: " + date);
        System.out.println("Appointment status: " + status);
    }

    public boolean isActive(){
        return status.equalsIgnoreCase("accepted")
                || status.equalsIgnoreCase("in progress");
    }


    public abstract void conductAppointment(){
        System.out.println("Assignment1.Appointment is being conducted.");
    }


    @Override
    public String toString(){
        return "Assignment1.Appointment ID: " + appointmentId +
                ", Date: " + date +
                ", Status: " + status;
    }

}
