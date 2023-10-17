import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) 
    throws FileNotFoundException{
    System.out.println("=== HW02 ===");



    //reading through student data
    // ArrayList <Student> studData = fileRdr("hw02Data.txt") ;
    // System.out.println("Reading through file: " + studData);

    ArrayList <Student> studData25 = readDataFromFile("hw02Data.txt") ;
    System.out.println("\n\nReading through file: " + studData25);








    /*TODO 0 - Display all the students and how many 
    students read from the data.txt file*/
    System.out.println("\n\nEach student's name: ");

    for(Student s: studData25) {  
      System.out.println( s.getName());
    } //for loop
    System.out.println("\nNumber of students: " + studData25.size());


    /*TODO 1 - Which students have classes on 
    Tuesdays and Thurdays*/



    /*TODO 2 - Which students have online classes 
    on Tuesdays and Thurdays*/

    /*TODO 3 - What is the least amount of 
    credits a student is enrolled in*/

    /*TODO 4 - Which students have last names that begin 
    with the letter P*/

    /*TODO 5 - Which 2000+ courses are students enrolled in?*/


  }//main

  //Function definitions














  // } //function call
// public static ArrayList <Student> readDataFromFile(String fName) 
//   throws FileNotFoundException{
//     ArrayList <Student> result = new ArrayList <> () ;

//     Scanner fileRdr = new Scanner(new File(fName)) ;

//     String name = fileRdr.nextLine() ;
//     int id = Integer.parseInt(fileRdr.nextLine()) ;
//     int bYr = Integer.parseInt(fileRdr.nextLine()) ;
//     boolean ism = Boolean.parseBoolean(fileRdr.nextLine()) ;
//     String CRSEline = fileRdr.nextLine() ;
//     ArrayList <Course> cAL25 = new ArrayList <> () ;

//     // System.out.println("Line read" + CRSEline);
//     //checking for more data
//     while(fileRdr.hasNextLine()) {

//       if(CRSEline != "") {

//         String [] data = CRSEline.split(",") ;

//         // System.out.println(Arrays.toString(data)) ;




//         Course c1 = new Course(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4]) ;
//         cAL25.add(c1) ;

//         CRSEline = fileRdr.nextLine() ;

//         if(CRSEline.equals("")) {
//           Student newNew = new Student(name,id,bYr,ism) ;
//           newNew.setSchedule(cAL25) ;

//           result.add(newNew) ;


//         } // nested if statement

//       } //if statement

//       if(CRSEline == "") {
//         String CRSEline2 = fileRdr.next() ;




//       } //if statement











//     } //while loop





//     return result ;



// } //function call

  public static ArrayList<Student> readDataFromFile(String fName) 
    throws FileNotFoundException{
    ArrayList<Student> result = new ArrayList<>();
    Scanner fileRdr = new Scanner(new File(fName));

    String name = fileRdr.nextLine();
    int sId = Integer.parseInt(fileRdr.nextLine());
    int birthYr = Integer.parseInt(fileRdr.nextLine());
    boolean sciMajor = Boolean.parseBoolean(fileRdr.nextLine());
    ArrayList<Course> crseAL = new ArrayList<>();
    String lineRead = fileRdr.nextLine();
    while(fileRdr.hasNextLine()){
      String [] data = lineRead.split(",");
      Course c = new Course(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4]);
      crseAL.add(c);
      lineRead = fileRdr.nextLine(); //skips empty line

      //You've read all courses for a particular student
      if(lineRead.equals("")){//line empty
        Student s = new Student(name,sId,birthYr,sciMajor);
        s.setSchedule(crseAL);
        result.add(s);
        //read student info for next student
        name = fileRdr.nextLine();
        sId = Integer.parseInt(fileRdr.nextLine());
        birthYr = Integer.parseInt(fileRdr.nextLine());
        sciMajor = Boolean.parseBoolean(fileRdr.nextLine());
        crseAL = new ArrayList<>();
        lineRead = fileRdr.nextLine();
      }


      /*no more data in file to read
      - check that the file does not have any more data - special case
        - split the last line read
        - create a course from the result of the split and store the course
        - create a student
        - set the student's schedule
        - store the student*/




    }//while

    //adds the last student
    Student s1 = new Student(name, sId, birthYr, sciMajor) ;
    s1.setSchedule(crseAL) ;
    result.add(s1) ;


    ArrayList <Integer> leastCH = new ArrayList <> () ;
    ArrayList <String> studwithTR = new ArrayList <> () ;
    ArrayList <String> get2000 = new ArrayList <> () ;
    for(Student s: result) {
      for(Course c: s.getSchedule()) {

        leastCH.add(c.getcreditHrs()) ;

        int courseNum = Integer.parseInt(c.getcourseNum()) ;

        if (courseNum >= 2000) {
          if(!get2000.contains(c.getName())) {
            get2000.add(c.getName()) ;
          } //if statement

        } //if statement



        if(c.getmeetings().contains("TR")) {

          if(!studwithTR.contains(s.getName())){
            studwithTR.add(s.getName()) ;



          } //if statement

          if(c.getmode().contains("online")) {
            System.out.println("Students with online TR classes: " + s.getName());


          } //





        } //if statement

      } //for loop



   } //for loop

  //removes duplicates    
  System.out.println("\nStudents in TR classes: " + studwithTR);

  int smallestNum = leastCH.get(0) ;
  for(Integer num: leastCH) {
    if(num < smallestNum) {
      smallestNum = num ;

    } //if statement

  } //for loop
  System.out.println("\n\nLeast number of credit hours: " + smallestNum + "\n");

  for(Student s: result) {
    if(s.getName().contains("P")) {
      System.out.println("Students with last names that start with P: " + s.getName());

    } //if statement


  } //for loop
  System.out.println("\n2000+ courses: " + get2000);



    return result;

  } //function












}//class