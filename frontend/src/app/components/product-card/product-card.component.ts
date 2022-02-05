import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.module';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
  constructor(private route: ActivatedRoute,private service:ProductService) { }
   
   page=1;
   products:Product[];
  ngOnInit():void{
    this.getProducts();
  }
  


  getProducts(){
      this.service.getProducts().subscribe(
        products=>{
        this.products=products;
      },
      error => {
        console.log(error);
      });
  }

  

  /*bookImage(product:Product){
    return product.
  }*/

}
