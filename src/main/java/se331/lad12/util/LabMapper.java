package se331.lad12.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lad12.entity.Event;
import se331.lad12.entity.EventDTO;
import se331.lad12.entity.Organizer;
import se331.lad12.entity.OrganizerDTO;

import java.util.List;
import se331.lad12.entity.Participant;
import se331.lad12.entity.ParticipantDetailDTO;

import org.mapstruct.Mapping;
import se331.lad12.entity.OrganizerAuthDTO;


@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);

    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDetailDTO getParticipantDetailDto(Participant participant);

    List<ParticipantDetailDTO> getParticipantDetailDto(List<Participant> participants);

    @Mapping(target = "roles", source = "user.roles")
    OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);

}
