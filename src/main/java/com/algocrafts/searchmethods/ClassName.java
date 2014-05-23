package com.algocrafts.searchmethods;


import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.className;

public enum ClassName implements Supplier<By> {

    SF_JS_ENABLED("sf-js-enabled"),

    UI_DATEPICKER_CALENDAR("ui-datepicker-calendar"),
    UI_DATEPICKER_NEXT("ui-datepicker-next"),
    UI_DATEPICKER_PREV("ui-datepicker-prev"),
    UI_DATEPICKER_MONTH("ui-datepicker-month"),
    UI_DATEPICKER_YEAR("ui-datepicker-year"),
    UI_DATEPICKER_HEADER("ui-datepicker-header"),

    PAGE_TITLE("page-title"),
    UI_DATEPICKER_CLOSE("ui-datepicker-close");

    private final By by;

    private ClassName(String id) {
        this.by = className(id);
    }

    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}
