package uk.ac.ucl.model;
import java.io.Serializable;
public abstract class Item implements Serializable {
    private String id;

    public Item(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getContent();
}

