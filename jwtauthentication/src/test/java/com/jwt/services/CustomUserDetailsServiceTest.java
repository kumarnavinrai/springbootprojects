package com.jwt.services;

import com.jwt.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    private CustomUserDetailsService customUserDetailsService;

    @BeforeEach
    void setUp() {
        this.customUserDetailsService = new CustomUserDetailsService(this.userRepository);
    }

    @Test
    void getAllUsers() {
        customUserDetailsService.getAllUsers();
        verify(userRepository).findAll();
    }


}
