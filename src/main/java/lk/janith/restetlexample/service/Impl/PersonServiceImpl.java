package lk.janith.restetlexample.service.Impl;

import lk.janith.restetlexample.dto.PersonRequestDTO;
import lk.janith.restetlexample.entity.PersonEntity;
import lk.janith.restetlexample.repository.UserRepository;
import lk.janith.restetlexample.service.PersonService;
import lk.janith.restetlexample.util.PersonDataClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDataClient personDataClient;
    private final UserRepository userRepository;

    @Override
    public String extractPersonData() {
        log.info("EXTRACT_PERSON_DATA METHOD ACCESSED.");

        List<PersonRequestDTO> users = personDataClient.fetchUsers();
        if (users == null || users.isEmpty()) {
            return "no users fetched to insert";
        }

        List<PersonEntity> entities = users.stream()
                .map(d -> d.mapData(PersonEntity.class))
                .toList();

        int insertedCount = userRepository.saveAll(entities).size();

        return insertedCount > 0
                ? String.format("Successfully inserted %d records into persons", insertedCount)
                : "No records inserted";
    }


}
