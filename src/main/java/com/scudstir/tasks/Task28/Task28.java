package com.scudstir.tasks.Task28;

import java.util.Set;

public interface Task28 {

    /**
     * На кольцевой гоночной трассе стоит N автомобилей.
     * Для каждого из них известны начальное положение и скорость.
     * Определить, сколько произойдет обгонов за указанное количество кругов.
     * @param cars Расположенные на трассе машины.
     * @param lengthLap Длина одного круга.
     * @param numberLaps Количество кругов.
     * @return Количество осуществленных обгонов.
     */
    int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps);

    /**
     * Машина.
     */
    interface Car {

        /**
         * Расположение машин в на старте:
         *
         * -----
         * START
         * -----
         *  1
         *    2
         *  3
         *    4
         *  5
         *   .
         *   .
         *   .
         *
         * @return Позиция в начальный момент времени.
         */
        int getStartPosition();

        /**
         * @return Скорость движения.
         */
        int getSpeed();
    }
}