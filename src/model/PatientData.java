package model;

import Appointment2.Appointment2;

public class PatientData implements Acceptable{
    private String name;
    private int age;
    private String state;

    public PatientData(String name, int age, String state){
        setName(name);
        setAge(age);
        setState(state);
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getState(){
        return state;
    }

    public void setName(String name){
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name=name;
    }

    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age=age;
    }

    public void setState(String state){
        if(state==null || state.trim().isEmpty()){
            throw new IllegalArgumentException("State cannot be null");
        }
        this.state=state;
    }

    @Override
    public void accept() {
        System.out.println(name + " is accepted for appointment");
    }

    @Override
    public String getData() {
        return "Patient card: " + name + " " + age + " " + " (" + state + ")";
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("State: " + state);
    }

    @Override
    public String toString(){
        return name + " " + age + " " + " (" + state + ")";
    }

}
