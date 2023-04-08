package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Person implements Comparable {

    int age;
    char gender;
    int height;
    String name;


    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        if (this.age > p.age) {
            return 1;
        } else if (this.age == p.age) {
            return name.compareTo(p.getName());
        } else {
            return -1;
        }
    }

    public Person(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public Person() {
    }

    public Person(int age, char gender, int height, String name) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (gender != person.gender) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (int) gender;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
