package IrrelevantLlamas;

import IrrelevantLlamas.Repository.NoteRepo;
import IrrelevantLlamas.Repository.StudentRepo;
import IrrelevantLlamas.Repository.TemeRepo;
import IrrelevantLlamas.Service.ServiceNote;
import IrrelevantLlamas.Service.ServiceStudent;
import IrrelevantLlamas.Service.ServiceTeme;
import IrrelevantLlamas.UI.UI;
import IrrelevantLlamas.Validator.NotaValidator;
import IrrelevantLlamas.Validator.StudentValidator;
import IrrelevantLlamas.Validator.TemeValidator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        StudentRepo rep=new StudentRepo(new StudentValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\studenti.xml");
        TemeRepo repo=new TemeRepo(new TemeValidator(),"D:\\info\\ubb\\sem 6\\verificarea si validarea sistemelor soft\\lab2\\src\\main\\java\\IrrelevantLlamas\\teme.xml");
        NoteRepo r=new NoteRepo(new NotaValidator());
        ServiceStudent srv=new ServiceStudent(rep);
        ServiceTeme serv=new ServiceTeme(repo);
        ServiceNote sv=new ServiceNote(r);
        UI ui=new UI(srv,serv,sv);
        ui.show();

    }
}
