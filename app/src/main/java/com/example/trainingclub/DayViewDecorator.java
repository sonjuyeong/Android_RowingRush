package com.example.trainingclub;

import java.time.LocalDate;

public interface DayViewDecorator {

    /**
     * Determine if a specific day should be decorated
     *
     * @param day {@linkplain java.time.LocalDate} to possibly decorate
     * @return true if this decorator should be applied to the provided day
     */
    boolean shouldDecorate(LocalDate day);

    /**
     * Set decoration options onto a facade to be applied to all relevant days
     *
     * @param view View to decorate
     */
    void decorate(DayViewFacade view);
}