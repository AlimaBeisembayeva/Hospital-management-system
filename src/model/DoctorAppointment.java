package model;

import Appointment2.Appointment2;

public class DoctorAppointment extends Appointment implements Appointment2 {
    private String doctorName;
    private String specialization;

    public DoctorAppointment(int appointmentId, String date, String status, String doctorName, String specialization) {
        super(appointmentId, date, status);
        setDoctorName(doctorName);
        setSpecialization(specialization);
    }

    public void setDoctorName(String doctorName){
        if ( doctorName ==null || doctorName.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.doctorName=doctorName;
    }


    public void setSpecialization(String specialization){
        if(specialization==null || specialization.trim().isEmpty()){
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization=specialization;
    }

    @Override
    public void conductAppointment() {
        System.out.println("Assignment1.Doctor " + doctorName + " is conducting an appointment in " + specialization + ".");

    }
    @Override
    public String getAppointmentType(){
        return "Doctor Apppointment";
    }


    public boolean isSpecialistAppointment() {
        return specialization.equalsIgnoreCase("Surgeon");
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Name: " + doctorName);
        System.out.println("Specialization " + specialization);
    }


    @Override
    public String toString() {
        return super.toString() +
                ", Doctor: " + doctorName +
                ", Specialization: " + specialization;
    }

    @Override
    public void displayAppointment() {

    }

    @Override
    public void run() {

    }
}
