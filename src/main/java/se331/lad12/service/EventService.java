package se331.lad12.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lad12.entity.Event;

public interface EventService {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Page<Event> getEvents(String title,String description, Pageable pageable);

    Event getEvent(Long id);

    Event save(Event event);
}