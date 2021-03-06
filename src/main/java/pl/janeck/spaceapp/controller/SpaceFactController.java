package pl.janeck.spaceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.janeck.spaceapp.model.SpaceFact;
import pl.janeck.spaceapp.service.SpaceFactService;

import java.util.List;
import java.util.Optional;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 23:42
 */

@RestController
@RequestMapping("/app/v2/space/facts")
public class SpaceFactController {


    private final SpaceFactService spaceFactService;

    @Autowired
    public SpaceFactController(SpaceFactService spaceFactService) {
        this.spaceFactService = spaceFactService;
    }

    @GetMapping
    public ResponseEntity<List<SpaceFact>> getSpaceFacts() {
        return new ResponseEntity<>(spaceFactService.getSpaceFacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceFact> getSpaceFactById(@PathVariable long id) {
        Optional<SpaceFact> spaceFact = spaceFactService.getSpaceFactById(id);
        if (spaceFact.isPresent()) {
            return new ResponseEntity<>(spaceFact.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<SpaceFact> addSpaceFact(@RequestBody SpaceFact spaceFactToAdd) {
        Optional<SpaceFact> spaceFact = spaceFactService.addSpaceFact(spaceFactToAdd);
        if (spaceFact.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SpaceFact> removeSpaceFact(@PathVariable long id) {
        Optional<SpaceFact> spaceFact = spaceFactService.removeCar(id);
        if (!spaceFact.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(spaceFact.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SpaceFact> updateCar(@RequestBody SpaceFact spaceFactToUpdate) {
        Optional<SpaceFact> spaceFact = spaceFactService.updateSpaceFact(spaceFactToUpdate);
        if (spaceFact.isPresent()) {
            return new ResponseEntity<>(spaceFact.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
