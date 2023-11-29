package com.portfolio.api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;
    
    //@Column(nullable = false, unique = true)
    private String name;

    //@Column(nullable = false, unique = true)
    private String email;

    //@Column(nullable = false)
    private String password;
}
