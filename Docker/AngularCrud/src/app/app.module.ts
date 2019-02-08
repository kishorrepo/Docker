import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeComponent } from './employees/employee/employee.component';
import { EmployeeListComponent } from './employees/employee-list/employee-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { QuickhealComponent } from './quickheal/quickheal.component';
import { RouterModule,Routes } from '@angular/router';
import { ParentComponent } from './ComponentCommunication/parent/parent.component';
import { ChildComponent } from './ComponentCommunication/child/child.component';
import { CommunicationService } from './ComponentCommunicationservice/communication.service';
import { CommunicationComponent } from './ComponentCommunication/communication/communication.component';
 @NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeComponent,
    EmployeeListComponent,
    QuickhealComponent,
    ParentComponent,
    ChildComponent,
    CommunicationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
   
    ToastrModule.forRoot(),
    RouterModule.forRoot([
      {path:'quickheal',component:QuickhealComponent},
      {path:'employees',component:EmployeesComponent},
      // {path:'parent',component:ParentComponent},
      // {path:'child',component:ChildComponent}
      {path:'communication',component:CommunicationComponent}
    ])
  ],
  providers: [CommunicationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
