package uk.ac.ucl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListManager {
    private List<ListModel> lists;
    private static ListManager instance;
    private static final String FILE_NAME = "lists.dat";

    private ListManager() {
        lists = loadListsFromFile();
    }

    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public List<ListModel> getLists() {
        return lists;
    }

    public void addList(ListModel list) {
        lists.add(list);
        System.out.println("Added list: " + list.getName() + " with ID: " + list.getId());
        saveListsToFile();
    }

    // Debugging
    public ListModel getList(String listId) {
        for (ListModel list : lists) {
            if (list.getId().equals(listId)) {
                System.out.println("List retrieved: " + list.getName() + " with ID: " + list.getId());
                return list;
            }
        }
        return null;
    }

    public void createList(String name) {
        String id = UUID.randomUUID().toString();
        ListModel list = new ListModel(id, name);
        addList(list);
    }

    public void deleteList(String listId) {
        ListModel list = getList(listId);
        if (list != null) {
            lists.remove(list);
            System.out.println("Deleted list: " + list.getName() + " with ID: " + list.getId());
            saveListsToFile();
        }
    }

    //saving + loading lists with serialization
    private void saveListsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<ListModel> loadListsFromFile() {
        List<ListModel> loadedLists = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            loadedLists = (List<ListModel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedLists;
    }
}
