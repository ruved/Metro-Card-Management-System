package org.projectsDemo.service;

import org.projectsDemo.exception.InsufficientCardBalanceException;
import org.projectsDemo.exception.MinimumCardBalanceException;
import org.projectsDemo.model.CardTransaction;
import org.projectsDemo.model.SmartCard;
import org.projectsDemo.model.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class MetroServiceTest {
    private MetroService metroService = new MetroService();

    private SmartCard card;

    @Before
    public void setUp() throws Exception {
        card = new SmartCard(1,100);
    }

    @Test
    public void testCalculateFootFallForStation() throws Exception {
        metroService.swipeIn(card, Station.A1, LocalDateTime.of(2016, Month.APRIL, 8, 18, 25));
        metroService.swipeOut(card, Station.A6, LocalDateTime.of(2016, Month.APRIL, 8, 18, 35));

        metroService.swipeIn(card, Station.A6, LocalDateTime.of(2016, Month.APRIL, 10, 19, 05));
        metroService.swipeOut(card, Station.A10, LocalDateTime.of(2016, Month.APRIL, 10, 19, 15));

        Assert.assertEquals("FootFall for station A6 should be 2",2, metroService.calculateFootFall(Station.A6));
        Assert.assertEquals("FootFall for station A1 should be 1", 1,metroService.calculateFootFall(Station.A1));
        Assert.assertEquals("FootFall for station A10 should be 1", 1,metroService.calculateFootFall(Station.A10));
    }

    @Test
    public void testCardReport() throws Exception {
        metroService.swipeIn(card, Station.A1, LocalDateTime.of(2016, Month.APRIL, 8, 18, 25));
        metroService.swipeOut(card, Station.A6, LocalDateTime.of(2016, Month.APRIL, 8, 18, 35));

        metroService.swipeIn(card, Station.A6, LocalDateTime.of(2016, Month.APRIL, 10, 19, 05));
        metroService.swipeOut(card, Station.A10, LocalDateTime.of(2016, Month.APRIL, 10, 19, 15));
        final List<CardTransaction> transactions = metroService.cardReport(card);

        Assert.assertEquals("There should be 2 transactions for this card", 2,transactions.size());

    }

    @Test(expected = MinimumCardBalanceException.class)
    public void testMinimumBalanceAtSwipeIn() throws Exception {
        card.setBalance(1);
        metroService.swipeIn(card, Station.A1, LocalDateTime.of(2016, Month.APRIL, 8, 18, 25));
    }

    @Test(expected = InsufficientCardBalanceException.class)
    public void testSufficientBalanceAtSwipeOut() throws Exception {
        card.setBalance(10);
        metroService.swipeIn(card, Station.A1, LocalDateTime.of(2016, Month.APRIL, 8, 18, 25));
        metroService.swipeOut(card, Station.A6, LocalDateTime.of(2016, Month.APRIL, 8, 18, 35));
    }
}
