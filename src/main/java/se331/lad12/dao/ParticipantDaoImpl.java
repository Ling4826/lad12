package se331.lad12.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import se331.lad12.entity.Participant;
import se331.lad12.repository.ParticipantRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao {
    final ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAllParticipant() {
        return participantRepository.findAll();
    }
}


