import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private userService: UserService,
    private router: Router) {
}

  ngOnInit(): void {
  }

  onSubmit(event: any, user: string, pass: string){
   
    event.preventDefault();

    this.userService.logIn(user, pass);
  }

  
  logOut() {
    this.userService.logOut();
  }

}   
