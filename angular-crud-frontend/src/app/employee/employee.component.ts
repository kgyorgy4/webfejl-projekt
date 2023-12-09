import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {

  EmployeeArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
  

  currentAction: string = "Add employee";
  editing: boolean = false;
  first_name: string ="";
  last_name: string ="";
  email: string="";

  currentEmployeeID = "";

  constructor(private http: HttpClient ) 
  {
    this.getAllEmployees();

  }

  getAllEmployees()
  { 
    
    this.http.get("http://localhost:8080/api/v1/employee/employees")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        
        this.EmployeeArray = resultData;
    });
  }

  register()
  {
   
    let bodyData = {
      "first_name" : this.first_name,
      "last_name" : this.last_name,
      "email" : this.email
    };

    this.http.post("http://localhost:8080/api/v1/employee/add",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
        alert("Employee added")
        this.getAllEmployees();
        this.first_name = '';
        this.last_name = '';
        this.email  = '';
    });
  }
  setUpdate(data: any) 
  {
   this.first_name = data.first_name;
   this.last_name = data.last_name;
   this.email = data.email;
   this.currentEmployeeID = data.id; 
   this.currentAction="Update " + this.last_name;
   this.editing=true;
  }

  cancelUpdate()
  {
    this.first_name = '';
    this.last_name = '';
    this.email  = '';
    this.currentEmployeeID  = '';     
    this.currentAction="Add employee"
    this.editing=false;

  }

  UpdateRecords()
  {
    let bodyData = {
      "id": this.currentEmployeeID,
      "first_name" : this.first_name,
      "last_name" : this.last_name,
      "email" : this.email,
    };
    
    this.http.put("http://localhost:8080/api/v1/employee/update",bodyData, {responseType: 'text'}).subscribe((resultData: any)=>
    {
       console.log(resultData);
        alert("Employee updated")
        this.getAllEmployees();
        this.first_name = '';
        this.last_name = '';
        this.email  = '';
        this.currentEmployeeID  = '';       
    });
  }



  add()
  {
    if(this.currentEmployeeID == '')
    {
        this.register();
    }
      else
      {
        this.currentAction="Add employee"
        this.editing=false;
       this.UpdateRecords();
       
      }       

  }
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8080/api/v1/employee/delete"+ "/"+ data.id,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Employee deleted")
        this.getAllEmployees();
   
    });

  }
}


