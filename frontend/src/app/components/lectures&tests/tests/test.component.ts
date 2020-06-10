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
import {Testing} from "../../../modules/testing";
import {Wallet} from "../../../modules/wallet";
import {WalletService} from "../../../services/wallet.service";

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
  testing: Testing;
  newBalance: number;
  balance: number;
  wallet: Wallet;


  constructor(private testService: TestService,
              private questionService: QuestionService,
              private cdr: ChangeDetectorRef,
              private answerService: AnswerService,
              private router: Router,
              private route: ActivatedRoute,
              private userService: UserService,
              private modalService: BsModalService,
              private passedTestService: PassedTestService,
              private walletService: WalletService
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

    this.passedTestService.findResult(this.user.idStudent, this.id.substr(1, 2)).subscribe((data) => {
      this.testing = data as Testing;
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
    this.balance = this.user.balance - this.testing.mark;
    this.newBalance = this.balance + mark;

    this.wallet = new Wallet(this.user.idWallet, this.newBalance, this.user.walletStatus);
    this.walletService.balanceReplenishment(this.wallet).subscribe( () =>{
      this.userService.currentUser.balance = this.newBalance;
      localStorage.setItem("user", JSON.stringify(this.userService.currentUser));
    });

    if(this.testing.isExist === true){
      this.testing = new Testing(this.testing.idPassedTest, this.user.idStudent, test, mark);
      this.passedTestService.reSaveResult(this.testing).subscribe();
    } else {
      this.passedTest = new PassedTest(this.user.idStudent, test, mark);
      this.passedTestService.saveResult(this.passedTest).subscribe();
    }
  }

}
