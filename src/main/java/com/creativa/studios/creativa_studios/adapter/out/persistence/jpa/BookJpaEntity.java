package com.creativa.studios.creativa_studios.adapter.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "book")
@Setter
@Getter
public class BookJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    private String author;

    @Column(name = "date_of_publication")
    private Date dateOfPublication;

    @Column(name = "price", columnDefinition = "DECIMAL(10,2)")
    private double price;
}
