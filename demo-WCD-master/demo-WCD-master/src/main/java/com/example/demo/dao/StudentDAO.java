package dao;

import entity.Student;
import com.example.demo.util.JpaUtils;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO {
    private EntityManager em = JpaUtils.getEntityManager();
    @Override
    protected  void finalize() throws Throwable{
        em.close();
        super.finalize();
    }

    public Student create(Student entity){
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;

        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Student update(Student entity){
        try {
            em.getTransaction().begin();
            em.merge(entity);//ham sua
            em.getTransaction().commit();
            return entity;

        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Student remove(String id){
        try {
            em.getTransaction().begin();
            Student entity = this.findById(id);
            em.remove(entity);//ham xoas
            em.getTransaction().commit();
            return entity;

        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Student findById(String id){
        return em.find(Student.class, id);
    }

    //Tim theo quyen
//    public List<User> findByRole(boolean role){
//        String jpql = "Select o from Student o.admin:role";
//        TypedQuery<User>  query = em.createQuery(jpql, User.class);
//        return query.getResultList();
//    }
    //Tim theo keyword
    public List<Student> findByKeyWord(String keyword){
        String jpql = "Select o from Student o where  o.name like ?1";
        TypedQuery<Student>  query = em.createQuery(jpql, Student.class);
        query.setParameter(1, keyword);
        return query.getResultList();
    }
    // Aps dung tim nhung cai khac theo y

    //Tim kiem phan trang
    public List<Student> findPage(int page, int size){
        String jpql = "Select o from Student o";
        TypedQuery<Student> query = em.createQuery(jpql, Student.class);
        query.setFirstResult(page*size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    //lấy hêt Student
    public List<Student> findAll(){
        String jpql = "Select o from Student o";
        TypedQuery<Student> query = em.createQuery(jpql, Student.class);
        return query.getResultList();
    }




}