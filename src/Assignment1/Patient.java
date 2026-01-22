package Assignment1;

public class Patient{
    private int patientId;
    private String fullName;
    private int age;
    private String bloodType;

    public Patient(int patientId, String fullName, int age, String bloodType){
        this.patientId=patientId;
        setFullName(fullName);
        setAge(age);
        this.bloodType=bloodType;
    }
    public int getPatientId(){
        return patientId;
    }
    public String getFullName(){
        return fullName;
    }
    public int getAge(){
        return age;
    }
    public String getBloodType(){
        return bloodType;
    }

    public void setFullName(String fullName){
        if(fullName != null && !fullName.trim().isEmpty()){
            this.fullName=fullName;
        }
        else{
            this.fullName="Unknown";
            System.out.println("Name cannot be empty. Set to 'Unknown'.");
        }
    }

    public void setAge(int age) {
        if(age>=0){
            this.age = age;
        }
        else{
            this.age=0;
            System.out.println("Age cannot be negative. Set to 0.");
        }
    }

    public boolean isMinor(){
        return age<18;
    }

    @Override
    public String toString() {
        return "Assignment1.Patient{id=" + patientId +
                ", name='" + fullName +
                "', age=" + age +
                ", bloodType='" + bloodType + "'}";
    }

}