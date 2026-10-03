package se331.lad12.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDetailDTO {
    Long id;
    String name;
    String telNo;

    @Builder.Default
    List<ParticipantEventHistoryDTO> eventHistories = new ArrayList<>();
}


