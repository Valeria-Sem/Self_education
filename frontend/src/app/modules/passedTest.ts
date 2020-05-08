export class PassedTest {
  idPassedTest: number;
  studentId: number;
  idTest: string;
  mark: number;


  constructor( studentId: number, idTest: string, mark: number) {
    this.studentId = studentId;
    this.idTest = idTest;
    this.mark = mark;
  }
}
