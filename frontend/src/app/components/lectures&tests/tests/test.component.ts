import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {Test} from "../../../modules/test";
import {ActivatedRoute, Router} from "@angular/router";
import {TestService} from "../../../services/test.service";
import {Question} from "../../../modules/question";
import {QuestionService} from "../../../services/question.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

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



  constructor(private testService: TestService,
              private questionService: QuestionService,
              private cdr: ChangeDetectorRef,
              private router: Router,
              private route: ActivatedRoute,
              private modalService: BsModalService
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
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-lg'}));
  }
}
