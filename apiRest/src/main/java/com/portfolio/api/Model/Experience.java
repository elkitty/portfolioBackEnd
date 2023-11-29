package com.portfolio.api.Model;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "Experiences")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExp")
    private Integer id;

    private String urlImage;
    private String position;
    private String mode;

    @Column(nullable = true)
    private int start;
    @Column(nullable = true)
    private int end;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Experience() {
    }

    public Experience(Integer id, String urlImage, String position, String mode, int start, int end, Persona persona) {
        this.id = id;
        this.urlImage = urlImage;
        this.position = position;
        this.mode = mode;
        this.start = start;
        this.end = end;
        this.persona = persona;
    }
    
    
    
    

}
