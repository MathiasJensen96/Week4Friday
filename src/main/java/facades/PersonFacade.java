package facades;

import dtos.PersonDTO;
import dtos.PersonsDTO;
import entities.Person;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    public PersonFacade() {}

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public PersonDTO addPerson(String fName, String lName, String phone) {
        Person person = new Person(fName, lName, phone);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person.getFirstName(), person.getLastName(), person.getPhone());
    }

    @Override
    public PersonDTO deletePerson(int id) {
        return null;
    }

    @Override
    public PersonDTO getPerson(int id) {
        return null;
    }

    @Override
    public PersonsDTO getAllPersons() {
        return null;
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) {
        return null;
    }


//    public RenameMeDTO getById(long id){
//        EntityManager em = emf.createEntityManager();
//        return new RenameMeDTO(em.find(RenameMe.class, id));
//    }
//
//    //TODO Remove/Change this before use
//    public long getRenameMeCount(){
//        EntityManager em = emf.createEntityManager();
//        try{
//            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        }finally{
//            em.close();
//        }
//    }
//
//    public List<RenameMeDTO> getAll(){
//        EntityManager em = emf.createEntityManager();
//        TypedQuery<RenameMe> query = em.createQuery("SELECT r FROM RenameMe r", RenameMe.class);
//        List<RenameMe> rms = query.getResultList();
//        return RenameMeDTO.getDtos(rms);
//    }
//
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade pf = getPersonFacade(emf);
        pf.addPerson("Mathias", "Jensen", "1234");
    }
}
