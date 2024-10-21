package org.example.march2024springhw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner update(Long id, Owner owner) {
        Owner existingOwner = findById(id);
        existingOwner.setUsername(owner.getUsername());
        existingOwner.setEmail(owner.getEmail());
        return ownerRepository.save(existingOwner);
    }

    public void deleteById(Long id) {
        if (ownerRepository.findById(id).orElseThrow().getCars().isEmpty()) {
            ownerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete owner with cars");
        }
    }
}
