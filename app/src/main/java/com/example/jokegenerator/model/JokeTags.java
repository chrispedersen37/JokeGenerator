package com.example.jokegenerator.model;

public class JokeTags {
    public boolean nsfw;
    public boolean religious;
    public boolean political;
    public boolean racist;
    public boolean sexist;
    public boolean explicit;

    public JokeTags(boolean nsfw, boolean religious, boolean political, boolean racist, boolean sexist, boolean explicit) {
        this.nsfw = nsfw;
        this.religious = religious;
        this.political = political;
        this.racist = racist;
        this.sexist = sexist;
        this.explicit = explicit;
    }
}
