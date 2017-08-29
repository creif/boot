package com.boot;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWrecRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ShipwreckRepositoryIntegrationTest {

    @Autowired
    private ShipWrecRepository shipWrecRepository;

    @Test
    public void testFindAll(){
        List<Shipwreck> wrecks = shipWrecRepository.findAll();
        assertThat(wrecks.size(),is(Matchers.greaterThanOrEqualTo(0)));
    }
}
