package model;

import Appointment2.Appointment2;

public class PatientAppointment extends Appointment implements Appointment2 {
    private String patientName;

    public PatientAppointment(int appointmentId, String date, String status, String patientName){
        super(appointmentId, date, status);
        setPatientName(patientName);

    }
    public String getPatientName(){
        return patientName;
    }

    public void setPatientName(String patientName){
        if (patientName==null || patientName.trim().isEmpty()){
            throw new IllegalArgumentException("Patient name cannot be empty");
        }
        this.patientName=patientName;
    }



    @Override
    public void conductAppointment(){
        System.out.println("Assignment1.Patient appointment for " + patientName + " is in progress.");
    }

    @Override
    public String getAppointmentType() {
        return "Patient Appointment";
    }

    public void isInProgress(){
        System.out.println(patientName + " appointment is in progress");
    }

    public boolean isFistVisit(){
        return status.equalsIgnoreCase("new");
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Patient name: " + patientName);
    }

    @Override
    public String toString() {
        return super.toString() + ", Assignment1.Patient: " + patientName;
    }


    @Override
    public void displayAppointment() {

    }

    @Override
    public void run() {

    }
}
