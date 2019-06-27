import { Injectable } from "@angular/core";
import { LoginService } from '../login.service';
import { HttpRequest, HttpHandler, HttpInterceptor, HttpEvent } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

    constructor(private loginServices: LoginService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {

            if (err.status === 401) {
                console.log('DENIED ACCES');
                this.loginServices.removeCurrentUser();
            }

            return throwError(err);
        }))
    
    }
}