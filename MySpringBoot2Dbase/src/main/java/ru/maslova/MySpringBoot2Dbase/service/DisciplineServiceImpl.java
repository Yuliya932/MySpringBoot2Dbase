package ru.maslova.MySpringBoot2Dbase.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maslova.MySpringBoot2Dbase.dao.DisciplineDAO;
import ru.maslova.MySpringBoot2Dbase.entity.Discipline;
import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {


    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public Discipline deleteDiscipline(int id) {
        return disciplineDAO.deleteDiscipline(id);

    }
}
