package com.pelatihan.pelatihan.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pelatihan.pelatihan.dto.PageResponse;
import com.pelatihan.pelatihan.dto.SampleDto;
import com.pelatihan.pelatihan.dto.UpdateSampleDto;

public interface SampleService {
    List<SampleDto> findAll(String nmae,Pageable pageable);
    PageResponse<SampleDto> findAllWithFilter(String nmae,
                                        String code,
                                        Boolean status,
                                        Pageable pageable);
    void create(SampleDto dto); 
    void update(int id, UpdateSampleDto dto);
    void detele(int id);   
} 