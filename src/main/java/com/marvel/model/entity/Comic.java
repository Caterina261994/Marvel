package com.marvel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comic")
public class Comic {
    @Id
    @SequenceGenerator(name = "comic_id_seq", sequenceName = "comic_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comic_id_seq")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "born")
    private Date born;
    @Column(name = "thumbnail")
    private String thumbnail;
    @ManyToMany(mappedBy = "comics")
    private List<Character> characters;


}
