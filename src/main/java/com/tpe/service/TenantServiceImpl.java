package com.tpe.service;

import com.tpe.domain.Tenant;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService{


    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public List<Tenant> getAllTenants() {
        return null;
    }

    @Override
    public Tenant findTenantById(Long id)  {
        return tenantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tenant not found with id: "+ id));
    }

    @Override
    public void saveTenant(Tenant tenant) {

    }

    @Override
    public void updateTenant(Long id, Tenant tenant) {

    }

    @Override
    public void deleteTenant(Long id) {

    }
}
