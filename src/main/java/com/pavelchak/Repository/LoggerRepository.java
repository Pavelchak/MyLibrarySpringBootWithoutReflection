package com.pavelchak.Repository;

import com.pavelchak.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {
    List<Logger> findByPersonLike(String like);
}
