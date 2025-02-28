import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormComponent } from './components/form/form.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA, ApplicationRef } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatLegacyButtonModule as MatButtonModule } from '@angular/material/legacy-button';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    FormComponent, 
    HomeComponent, 
    LoginComponent, 
    SignUpComponent,
    AppComponent
  ],
  declarations: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {
  ngDoBootstrap(appRef: ApplicationRef) {
    appRef.bootstrap(AppComponent);
  }
}