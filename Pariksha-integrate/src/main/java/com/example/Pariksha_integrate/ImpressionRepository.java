package com.example.Pariksha_integrate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImpressionRepository extends JpaRepository<Impression, Long> {
    // Additional query methods can be defined here if needed
}
