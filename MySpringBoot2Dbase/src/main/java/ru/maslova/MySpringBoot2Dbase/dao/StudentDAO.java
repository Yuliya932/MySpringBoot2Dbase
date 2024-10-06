package ru.maslova.MySpringBoot2Dbase.dao;

import org.springframework.stereotype.Repository;
import ru.maslova.MySpringBoot2Dbase.entity.Student;
import java.util.List;

@Repository
public interface StudentDAO {

    List<Student> getAllStudents();

    Student saveStudent (Student student);

    Student getStudent (int id);

    Student deleteStudent (int id);
}
