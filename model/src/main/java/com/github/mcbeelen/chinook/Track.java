package com.github.mcbeelen.chinook;

public class Track {

    private String name;
    private String composer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }


    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                '}';
    }


    public static final class TrackBuilder {
        private Track track;

        private TrackBuilder() {
            track = new Track();
        }

        public static TrackBuilder aTrack() {
            return new TrackBuilder();
        }

        public TrackBuilder withName(String name) {
            track.setName(name);
            return this;
        }

        public TrackBuilder withComposer(String composer) {
            track.setComposer(composer);
            return this;
        }

        public TrackBuilder but() {
            return aTrack().withName(track.getName()).withComposer(track.getComposer());
        }

        public Track build() {
            return track;
        }
    }
}
