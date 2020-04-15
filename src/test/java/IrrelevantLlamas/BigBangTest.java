package IrrelevantLlamas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import jdk.nashorn.internal.ir.Assignment;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class BigBangTest
{
    /**
     * Rigorous Test 🙂
     */

    @Test
    public void AddStudentCorrect() {
        StudentRepo rep = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srv = new ServiceStudent(rep);
        Student student = new Student("1000", "Numee", 936, "email@yopmail.com", "un prof");
        int prevLen = rep.size();
        srv.add(student);
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddAssignmentCorrect() {
        TemeRepo rep = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srv = new ServiceTeme(rep);
        Teme tema = new Teme(1000, "tema", 2, 3);
        int prevLen = rep.size();
        srv.add(tema);
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddGradeCorrect() {
        NoteRepo rep = new NoteRepo(new NotaValidator());
        TemeRepo teme = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme temeSrv = new ServiceTeme(teme);
        StudentRepo studs = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent studsSrv = new ServiceStudent(studs);
        ServiceNote srv = new ServiceNote(rep);
        Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>("100", 400);
        Nota nota = new Nota(nid, studsSrv.find("100"), temeSrv.find(400), 10, 7);
        int prevLen = rep.size();
        srv.add(nota, "feedback");
        assertEquals(prevLen + 1, rep.size());
    }

    @Test
    public void AddStudentGradeAssignmentCorrect() {
        StudentRepo repStuds = new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        ServiceStudent srvStuds = new ServiceStudent(repStuds);
        Student student = new Student("4005", "Numee", 936, "email@yopmail.com", "un prof");
        int prevLenStuds = repStuds.size();
        srvStuds.add(student);

        TemeRepo repTeme = new TemeRepo(new TemeValidator(), "D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        ServiceTeme srvTeme = new ServiceTeme(repTeme);
        Teme tema = new Teme(4006, "tema", 2, 3);
        int prevLenTeme = repTeme.size();
        srvTeme.add(tema);


        NoteRepo repNote = new NoteRepo(new NotaValidator());
        ServiceNote srvNote = new ServiceNote(repNote);
        Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>("4005", 4006);
        Nota nota = new Nota(nid, srvStuds.find("4005"), srvTeme.find(4006), 10, 7);
        int prevLen = repNote.size();
        srvNote.add(nota, "feedback");

        assertEquals(prevLenStuds + 1, repStuds.size());
        assertEquals(prevLenTeme + 1, repTeme.size());
        assertEquals(prevLen + 1, repNote.size());
    }
}