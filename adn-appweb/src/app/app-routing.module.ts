import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CasosComponent } from './casos/casos.component';

const routes: Routes = [
  {path: 'casos', component: CasosComponent},
  {path: '', redirectTo: 'casos', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
