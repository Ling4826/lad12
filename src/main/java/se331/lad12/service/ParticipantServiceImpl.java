package se331.lad12.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lad12.dao.ParticipantDao;
import se331.lad12.entity.Participant;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantDao participantDao;

    @Override
    public List<Participant> getAllParticipant() {
        return participantDao.getAllParticipant();
    }
}


