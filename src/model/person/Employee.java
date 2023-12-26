package model.person;

public class Employee extends Person{
    private  String  level,position;
    private  double salary;

    public Employee() {
    }

    public Employee(String level, String position, double salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String id, String name, String sex, String email,String dateOfBirth, String phoneNumber, String CMND, String level, String position, double salary) {
        super(id, name, sex, email, dateOfBirth, phoneNumber, CMND);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", level= " + level +
                ", position=" + position +
                ", salary=" + salary;
    }

    @Override
    public String getInforToCSV() {
        return super.getInforToCSV()+","+level+","+position+","+salary;
    }
}
