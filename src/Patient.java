public class Patient {
    private int patientID;
    private String fullName;
    private int age;
    private String bloodType;

    public Patient(int patientID, String fullName, int age, String bloodType){
        this.patientID= patientID;
        this.fullName= fullName;
        this.age= age;
        this.bloodType= bloodType;
    }

    public Patient(){
        this.patientID = 0;
        this.fullName = "unknown";
        this.age = 0;
        this.bloodType = "unknown";
    }

    public int getPatientID() {
        return patientID;
    }
    public void setPatientID() {
        this.patientID= patientID;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName() {
        this.fullName= fullName;
    }

    public int getAge() {
        return age;
    }
    public void setAge() {
        this.age= age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType() {
        this.bloodType = bloodType;
    }


    public boolean isMinor(){
        return age<18;
    }


    public String getAgeCategory(){
        if (age<18){
            return "Minor";
        }else if (age<60){
            return "Adult";
        }else {
            return "Senior";
        }
    }

    @Override
    public String toString() {
        return "Patient{ID=" + patientID +
                ", name='" + fullName +
                "', age=" + age +
                ", bloodType='" + bloodType + "'}";

    }
}