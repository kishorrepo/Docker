import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../shared/employee.service';
import {NgForm} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {


  selectedFile : File = null;

  public userFile : any = File;

  employeeList : any[] = [];
  fileListData : any[] = [];
  
  constructor(private employeeService : EmployeeService,
    private toastrService : ToastrService) { }

  ngOnInit() {
    this.resetForm();
  }


  onFileSelected(event){
    console.log(event);
    this.selectedFile = <File>event.target.files[0];
    const file = event.target.files[0];
    this.userFile = file;
    // let file = fileInput.target.files[0];
    // let fileName = file.name;
}


onUpload(){
  const formData = new FormData();
  formData.append('file',this.userFile);
  console.log("FormData: "+formData);
  this.employeeService.uploadFile(formData)
  // .subscribe( data =>{
  //   console.log("Data:");
  //   console.log(data);
    
  // })

  .subscribe((response)=>{
    console.log("Response :");
    console.log(response);
    if(response==null){
      document.getElementById("demo").innerHTML = "HTML file displayed on browser";
    }else{
      var myJSON = JSON.stringify(response);
      document.getElementById("demo").innerHTML = myJSON;
    }
    
   // this.fileListData = response;
  });
}

  resetForm(form?: NgForm){
    if(form != null)
     form.reset();
    this.employeeService.selectedEmployee = {
      employeeId : null,
      firstName : '',
      lastName  : '',
      position  : '',
      empCode   : '',
      office    : ''
    }
  }

  onSubmit(form : NgForm){
    if(form.value.employeeId == null){
    console.log("Inside onSubmit  "+form.value);
    this.employeeService.postEmployee(form.value)
    .subscribe( data =>{
      console.log("Data:")
      console.log(data);
      this.resetForm(form);
      this.toastrService.success('Employee created successfully...','Employee Register');
    })
  }
    else{
      //Update Operation
      console.log("Inside update employee Id: "+form.value.employeeId);
      this.employeeService.updateEmployee(form.value)
      .subscribe( data =>{
        console.log("Data:")
        console.log(data);
        this.resetForm(form);
          this.toastrService.success('Employee updated successfully...','Employee Updated');
      })

    }
  }
}
