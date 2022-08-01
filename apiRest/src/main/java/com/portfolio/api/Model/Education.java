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
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Basic
    String schoolEd;
    String urlImageEd;
    String titleEd;
    String startEd;
    String endEd;

    public Education() {
    }

    public Education(Long id, String schoolEd, String urlImageEd, String titleEd, String startEd, String endEd) {
        this.id = id;
        this.schoolEd = schoolEd;
        this.urlImageEd = urlImageEd;
        this.titleEd = titleEd;
        this.startEd = startEd;
        this.endEd = endEd;
    }

    public class HttpStatus {

        public HttpStatus() {
        }
    }

}
