package com.tpe.service;

import com.tpe.domain.Apart;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.ApartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartServiceImpl  implements ApartService{

    @Autowired
    private ApartRepository apartRepository;

    @Override
    public List<Apart> getAllApart() {
        List<Apart> all = apartRepository.findAll();
        return all;
    }

    @Override
    public Apart findApartById(Long id) {
       return apartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Apart not found with id: " + id));
    }

    @Override
    public void saveApart(Apart apart) {
        apartRepository.save(apart);
    }

    @Override
    public Apart updateApart(Long id, Apart updatedapart) {
         return apartRepository.findById(id)
         .map(apart ->{apart.setName(updatedapart.getName());
         apart.setRentPrice(updatedapart.getRentPrice());
         apart.setIsPaid(updatedapart.getIsPaid());
         apart.setRentDate(updatedapart.getRentDate());
         return apartRepository.save(apart);
         }).orElseThrow(()-> new ResourceNotFoundException("Apart not found with id " + id));
    }

    @Override
    public void deleteApart(Long id) {
        apartRepository.deleteById(id);

    }
}
