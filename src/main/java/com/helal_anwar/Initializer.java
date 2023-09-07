package com.helal_anwar;

import com.helal_anwar.model.Event;
import com.helal_anwar.model.GroupRepository;
import com.helal_anwar.model.Group;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        var list = Arrays.asList("Seattle JUG", "Denver JUG", "Dublin JUG", "London JUG");
        for (String name : list) {
            repository.save(new Group(name));
        }
        Group DJug = repository.findByName("Seattle JUG");
        Event e = Event.builder().title("Micro Frontends for Java Developers")
                .description("JHipster now has micro frontend support!")
                .date(Instant.parse("2022-09-13T17:00:00.000Z"))
                .build();
        DJug.setEvents(Collections.singleton(e));
        repository.save(DJug);

        repository.findAll().forEach(System.out::println);
    }
}