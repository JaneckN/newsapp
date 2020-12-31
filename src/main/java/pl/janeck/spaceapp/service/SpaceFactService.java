package pl.janeck.spaceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.janeck.spaceapp.model.SpaceFact;
import pl.janeck.spaceapp.repository.SpaceFactDao;

import java.util.List;
import java.util.Optional;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 23:42
 */

@Service
public class SpaceFactService {

    private final SpaceFactDao spaceFactDao;

    @Autowired
    public SpaceFactService(SpaceFactDao spaceFactDao) {
        this.spaceFactDao = spaceFactDao;
    }


    public List<SpaceFact> getSpaceFacts() {
        return spaceFactDao.getSpaceFacts();
    }

    public Optional<SpaceFact> getSpaceFactById(long id) {
        return spaceFactDao.findById(id);
    }

    public Optional<SpaceFact> removeCar(long id) {
        Optional<SpaceFact> spaceFactToRemove = spaceFactDao.findById(id);
        if (spaceFactToRemove.isPresent()) {
            spaceFactDao.deleteSpaceFact(spaceFactToRemove.get().getId());
            return spaceFactToRemove;
        }
        return Optional.empty();
    }


    public Optional<SpaceFact> addSpaceFact(SpaceFact spaceFactToAdd) {
        spaceFactDao.saveSpaceFact(spaceFactToAdd);
        return Optional.of(spaceFactToAdd);
    }

    public Optional<SpaceFact> updateSpaceFact(SpaceFact spaceFact) {
        Optional<SpaceFact> spaceFactToUpdate = spaceFactDao.findById(spaceFact.getId());
        if (spaceFactToUpdate.isPresent()) {
            spaceFactDao.updateSpaceFact(spaceFact);
            return Optional.of(spaceFact);
        }
        return spaceFactToUpdate;
    }


}


