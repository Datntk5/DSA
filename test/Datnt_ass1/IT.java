
package Datnt_ass1;

public class IT extends Person {
    private String major;
    private double mark;

    public IT() {
    }

    public IT(int id, String name, int age, String major, double mark) {
        super(id, name, age);
        this.major = major;
        this.mark = mark;
    }

    public String getMajor() {
        return major;
    }

    public double getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return super.toString() + ", Major=" + major + ", Mark=" + mark;
    }
}
