package com.boot;

import com.boot.controller.ShipwrecController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipWrecRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTester {

    @InjectMocks
    private ShipwrecController sh;

    @Mock
    private ShipWrecRepository shipWrecRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testShipwreckTestGet(){
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);
        when(shipWrecRepository.findOne(1L)).thenReturn(shipwreck);

        verify(shipWrecRepository).findOne(1L);
      //  assertEquals(1L,shipwreck.getId().longValue());
        assertThat(shipwreck.getId(),is(1L));
    }
}
