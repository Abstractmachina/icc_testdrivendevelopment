package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RecentlyUsedListTest {

  @Test
  public void shouldBeEmptyWhenInitialized() {
    assertThat(new RecentlyUsedList().size(), is(0));
  }

  @Test
  public void shouldBeAbleToAddThings() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item("a"));
    l.add(new Item("b"));
    l.add(new Item("c"));
    l.add(new Item("d"));

    assertThat(l.size(), is(4));
  }

  @Test
  public void shouldBeAbleToRetrieveItems() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item("a"));
    l.add(new Item("b"));
    l.add(new Item("c"));
    l.add(new Item("d"));
    Item i = l.getLast();

    assertNotNull(i);
  }

  @Test
  public void mostRecentItemShouldBeFirst() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item("a"));
    l.add(new Item("b"));
    l.add(new Item("c"));
    l.add(new Item("d"));

    Item i = l.getFirst();
    assertThat(i.name(), is("d"));
  }

  @Test
  public void itemsInListAreUnique() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item("a"));
    l.add(new Item("b"));
    l.add(new Item("c"));
    l.add(new Item("a"));

    assertThat(l.size(), is(3));
    assertThat(l.getLast().name(), is("b"));
  }

  @Test
  public void shouldBeAbleToDeleteItems() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item("a"));
    l.deleteFirst();

    assertThat(l.size(), is(0));
  }

  @Test
  public void oldestItemShouldBeLast() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item("a"));
    l.add(new Item("b"));

    assertThat(l.getLast().name(), is("a"));
  }

  @Test
  public void canAddUndefinedItems() {
    RecentlyUsedList l = new RecentlyUsedList();
    l.add(new Item());

    assertThat(l.getFirst().name(), is("undefined"));
  }

}
