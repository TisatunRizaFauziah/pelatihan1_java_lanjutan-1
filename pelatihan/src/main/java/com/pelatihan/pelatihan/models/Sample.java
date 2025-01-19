package com.pelatihan.pelatihan.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sample")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sample {
    @Id
    @Column(name="id",nullable = false,unique = true)
    private int id;

    @Column(name="name",length = 5000)
    private String name;

    @Column(name="code",length = 20)
    private String code;

    @Column(name="description",length = 1000)
    private String description;

    @Column(name="status")
    private boolean status;

    @Column(name="created_date",columnDefinition = "DATE")
    private LocalDate createDate;

    @Column(name="updated_date",columnDefinition = "DATE")
    private LocalDate updateDate;
}
