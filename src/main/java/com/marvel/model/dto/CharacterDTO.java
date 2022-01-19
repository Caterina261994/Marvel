package com.marvel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class CharacterDTO {


     String name;

     String description;

     LocalDate born;

     String thumbnail;
}
