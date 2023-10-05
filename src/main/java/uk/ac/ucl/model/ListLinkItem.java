package uk.ac.ucl.model;

public class ListLinkItem extends Item {
    private String linkedListId;

    public ListLinkItem(String linkedListId, String id) {
        super(id);
        this.linkedListId = linkedListId;
    }

    public String getLinkedListId() {
        return linkedListId;
    }

    @Override
    public String getContent() {
        return "Link to list: " + linkedListId;
    }
}
