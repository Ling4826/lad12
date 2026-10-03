package se331.lad12.service;

import org.springframework.data.domain.Page;
import se331.lad12.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();
    Page<Organizer> getOrganizer(Integer page, Integer pageSize);
    Organizer getOrganizerById(Long id);
    Organizer save(Organizer organizer);
}
