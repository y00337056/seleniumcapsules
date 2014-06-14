package com.algocrafts.table;


import com.algocrafts.selenium.Element;
import com.algocrafts.selenium.Locating;
import com.algocrafts.locators.Locators;
import com.algocrafts.selenium.Locator;
import com.algocrafts.selenium.Searchable;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.algocrafts.converters.GetText.TEXT;
import static com.algocrafts.locators.Locators.elements;
import static com.algocrafts.selectors.TagName.*;
import static java.util.stream.Collectors.toSet;

public class Table<T, Where extends Searchable<Where>> extends Locating<Where, Element> {


    private final Locator<Stream<Element>, T> mapper;

    public Table(Where where,
                 Locator<Where, Element> locator,
                 Locator<Stream<Element>, T> mapper) {
        super(where, locator);
        this.mapper = mapper;
    }

    public Stream<String> getHeader() {
        return then(Locators.<Element>elements(TH)).map(TEXT);
    }

    public Stream<T> getRows() {
        return then(Locators.<Element>elements(TR))
                .filter(e -> Locators.<Element>tryElement(TD).locate(e) != null)
                .map(elements(TD))
                .map(mapper);
    }

    public TableContents<T> getContents() {
        return new TableContents<T>(
                this.getHeader().collect(toSet()),
                this.getRows().collect(Collectors.<T>toSet())
        );
    }
}

