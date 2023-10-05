package uk.ac.ucl.model;

public class UrlItem extends Item {
    private String url;

    public UrlItem(String id, String url) {
        super(id);
        this.url = url;
    }

    @Override
    public String getContent() {
        return "<a href='" + url + "'>" + url + "</a>";
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
