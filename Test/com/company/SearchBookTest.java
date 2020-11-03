package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {

    @Test
    void checkisBook() {
        SearchBook searchbook = new SearchBook();
        BookInformation bookInformation = new BookInformation();
        bookInformation.setTitle("title");
        bookInformation.setPublisher("test");
        bookInformation.setWriter(" ");
        bookInformation.setPublishedYear(" ");
        bookInformation.setPrice(" ");
        bookInformation.setBookState(" ");
        bookInformation.setISBNNumber(" ");
        bookInformation.setSellerID("test");
        bookInformation.setSellerEmail("test");
        ArrayList<BookInformation> checklist = new ArrayList<BookInformation>();
        checklist.add(bookInformation);

        assertEquals(searchbook.CheckisBook(checklist),true);
    }
}