export class Subject {
  idSubject: string;
  name: string;

  static cloneBase(subject: Subject): Subject{
    const cloneSubject: Subject = new Subject();
    cloneSubject.idSubject = subject.idSubject;
    cloneSubject.name = subject.name;
    return cloneSubject;
  }
}

