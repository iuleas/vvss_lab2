package IrrelevantLlamas.Service;

import IrrelevantLlamas.Domain.Student;
import IrrelevantLlamas.Repository.StudentRepo;
import IrrelevantLlamas.Validator.ValidationException;

public class ServiceStudent {
    private StudentRepo rep;
    public ServiceStudent(StudentRepo rep){this.rep=rep;}
    /**
     * Adauga student
     * Returneaza studentul adaugat*/
    public Student add(Student s){
        try {
            return rep.save(s);
        } catch (ValidationException ex) {
            System.out.println(ex);
            return null;
        }
    }
    /***
     * Sterge student
     * @param id
     * @return studentul sters
     */
    public Student del(String id){
        return rep.delete(id);
    }

    /***
     * Modifica student
     * @param s
     * @return noul student
     */
    public Student mod(Student s){
        return rep.update(s);
    }

    /***
     * Cauta student dupa id
     * @param id
     * @return studentul gasit
     */
    public Student find(String id){
        return rep.findOne(id);
    }

    /***
     * @return studentii
     */
    public Iterable<Student> all(){
        return rep.findAll();
    }
}
