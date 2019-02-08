import { Component, OnInit } from '@angular/core';
import { CommunicationService } from '../../ComponentCommunicationservice/communication.service';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  user : string;

  constructor(private communicationService : CommunicationService) { }

  ngOnInit() {
    this.communicationService.cast.subscribe(user => this.user = user);
  }
}
