import { CommonModule } from '@angular/common';
import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
  imports: [CommonModule, ReactiveFormsModule, DividerModule, ButtonModule, InputTextModule]
})
export class FormComponent implements OnInit, OnChanges {

  @Input() title: string = 'Inscription';
  @Input() submitLabel: string = "S'inscrire";
  @Input() isLogin: boolean = false;
  @Input() isSignup: boolean = false;

  authForm!: FormGroup;
  emailOrUsernameError: string | undefined;
  emailError: string | undefined;
  passwordError: string | undefined;
  usernameError: string | undefined;
  
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['isLogin'] || changes['isSignup']) {
      this.initializeForm();
    }
  }

  initializeForm(): void {
    if (this.isLogin) {
      this.authForm = this.formBuilder.group({
        emailOrUsername: ['', [Validators.required, Validators.minLength(2)]],
        password: ['', [Validators.required, Validators.minLength(8)]]
      });
    } else {
      this.authForm = this.formBuilder.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        username: ['', [Validators.required, Validators.minLength(2)]]
      });
    }
  }

  onSubmit(): void {
    if (this.authForm.valid) {
      console.log(this.authForm.value);
      // Ajouter l'appel API ici
    }
  }

  getErrorMessage(controlName: string): string | undefined {
    const control = this.authForm.get(controlName);
    if (control?.invalid && (control.dirty || control.touched)) {
      if (control.errors?.['required']) {
        return 'Ce champ est obligatoire';
      } else if (control.errors?.['email']) {
        return 'Adresse email invalide';
      } else if (control.errors?.['minlength']) {
        return controlName === 'password' 
          ? 'Le mot de passe doit contenir au moins 8 caractères'
          : 'Ce champ doit contenir au moins 2 caractères';
      }
    }
    return undefined;
  }

  goToHomePage(): void {
    this.router.navigate(['/']);
  }
}