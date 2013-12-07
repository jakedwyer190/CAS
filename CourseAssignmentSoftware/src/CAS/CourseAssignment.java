/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS;

import CAS.Data.Course;
import CAS.Data.Instructor;
import CAS.DataIO.DataIO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sid
 */
public class CourseAssignment {
    
    
    private HashMap<String, Instructor> instructors;
   /**
    * @return Returns the instructor map..
    */
    public HashMap<String, Instructor> getInstructors()
    { return instructors; }
    
    private HashMap<String, Course> courses;
   /**
    * @return Returns the course map.
    */
    public HashMap<String, Course> getCourses()
    { return courses; }
    
    public CourseAssignment()
    {
        instructors = new HashMap<String, Instructor>();
        courses = new HashMap<String, Course>();
    }
    
    
   /**  Populates the course and instructor lists from 
      *  data files.
      *  @return Returns whether or not loading succeeded.
      */    
    public boolean loadData()
    {
        loadCourses();
        loadInstructors();
        loadSeniorityList();
        loadWorkAreas();
        return true;
    }
    
    public void loadCourses()
    { /**courses = DataIO.LoadCourses();*/ }
    
    public void loadInstructors()
    { /** instructors = DataIO.LoadInstructors();*/ }
    
    public void loadSeniorityList()
    { /**DataIO.LoadSeniorityList(instructors);*/ }
    
    public void loadWorkAreas()
    { /** load work areas */ }
    
  /** Iterates through each instructor and attempts to assign
      * their top available preferred course,  each instructor will have 
      * either 1 or 0 courses by the end.
      */    
    public void assignCourses()
    {
        for(Instructor instructor : instructors.values())
        {
            boolean assigned = false;
            while(!assigned && !instructor.getPreferredCourses().isEmpty())
            {
                Course preferredCourse =courses.get( instructor.getPreferredCourses().pop());
                if(preferredCourse.getInstructor() == null)
                {
                    preferredCourse.setInstructor(instructor);
                    assigned = true;
                }
                else  if(preferredCourse.getInstructor().compareTo(instructor, preferredCourse) < 0)
                {
                    preferredCourse.getInstructor().getCourses().remove(preferredCourse);
                    preferredCourse.setInstructor(instructor);
                    assigned = true;
                }
            }
        }
    }
  
   /**  Writes reports based on the current state of the
    *    instructor and course lists.
      *  @return Returns whether or not writing succeeded.
      */       
    public boolean writeReports()
    {
            return true;
    }
}