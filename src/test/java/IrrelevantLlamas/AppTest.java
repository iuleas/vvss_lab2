package IrrelevantLlamas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import IrrelevantLlamas.Domain.Student;
import IrrelevantLlamas.Domain.Teme;
import IrrelevantLlamas.Repository.StudentRepo;
import IrrelevantLlamas.Repository.TemeRepo;
import IrrelevantLlamas.Service.ServiceStudent;
import IrrelevantLlamas.Service.ServiceTeme;
import IrrelevantLlamas.Validator.StudentValidator;
import IrrelevantLlamas.Validator.TemeValidator;
import jdk.nashorn.internal.ir.Assignment;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void AddStudentCorrect() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("1", "Numee", 936, "email@yopmail.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddStudentWithSameID() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("2", "Nume", 936, "email@yopmail.com", "un prof");
        Student student2 = new Student("2", "AltNume", 936, "email@yopmail.com", "un prof");
        srv.add(student);
        int prevLen = rep.size();
        srv.add(student2);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddStudentWithWrongGroup() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("3", "Numee", 938, "email@yopmail.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddStudentWithWrongName() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("4", "Iu1ia Si1asi", 936, "email@yopmail.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddStudentWithWrongEmail() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("5", "Iulia Silasi", 936, "email.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddStudentWithWrongProfessor() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("6", "Iulia Silasi", 936, "email.com", "1oana P0pa");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddAssignmentWithNullID() {
        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema = new Teme(null, "tema", 2, 3);
        int prevLen = rep.size();
        srv.add(tema);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddAssignmentWithCorrectID() {
        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema = new Teme(1, "tema", 2, 3);
        int prevLen = rep.size();
        srv.add(tema);
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddAssignmentWithWrongDeadline() {
        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema = new Teme(2, "tema", 2, 15);
        int prevLen = rep.size();
        srv.add(tema);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddAssignmentWithWrongDeliveryWeek() {
        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema = new Teme(3, "tema", 0, 4);
        int prevLen = rep.size();
        srv.add(tema);
        assertEquals(prevLen, rep.size());
    }

    @Test
    public void AddAssignmentWithSameID() {
        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema1 = new Teme(4, "tema1", 2, 4);
        Teme tema2 = new Teme(4, "tema2", 3, 4);
        srv.add(tema1);
        int prevLen = rep.size();
        srv.add(tema2);
        assertEquals(prevLen, rep.size());
    }
}
