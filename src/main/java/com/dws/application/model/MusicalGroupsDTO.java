package com.dws.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicalGroupsDTO {

    private String id;
    private String name;
    private String image;
    private String genre;
    private String biography;
    private Long numPlays;
    private List<String> albums;

}
