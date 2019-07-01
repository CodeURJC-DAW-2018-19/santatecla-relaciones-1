import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

const URL = 'https://localhost:8443';

export interface User {
  id?:number;
  name:string;
  passwordHash:string;
  roles:string[];
  authdata:string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isLogged = false;
  isAdmin = false;
  user: User;
  auth: string;


  constructor(private http: HttpClient) {
    let user = JSON.parse(localStorage.getItem('currentUser'));
    if (user){
      console.log('Logged user');
      this.setCurrentUser(user);
    }
  }

  logIn(user: string, pass:string):Observable<User> {

    let auth = window.btoa(user + ':' + pass);

    const headers = new HttpHeaders({
      Authorization: 'Basic ' + auth,
      'X-Requested-With': 'XMLHttpRequest',
    });
    return this.http.get<User>(URL + '/login', { headers })
      .pipe(map(user => {
          if (user) {
              this.setCurrentUser(user);
              user.authdata = auth;
              localStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
      }));

  }

  logOut() {
    return this.http.get(URL + '/logout').pipe(
      map(response => {
        this.removeCurrentUser();
        return response;
      }),
    );
  }

  private setCurrentUser(user:User) {
    this.isLogged = true;
    this.user = user;
    this.isAdmin = this.user.roles.indexOf('ROLE_ADMIN') !== -1;
  }

  removeCurrentUser() {
    localStorage.removeItem('currentUser');
    this.isLogged = false;
    this.isAdmin = false;
  }
}
