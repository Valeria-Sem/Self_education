export class Course {
  idCourse: string;
  courseName: string;

  static cloneBase(course: Course): Course{
    const cloneCourse: Course = new Course();
    cloneCourse.idCourse = course.idCourse;
    cloneCourse.courseName = course.courseName;
    return cloneCourse;
  }
}

