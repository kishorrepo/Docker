import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
//import { BehaviorSubject } from 'rxjs/BehaviorSubject';
@Injectable({
  providedIn: 'root'
})
export class CommunicationService {
private user = new BehaviorSubject<string>('John');
cast = this.user.asObservable();
  constructor() { }

  editUser(newUser){
    this.user.next(newUser);
  }
}
