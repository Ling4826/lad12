package se331.lad12.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se331.lad12.dao.EventDao;
import se331.lad12.dao.OrganizerDao;
import se331.lad12.entity.Event;
import se331.lad12.entity.Organizer;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    final EventDao eventDao;
    final OrganizerDao organizerDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Page<Event> getEvents(String title,String description, Pageable pageable) {
        return eventDao.getEvents(title,description, pageable);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        if (event.getOrganizer() == null || event.getOrganizer().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The organizer id is required");
        }
        Organizer organizer = organizerDao.findById(event.getOrganizer().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizer not found"));
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        return eventDao.save(event);
    }
}