package se331.lad12.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lad12.entity.Event;
import se331.lad12.entity.Organizer;
import se331.lad12.entity.Participant;
import se331.lad12.repository.EventRepository;
import se331.lad12.repository.OrganizerRepository;
import se331.lad12.repository.ParticipantRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import se331.lad12.security.user.Role;
import se331.lad12.security.user.User;
import se331.lad12.security.user.UserRepository;



import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
        final EventRepository eventRepository;
        final OrganizerRepository organizerRepository;
        final ParticipantRepository participantRepository;
        final UserRepository userRepository;

        @Override
        @Transactional
        public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
                Organizer org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
                Organizer org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
                Organizer org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());

                Event event1 = eventRepository.save(Event.builder()
                        .category("Academic")
                        .title("Midterm Exam")
                        .description("A time for taking the exam")
                        .location("CAMT Building")
                        .date("3rd Sept")
                        .time("3.00-4.00 pm.")
                        .petsAllowed(false)
                        .build());
                event1.setOrganizer(org1);
                org1.getOwnEvents().add(event1);
                Event event2 = eventRepository.save(Event.builder()
                        .category("Academic")
                        .title("Commencement Day")
                        .description("A time for celebration")
                        .location("CMU Convention hall")
                        .date("21th Jan")
                        .time("8.00am-4.00 pm.")
                        .petsAllowed(false)
                        .build());
                event2.setOrganizer(org1);
                org1.getOwnEvents().add(event2);
                Event event3 = eventRepository.save(Event.builder()
                        .category("Cultural")
                        .title("Loy Krathong")
                        .description("A time for Krathong")
                        .location("Ping River")
                        .date("21th Nov")
                        .time("8.00-10.00 pm.")
                        .petsAllowed(false)
                        .build());
                event3.setOrganizer(org2);
                org2.getOwnEvents().add(event3);
                Event event4 = eventRepository.save(Event.builder()
                        .category("Cultural")
                        .title("Songkran")
                        .description("Let's Play Water")
                        .location("Chiang Mai Moat")
                        .date("13th April")
                        .time("10.00am - 6.00 pm.")
                        .petsAllowed(true)
                        .build());
                event4.setOrganizer(org3);
                org3.getOwnEvents().add(event4);

                Participant p1 = Participant.builder().name("imon8888").telNo("454168").build();
                Participant p2 = Participant.builder().name("imon7777").telNo("474827").build();
                Participant p3 = Participant.builder().name("imon89456").telNo("452542").build();
                Participant p4 = Participant.builder().name("imon4826").telNo("45245").build();
                Participant p5 = Participant.builder().name("imon784").telNo("542542").build();

                p1.getEventHistories().addAll(List.of(event1, event2, event3));
                event1.getParticipants().add(p1);
                event2.getParticipants().add(p1);
                event3.getParticipants().add(p1);

                p2.getEventHistories().addAll(List.of(event1, event2, event4));
                event1.getParticipants().add(p2);
                event2.getParticipants().add(p2);
                event4.getParticipants().add(p2);

                p3.getEventHistories().addAll(List.of(event1, event3, event4));
                event1.getParticipants().add(p3);
                event3.getParticipants().add(p3);
                event4.getParticipants().add(p3);

                p4.getEventHistories().addAll(List.of(event2, event3, event4));
                event2.getParticipants().add(p4);
                event3.getParticipants().add(p4);
                event4.getParticipants().add(p4);

                p5.getEventHistories().addAll(List.of(event1, event2, event3, event4));
                event1.getParticipants().add(p5);
                event2.getParticipants().add(p5);
                event3.getParticipants().add(p5);
                event4.getParticipants().add(p5);

                participantRepository.save(p1);
                participantRepository.save(p2);
                participantRepository.save(p3);
                participantRepository.save(p4);
                participantRepository.save(p5);
                addUser();

                org1.setUser(user1);
                user1.setOrganizer(org1);
                org2.setUser(user2);
                user2.setOrganizer(org2);
                org3.setUser(user3);
                user3.setOrganizer(org3);


        }
        User user1, user2, user3;

        private void addUser() {
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                user1 = User.builder()
                        .username("admin")
                        .password(encoder.encode("admin"))
                        .firstname("admin")
                        .lastname("admin")
                        .email("admin@admin.com")
                        .enabled(true)
                        .build();
                user2 = User.builder()
                        .username("user")
                        .password(encoder.encode("user"))
                        .firstname("user")
                        .lastname("user")
                        .email("enabled@user.com")
                        .enabled(true)
                        .build();
                user3 = User.builder()
                        .username("disableUser")
                        .password(encoder.encode("disableUser"))
                        .firstname("disableUser")
                        .lastname("disableUser")
                        .email("disableUser@user.com")
                        .enabled(false)
                        .build();

                user1.getRoles().add(Role.ROLE_USER);
                user1.getRoles().add(Role.ROLE_ADMIN);

                user2.getRoles().add(Role.ROLE_USER);
                user3.getRoles().add(Role.ROLE_USER);

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);


        }

}
