package com.pelatihan.pelatihan.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sample {
    private int id;
    private String name;
    private String code;
    private String description;
    private boolean status;
    private LocalDate createDate;
    private LocalDate updateDate;
}
