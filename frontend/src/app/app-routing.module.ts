import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AthleteComponent } from './components/athlete/athlete.component';
import { AppUserListComponent } from './components/user-list/user-list.component';

const routes: Routes = [
  { path: '', component: AppUserListComponent },
  { path: 'athlete/:id', component: AthleteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
