package com.pelatihan.pelatihan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSampleDto {
    private String name;
    private String code;
    private String description;
    private boolean status;
}
