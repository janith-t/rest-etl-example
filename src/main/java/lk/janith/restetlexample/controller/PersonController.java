package lk.janith.restetlexample.controller;

import lk.janith.restetlexample.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/extract")
    public ResponseEntity<String> getPersonData() {
        log.info("GET_PERSON_DATA METHOD ACCESSED.");
        String responseMsg = personService.extractPersonData();
        return ResponseEntity.ok(responseMsg);
    }
}
