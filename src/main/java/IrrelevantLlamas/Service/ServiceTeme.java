package IrrelevantLlamas.Service;

import IrrelevantLlamas.Domain.Teme;
import IrrelevantLlamas.Repository.TemeRepo;
import IrrelevantLlamas.Validator.ValidationException;
import sun.security.validator.ValidatorException;

public class ServiceTeme {
    private TemeRepo rep;
    public ServiceTeme(TemeRepo rep){this.rep=rep;}

    /***
     * Adauga tema
     * @param s
     * @return tema adaugata
     */
    public Teme add(Teme s){
        try {
            return rep.save(s);
        } catch (ValidationException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /***
     * sterge tema
     * @param id
     * @return tema stearsa
     */
    public Teme del(Integer id){
        return rep.delete(id);
    }

    /***
     * Modifica tema
     * @param s
     * @return tema modificata
     */
    public Teme mod(Teme s){
        return rep.update(s);
    }

    /***
     * Cauta tema dupa id
     * @param id
     * @return tema gasita
     */
    public Teme find(Integer id){
        return rep.findOne(id);
    }

    /***
     * @return temele
     */
    public Iterable<Teme> all(){
        return rep.findAll();
    }
}

