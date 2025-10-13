package com.nakhan.authapi.config;

import com.nakhan.authapi.model.Role;
import com.nakhan.authapi.model.User;
import com.nakhan.authapi.repository.RoleRepository;
import com.nakhan.authapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create roles if they don't exist
        if (roleRepository.findByName("USER").isEmpty()) {
            Role userRole = new Role("USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("ADMIN").isEmpty()) {
            Role adminRole = new Role("ADMIN");
            roleRepository.save(adminRole);
        }

        // Create default admin user if it doesn't exist
        if (userRepository.findByEmail("admin@example.com").isEmpty()) {
            User admin = new User("admin", "admin@example.com", passwordEncoder.encode("admin123"));

            List<Role> roles = new ArrayList<>();
            Role adminRole = roleRepository.findByName("ADMIN").orElseThrow();
            Role userRole = roleRepository.findByName("USER").orElseThrow();
            roles.add(adminRole);
            roles.add(userRole);

            admin.setRoles(roles);
            userRepository.save(admin);
        }
    }
}
