package pojos;

public class DummyRestApiDataPojo {
    private String employee_name;
    private Integer employee_salary;
    private String profile_image;
    private Integer  employee_age;


    public DummyRestApiDataPojo(String employee_name, Integer employee_salary, String profile_image, Integer employee_age) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.profile_image = profile_image;
        this.employee_age = employee_age;
    }

    public DummyRestApiDataPojo() {
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return "DummyRestApiDataPojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", profile_image='" + profile_image + '\'' +
                ", employee_age=" + employee_age +
                '}';
    }
}
