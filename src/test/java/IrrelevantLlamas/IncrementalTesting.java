package IrrelevantLlamas;

import IrrelevantLlamas.Domain.Nota;
import IrrelevantLlamas.Domain.Student;
import IrrelevantLlamas.Domain.Teme;
import IrrelevantLlamas.Repository.NoteRepo;
import IrrelevantLlamas.Repository.StudentRepo;
import IrrelevantLlamas.Repository.TemeRepo;
import IrrelevantLlamas.Service.ServiceNote;
import IrrelevantLlamas.Service.ServiceStudent;
import IrrelevantLlamas.Service.ServiceTeme;
import IrrelevantLlamas.Validator.NotaValidator;
import IrrelevantLlamas.Validator.StudentValidator;
import IrrelevantLlamas.Validator.TemeValidator;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Iulea
 */
public class IncrementalTesting {

    @Test
    public void AddStudentCorrect() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("1660", "Nume", 936, "email@yopmail.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddStudentAssignmentCorrect() {
        StudentRepo repStudent = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srvStudent = new ServiceStudent(repStudent);
        Student student = new Student("1661", "Nume", 936, "email@yopmail.com", "un prof");
        int prevLen = repStudent.size();
        srvStudent.add(student);
        assertEquals(prevLen + 1, repStudent.size());

        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema = new Teme(1660, "tema", 2, 3);
        int prevLen2 = rep.size();
        srv.add(tema);
        assertEquals(prevLen2 + 1, rep.size());
    }


    @Test
    public void AddStudentAssignmentGradeCorrect() {
        StudentRepo repStuds = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srvStuds = new ServiceStudent(repStuds);
        Student student = new Student("1662", "Numee", 936, "email@yopmail.com", "un prof");
        int prevLenStuds = repStuds.size();
        srvStuds.add(student);

        TemeRepo repTeme = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srvTeme = new ServiceTeme(repTeme);
        Teme tema = new Teme(1662, "tema", 2, 3);
        int prevLenTeme = repTeme.size();
        srvTeme.add(tema);


        NoteRepo repNote = new NoteRepo(new NotaValidator());
        ServiceNote srvNote = new ServiceNote(repNote);
        Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>("1662", 1662);
        Nota nota = new Nota(nid, srvStuds.find("1662"), srvTeme.find(1662), 10, 7);
        int prevLen = repNote.size();
        srvNote.add(nota, "feedback");

        assertEquals(prevLenStuds + 1, repStuds.size());
        assertEquals(prevLenTeme + 1, repTeme.size());
        assertEquals(prevLen + 1, repNote.size());
    }
}
