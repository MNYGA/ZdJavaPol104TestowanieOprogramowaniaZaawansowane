package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private static final Animal ANIMAL = new Animal(1L, "mammal", "dog");
    private static final AnimalDto2 ANIMAL_DTO2 = new AnimalDto2(1L, "mammal", "dog", true);

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldAddNewAnimal() {
        //given
        Mockito.when(animalRepository.add(any())).thenReturn(ANIMAL);
        //when
        AnimalDto2 result = animalService.add("mammal", "dog");
        //then
        assertEquals(ANIMAL_DTO2, result); //junit
        assertThat(result).isEqualTo(ANIMAL_DTO2); //assertj
    }

    @Test
    void shouldReturnAnimalById() {
        //given
        Mockito.when(animalRepository.findById(anyLong())).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(1L);
        //then
        assertEquals(ANIMAL, result); //junit
        assertThat(result).isEqualTo(ANIMAL); //assertj
    }

    @Test
    void shouldThrowExceptionWhenUserNotExist() {
        //given
        Mockito.when(animalRepository.findById(anyLong())).thenReturn(Optional.empty());
        //when & then
        //junit
        assertThrows(IllegalArgumentException.class,
                () -> animalService.getById(1L));
        //assertJ
        assertThatThrownBy(() -> animalService.getById(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("animal not exist with id: 1");
    }
}