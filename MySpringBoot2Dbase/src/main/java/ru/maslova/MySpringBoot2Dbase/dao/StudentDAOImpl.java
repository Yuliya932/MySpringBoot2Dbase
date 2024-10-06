package ru.maslova.MySpringBoot2Dbase.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maslova.MySpringBoot2Dbase.entity.Student;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents(){
        Query query = entityManager.createQuery("from Student");
        List<Student> allStudents = query.getResultList();
        log.info("getAllStunents" + allStudents);
        return allStudents;
    }

    @Override
    public Student saveStudent (Student student){
        log.info("saveStudent" + student);
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent (int id) {
        Query query = entityManager.createQuery("from Student");
        List<Student> allStudents = query.getResultList();
        log.info("getStudent" + allStudents.get(id-1));
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student deleteStudent (int id){
        Query query = entityManager.createQuery("delete from Student"
                    + " where id =:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
        log.info("deleteStudent" + id);
        Query query2 = entityManager.createQuery("from Student");
        List<Student> allStudents = query2.getResultList();
        log.info("deleteStudent" + allStudents);
        return entityManager.find(Student.class, id);
        }
}
