import { Component, OnInit } from '@angular/core';
import { FormComponent } from "../../components/form/form.component";

@Component({
    selector: 'app-sign-up',
    templateUrl: './sign-up.component.html',
    styleUrls: ['./sign-up.component.scss'],
    imports: [FormComponent],
    standalone: true
})
export class SignUpComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
  
}