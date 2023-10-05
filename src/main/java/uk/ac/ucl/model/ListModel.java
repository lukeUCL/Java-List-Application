package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class ListModel implements Serializable{

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private List<Item> items;

    public ListModel(String id, String name) {
        this.id = id;
        this.name = name;
        items = new ArrayList<>();
    }

    public String getId() {


        return id;
    }


    public String getName() {


        return name;
    }


    public void setName(String name) {


        this.name = name;
    }


    public List<Item> getItems() {


        return items;


    }

    public void addItem(Item item) {

        items.add(item);
    }

    public void removeItem(String itemId) {

        items.removeIf(item -> item.getId().equals(itemId));
    }

    public Item getItem(String itemId) {

        return items.stream().filter(item -> item.getId().equals(itemId)).findFirst().orElse(null);
    }


}