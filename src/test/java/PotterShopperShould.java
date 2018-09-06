import model.book.Book;
import model.book.PotterBooks;
import model.PotterShopper;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PotterShopperShould {

    private PotterShopper bookshop;

    @Before
    public void setUp() {
        bookshop = new PotterShopper();
    }

    @Test
    public void calculate_price_for_empty_basket_as_zero() {
        double price = bookshop.billFor(Collections.emptyList());


        assertThat(price, is(0.00));
    }

    @Test
    public void calculate_price_for_single_book_as_eight() {
        double price = bookshop.billFor(asList(new Book(PotterBooks.FIRST_BOOK)));


        assertThat(price, is(8.00));
    }

    @Test
    public void apply_five_percent_discount_for_two_distinct_books() {
        double price = bookshop.billFor(asList(new Book(PotterBooks.FIRST_BOOK), new Book(PotterBooks.SECOND_BOOK)));


        assertThat(price, is(15.20));
    }
}
