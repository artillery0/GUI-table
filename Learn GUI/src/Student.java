import java.util.Comparator;

class Student implements Comparable<Student>
{

    int age;
    double gpa;
    String name;
    long studentID;
    char gender;

    static Comparator<Student> byAge;
    static Comparator<Student> byGpa;
    static Comparator<Student> byName;
    static Comparator<Student> byID;
    static Comparator<Student> byGender;

    public Student(int age, double gpa, String name, long studentID, char gender)
    {
        this.age = age;
        this.gpa = gpa;
        this.name = name;
        this.studentID = studentID + 301192000;
        this.gender = gender;

        byAge = new Comparator<Student>()
        {
            @Override
            public int compare(Student student1, Student student2)
            {
                return student1.age - student2.age;
            }
        };

        byGpa = new Comparator<Student>()
        {
            @Override
            public int compare(Student student1, Student student2)
            {
                if (student1.gpa < student2.gpa)
                    return -1;
                if (student1.gpa > student2.gpa)
                    return 1;
                return 0;
            }
        };

        byID = new Comparator<Student>()
        {
            @Override
            public int compare(Student student1, Student student2)
            {
                if (student1.studentID < student2.studentID)
                    return -1;
                if (student1.studentID > student2.studentID)
                    return 1;
                return 0;
            }
        };

    }

    public void printStuInfo()
    {
        System.out.format("%-9s   %d  %-2d  %6.2f  %2c ", name, studentID, age, gpa, gender);
    }

    @Override
    public int compareTo(Student stu)
    {
        return this.name.compareToIgnoreCase(stu.name);
    }

}