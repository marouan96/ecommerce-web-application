import {NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductCardComponent } from './components/product-card/product-card.component';


const routes: Routes = [
{path:'products' , component:ProductCardComponent}
,{path: '', redirectTo: 'products', pathMatch: 'full' 
}
];
@NgModule({
    declarations: [],
    imports: [RouterModule.forRoot(routes)],
    exports:[RouterModule]})

export class AppRoutingModule {}
