import { Component , OnInit , Input , Output , EventEmitter  } from '@angular/core';
import { CommunicationService } from '../../ComponentCommunicationservice/communication.service';
@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  user : string;
  editUser : string;
  constructor(private communicationService : CommunicationService) { }

  ngOnInit() {
    this.communicationService.cast.subscribe(user => this.user = user);
  }

  editTheUser(){
    this.communicationService.editUser(this.editUser);
  }
  

}
