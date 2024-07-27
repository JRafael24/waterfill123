package com.Thesis.waterfill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thesis.waterfill.Model.*;
import java.util.List;

public interface HistoryRepository extends JpaRepository <History, Long> {
    List<History> findByUserId(Long userId);

}
