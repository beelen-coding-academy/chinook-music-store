package com.github.mcbeelen.chinook;

import java.sql.SQLException;
import java.util.Optional;

public interface TrackRepository {

    Optional<Track> getById(Integer id) throws SQLException;

}
