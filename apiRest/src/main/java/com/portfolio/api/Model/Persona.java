package com.portfolio.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaId")  // Cambia el nombre según tu preferencia
    private Integer id;

    @Column(nullable = false)
    private String fullName;
    private String position;
    private String location;
    private String urlImage;
    @Column(columnDefinition = "TEXT")
    private String about;

    @OneToMany(mappedBy = "persona")
    @JsonIgnoreProperties("persona")
    private List<Education> educationList;

    @OneToMany(mappedBy = "persona")
    @JsonIgnoreProperties("persona")
    private List<Skill> skillList;

    @OneToMany(mappedBy = "persona")
    @JsonIgnoreProperties("persona")
    private List<Experience> experienceList;

}
