package ro.unibuc.fmi;

public class Person {

    private String name;

    private Integer age;

    private Boolean isUnderAged = true;

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getUnderAged() {
        return isUnderAged;
    }

    public void setUnderAged(Boolean underAged) {
        isUnderAged = underAged;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isUnderAged=" + isUnderAged +
                '}';
    }
}
