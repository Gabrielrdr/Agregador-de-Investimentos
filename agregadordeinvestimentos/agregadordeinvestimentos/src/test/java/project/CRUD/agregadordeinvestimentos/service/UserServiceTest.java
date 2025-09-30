package project.CRUD.agregadordeinvestimentos.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.CRUD.agregadordeinvestimentos.controller.CreateUserDto;

import project.CRUD.agregadordeinvestimentos.entity.User;
import project.CRUD.agregadordeinvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    class createUser {

        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateAUser() {

            // Arrange
            var user = new User(
                UUID.randomUUID(),
                "username",
                "email@gmail.com",
                "password",
                Instant.now(),
                null
            );
            doReturn(null).when(userRepository).save(any());
            var input = new CreateUserDto(
                    "username",
                    "email",
                    "123");

            // Act
            var output = userService.createUser(input);

            //Assert

            assertNotNull(output);
        }
    }

}