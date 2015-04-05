import java.util.Comparator;

class Student implements Comparable<Student>
{
    int age;
    double gpa;
    String name;
    long studentID;
    char gender;

    private static Comparator<Student> byAge = new Comparator<Student>()
    {
        @Override
        public int compare(Student student1, Student student2)
        {
            if (student1.age < student2.age)
                return -1;
            else if (student1.age > student2.age)
                return 1;
            else
                return 0;
        }
    };

    private static Comparator<Student> byGpa = new Comparator<Student>()
    {
        @Override
        public int compare(Student student1, Student student2)
        {
            if (student1.gpa < student2.gpa)
                return -1;
            else if (student1.gpa > student2.gpa)
                return 1;
            else
                return 0;
        }
    };

    private static Comparator<Student> byID = new Comparator<Student>()
    {
        @Override
        public int compare(Student student1, Student student2)
        {
            if (student1.studentID < student2.studentID)
                return -1;
            else if (student1.studentID > student2.studentID)
                return 1;
            else
                return 0;
        }
    };

    // private static Comparator<Student> byName;
    // private static Comparator<Student> byGender;

    public Student(int age, double gpa, String name, long studentID, char gender)
    {
        this.age = age;
        this.gpa = gpa;
        this.name = name;
        this.studentID = studentID + 301192000;
        this.gender = gender;
    }

    // public void printStuInfo()
    // {
    // System.out.format("%-9s   %d  %-2d  %6.2f  %2c ", name, studentID, age, gpa, gender);
    // }

    @Override
    public int compareTo(Student stu)
    {
        return name.compareToIgnoreCase(stu.name);
    }

    public static Comparator<Student> getAgeComparator()
    {
        return byAge;
    }

    public static Comparator<Student> getGpaComparator()
    {
        return byGpa;
    }

    public static Comparator<Student> getIDComparator()
    {
        return byID;
    }

}