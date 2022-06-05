package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Objects;

public class AnimalDto2 {
    private final long id;
    private final String type;
    private final String name;
    public final boolean isAlive;

    public AnimalDto2(long id, String type, String name, boolean isAlive) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.isAlive = isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AnimalDto2 that = (AnimalDto2) o;
        return id == that.id && isAlive == that.isAlive && Objects.equals(type, that.type) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, isAlive);
    }
}
