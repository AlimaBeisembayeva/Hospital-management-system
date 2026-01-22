package Assignment1;

public class Doctor {
    private int doctorId;
    private String fullName;
    private String specialization;
    private int experienceYears;

    public Doctor(int doctorId, String fullName, String specialization, int experienceYears) {
        this.doctorId = doctorId;
        setFullName(fullName);
        this.specialization = specialization;
        setExperienceYears(experienceYears);
    }

    public int getDoctorId() {
        return doctorId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getSpecialization() {
        return specialization;
    }
    public int getExperienceYears() {
        return experienceYears;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            this.fullName = "Unknown Assignment1.Doctor";
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }


    @Override
    public String toString() {
        return "Assignment1.Doctor{ID=" + doctorId +
                ", name='" + fullName +
                "', specialization =" + specialization +
                ", experienceYears='" + experienceYears + "'}";

    }


    }
