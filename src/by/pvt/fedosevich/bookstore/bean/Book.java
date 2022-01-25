package by.pvt.fedosevich.bookstore.bean;

import java.util.Objects;

public class Book {
  private long id;
  private String title;
  private String author;
  private double price;
  private BookGenre bookGenre;

  public Book(long id, String title, String author, double price, BookGenre bookGenre) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.price = price;
    this.bookGenre = bookGenre;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public BookGenre getBookGenre() {
    return bookGenre;
  }

  public void setBookGenre(BookGenre bookGenre) {
    this.bookGenre = bookGenre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id == book.id && Double.compare(book.price, price) == 0
        && Objects.equals(title, book.title) && Objects.equals(author,
        book.author) && bookGenre == book.bookGenre;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, price, bookGenre);
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", price=" + price +
        ", bookGenre=" + bookGenre +
        '}';
  }
}
