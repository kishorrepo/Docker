import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../shared/employee.service';
import { Employee } from '../shared/employee.model';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employeeList : any[] = [];
  
  constructor(private employeeService : EmployeeService,
    private toastrService : ToastrService) { }

  ngOnInit() {
    this.employeeService.getEmployeeList()
   .subscribe( data =>{
    console.log("EmployeeList Data:")
    console.log(data);
    this.employeeList = data;
   
  })
  }

  showForEdit(emp : Employee){
    this.employeeService.selectedEmployee = Object.assign({},emp);
  }

  deleteEmployee(emp : Employee){
   this.employeeService.deleteEmployee(emp)
   .subscribe( data =>{
    console.log("deleteEmployee Data:");
    console.log(data);

    this.employeeService.getEmployeeList()
   .subscribe( data1 =>{
    console.log("EmployeeList Data:")
    console.log(data1);
    this.employeeList = data1;
   
  })

    this.toastrService.success('Employee deleted successfully...','Employee Deleted');
   
  })
  }
}
