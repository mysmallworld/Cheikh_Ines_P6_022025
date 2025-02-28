import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  @Input() title: string = 'Inscription';
  @Input() submitLabel: string = 'S\'inscrire';
  @Input() isLogin: boolean = false;
  @Input() isSignup: boolean = false;

  authForm!: FormGroup<any>;
  emailOrUsernameError: string | undefined;
  emailError: string | undefined;
  passwordError: string | undefined;
  usernameError: string | undefined;
  
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    if (this.isLogin) {
      this.authForm = this.formBuilder.group({
        emailOrUsername: ['', [Validators.required, Validators.minLength(2)]],
        password: ['', [Validators.required, Validators.minLength(8)]]
      });
    } else {
      this.authForm = this.formBuilder.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        username: ['', [Validators.required]]
      });
    }
  }

  onSubmit(): void {
    // Envoyer les données à votre API pour créer un nouveau compte
    console.log(this.authForm?.value);
  }

  getErrorMessage(controlName: string): string | undefined {
    const control = this.authForm?.get(controlName);
    if (control?.invalid && (control.dirty || control.touched)) {
      if (control.errors?.['required']) {
        return 'Ce champ est obligatoire';
      } else if (control.errors?.['email']) {
        return 'Adresse email invalide';
      } else if (control.errors?.['username']) {
        return "Nom d'utilisateur doit contenir au moins 2 caractères";
      }else if (control.errors?.['minlength']) {
        return 'Le mot de passe doit contenir au moins 8 caractères';
      }
    }
    return undefined;
  }

  ngDoCheck(): void {
    if (this.isLogin) {
      this.emailOrUsernameError = this.getErrorMessage('emailOrUsername');
      this.passwordError = this.getErrorMessage('password');
    } else {
      this.emailError = this.getErrorMessage('email');
      this.passwordError = this.getErrorMessage('password');
      this.usernameError = this.getErrorMessage('username');
    }
  }

  goToHomePage(): void {
    this.router.navigate(['/']);
  }

}