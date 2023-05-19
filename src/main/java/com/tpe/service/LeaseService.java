package com.tpe.service;

import com.tpe.dto.LeaseDto;
import com.tpe.model.Lease;
import com.tpe.repository.LeaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<LeaseDto> createLease(LeaseDto leaseDto) {
        Lease lease = Lease.builder()
                .apartName(leaseDto.getApartName())
                .rentPrice(leaseDto.getRentPrice())
                .leaseStartDate(leaseDto.getLeaseStartDate())
                .leaseEndDate(leaseDto.getLeaseEndDate())
                .leaserName(leaseDto.getLeaserName())
                .leaserLastName(leaseDto.getLeaserLastName())
                .leaserPhone(leaseDto.getLeaserPhone())
                .socialSecurityNumber(leaseDto.getSocialSecurityNumber())
                .build();
        leaseRepository.save(lease);

        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.CREATED);

    }

    public ResponseEntity<LeaseDto> updateLease(Long id, LeaseDto leaseDto) {
        Lease lease = leaseRepository.findById(id).orElse(null);
        if (lease == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        lease.setApartName(leaseDto.getApartName() == null ? lease.getApartName() : leaseDto.getApartName());
        lease.setRentPrice(leaseDto.getRentPrice() == null ? lease.getRentPrice() : leaseDto.getRentPrice());
        lease.setLeaseStartDate(leaseDto.getLeaseStartDate() == null ? lease.getLeaseStartDate() : leaseDto.getLeaseStartDate());
        lease.setLeaseEndDate(leaseDto.getLeaseEndDate() == null ? lease.getLeaseEndDate() : leaseDto.getLeaseEndDate());
        lease.setLeaserName(leaseDto.getLeaserName() == null ? lease.getLeaserName() : leaseDto.getLeaserName());
        lease.setLeaserLastName(leaseDto.getLeaserLastName() == null ? lease.getLeaserLastName() : leaseDto.getLeaserLastName());
        lease.setLeaserPhone(leaseDto.getLeaserPhone() == null ? lease.getLeaserPhone() : leaseDto.getLeaserPhone());
        lease.setSocialSecurityNumber(leaseDto.getSocialSecurityNumber() == null ? lease.getSocialSecurityNumber() : leaseDto.getSocialSecurityNumber());

        leaseRepository.save(lease);

        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.OK);
    }

    public ResponseEntity<LeaseDto> deleteLease(Long id) {
        Lease lease = leaseRepository.findById(id).orElse(null);
        if (lease == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        leaseRepository.deleteById(id);
        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.OK);
    }

    public ResponseEntity<LeaseDto> getLease(Long id) {
        Lease lease = leaseRepository.findById(id).orElse(null);
        if (lease == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.OK);
    }

    public ResponseEntity<List<LeaseDto>> getAllLeases() {
        List<Lease> leases = leaseRepository.findAll();
        return new ResponseEntity<>(modelMapper.map(leases, List.class), HttpStatus.OK);
    }

    public ResponseEntity<LeaseDto> getLeaseByLeaserName(String leaserName) {
        Lease lease = leaseRepository.findByLeaserName(leaserName);
        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.OK);
    }

    public ResponseEntity<LeaseDto> getLeaseBySocialSecurityNumber(String socialSecurityNumber) {
        Lease lease = leaseRepository.findBySocialSecurityNumber(socialSecurityNumber);
        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.OK);
    }

    public ResponseEntity<LeaseDto> getLeaseByLeaserPhone(String leaserPhone) {
        Lease lease = leaseRepository.findByLeaserPhone(leaserPhone);
        return new ResponseEntity<>(modelMapper.map(lease, LeaseDto.class), HttpStatus.OK);
    }
}
