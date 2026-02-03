import database.DatabaseConnection;
import database.AppointmentDAO;
import model.Appointment;
import model.PatientAppointment;
import model.DoctorAppointment;

import java.sql.Connection;
import java.util.List;


public class TestInsert {
    public static void main(String[] args){

        Appointment appointment= new Appointment(290189, "02.02.26", "Emergency");

        AppointmentDAO dao= new AppointmentDAO();
        dao.insertAppointment(appointment);

        List<PatientAppointment> patientAppointments= dao.getAllAppointment();
        for(Appointment2 pa : appointments){
            System.out.println(pa);
        }
    }
}
