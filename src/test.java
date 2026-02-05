import database.DatabaseConnection;
import database.AppointmentDAO;
import model.Appointment;
import model.DoctorAppointment;
import model.DoctorAppointment;

import java.sql.Connection;
import java.util.List;


public class test {
    static void main(){
        DoctorAppointment testDoctorAppointment= new DoctorAppointment(12345677, "26-01-26", "In progress",  "Alima", "Unknown");
        AppointmentDAO appointmentDAO=new AppointmentDAO();
        appointmentDAO.insertDoctorAppointment(testDoctorAppointment);

        List<DoctorAppointment> doctorAppointments=appointmentDAO.getAllDoctorAppointment();
        for(DoctorAppointment doctorAppointment1: doctorAppointments){
            System.out.println(doctorAppointment1);
        }
    }
}
