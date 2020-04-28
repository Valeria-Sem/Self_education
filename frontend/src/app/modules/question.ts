import {Answer} from "./answer";

export class Question {
  idQuestion: number;
  testId: string;
  text: string;
  answers: Answer[];



  constructor( idQuestion: number, testId: string,
               text: string, answers: Answer[]) {
    this.idQuestion = idQuestion;
    this.testId = testId;
    this.text = text;
    this.answers = answers;
  }
}
