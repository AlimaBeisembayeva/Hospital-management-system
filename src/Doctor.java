public class Doctor {
    private int doctorID;
    private String fullName;
    private String specialization;
    private int experienceYears;

    public Doctor(int doctorID, String fullName, String specialization, int experienceYears){
        this.doctorID= doctorID;
        this.fullName= fullName;
        this.specialization= specialization;
        this.experienceYears= experienceYears;
    }

    public int getDoctorID() {
        return doctorID;
    }
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }


    public boolean isExperienced() {
        return experienceYears >= 10;
    }


    public boolean canPerformSurgery() {
        return specialization.equalsIgnoreCase("Surgeon") && experienceYears >= 5;
    }


    @Override
    public String toString() {
        return "Doctor{ID=" + doctorID +
                ", name='" + fullName +
                "', specialization =" + specialization +
                ", experienceYears='" + experienceYears + "'}";

    }


    }
