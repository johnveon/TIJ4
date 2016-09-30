package typeinfo;

//: typeinfo/Position.java

class Position {
  private String title;
  private Person person;
  public Position(String jobTitle, Person employee) {
    title = jobTitle;
    person = employee;
    if(person == null)
      person = Person.NULL;//赋值一个值为默认值为空的对象
  }
  public Position(String jobTitle) {
    title = jobTitle;
    person = Person.NULL;//赋值一个值为默认值为空的对象
  }	
  public String getTitle() { return title; }
  public void setTitle(String newTitle) {
    title = newTitle;
  }
  public Person getPerson() { return person; }
  public void setPerson(Person newPerson) {
    person = newPerson;
    if(person == null)
      person = Person.NULL;//赋值一个值为默认值为空的对象
  }
  public String toString() {
    return "Position: " + title + " " + person;
  }
} ///:~
