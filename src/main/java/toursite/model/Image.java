package toursite.model;

import javax.persistence.*;

/**
 * Created by Vasyl on 13.06.2015.
 */
@Entity
public class Image {
    private int imageId;
    private String fileName;

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (imageId != image.imageId) return false;
        if (fileName != null ? !fileName.equals(image.fileName) : image.fileName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }
}
