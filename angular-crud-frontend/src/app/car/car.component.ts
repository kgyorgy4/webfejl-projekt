import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent {
  CarArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
  

  currentAction: string = "Add car";
  editing: boolean = false;
  rendszam: string ="";
  szin: string ="";
  employee_id:string=""
  

  currentCarID = "";

  constructor(private http: HttpClient ) 
  {
    this.getAllCars();

  }

  getAllCars()
  { 
    
    this.http.get("http://localhost:8080/api/v1/car/cars")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        
        this.CarArray = resultData;
    });
  }

  register()
  {
   
    let bodyData = {
      "rendszam" : this.rendszam,
      "szin" : this.szin,
      "employee_id": this.employee_id
      };

    this.http.post("http://localhost:8080/api/v1/car/add",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      console.log(resultData);
        alert("car added")
        this.getAllCars();
        this.rendszam = '';
        this.szin = '';   
        this.employee_id='';     
    });
  }
  setUpdate(data: any) 
  {
   this.rendszam = data.rendszam;
   this.szin = data.szin;   
   this.currentCarID = data.id; 
   this.employee_id=data.employee_id;
   this.currentAction="Update " + this.szin;
   this.editing=true;
  }

  cancelUpdate()
  {
    this.rendszam = '';
    this.szin = '';   
    this.employee_id='';
    this.currentCarID  = '';     
    this.currentAction="Add car"
    this.editing=false;

  }

  UpdateRecords()
  {
    let bodyData = {
      "id": this.currentCarID,
      "rendszam" : this.rendszam,
      "szin" : this.szin,     
      "employee_id": this.employee_id
    };
    
    this.http.put("http://localhost:8080/api/v1/car/update",bodyData, {responseType: 'text'}).subscribe((resultData: any)=>
    {
       console.log(resultData);
        alert("car updated")
        this.getAllCars();
        this.rendszam = '';
        this.szin = '';        
        this.employee_id='';
        this.currentCarID  = '';       
    });
  }



  add()
  {
    if(this.currentCarID == '')
    {
        this.register();
    }
      else
      {
        this.currentAction="Add car"
        this.editing=false;
       this.UpdateRecords();
       
      }       

  }
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8080/api/v1/car/delete"+ "/"+ data.id,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("car deleted")
        this.getAllCars();
   
    });

  }
}
