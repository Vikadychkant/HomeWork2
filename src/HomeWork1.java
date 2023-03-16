
package org.future.code.homework;

        import java.util.Collection;
        import java.util.Collections;
        import java.util.Objects;
        import java.util.function.Function;

public class HomeWork1 {

    public static class Student {
        private String name;
        private int grade;
        String getName() {
            return name;
        }
        int getGrade() {
            return grade;
        }
        public Student  (String name, int grade){
            this.name = name;
            this.grade = grade;
        }
        String announce() {
            return name + " учится в " + grade + "классе";
        }
    }
    public static class Teacher {
        private String name;
        private Student[] student = new Student[30];
        String getName() {
            return name;
        }
        Student[] getStudents () {
            return student;
        }


        public Teacher (String name) {
            this.name = name;
        }
        void addStudent(Student student) {
            for (int i = 0; i < 30; i++) {
                getStudents()[i] = student;
            }
        }
        String[] rollCall() {
            String[] calls = new String[1];
            calls[0] = getStudents()[0].announce();
            return calls;
        }

    }

    public static void main(String[] args) {

        var student = new Student(STUDENT_NAME, STUDENT_GRADE);
        print("Student: Студент создался", true);
        print("Student: Геттер имени", Objects.equals(student.getName(), STUDENT_NAME));
        print("Student: Геттер класса", Objects.equals(student.getGrade(), STUDENT_GRADE));
        print("Student: announce содержит имя", student.announce().contains(STUDENT_NAME));
        print("Student: announce содержит класс", student.announce().contains(STUDENT_GRADE.toString()));

        var teacher = new Teacher(TEACHER_NAME);
        print("Teacher: Уичтель создался", true);
        print("Teacher: Геттер имени", teacher.getName() == TEACHER_NAME);
        print("Teacher: Геттер студентов", teacher.getStudents() != null);
        print("Teacher: Массив учеников должен быть размером 30", teacher.getStudents().length == 30);

        teacher.addStudent(student);
        print("Teacher: Студент сохранился в массив", teacher.getStudents()[0] == student);
        String[] calls = teacher.rollCall();
        print("Teacher: Массив rollCall состоит из одиного элемента", calls.length == 1);
        print("Teacher: В строке содержится имя студента", calls[0].contains(STUDENT_NAME));
    }
    private static void print(String condition, Boolean act) {
        Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
        System.out.print( "TEST CASE " + yellow.apply(constLen(condition, 55)));
        if (act) System.out.print("✅"); else System.out.print("❌");
        System.out.println();
    }

    private static String constLen(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        while (len-- - str.length() > 0) sb.append(" ");
        return sb.toString();
    }

    private final static String STUDENT_NAME = "NameStudent";
    private final static String TEACHER_NAME = "NameStudent";
    private final static Integer STUDENT_GRADE = 1;
}