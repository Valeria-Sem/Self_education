import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {Test} from "../../../modules/test";
import {ActivatedRoute, Router} from "@angular/router";
import {TestService} from "../../../services/test.service";
import {Question} from "../../../modules/question";
import {QuestionService} from "../../../services/question.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {RightAnswers} from "../../../modules/rightAnswers";
import {AnswerService} from "../../../services/answer.service";
import {PassedTestService} from "../../../services/passedTest.service";
import {User} from "../../../modules/user";
import {UserService} from "../../../services/user.service";
import {PassedTest} from "../../../modules/passedTest";

@Component({
  selector: "app-test",
  templateUrl: "./test.component.html",
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit{
  id: string;
  test: Test;
  questions : Question[];
  private userAnswers: Map<number, number> = new Map<number, number>();
  modalRef: BsModalRef;
  counter: number = 0;
  private request = {};
  private subscriptions: Subscription[] = [];
  private rightAnswers: RightAnswers = null;
  public user: User = this.userService.currentUser;
  passedTest: PassedTest;


  constructor(private testService: TestService,
              private questionService: QuestionService,
              private cdr: ChangeDetectorRef,
              private answerService: AnswerService,
              private router: Router,
              private route: ActivatedRoute,
              private userService: UserService,
              private modalService: BsModalService,
              private passedTestService: PassedTestService,
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });

    this.testService.getTestsByLectureId(this.id.substr(1, 2)).subscribe((data) => {
      this.test = data as Test;
      this.cdr.detectChanges();
    });

    this.questionService.getQuestionsByTestId(this.id.substr(1, 2)).subscribe((data) => {
      this.questions = data as Question[];
      this.cdr.detectChanges();
    });
  }

  public onChange(questionId: number, answerId: number): void {
    this.userAnswers.set(questionId, answerId);
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  public changeFormat(): void {
    this.userAnswers.forEach((value, key) => {
      this.request[key] = value;
    })
  }

  public finishPassing(): void {
    this.changeFormat();
    this.subscriptions.push(this.answerService.getRightAnswer(this.request).subscribe((rightAnswersModel) => {
      this.rightAnswers = rightAnswersModel as RightAnswers;
    }));
  }

  public saveResult(mark: number, test: string): void{
    this.passedTest = new PassedTest( this.user.idStudent, test, mark);
    this.passedTestService.saveResult(this.passedTest).subscribe();
  }
}
