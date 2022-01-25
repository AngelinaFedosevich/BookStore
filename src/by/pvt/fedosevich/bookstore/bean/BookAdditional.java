package by.pvt.fedosevich.bookstore.bean;

import java.util.Objects;

public class BookAdditional {
  private BookGenre genre;
  private int count;

  public BookAdditional(BookGenre genre, int count) {
    this.genre = genre;
    this.count = count;
  }

  public BookGenre getGenre() {
    return genre;
  }

  public void setGenre(BookGenre genre) {
    this.genre = genre;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookAdditional that = (BookAdditional) o;
    return count == that.count && genre == that.genre;
  }

  @Override
  public int hashCode() {
    return Objects.hash(genre, count);
  }

  @Override
  public String toString() {
    return "BookAdditional{" +
        "genre=" + genre +
        ", count=" + count +
        '}';
  }
}
