package com.cinearchive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRespository extends JpaRepository<StreamingRespository, Long> {
}
