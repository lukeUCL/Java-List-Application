package uk.ac.ucl.model;

public class TextItem extends Item {
    private String content;

    public TextItem(String id, String content) {
        super(id);
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
