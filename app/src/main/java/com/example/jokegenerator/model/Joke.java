package com.example.jokegenerator.model;

public class Joke {
    public boolean error;
    public String type;
    public String category;
    public String joke;
    public String setup;
    public String delivery;
    public JokeTags flags;
    public int id;
    public String safe;
    public String lang;

    public Joke(boolean error, String type, String category, String joke, String setup, String delivery, JokeTags flags, int id, String safe, String lang) {
        this.error = error;
        this.type = type;
        this.category = category;
        this.joke = joke;
        this.setup = setup;
        this.delivery = delivery;
        this.flags = flags;
        this.id = id;
        this.safe = safe;
        this.lang = lang;
    }
}
