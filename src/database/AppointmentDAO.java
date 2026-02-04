package database;

import Appointment2.Appointment2;
import model.Appointment;
import model.DoctorAppointment;
import model.PatientAppointment;
import model.PatientData;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    public boolean insertDoctorAppointment(DoctorAppointment doctorAppointment) {
        String sql = "INSERT INTO appointment(appointment_id, appointment_date, status, doctor_name, specialization)" + " VALUES (?, TO_DATE(?, 'DD-MM-YY') , ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, doctorAppointment.getAppointmentId());
            statement.setString(2, doctorAppointment.getDate());
            statement.setString(3, doctorAppointment.getStatus());
            statement.setString(4, doctorAppointment.getDoctorName());
            statement.setString(5, doctorAppointment.getSpecialization());

            int rowsInserted=statement.executeUpdate();
            statement.close();

            if (rowsInserted>0){
                System.out.println("Doctor Appointment inserted: " + doctorAppointment.getDoctorName());
                return true;
            }
        }catch (SQLException e){
            System.out.println("Insert Doctor Appointment failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;

    }

    public boolean insertPatientAppointment(PatientAppointment patientAppointment){
        String sql= "INSERT INTO appointment(appointment_id,appointment_date, status, patient_name)" + "VALUES(?, TO_DATE(?, 'DD-MM-YY') , ?, ?)";

        Connection connection= DatabaseConnection.getConnection();
        if (connection==null) return false;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientAppointment.getAppointmentId());
            statement.setString(2, patientAppointment.getDate());
            statement.setString(3, patientAppointment.getStatus());
            statement.setString(4, patientAppointment.getPatientName());

            int rowInserted= statement.executeUpdate();
            statement.close();

            if (rowInserted>0){
                System.out.println("Patient Appointment inserted: " + patientAppointment.getPatientName());
                return true;
            }
        }catch (SQLException e){
            System.out.println("Insert Patient Appointment failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }


    public List<Appointment> getAllAppointment(){
        List<Appointment> appointmentList=new ArrayList<>();
        String sql= "SELECT * FROM appointment ORDER BY appointment_id";

        Connection connection = DatabaseConnection.getConnection();
        if(connection==null) return appointmentList;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                Appointment appointment= extractAppointmentFromResultSet(resultSet);
                if (appointment!=null){
                    appointmentList.add(appointment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + appointmentList.size() + "appointment from database");

        }catch (SQLException e){
            System.out.println("Select all staff failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return appointmentList;
    }

    public Appointment getAppointmentById(int appointmentId){
        String sql= "SELECT * FROM appointment WHERE appointment_id=?";

        Connection connection= DatabaseConnection.getConnection();
        if(connection==null) return null;

        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1, appointmentId);

            ResultSet resultSet= statement.executeQuery();

            if(resultSet.next()){
                Appointment appointment=extractAppointmentFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if(appointment != null){
                    System.out.println("Found appointment with ID: " + appointmentId);
                }

                return appointment;
            }

            System.out.println("No appointment found with ID: " + appointmentId);

            resultSet.close();
            statement.close();

        }catch (SQLException e){
            System.out.println("Select by ID failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }


    public List<DoctorAppointment> getAllDoctorAppointment(){
        List<DoctorAppointment> doctorAppointments= new ArrayList<>();
        String sql="SELECT * FROM appointment WHERE status = 'EMERGENCY' ORDER BY appointment_id";

        Connection connection=DatabaseConnection.getConnection();
        if (connection==null) return doctorAppointments;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                Appointment appointment= extractAppointmentFromResultSet(resultSet);
                if (appointment instanceof DoctorAppointment){
                    doctorAppointments.add((DoctorAppointment) appointment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + doctorAppointments.size() + " doctor appointments");

        }catch (SQLException e){
            System.out.println("Select doctor appointments failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return doctorAppointments;
    }


    public List<PatientAppointment> getAllPatientAppointments(){
        List<PatientAppointment> patientAppointments=new ArrayList<>();
        String sql= "SELECT * FROM appointment WHERE status= 'in progress' ORDER BY appointment_id";

        Connection connection=DatabaseConnection.getConnection();
        if (connection==null) return patientAppointments;

        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                Appointment appointment=extractAppointmentFromResultSet(resultSet);
                if (appointment instanceof PatientAppointment){
                    patientAppointments.add((PatientAppointment) patientAppointments);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + patientAppointments.size() + " patient appointments");

        }catch (SQLException e){
            System.out.println("Select patient appointments failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patientAppointments;
    }

    public boolean updateDoctorAppointments(DoctorAppointment doctorAppointment){
        String sql="UPDATE appointment SET appointment_date=?, status=?, doctor_name=?, specialization=?" + "WHERE appointment_id=?";

        Connection connection= DatabaseConnection.getConnection();
        if (connection==null) return false;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, doctorAppointment.getDate());
            statement.setString(2, doctorAppointment.getStatus());
            statement.setString(3, doctorAppointment.getDoctorName());
            statement.setString(4, doctorAppointment.getSpecialization());

            int rowsUpdated= statement.executeUpdate();
            statement.close();

            if (rowsUpdated>0){
                System.out.println("Doctor appointment updated: " + doctorAppointment.getDoctorName());
                return true;
            }else {
                System.out.println("No doctor appointment found with ID: " + doctorAppointment.getAppointmentId());
            }
        }catch (SQLException e){
            System.out.println("Update doctor appointment failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }


    public boolean updatePatientAppointment(PatientAppointment patientAppointment){
        String sql= "UPDATE patient appointment SET appointment_date=?, status=?, patient_name=?" + "WHERE appointment_id=?";

        Connection connection= DatabaseConnection.getConnection();
        if (connection==null) return false;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, patientAppointment.getDate());
            statement.setString(2, patientAppointment.getStatus());
            statement.setString(3, patientAppointment.getPatientName());

            int rowsUpdated=statement.executeUpdate();
            statement.close();

            if (rowsUpdated>0){
                System.out.println("Patient appointment updated: " + patientAppointment.getPatientName());
                return true;
            }else{
                System.out.println("No patient appointment found with ID: " + patientAppointment.getAppointmentId());
            }
        }catch (SQLException e){
            System.out.println("Update patient appointment failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean deleteAppointment(int appointmentId){
        String sql="DELETE FROM appointment WHERE appointment_id=?";

        Connection connection= DatabaseConnection.getConnection();
        if (connection==null) return false;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, appointmentId);

            int rowsDeleted=statement.executeUpdate();
            statement.close();

            if(rowsDeleted>0){
                System.out.println("Appointment deleted (ID: "+ appointmentId +")");
                return true;
            }else{
                System.out.println("No appointment found with ID: " + appointmentId);
            }
        }catch (SQLException e){
            System.out.println("Delete failed");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public List<Appointment> searchByDate(String date){
        List<Appointment> appointmentList=new ArrayList<>();

        String sql="SELECT * FROM appointment WHERE appointment_date ILIKE ? ORDER BY appointment_date";

        Connection connection= DatabaseConnection.getConnection();
        if (connection==null) return appointmentList;

        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1, "%" + date + "%");

            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                Appointment appointment=extractAppointmentFromResultSet(resultSet);
                if (appointment!=null){
                    appointmentList.add(appointment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + appointmentList.size() + " appointment matching '" + date + "'");

        }catch (SQLException e){
            System.out.println("Search by date failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return appointmentList;
    }


    public List<Appointment> searchByStatus(boolean emergency){
        List<Appointment> appointmentList=new ArrayList<>();

        String sql="SELECT * FROM appointment WHERE is_emergency=?";

        Connection connection= DatabaseConnection.getConnection();
        if(connection==null) return appointmentList;

        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setBoolean(1, emergency);

            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                Appointment appointment=extractAppointmentFromResultSet(resultSet);
                if(appointment!=null){
                    appointmentList.add(appointment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + appointmentList.size() + " appointment with is_emergency =" + emergency);

        }catch (SQLException e){
            System.out.println("Search by boolean failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

        return appointmentList;
    }

   private Appointment extractAppointmentFromResultSet(ResultSet resultSet) throws SQLException{
        int appoitmentId= resultSet.getInt("appointment_id");
        String date= resultSet.getString("appointment_date");
        String status = resultSet.getString("status");
        String appointmentType= resultSet.getString("appointment_type");

        Appointment appointment=null;

        if("DoctorAppointment".equals(appointmentType)){
            String doctorName= resultSet.getString("patient_name");
            String specialization = resultSet.getString("specialization");
            appointment = new DoctorAppointment(appoitmentId, date, status, doctorName,specialization);

        }else if("PatientAppointment".equals(appointmentType)){
            String patientName=resultSet.getString("patient_name");
            appointment = new PatientAppointment(appoitmentId, date, status, patientName);

        }

        return appointment;
    }

    public void displayAllAppointment(){
        List<Appointment> appointmentList= getAllAppointment();

        System.out.println("\n========================================");
        System.out.println("   ALL STAFF FROM DATABASE");
        System.out.println("========================================");

        if(appointmentList.isEmpty()){
            System.out.println("No appointments in database.");
        }else{
            for(int i=0; i<appointmentList.size(); i++){
                Appointment a= appointmentList.get(i);
                System.out.println((i+1) + ". ");
                System.out.println("[" + a.getAppointmentType() + "]");
                System.out.println(a.toString());
            }
        }

        System.out.println("========================================\n");
    }

    public void demonstratePolymorphism(){
        List<Appointment> appointmentList=getAllAppointment();

        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: Staff from Database");
        System.out.println("========================================");

        if (appointmentList.isEmpty()){
            System.out.println("No appointment to demonstrate.");
        }else{
            for(Appointment2 a: appointmentList){
                a.displayAppointment();
            }
        }
        System.out.println("========================================\n");
    }

}
