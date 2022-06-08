package com.piecetogether.piecetogether.UserPackage;

import com.piecetogether.piecetogether.Repository.UserRepository;
import com.piecetogether.piecetogether.Service.BodyModification;
import com.piecetogether.piecetogether.model.*;
import com.piecetogether.piecetogether.model.Vacation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            Vacation v1 = new Vacation("Ireland", "saw lots of castles", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"));
            Vacation v2 = new Vacation("Costa Rica", "saw a sling shot spider", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"));

            BodyModification b1 = new BodyModification("Spider webs with bat and 2 spiders", "ping was the artist, completed over 2 sessions", LocalDate.parse("2010-04-04"), 825.00, "Dekalb Tattoo Company");
            BodyModification b2 = new BodyModification("ears pierced", "it hurt", LocalDate.parse("2010-04-04"),  20.00, "Clares");

            Family f1 = new Family("Baby Nya born", "8lb 0oz, 40w 0d, born at 1am", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"));
            Family f2 = new Family("Baby Edwin born", "7lb 14oz, 38w 1d, born at 830am", LocalDate.parse("2010-04-04"), null);

            School s1 = new School("Henry Sibley High School", "Colorguard in marching band, Winterguard", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"));
            School s2 = new School("Inverhills Community College", "Associate of Arts degree", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"));

            Jobs j1 = new Jobs("Zookeeper", "got bit by an otter", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"), "Red River Zoo",  10.00);
            Jobs j2 = new Jobs("Gestational Surrogate", "Lizzie 2019 and William 2021", LocalDate.parse("2010-04-04"), "Concieveabilities", 43000);

            Pets p1 = new Pets("Lita", "Cat", LocalDate.parse("2010-04-04"), null, "Stray kitten outside");
            Pets p2 = new Pets("Shadow", "Cat", LocalDate.parse("2010-04-04"), null, "Adopted");

            Other o1 = new Other("Rezz concert", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"), "Awesome!");
            Other o2 = new Other("Beerdabler", LocalDate.parse("2010-04-04"), LocalDate.parse("2010-04-04"), "Cold fun time drinking all the beer");

            User kathy = new User("Kathy", "Bradt", "kathy@email.com", "Misty7!7");
            User ben = new User("Ben", "Bangen", "bangenben@email.com", "Killenit69");

            List<Vacation> vacationList = List.of(v1, v2);
            List<BodyModification> bodyModList = List.of(b1, b2);
            List<Family> familyList = List.of(f1, f2);
            List<School> schoolList = List.of(s1, s2);
            List<Jobs> jobList = List.of(j1, j2);
            List<Pets> petList = List.of(p1, p2);
            List<Other> otherList = List.of(o1, o2);

            kathy.setVacationList(vacationList);
            kathy.setBodyModList(bodyModList);
            kathy.setFamilyList(familyList);
            kathy.setJobsList(jobList);
            kathy.setPetsList(petList);
            kathy.setSchoolList(schoolList);
            kathy.setOtherList(otherList);

            repository.saveAll(List.of(kathy, ben));
        };
    }


}
