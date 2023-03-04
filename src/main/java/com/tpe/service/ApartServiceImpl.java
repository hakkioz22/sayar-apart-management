package com.tpe.service;

import com.tpe.domain.Apart;
import com.tpe.dto.ApartDTO;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.ApartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApartServiceImpl  implements ApartService{

    @Autowired
    private ApartRepository apartRepository;
    @Override
    public List<Apart> getAllApart() {
        return apartRepository.findAll();
    }

    @Override
    public Apart findApartById(Long id) {
        return apartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Apart bulunamadı :" + id));
    }

    @Override
    public void saveApart(Apart apart) {
        apartRepository.save(apart);

    }

    @Override
    public void updateApart(Long id, ApartDTO apartDTO) {
        //TODO:update ve save metodları için DTO kullanılacak!
    }

    @Override
    public void deleteApart(Long id) {

    }
}
