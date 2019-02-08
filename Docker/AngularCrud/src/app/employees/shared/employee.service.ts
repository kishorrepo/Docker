import { Injectable } from '@angular/core';
import {Employee} from '../shared/employee.model';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class EmployeeService {

  selectedEmployee : Employee;
  employeeList : Employee[];
  constructor(private http : HttpClient) { }

  //Save employee
  postEmployee(emp : Employee){
    console.log("Inside Service "+emp.firstName);
   // return this.http.post('http://localhost:7070/api/saveEmployee',emp);
    return this.http.post('http://192.168.99.100:8086/api/create',emp);
   
  }

  //Get employee list
  getEmployeeList() : Observable<any>{
    console.log("Inside getEmployeeList");
  //   return this.http.get('http://localhost:7070/api/getEmployeeList'); 
    return this.http.get('http://192.168.99.100:8086/api/getAll')
    .pipe(
      map((data: Employee[]) => {
        this.employeeList = data;
       // return  this.employeeList;
      })
   )
  }

  //Update employee
 updateEmployee(emp : Employee){
    console.log("Inside Service  updateEmployee "+emp.firstName);
   // return this.http.post('http://localhost:7070/api/updateEmployee',emp);
    return this.http.post('http://192.168.99.100:8086/api/update',emp);
   
  }

  // Delete employee
  deleteEmployee(emp : Employee){
    console.log("Inside service delete Employee "+emp.employeeId);
    //return this.http.post('http://localhost:7070/api/deleteEmployee',emp);
    return this.http.post('http://192.168.99.100:8086/api/delete',emp);
  }

  //upload File
  uploadFile(formData : FormData) : Observable<any>{
    console.log("Inside Service FormData : "+formData);
    return this.http.post('http://192.168.99.100:8086/api/uploadFile',formData);
  }
  
}
