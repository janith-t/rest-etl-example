package lk.janith.restetlexample.util;

import lk.janith.restetlexample.dto.PersonRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonDataClient {

    @Value("${client.user-data.url}")
    private String url;

    private final WebClient webClient;

    public List<PersonRequestDTO> fetchUsers() {

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(PersonRequestDTO.class)
                .collectList()
                .onErrorResume(WebClientResponseException.class, ex -> {
                    throw new RuntimeException(String.format("PersonDataClient failed with status code: %d, status text: %s", ex.getStatusCode().value(), ex.getStatusText()));
                })
                .block();
    }
}
