package Chapter3;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int ageDifference(final Person other){
        return age - other.age;
    }
    @Override
    public String toString() {
        return String.format("%s - %d",name,age);
    }
}
