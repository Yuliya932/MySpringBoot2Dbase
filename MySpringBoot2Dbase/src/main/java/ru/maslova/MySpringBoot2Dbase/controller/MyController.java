package ru.maslova.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maslova.MySpringBoot2Dbase.entity.Student;
import ru.maslova.MySpringBoot2Dbase.service.DisciplineService;
import ru.maslova.MySpringBoot2Dbase.service.StudentService;
import ru.maslova.MySpringBoot2Dbase.entity.Discipline;
import java.util.List;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> allStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent (@PathVariable("id") int id){
        return studentService.getStudent(id);
    }

    @PostMapping ("/students")
    public String saveStudent (@RequestBody Student student){
         studentService.saveStudent(student);
         return "add student success";
    }

    @PutMapping("/students")
    public String updateStudent (@RequestBody Student student){
        studentService.saveStudent(student);
        return "update student success";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent (@PathVariable("id") int id){
        studentService.deleteStudent(id);
        return "delete student success";
    }

    /***
     * для Disciplines
     */

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public List<Discipline> allDisciplines(){
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        return allDisciplines;
    }

    @GetMapping("/disciplines/{id}")
    public Discipline getDiscipline (@PathVariable("id") int id){
        return disciplineService.getDiscipline(id);
    }

    @PostMapping ("/disciplines")
    public String saveDiscipline (@RequestBody Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return "add discipline success";
    }

    @PutMapping("/disciplines")
    public String updateDiscipline (@RequestBody Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return "update discipline success";
    }

    @DeleteMapping("/disciplines/{id}")
    public String deleteDiscipline (@PathVariable("id") int id){
        disciplineService.deleteDiscipline(id);
        return "delete discipline success";
    }
}
