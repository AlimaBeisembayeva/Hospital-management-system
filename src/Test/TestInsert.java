package Test;

import database.DatabaseConnection;
import database.AppointmentDAO;
import model.Appointment;
import model.DoctorAppointment;
import model.PatientAppointment;

import java.sql.Connection;
import java.util.List;

public class TestInsert {
    public static void main(String[] args){
        PatientAppointment patientAppointment= new PatientAppointment(259457, "05-02-26", "emergency", "Alima");

        AppointmentDAO dao= new AppointmentDAO();
        dao.insertPatientAppointment(patientAppointment);

        DoctorAppointment doctorAppointment=new DoctorAppointment(268963, "27-01-26", "in progress", "Yeldana", "doctor");

        AppointmentDAO dao1= new AppointmentDAO();
        dao1.insertDoctorAppointment(doctorAppointment);


        List<PatientAppointment> patientAppointments= dao.getAllPatientAppointments();
        for(PatientAppointment patientAppointment1: patientAppointments){
            System.out.println(patientAppointment1);
        }
    }
}