package pl.janeck.spaceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.janeck.spaceapp.model.Space;
import pl.janeck.spaceapp.service.SpaceService;

import java.util.Optional;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 20:52
 */

@RestController
@RequestMapping("/app/v2/space")
public class SpaceController {

    private final SpaceService spaceService;


    @Autowired
    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping
    public ResponseEntity<Space> getSpace(){
        Optional<Space> space = spaceService.getSpace();
        if(space.isPresent()){
            return ResponseEntity.ok(space.get());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
