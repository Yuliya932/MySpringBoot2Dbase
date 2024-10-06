package ru.maslova.MySpringBoot2Dbase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maslova.MySpringBoot2Dbase.entity.Discipline;
import java.util.List;

@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDisciplines(){
        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query.getResultList();
        log.info("getAllDisciplines" + allDisciplines);
        return allDisciplines;
    }

    @Override
    public Discipline saveDiscipline (Discipline discipline){
        log.info("saveDiscipline" + discipline);
        return entityManager.merge(discipline);
    }

    @Override
    public Discipline getDiscipline (int id) {
        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query.getResultList();
        log.info("getDiscipline" + allDisciplines.get(id-1));
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public Discipline deleteDiscipline (int id){
        Query query = entityManager.createQuery("delete from Discipline"
                + " where id =:disciplineId");
        query.setParameter("disciplineId", id);
        query.executeUpdate();
        log.info("deleteDiscipline" + id);
        Query query2 = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query2.getResultList();
        log.info("deleteDiscipline" + allDisciplines);
        return entityManager.find(Discipline.class, id);
    }
}
