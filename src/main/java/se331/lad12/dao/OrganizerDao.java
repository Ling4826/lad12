package se331.lad12.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lad12.entity.Organizer;
import java.util.Optional;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Optional<Organizer> findById(Long id);
    Organizer save(Organizer organizer);
}
