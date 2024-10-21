package org.example.march2024springhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByUsername(String username);
}
