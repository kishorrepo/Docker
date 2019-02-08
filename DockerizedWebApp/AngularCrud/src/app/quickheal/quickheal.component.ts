import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { TenantService } from '../quickheal/shared/tenant.service';

@Component({
  selector: 'app-quickheal',
  templateUrl: './quickheal.component.html',
  styleUrls: ['./quickheal.component.css']
})
export class QuickhealComponent implements OnInit {

  selectedFile : File = null;

  public tenantFile : any = File;

  constructor(private tenantService : TenantService) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm){
    if(form != null)
     form.reset();
    this.tenantService.selectedTenant = {
      tenantId : '',
      clientGUIId : '',
      tenantData : ''
    }
  }

  onFileSelected(event){
    console.log(event);
    this.selectedFile = <File>event.target.files[0];
    const file = event.target.files[0];
    this.tenantFile = file;
    // let file = fileInput.target.files[0];
    // let fileName = file.name;
}


onUpload(){
  console.log("File Name : "+this.tenantFile.name);
  const formData = new FormData();
  formData.append('file',this.tenantFile);
  console.log("FormData: "+formData);
  this.tenantService.uploadFile(formData)
    .subscribe((response)=>{
    console.log("Response :");
    console.log(response);
    
    // if(response==null){
    //   document.getElementById("demo").innerHTML = "HTML file displayed on browser";
    // }else{
    //   var myJSON = JSON.stringify(response);
    //   document.getElementById("demo").innerHTML = myJSON;
    // }
   
  });
}


onSubmit(form : NgForm){
  console.log(form.value);
  this.tenantService.postTenant(form.value)
    .subscribe( response =>{
     console.log("Response:"); 
     console.log(response);
     this.resetForm(form);
    })
  
}

}
