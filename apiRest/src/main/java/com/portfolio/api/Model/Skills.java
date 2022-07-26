package com.portfolio.api.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String nombreSk;
    private String fotoSk;
    private int porcentaje;

    public Skills(Long id, String nombreSk, String fotoSk, int porcentaje) {
        this.id = id;
        this.nombreSk = nombreSk;
        this.fotoSk = fotoSk;
        this.porcentaje = porcentaje;
    }
    
        public Skills() {
    }
}
