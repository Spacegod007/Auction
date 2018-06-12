package auction.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Painting extends Item{

    private String title;

    private String painter;

    public Painting(User seller, Category category, String description, String title, String painter) {
        super(seller, category, description);
        this.title = title;
        this.painter = painter;
    }

    public Painting() {
    }

    public String getTitle() {
        return title;
    }

    public String getPainter() {
        return painter;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Painting painting = (Painting) o;

        if (!title.equals(painting.title)) return false;
        return painter.equals(painting.painter);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), title, painter);
    }
}
