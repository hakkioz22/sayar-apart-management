package com.tpe.service;

import com.tpe.domain.Apart;

import java.util.List;

public interface ApartService {

    List<Apart> getAllApart();
    Apart findApartById(Long id);
    void saveApart(Apart apart);
    Apart updateApart(Long id, Apart apart);
    void deleteApart(Long id);
}
