package ru.maslova.MySpringBoot2Dbase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="disciplines")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "form_of_control")
    private String form_of_control;

    @Column(name = "total_hours")
    private int total_hours;
}
