package pl.sdacademy.unit.test.advance.exercises.task2;

public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getById(long id) {
        return animalRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("animal not exist with id: " + id));
    }

    public AnimalDto2 add(String type, String name) {
        AnimalDto animalDto = new AnimalDto(type, name);
        Animal newCreatedAnimal = animalRepository.add(animalDto);
        return animalMapper(newCreatedAnimal);
    }

    private static AnimalDto2 animalMapper(Animal animal) {
        return new AnimalDto2(
                animal.getId(),
                animal.getType(),
                animal.getName(),
                true
        );
    }
}
