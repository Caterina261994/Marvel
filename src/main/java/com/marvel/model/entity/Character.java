package com.marvel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "character")
public class Character {
    @Id
    @SequenceGenerator(name = "character_id_seq", sequenceName = "character_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="character_id_seq")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "born")
    private LocalDate born;
    @Column(name = "thumbnail")
    private String thumbnail;
    @ManyToMany
    @JoinTable(
            name = "comicandcharacter",
            joinColumns = @JoinColumn(name = "idcomic"),
            inverseJoinColumns = @JoinColumn(name = "idcharacter"))
    private List<Comic> comics;
//    private ArrayList<String> stories;
//    private ArrayList<String> events;
}
