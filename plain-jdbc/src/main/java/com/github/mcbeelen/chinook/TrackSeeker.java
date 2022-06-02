package com.github.mcbeelen.chinook;

import com.google.common.base.Strings;

import java.sql.SQLException;
import java.util.Optional;

public class TrackSeeker {

    public static void main(String[] args) throws SQLException {
        TrackRepository accessToTheDbTracks = new PlainJdbcTrackRepository();

        printInfoOfTrack(accessToTheDbTracks, 2);
        printInfoOfTrack(accessToTheDbTracks, 23);
        printInfoOfTrack(accessToTheDbTracks, 232);
        printInfoOfTrack(accessToTheDbTracks, 2322);
        printInfoOfTrack(accessToTheDbTracks, 23223);
    }

    private static void printInfoOfTrack(TrackRepository trackRepository, int trackId) {

        try {
            Optional<Track> foundTrack = trackRepository.getById(trackId);
            foundTrack
                    .ifPresentOrElse(theTrack -> printTrackInfo(trackId, theTrack),
                            () -> issueWarning(trackId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private static void printTrackInfo(Integer trackId, Track x) {
        String idInfo = Strings.padStart(trackId.toString(), 8, ' ');
        System.out.println(idInfo + " --> " + x);
    }

    private static void issueWarning(int trackId) {
        System.err.println("The DB does not have a track with id:" + trackId);
    }
}
