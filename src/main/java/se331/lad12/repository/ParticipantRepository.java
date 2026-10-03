package se331.lad12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lad12.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
