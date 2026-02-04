package Test;

import database.DatabaseConnection;

import database.AppointmentDAO;

public class TestSelect {
    public static void main(String[] args){
        AppointmentDAO dao= new AppointmentDAO();
        dao.getAllDoctorAppointment();
        AppointmentDAO dao1= new AppointmentDAO();
        dao1.getAllPatientAppointments();
    }
}
