package com.tpe.controller;

import com.tpe.dto.LeaseDto;
import com.tpe.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lease")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;

    //define createLease method here
    @PostMapping("/create")
    public ResponseEntity<LeaseDto> createLease(@RequestBody LeaseDto leaseDto) {
        return leaseService.createLease(leaseDto);
    }

    //define updateLease method here
    @PutMapping("/update/{id}")
    public ResponseEntity<LeaseDto> updateLease(@PathVariable Long id, @RequestBody LeaseDto leaseDto) {
        return leaseService.updateLease(id,leaseDto);
    }

    //define deleteLease method here
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LeaseDto> deleteLease(@PathVariable Long id) {
        return leaseService.deleteLease(id);
    }

    //define getLease method here
    @GetMapping("/get/{id}")
    public ResponseEntity<LeaseDto> getLease(@PathVariable Long id) {
        return leaseService.getLease(id);
    }

    //define getAllLeases method here
    @GetMapping("/getAll")
    public ResponseEntity<List<LeaseDto>> getAllLeases() {
        return leaseService.getAllLeases();
    }

    //define getLeaseByLeaserName method here
    @GetMapping("/getByLeaserName/{leaserName}")
    public ResponseEntity<LeaseDto> getLeaseByLeaserName(@PathVariable String leaserName) {
        return leaseService.getLeaseByLeaserName(leaserName);
    }
    //define getLeaseBySocialSecurityNumber method here
    @GetMapping("/getBySsn/{socialSecurityNumber}")
    public ResponseEntity<LeaseDto> getLeaseBySocialSecurityNumber(@PathVariable String socialSecurityNumber) {
        return leaseService.getLeaseBySocialSecurityNumber(socialSecurityNumber);
    }
    //define getLeaseByLeaserPhone method here
    @GetMapping("/getByLeaserPhone/{leaserPhone}")
    public ResponseEntity<LeaseDto> getLeaseByLeaserPhone(@PathVariable String leaserPhone) {
        return leaseService.getLeaseByLeaserPhone(leaserPhone);
    }

}
