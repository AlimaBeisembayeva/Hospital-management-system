import database.DatabaseConnection;
import database.AppointmentDAO;
import model.Appointment;
import model.PatientAppointment;
import model.DoctorAppointment;

import java.sql.Connection;
import java.util.List;


public class TestInsert {
    public static void main(String[] args){

        PatientAppointment patientAppointment= new PatientAppointment(290189, "02.02.26", "Emergency", "Alima");

        AppointmentDAO dao= new AppointmentDAO();
        dao.insertPatientAppointment(patientAppointment);

        List<PatientAppointment> patientAppointments= dao.getAllPatientAppointment();
        for(PatientAppointment pa : patientAppointments){
            System.out.println(pa);
        }
    }
}
