import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  standalone: true
})
export class HomeComponent implements OnInit {


  constructor(private router: Router) { }

  ngOnInit(): void { }

  goToLoginPage(): void {
    this.router.navigate(['/login']);
  }

  goToSignUpPage(): void {
    this.router.navigate(['/sign-up']);
  }
}