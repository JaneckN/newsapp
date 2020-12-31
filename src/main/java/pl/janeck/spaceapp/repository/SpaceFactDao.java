package pl.janeck.spaceapp.repository;

import pl.janeck.spaceapp.model.SpaceFact;

import java.util.List;
import java.util.Optional;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 21:43
 */


public interface SpaceFactDao {


    void saveSpaceFact(SpaceFact newSpaceFact);

    List<SpaceFact> getSpaceFacts();

    Optional<SpaceFact> findById(long id);

    void updateSpaceFact(SpaceFact spaceFactToEdit);

    void deleteSpaceFact(long id);


}
