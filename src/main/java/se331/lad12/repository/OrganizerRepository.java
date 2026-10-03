package se331.lad12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lad12.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
