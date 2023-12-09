import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarComponent } from './car/car.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [

{path:'', component: EmployeeComponent},
{path:'cars', component:CarComponent},
{path:'employees',component:EmployeeComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
