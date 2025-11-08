package com.ogoma.blog.setup;

import com.ogoma.blog.iam.entities.UserEntity;
import com.ogoma.blog.iam.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("dev")
@Component
public class DbInitializer implements CommandLineRunner {
    private final UserRepository userRepository;

    public DbInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.count() == 0) {
            UserEntity userEntity = UserEntity.createNew(
                    "emmanuel",
                    "password",
                    "test@ogoma.emmanuel",
                    "Emmanuel",
                    "Ogoma",
                    "+72555363636");
            this.userRepository.save(userEntity);
        }
    }
}
