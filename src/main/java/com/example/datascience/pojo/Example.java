package com.example.datascience.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Gabri
 */
@Entity
@Data
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
