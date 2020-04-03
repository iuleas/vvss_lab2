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
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void AddStudentCorrect() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("13", "Numee", 936, "email@yopmail.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddStudentWithSameID() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("9", "Nume", 936, "email@yopmail.com", "un prof");
        Student student2 = new Student("9", "AltNume", 936, "email@yopmail.com", "un prof");
        srv.add(student);
        int prevLen = rep.size();
        srv.add(student2);
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
        Teme tema = new Teme(13, "tema", 2, 3);
        int prevLen = rep.size();
        srv.add(tema);
        assertEquals(prevLen + 1, rep.size());
    }
}
