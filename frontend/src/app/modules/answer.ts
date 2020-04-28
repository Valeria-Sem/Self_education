export class Answer {
  idAnswer: number;
  questionId: string;
  answerText: string;
  isRight: number;



  constructor( idAnswer: number, questionId: string,
               answerText: string, isRight: number) {
    this.idAnswer = idAnswer;
    this.questionId = questionId;
    this.answerText = answerText;
    this.isRight = isRight;
  }
}
