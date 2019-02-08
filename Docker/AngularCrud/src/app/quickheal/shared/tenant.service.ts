import { Injectable } from '@angular/core';
import { Tenant } from '../shared/tenant';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
//import { map } from 'rxjs/operator';


@Injectable({
  providedIn: 'root'
})
export class TenantService {

  selectedTenant : Tenant;
  constructor(private http : HttpClient) { }

   //upload tenant file
   uploadFile(formData : FormData) : Observable<any>{
    console.log("Inside Tenant Service : "+formData);
    return this.http.post('http://localhost:8080/uploadFile',formData);
  }

   //Send Tenant
   postTenant(tenant : Tenant) : Observable<any>{
    console.log("Inside Service "+tenant.tenantId);
    return this.http.post('http://localhost:8080/uploadData',tenant);
   
  }
}
