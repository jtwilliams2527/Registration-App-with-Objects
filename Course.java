import java.util.* ;
public class Course {

//instance vars
private String name ;
private String courseNum ;
private int creditHrs ;
private String mode ;
private String meetings ;

//original constructor
public Course () {
  // name = "Joneya" ;
  // courseNum = "2735" ;
  // creditHrs = 5 ;
  // mode = "in-person" ;
  // meetings = "MWF" ;
  this("Joneya","2735",5,"in-person","MWF") ;

} //constructor brace

//parameterized constructor
public Course (String name, String courseNum, int creditHrs, String mode, String meetings) {

  //settings default values
  this.name = name ;
  this.courseNum = courseNum ;
  this.creditHrs = creditHrs ;
  this.mode = mode ;
  this.meetings = meetings ;


} //parameterized constructor

//to String ()
public String toString () {
  return name + " " + courseNum + " " + creditHrs + " " + mode + " " + meetings ; 

} //to String ()

//getters and setters
public String getName () {
  return name ;

} //getter

public void setName (String name) {
  this.name = name ;

} //setter

public String getcourseNum () {
  return courseNum ;

} //getter

public void setcourseNum (String courseNum) {
  this.courseNum = courseNum ;

} //setter

public int getcreditHrs () {
  return creditHrs ;

} //getter

public void setcreditHrs (int creditHrs) {
  this.creditHrs = creditHrs ;


} //setter

public String getmode () {
  return mode ;

} //getter

public void setmode (String mode) {
  this.mode = mode ;

} //setter

public String getmeetings () {
  return meetings ;


} //getter

public void setmeetings (String meetings) {
  this.meetings = meetings ;


} //setter

 //equla
  @Override 
  public boolean equals (Object o) {
    if(this == o) {return true;} //s1 = 0
    if(o == null || this.getClass() != o.getClass()) {
      return false ;

    } // if statement
    //don't need to memorize the lines above this

    Course s = (Course) o ; 

    return name.equals(s.name) && 
      courseNum.equals(s.courseNum) 
      && creditHrs == s.creditHrs 
      && mode.equals(s.mode) 
      && meetings.equals(s.meetings) ;


  } //function call

  //pair this with your equals method 


  @Override
  public int hashCode() {
    return Objects.hash(name, courseNum, creditHrs, mode, meetings) ;

  } //function call



} //class brace