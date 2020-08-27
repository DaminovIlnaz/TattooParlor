package app.entities;

import java.util.Objects;

public class Tattoo {
    private String name;
    private String link;

    public Tattoo(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tattoo tattoo = (Tattoo) o;
        return Objects.equals(name, tattoo.name) &&
                Objects.equals(link, tattoo.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link);
    }

    @Override
    public String toString() {
        return "Tattoo{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
