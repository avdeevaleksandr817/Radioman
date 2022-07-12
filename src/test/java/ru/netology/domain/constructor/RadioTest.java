package ru.netology.domain.constructor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    private Radio radio = new Radio();
    private Radio radioChangeMaxStation = new Radio(10);

    @Test
    void GetInitialStation() {
        int expected = 0;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void GetCurrentStationMax() {
        int expected = 9;
        int actual = radioChangeMaxStation.getMaxStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetNextNumberStation() {
        int expected = 1;
        radio.nextStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetNextNumberChangeStationMax() {
        int expected = radioChangeMaxStation.getMinStation();
        radioChangeMaxStation.setNumberCurrentStation(radioChangeMaxStation.getMaxStation());
        radioChangeMaxStation.nextStation();
        int actual = radioChangeMaxStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetNextNumberStationMax() {
        int expected = radio.getMinStation();
        radio.setNumberCurrentStation(radio.getMaxStation());
        radio.nextStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetPrevNumberStationMin() {
        int expected = radio.getMinStation();
        radio.setNumberCurrentStation(-1);
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetNextNumberStationMaxChange() {
        int expected = radioChangeMaxStation.getMaxStation();
        radioChangeMaxStation.setNumberCurrentStation(50);
        int actual = radioChangeMaxStation.getMaxStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetPrevStation() {
        int expected = 5;
        radioChangeMaxStation.setNumberCurrentStation(6);
        radioChangeMaxStation.prevStation();
        int actual = radioChangeMaxStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetPrevStationMin() {
        int expected = radio.getMaxStation() - 1;
        radio.setCurrentStation(0);
        radio.prevStation();
        int actual = radio.getCurrentStation() - 1;

        assertEquals(expected, actual);
    }

    @Test
    void SetPrevStationMinChange() {
        int expected = radioChangeMaxStation.getMaxStation();
        radioChangeMaxStation.setCurrentStation(0);
        radioChangeMaxStation.prevStation();
        int actual = radioChangeMaxStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetPrevStationChangeMin() {
        int expected = 8;
        radioChangeMaxStation.setCurrentStation(radioChangeMaxStation.getMaxStation());
        radioChangeMaxStation.prevStation();
        int actual = radioChangeMaxStation.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetPrevStationMinRadio() {
        int expected = 8;
        radio.setCurrentStation(radio.getMaxStation() - 1);
        radio.prevStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void SetCurrentStation() {
        int expected = 7;
        int actual = radioChangeMaxStation.setCurrentStation(7);

        assertEquals(expected, actual);
    }

    @Test
    void GetCurrentVolume() {
        int expected = 0;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void IncreaseVolume() {
        int expected = 1;
        radio.increaseCurrentVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void IncreaseVolumeBigMax() {
        int expected = 100;
        radio.setCurrentVolume(radio.getMaxVolume());
        radio.increaseCurrentVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void IncreaseVolumeMax() {
        int expected = 100;
        radio.setCurrentVolume(radio.getMaxVolume());
        radio.increaseCurrentVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void DecreaseVolume() {
        int expected = 5;
        radio.setCurrentVolume(6);
        radio.decreaseCurrentVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void DoubleDecreaseVolume() {
        int expected = 5;
        radio.setCurrentVolume(7);
        radio.decreaseCurrentVolume();
        radio.decreaseCurrentVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void IncreaseVolumeMin() {
        int expected = 0;
        radio.setCurrentVolume(radio.getMinVolume());
        radio.decreaseCurrentVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }
}