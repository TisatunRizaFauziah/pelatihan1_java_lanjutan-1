package com.pelatihan.pelatihan.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pelatihan.pelatihan.dto.SampleDto;
import com.pelatihan.pelatihan.dto.UpdateSampleDto;
import com.pelatihan.pelatihan.models.Sample;

@Service
public class SampleServiceImpl implements SampleService {

    List<Sample> samples = new ArrayList<>();

    @Override
    public void create(SampleDto dto) {
        samples.add(mapToSample(dto));

    }

    @Override
    public void detele(int id) {
        Optional<Sample> sample = samples.stream()
                .filter(sample1 -> sample1.getId() == id)
                .findFirst();

        sample.ifPresent(value -> samples.remove(value));
    }

    
    @Override
    public List<SampleDto> findAll() {
        return samples.stream()
                .map(this::mapToSampleDto)
                .toList();
    }

    @Override
    public void update(int id, UpdateSampleDto dto) {
        samples.stream()
                .filter(sample -> sample.getId() == id)
                .map(sample -> {
                    Sample sample1 = new Sample();
                    sample1.setId(id);
                    sample1.setName(dto.getName());
                    sample1.setCode(dto.getCode());
                    sample1.setDescription(dto.getDescription());
                    sample1.setStatus(dto.isStatus());
                    sample1.setUpdateDate(LocalDate.now());
                    return sample1;
                })
                .toList();
    }

    public SampleDto mapToSampleDto(Sample sample) {
        return SampleDto.builder()
                .id(sample.getId())
                .name(sample.getName())
                .code(sample.getCode())
                .description(sample.getDescription())
                .status(sample.isStatus())
                .build();
    }

    public Sample mapToSample(SampleDto sample) {
        return Sample.builder()
                .id(sample.getId())
                .name(sample.getName())
                .code(sample.getCode())
                .description(sample.getDescription())
                .status(sample.isStatus())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .build();
    }

}
