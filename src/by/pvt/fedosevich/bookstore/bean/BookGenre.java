package by.pvt.fedosevich.bookstore.bean;

public enum BookGenre {
  IMAGINATIVE_LITERATURE, PSYCHOLOGY, PROGRAMMING, FANTASY, BEST_SELLING;
  public String getGenre(){
switch (this){
  case FANTASY:
    return "фантастика";
  case PSYCHOLOGY:
    return "психология";
  case PROGRAMMING:
    return "программирование";
  case IMAGINATIVE_LITERATURE:
    return "художественная литература";
  case BEST_SELLING:
    return "бестселлер";
  default:
    throw new IllegalStateException("Unexpected value: " + this);
}
  }
}
