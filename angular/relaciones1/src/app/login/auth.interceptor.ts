import { Injectable } from "@angular/core";
import { HttpHandler, HttpEvent, HttpRequest, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor {

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let user = JSON.parse(localStorage.getItem('currentUser'));

        if(user && user.authdata) {
            request = request.clone({
                setHeaders: {
                    Autorization: `Basic ${user.authdata}`
                }
            });
        }

        return next.handle(request);
    
    }
}