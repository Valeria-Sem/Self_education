export class PassedTest {
  idPassedTest: number = undefined;
  studentId: number;
  idTest: string;
  mark: number;


  constructor(studentId: number, idTest: string, mark: number) {
    this.studentId = studentId;
    this.idTest = idTest;
    this.mark = mark;
  }

}
