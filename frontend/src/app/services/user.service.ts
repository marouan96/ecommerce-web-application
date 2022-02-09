import { Injectable } from '@angular/core';
import {User} from '../models/user.module';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';

const BASE_URL = '/api/auth';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  logged: boolean;
  user: User;

  constructor(private http: HttpClient) {
    this.reqIsLogged();
}

reqIsLogged() {

  this.http.get('/api/users/me', { withCredentials: true }).subscribe(
      response => {
          this.user = response as User;
          this.logged = true;
      },
      error => {
          if (error.status != 404) {
              console.error('Error when asking if logged: ' + JSON.stringify(error));
          }
      }
  );

}

logIn(user: string, pass: string) {

  this.http.post(BASE_URL + "/login", { userName: user, password: pass }, { withCredentials: true })
      .subscribe(
          (response) => this.reqIsLogged(),
          (error) => alert("Wrong credentials")
      );

}

logOut() {

  return this.http.post(BASE_URL + '/logout', { withCredentials: true })
      .subscribe((resp: any) => {
          console.log("LOGOUT: Successfully");
          this.logged = false;
          this.user = undefined;
      });

}

signUp(user: User): Observable<User> {
  return this.http.post<User>('/api/register', user);
}

currentUser() {
  return this.user;
}

}
