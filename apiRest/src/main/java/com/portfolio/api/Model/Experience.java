package com.portfolio.api.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String urlImageEx;
    private String positionEx;
    private String modeEx;
    private int startEx;
    private int endEx;

    public Experience() {
    }

    public Experience(Long id, String urlImageEx, String positionEx, String modeEx, int startEx, int endEx) {
        this.id = id;
        this.urlImageEx = urlImageEx;
        this.positionEx = positionEx;
        this.modeEx = modeEx;
        this.startEx = startEx;
        this.endEx = endEx;
    }
    
    
    
    

}
