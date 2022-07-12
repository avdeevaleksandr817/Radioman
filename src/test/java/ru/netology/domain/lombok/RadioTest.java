package ru.netology.domain.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RadioTest {
    public int minStation = 0;
    public int maxStation = 9;
    public int minVolume = 0;
    public int maxVolume = 100;


    @Test
        //установить текущую станцию
    void setCurrentStationOn() {
        Radio station = new Radio(8,15,minStation,maxStation,minVolume,maxVolume);
        int expected = 3;

        station.setCurrentStation(expected);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //неправильное минимальное значение Установить текущую станцию
    void incorrectMinValueSetCurrentStation() {
        int expected = 3;
        Radio station = new Radio(expected, 60, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentStation(-1);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //неправильное минимальное значение Установить текущую станцию Получить минимальную.
    void incorrectMinValueSetCurrentStationGetMin() {
        int expected = 0;
        Radio station = new Radio();

        station.setCurrentStation(-1);

        assertEquals(expected, station.getMinStation());
    }

    @Test
        //неправильная установка максимального значения Текущая станция
    void incorrectMaxValueSetCurrentStation() {
        int expected = 3;
        Radio station = new Radio(expected, 50, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentStation(12);

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //неправильное максимальное значение Установить текущую станцию Получить максимальную.
    void incorrectMaxValueSetCurrentStationGetMax() {
        int expected = 9;
        Radio station = new Radio(9, 70, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentStation(12);

        assertEquals(expected, station.getMaxStation());
    }

    @Test
        //нажмите Следующая радиостанция
    void pushNextRadioStation() {
        Radio station = new Radio(9,40 , minStation, maxStation, minVolume, maxVolume);
        station.nextStation();

        int expected = 0;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //нажать Следующая радиостанция Получить минимальную
    void pushNextRadioStationGetMin() {
        Radio station = new Radio(11, 63, minStation, maxStation, minVolume, maxVolume);
        station.nextStation();

        int expected = 0;

        assertEquals(expected, station.getMinStation());
    }

    @Test
        //Дважды нажать на выбор Следующая радиостанция
    void pushDoubleNextRadioStation() {
        Radio station = new Radio(9, 63, minStation, maxStation, minVolume, maxVolume);
        station.nextStation();
        station.nextStation();

        int expected = 1;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //Предыдущая радиостанция
    void pushPrevRadioStation() {
        Radio station = new Radio(0, 63, minStation, maxStation, minVolume, maxVolume);
        station.prevStation();

        int expected = 9;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //Нажать дважды Предыдущая радиостанция
    void pushDoublePrevRadioStation() {
        Radio station = new Radio(1, 63, minStation, maxStation, minVolume, maxVolume);

        station.prevStation();
        station.prevStation();

        int expected = 9;

        assertEquals(expected, station.getCurrentStation());
    }

    @Test
        //установить текущую громкость
    void setCurrentVolume() {
        Radio station = new Radio(8, 80, minStation, maxStation, minVolume, maxVolume);
        int expected = 80;

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getCurrentVolume());
    }

    @Test
        //установить Текущую громкость Минимум
    void setCurrentVolumeMinVolume() {
        int expected = 0;
        Radio station = new Radio(7,2,minStation,maxStation,minVolume,maxVolume);

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getMinVolume());
    }

    @Test
        //громкость нуль
    void setCurrentVolumeMinVolumeNo() {
        int expected = 0;
        Radio station = new Radio();

        station.setCurrentVolume(expected);

        assertEquals(expected, station.getMinVolume());
    }

    @Test
        //неправильное максимальное значение установленной громкости
    void incorrectMaxValueSetCurrentVolume() {
        int expected = 70;
        Radio station = new Radio(5, expected, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentVolume(101);

        assertEquals(expected, station.getCurrentVolume());
    }

    @Test
        //неправильное максимальное значение Установить текущую громкость Вкл.
    void incorrectMaxValueSetCurrentVolumeOn() {
        int expected = 100;
        Radio station = new Radio();

        station.setCurrentVolume(101);

        assertEquals(expected, station.getMaxVolume());
    }


    @Test
        //неправильное минимальное значение Установить громкость
    void incorrectMinValueSetCurrentVolume() {
        int expected = 0;
        Radio station = new Radio(5, expected, minStation, maxStation, minVolume, maxVolume);

        station.setCurrentVolume(-1);

        assertEquals(expected, station.getMinVolume());
    }

    @Test
        //увеличение громкости Текущая громкость максимальная
    void volumeUpCurrentVolume() {
        Radio station = new Radio(5, 100, minStation, maxStation, minVolume, maxVolume);

        station.increaseCurrentVolume();

        assertEquals(station.getMaxVolume(), station.getCurrentVolume());
    }

    @Test
        //увеличить громкость дважды до максимума
    void volumeDoubleUpCurrentVolume() {
        Radio station = new Radio(7, 99, minStation, maxStation, minVolume, maxVolume);

        station.increaseCurrentVolume();
        station.increaseCurrentVolume();

        assertEquals(station.getMaxVolume(), station.getCurrentVolume());
    }

    @Test
        //убавить текущую громкость до минимума
    void volumeDownCurrentVolume() {
        Radio station = new Radio(8, 0, minStation, maxStation, minVolume, maxVolume);

        station.decreaseCurrentVolume();

        assertEquals(station.getMinVolume(), station.getCurrentVolume());
    }

    @Test
        ////убавить текущую громкость дважды до минимума
    void volumeDoubleDownCurrentVolume() {
        Radio station = new Radio(8, 1, minStation, maxStation, minVolume, maxVolume);

        station.decreaseCurrentVolume();
        station.decreaseCurrentVolume();

        assertEquals(station.getMinVolume(), station.getCurrentVolume());
    }
}