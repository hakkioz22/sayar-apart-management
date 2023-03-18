package com.tpe.service;

import com.tpe.domain.Tenant;

import java.util.List;

public interface TenantService {

    List<Tenant> getAllTenants();

    Tenant findTenantById(Long id);

    void saveTenant(Tenant tenant);

    void updateTenant(Long id,Tenant tenant);

    void deleteTenant(Long id);
}
