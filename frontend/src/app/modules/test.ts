import {Question} from "./question";

export class Test {
  idTest: string;
  lecId: string;
  testName: string;
  questionNumber: string;



  constructor( idTest: string, lecId: string,
               testName: string, questionNumber: string) {
    this.idTest = idTest;
    this.lecId = lecId;
    this.testName = testName;
    this.questionNumber = questionNumber;
  }
}
