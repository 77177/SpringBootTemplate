package com.template.demo.group.repositories;

import com.template.demo.group.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune, Long> {
}
