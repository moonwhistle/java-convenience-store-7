package store.domain.vo;

import java.util.Objects;

public class Name {

    private final String name;

    public static Name from(String name) {
        return new Name(name);
    }

    public static Name noName() {
        return new Name("");
    }

    private Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name myObject = (Name) obj;
        return Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
