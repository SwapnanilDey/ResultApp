package com.example.result;

public class UserHelperClass {
    String Physics, Chemistry, Math, Total;

    public UserHelperClass() {
    }

    public UserHelperClass(String physics, String chemistry, String math, String total) {
        //StudentName = studentName;
        Physics = physics;
        Chemistry = chemistry;
        Math = math;
        Total = total;
    }

    /*public String getStudentName() {
        return StudentName;
    }*/

    /*public void setStudentName(String studentName) {
        StudentName = studentName;
    }*/

    public String getPhysics() {
        return Physics;
    }

    public void setPhysics(String physics) {
        Physics = physics;
    }

    public String getChemistry() {
        return Chemistry;
    }

    public void setChemistry(String chemistry) {
        Chemistry = chemistry;
    }

    public String getMath() {
        return Math;
    }

    public void setMath(String math) {
        Math = math;
    }
    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
