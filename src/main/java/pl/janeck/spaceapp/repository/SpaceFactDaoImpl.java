package pl.janeck.spaceapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.janeck.spaceapp.model.SpaceFact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 21:47
 */

@Repository
public class SpaceFactDaoImpl implements SpaceFactDao {


    private JdbcTemplate jdbcTemplate;


    @Autowired
    public SpaceFactDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveSpaceFact(SpaceFact newSpaceFact) {
        String sql = "INSERT INTO space_facts(copyright, date,  explanation, title, url )VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, newSpaceFact.getCopyright(), newSpaceFact.getDate(), newSpaceFact.getExplanation(), newSpaceFact.getTitle(), newSpaceFact.getUrl());
    }

    @Override
    public List<SpaceFact> getSpaceFacts() {
        String sql = "SELECT * FROM space_facts";
        List<SpaceFact> spaceFactList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return getSpaceFactsList(spaceFactList, maps);
    }


    @Override
    public Optional<SpaceFact> findById(long id) {
        String sql = "SELECT * FROM space_facts where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new RowMapper<SpaceFact>() {
            @Override
            public SpaceFact mapRow(ResultSet resultSet, int i) throws SQLException {
                return new SpaceFact(resultSet.getLong("id"),
                        resultSet.getString("date"),
                        resultSet.getString("copyright"),
                        resultSet.getString("explanation"),
                        resultSet.getString("title"),
                        resultSet.getString("url"));

            }
        }, id));
    }


    @Override
    public void updateSpaceFact(SpaceFact spaceFactToEdit) {
        String sql = "UPDATE space_facts SET date=?, copyright=?, explanation=?, title=?, url=?  WHERE id=?";
        jdbcTemplate.update(sql, spaceFactToEdit.getDate(), spaceFactToEdit.getCopyright(), spaceFactToEdit.getExplanation(), spaceFactToEdit.getTitle(), spaceFactToEdit.getUrl(), spaceFactToEdit.getId());
    }

    @Override
    public void deleteSpaceFact(long id) {
        String sql = "DELETE FROM space_facts WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }


    private List<SpaceFact> getSpaceFactsList(List<SpaceFact> spaceFactList, List<Map<String, Object>> maps) {
        maps.stream().forEach(element -> spaceFactList.add(new SpaceFact(
                Long.parseLong(String.valueOf(element.get("id"))),
                String.valueOf(element.get("date")),
                String.valueOf(element.get("copyright")),
                String.valueOf(element.get("explanation")),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("url"))
        )));
        return spaceFactList;
    }
}
