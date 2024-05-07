package lesson31hw28;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingOptionsTests extends BaseTest {

    SelenideElement selectSort = $(".product_sort_container");

    @Test
    public void sortByPriceLowToHigh() {
        selectSort.selectOption("Price (low to high)");
        ElementsCollection prices = $$(".inventory_item_price").shouldHave(sizeGreaterThan(0));
        assertSorted(prices.texts(), true, text -> Double.parseDouble(text.replace("$", "")));
    }

    @Test
    public void sortByPriceHighToLow() {
        selectSort.selectOption("Price (high to low)");
        ElementsCollection prices = $$(".inventory_item_price").shouldHave(sizeGreaterThan(0));
        assertSorted(prices.texts(), false, text -> Double.parseDouble(text.replace("$", "")));
    }

    @Test
    public void sortByNameAToZ() {
        selectSort.selectOption("Name (A to Z)");
        ElementsCollection names = $$(".inventory_item_name").shouldHave(sizeGreaterThan(0));
        assertSorted(names.texts(), true, Function.identity());
    }

    @Test
    public void sortByNameZToA() {
        selectSort.selectOption("Name (Z to A)");
        ElementsCollection names = $$(".inventory_item_name").shouldHave(sizeGreaterThan(0));
        assertSorted(names.texts(), false, Function.identity());
    }

    private <T extends Comparable<T>> void assertSorted(List<String> list, boolean ascending, Function<String, T> parseFunction) {
        List<T> actual = list.stream().map(parseFunction).collect(Collectors.toList());
        Comparator<T> comparator = ascending ? Comparator.naturalOrder() : Comparator.reverseOrder();
        List<T> sortedList = actual.stream().sorted(comparator).collect(Collectors.toList());
        Assert.assertEquals(actual, sortedList, "List is not sorted as expected.");
    }

}
