package pl.sdacademy.unit.test.advance.exercises.mockito.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final User USER = new User(1L, "Ala", "Nowak");

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserValidator userValidator;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldGetUserById() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(USER));
        //when
        User result = userService.getUserById(1L);
        //then
        assertEquals(USER, result); //junit
        assertThat(result).isEqualTo(USER); //assertJ
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        //when & then
        //junit
        assertThrows(NoSuchElementException.class,
                () -> userService.getUserById(1L));
        //assertJ
        assertThatThrownBy(() -> userService.getUserById(1L))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldCreateNewUser() {
        //given
        Mockito.when(userValidator.isUserValid(any())).thenReturn(true);
        Mockito.when(userRepository.addUser(any())).thenReturn(USER);
        //when
        User result = userService.createUser(USER);
        //then
        assertEquals(USER, result); //junit
        assertThat(result).isEqualTo(USER); //assertJ
    }

    @Test
    void shouldThrowExceptionWhenUserIsNotValid() {
        //given
        Mockito.when(userValidator.isUserValid(any())).thenReturn(false);
        //when & then
        //junit
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser(USER));
        //assertJ
        assertThatThrownBy(() -> userService.createUser(USER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User is invalid");
    }
}