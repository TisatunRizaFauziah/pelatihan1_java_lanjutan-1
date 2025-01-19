package com.pelatihan.pelatihan.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pelatihan.pelatihan.dto.PageResponse;
import com.pelatihan.pelatihan.dto.SampleDto;
import com.pelatihan.pelatihan.dto.UpdateSampleDto;
import com.pelatihan.pelatihan.models.Sample;
import com.pelatihan.pelatihan.repository.SampleRepository;
import com.pelatihan.pelatihan.repository.specification.SampleSpecification;

@Service
public class SampleServiceImpl implements SampleService {
    private final SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository)
    {
        this.sampleRepository=sampleRepository;
    }
    List<Sample> samples = new ArrayList<>();

    @Override
    public void create(SampleDto dto) {
        sampleRepository.save(mapToSample(dto));

    }

    @Override
    public void detele(int id) {
        Optional<Sample> sample= sampleRepository.findById(id);
        sample.ifPresent(sampleRepository::delete);
    }

    
    @Override
    public List<SampleDto> findAll(String name,Pageable pageable) {
        return sampleRepository.findAll(name,pageable).stream()
                .map(this::mapToSampleDto)
                .toList();
    }
    @Override
    public PageResponse<SampleDto> findAllWithFilter(String name,String code,Boolean status,Pageable pageable) {
       Specification<Sample> spec = Specification.where(null);

       //name
        spec=spec.and(SampleSpecification.coutainName(name));

       //code
       if(code != null && !code.isEmpty()){
        spec=spec.and(SampleSpecification.equalCode(code));
       }

       //status
       if(status != null ){
        spec=spec.and(SampleSpecification.equalStatus(status));
       }

        Page<Sample>samplePage=sampleRepository.findAll(spec,pageable);
        return PageResponse.<SampleDto>builder()
                .page(pageable.getPageNumber())
                .size(pageable.getPageSize())
                .totalPage(samplePage.getTotalPages())
                .totalItem(samplePage.getTotalElements())
                .items(samplePage.stream()
                    .map(this::mapToSampleDto)
                    .toList())

                .build();
    }
    @Override
    public void update(int id, UpdateSampleDto dto) {
        Optional<Sample>sample=sampleRepository.findById(id);

        sample.ifPresent(sampleToUpdate->{
            sampleToUpdate.setId(id);
            sampleToUpdate.setName(dto.getName());
            sampleToUpdate.setCode(dto.getCode());
            sampleToUpdate.setDescription(dto.getDescription());
            sampleToUpdate.setStatus(dto.isStatus());
            sampleToUpdate.setUpdateDate(LocalDate.now());
            sampleRepository.save(sampleToUpdate);
        });
       
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
