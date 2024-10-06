package com.identity.configuration;

import com.identity.entity.Role;
import com.identity.entity.User;
import com.identity.repo.RoleRepo;
import com.identity.repo.UserRepo;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.identity.constant.Constants.PreDefineRole.ROLE_ADMIN;
import static com.identity.constant.Constants.PreDefineRole.ROLE_USER;

import java.util.HashSet;

@Configuration
@Slf4j
public class InitialApplicationConfig {
    PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USER_NAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

    @Bean
    @ConditionalOnProperty(
            prefix = "spring",
            value = "datasource.driverClassName",
            havingValue = "org.postgresql.Driver"
    )
    ApplicationRunner applicationRunner(UserRepo userRepo, RoleRepo roleRepo) {
        log.info("Initializing application with custom configuration.....");
        return args -> {
            if (userRepo.findByUsername(ADMIN_USER_NAME).isEmpty()) {
                roleRepo.save(Role.builder()
                        .name(ROLE_USER)
                        .description("User role")
                        .build());

                Role adminRole = roleRepo.save(Role.builder()
                        .name(ROLE_ADMIN)
                        .description("Admin role")
                        .build());

                var roles = new HashSet<Role>();
                roles.add(adminRole);

                User user = User.builder()
                        .username(ADMIN_USER_NAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .roles(roles)
                        .build();

                userRepo.save(user);
                log.warn("admin user has been created with default password: admin, please change it");
            }
            log.info("Application initialization completed .....");
        };
    }
}
