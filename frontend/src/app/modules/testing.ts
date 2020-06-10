export class Testing {
  idPassedTest: number = undefined;
  studentId: number;
  idTest: string;
  mark: number;
  isExist: boolean;

  constructor(idPassedTest: number, studentId: number, idTest: string, mark: number) {
    this.idPassedTest = idPassedTest;
    this.studentId = studentId;
    this.idTest = idTest;
    this.mark = mark;
  }
}
