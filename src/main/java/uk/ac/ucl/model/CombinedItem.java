package uk.ac.ucl.model;

public class CombinedItem extends Item {
    private Item firstItem;
    private ImageItem imageItem;

    public CombinedItem(String id, Item firstItem, ImageItem imageItem) {
        super(id);
        this.firstItem = firstItem;
        this.imageItem = imageItem;
    }

    public Item getFirstItem() {
        return firstItem;
    }
    public void setFirstItem(Item firstItem) {
        this.firstItem = firstItem;
    }

    public ImageItem getImageItem() {
        return imageItem;
    }
    public void setImageItem(ImageItem imageItem) {
        this.imageItem = imageItem;
    }

    public String getContent() {
        String firstItemContent = "";
        if (firstItem instanceof TextItem) {
            firstItemContent = ((TextItem) firstItem).getContent();
        } else if (firstItem instanceof UrlItem) {
            firstItemContent = "<a href='" + ((UrlItem) firstItem).getContent() ;
        } else if (firstItem instanceof ListLinkItem) {
            firstItemContent = "<a href='viewListItems.html?listId=" + ((ListLinkItem) firstItem).getLinkedListId() + "'>Linked List</a>";
        }

        String imgContent = imageItem.getContent();
        return firstItemContent + "<br/>" + imgContent;
    }

}

