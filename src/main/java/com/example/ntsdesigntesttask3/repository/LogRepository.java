package com.example.ntsdesigntesttask3.repository;

import com.example.ntsdesigntesttask3.entity.LogMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogMessage,Long> {
}
