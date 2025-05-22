package com.tekpyramid.MovieRater.repository;

import com.tekpyramid.MovieRater.entity.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<Financial,Integer> {
}
