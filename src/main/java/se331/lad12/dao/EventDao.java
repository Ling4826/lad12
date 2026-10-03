package se331.lad12.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lad12.entity.Event;

public interface EventDao {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);

    Event save(Event event);

    Page<Event> getEvents(String name, String description, Pageable page);
}