package net.javaguides.mms.repository;

import net.javaguides.mms.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByActorContainingIgnoreCase(String actor);
}
