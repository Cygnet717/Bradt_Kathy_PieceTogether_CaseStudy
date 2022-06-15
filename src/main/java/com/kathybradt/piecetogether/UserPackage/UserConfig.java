package com.kathybradt.piecetogether.UserPackage;

import com.kathybradt.piecetogether.Repository.UserRepository;
import com.kathybradt.piecetogether.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            Vacation v1 = new Vacation("Ireland", "saw lots of castles", Date.valueOf("2020-04-04"), Date.valueOf("2020-12-04"));
            Vacation v2 = new Vacation("Costa Rica", "saw a sling shot spider", Date.valueOf("2019-04-04"), Date.valueOf("2019-04-04"));

            Family f1 = new Family("Baby Nya born", "8lb 0oz, 40w 0d, born at 1am", Date.valueOf("2020-01-13"), Date.valueOf("2020-01-13"));
            Family f2 = new Family("Baby Edwin born", "7lb 14oz, 38w 1d, born at 830am", Date.valueOf("2018-05-04"), null);

            School s1 = new School("Henry Sibley High School", "Colorguard in marching band, Winterguard", Date.valueOf("2021-05-04"), Date.valueOf("2021-04-04"));
            School s2 = new School("Inverhills Community College", "Associate of Arts degree", Date.valueOf("2020-04-09"), Date.valueOf("2020-04-10"));

            Jobs j1 = new Jobs("Zookeeper", "got bit by an otter", Date.valueOf("2018-04-04"), Date.valueOf("2019-04-04"), "Red River Zoo",  10.00);
            Jobs j2 = new Jobs("Gestational Surrogate", "Lizzie 2019 and William 2021", Date.valueOf("2020-04-04"), "Concieveabilities", 43000);

            Pets p1 = new Pets("Lita", "Cat", Date.valueOf("2021-04-10"), null, "Stray kitten outside");
            Pets p2 = new Pets("Shadow", "Cat", Date.valueOf("2021-04-10"), null, "Adopted");

            Other o1 = new Other("Rezz concert", Date.valueOf("2019-04-04"), Date.valueOf("2019-05-04"), "Awesome!");
            Other o2 = new Other("Beerdabler", Date.valueOf("2018-04-04"), Date.valueOf("2018-04-04"), "Cold fun time drinking all the beer");

            User kathy = new User("Kathy", "Bradt", "kathy@email.com", "123");
            User ben = new User("Ben", "Bang", "bang@email.com", "123");

            List<Vacation> vacationList = List.of(v1, v2);
            List<Family> familyList = List.of(f1, f2);
            List<School> schoolList = List.of(s1, s2);
            List<Jobs> jobList = List.of(j1, j2);
            List<Pets> petList = List.of(p1, p2);
            List<Other> otherList = List.of(o1, o2);

            kathy.setVacationList(vacationList);
            kathy.setFamilyList(familyList);
            kathy.setJobsList(jobList);
            kathy.setPetsList(petList);
            kathy.setSchoolList(schoolList);
            kathy.setOtherList(otherList);

            repository.saveAll(List.of(kathy, ben));
        };
    }


}
