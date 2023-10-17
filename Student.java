import java.util.* ; 
//this is needed to create an object

public class Student {
  //creating objects

  //you cannot access these from main directly , you need a method

  //instance vars
  private String name;
  private int birthyear;
  private int id;
  private boolean isSciMajor;
  private ArrayList <Course> courseSchedule ;

  //original constructor
  //constructor(s), how we initialize or set our instance vals
  public Student () {
    name = "Joneya" ; //this is the default value
    id = -1 ;
    birthyear = -1 ;
    isSciMajor = false ;
    courseSchedule = new ArrayList <> () ;

    //the keyword "this" below calls the parameterized constructor
    // this("Joneya",Integer.MAX_VALUE,Integer.MAX_VALUE,false) ;

  } //end of constructor

  //parameterized constructor (instead of using setters)
    public Student (String name,int birthyear, int id, boolean isSciMajor) {

    //this is how you set default values
    this.name = name ; //this is the default value
    this.birthyear = birthyear;
    this.id = id ;
    this.isSciMajor = isSciMajor;

  } //end of constructor

  //going to take the object and create a string out of it
  public String toString() {
    return name + " " + birthyear + " " + id + " " + isSciMajor ;

  } //end of toString

  //methods
  public String getName () { //accessor / getter
    return name ; //because you are giving something back

  } //accessor of getName

  public void setName (String name) {
    // name = iname ; when you have different variable names
    this.name = name ;  //only when the variable has the same name


  } //modifier of getName



  //allows us to compare 2 objects
  @Override 
  public boolean equals (Object o) {
    if(this == o) {return true;} //s1 = 0
    if(o == null || this.getClass() != o.getClass()) {
      return false ;

    } // if statement
    //don't need to memorize the lines above this

    Student s = (Student) o ; //typecast to convert o to student
    //checks to see if the data from s1 matches s2
    return id == s.id && birthyear == s.birthyear && name.equals(s.name) && isSciMajor == s.isSciMajor ;// or s.getId() 


  } //function call

  //pair this with your equals method 
  @Override
  public int hashCode() {
    return Objects.hash(name, id, birthyear, isSciMajor) ;

  } //function call




  //getting Id
  public int getId () {
    return id ;

  }

  //setting Id
  public void setId(int sid) {
    id = sid ;
  }

  //getting schedule
  public ArrayList <Course> getSchedule() {
    return courseSchedule ;
  }

  //setting schedule
  public void setSchedule(ArrayList <Course> courseSchedule) {
    this.courseSchedule = courseSchedule ;
  }


} // end of object