package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Objects;

public class AnimalDto {
    private final String type;
    private final String name;

    public AnimalDto(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return Objects.equals(type, animalDto.type) && Objects.equals(name, animalDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
