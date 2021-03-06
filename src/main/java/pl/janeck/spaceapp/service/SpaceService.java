package pl.janeck.spaceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.janeck.spaceapp.model.Space;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 20:42
 */

@Service
public class SpaceService {

    @Value("${api.key}")
    private static String API_KEY ;
    private String API_URL = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY + "&count=1&thumbs=true";
    private final RestTemplate restTemplate;


    @Autowired
    public SpaceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<Space> getSpace() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(API_URL, Space[].class))).findFirst();

    }


}
