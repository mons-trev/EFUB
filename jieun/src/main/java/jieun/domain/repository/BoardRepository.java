package jieun.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jieun.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}