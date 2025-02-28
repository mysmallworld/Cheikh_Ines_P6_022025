import { Component, OnInit } from '@angular/core';
import { FormComponent } from "../../components/form/form.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  standalone: true,
  imports: [FormComponent],
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
