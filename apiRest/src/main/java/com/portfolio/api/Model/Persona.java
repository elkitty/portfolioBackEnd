package com.portfolio.api.Model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Basic
    String fullName;
    String position;
    String location;
    String urlImage;

    public Persona() {
    }

    public Persona(Long id, String fullName, String position, String location, String urlImage) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.location = location;
        this.urlImage = urlImage;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Education> educationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Skills> skillList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Experience> experienceList;

}
