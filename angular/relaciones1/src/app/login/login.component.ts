import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { MatDialogRef, MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  @ViewChild('loginDialog', {static:false}) loginDialog: TemplateRef<any>;
  dialogRef: MatDialogRef<any,any>;

  constructor(public dialog: MatDialog, private router: Router, public loginService: LoginService) { }

  logIn(event:any, user:string, pass:string){
    event.preventDefault();

    this.loginService.logIn(user,pass).subscribe(
      (u) => {
        console.log(u);
        this.dialogRef.close();
      },
      (error) => alert('Invalid user or password'),
    );
  }

  logOut() {
    this.loginService.logOut().subscribe(
      (response) => {
        this.router.navigate(['/']);
      },
      (error) => console.log('Error when trying to log out: ' + error),
    );
  }

  openLoginDialog() {
    this.dialogRef = this.dialog.open(this.loginDialog, {
      width: '50%',
      height: '50%',
    });
  }
 

}
