package com.pelatihan.pelatihan.services;

import java.util.List;

import com.pelatihan.pelatihan.dto.SampleDto;
import com.pelatihan.pelatihan.dto.UpdateSampleDto;

public interface SampleService {
    List<SampleDto> findAll();
    void create(SampleDto dto);
    void update(int id, UpdateSampleDto dto);
    void detele(int id);   
} 