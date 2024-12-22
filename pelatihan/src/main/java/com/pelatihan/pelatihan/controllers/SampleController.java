package com.pelatihan.pelatihan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelatihan.pelatihan.dto.SampleDto;
import com.pelatihan.pelatihan.dto.UpdateSampleDto;
import com.pelatihan.pelatihan.services.SampleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/sample")
public class SampleController {
    private final SampleService sampleService;

    @Autowired
    SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<SampleDto>> findAll(){
        return ResponseEntity.ok().body(sampleService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SampleDto dto){
        sampleService.create(dto);
        return ResponseEntity.ok().body("Berhasil Menambah Data");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody UpdateSampleDto dto){
        sampleService.update(id, dto);
        return ResponseEntity.ok().body("Berhasil Mengubah Data");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> detele(@PathVariable int id){
        sampleService.detele(id);
        return ResponseEntity.ok().body("Berhasil Menghapus Data");
    }
}
