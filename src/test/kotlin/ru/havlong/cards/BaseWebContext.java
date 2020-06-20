package ru.havlong.cards;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
@EnableJpaRepositories(basePackages = "ru.havlong.cards.store.repository")
public class BaseWebContext {

}
