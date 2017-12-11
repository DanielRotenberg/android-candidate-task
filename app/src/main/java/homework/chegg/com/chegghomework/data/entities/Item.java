package homework.chegg.com.chegghomework.data.entities;

/**
 * Created by DanielR on 01/12/2017.
 */

public class Item {


    private String header;
    private String description;
    private String picture;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (header != null ? !header.equals(item.header) : item.header != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null)
            return false;
        return picture != null ? picture.equals(item.picture) : item.picture == null;
    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
