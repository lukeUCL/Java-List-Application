package uk.ac.ucl.model;

public class ImageItem extends Item {
    private String imagePath;

    public ImageItem(String id, String imageName) {
        super(id);
        this.imagePath = "/data/" + imageName;
    }

    @Override
    public String getContent() {
        return "<img src='" + imagePath + "' alt='Image' />";
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}