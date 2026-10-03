package se331.lad12.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lad12.entity.Event;
import se331.lad12.repository.EventRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class EventDaoDbImpl implements EventDao {
    final EventRepository eventRepository;

    @Override
    public Integer getEventSize() {
        return Math.toIntExact(eventRepository.count());
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        int total = (int) eventRepository.count();
        pageSize = (pageSize == null || pageSize < 1) ? (total == 0 ? 1 : total) : pageSize;
        page = (page == null || page < 1) ? 1 : page;
        return eventRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Page<Event> getEvents(String title , String description, Pageable page) {
        return eventRepository.findByTitleContainingAndDescriptionContaining(title, description, page);
    }

}


