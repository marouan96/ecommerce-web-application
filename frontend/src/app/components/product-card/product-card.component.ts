import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.module';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
   products: Product[];
  constructor(private router: Router,private service:ProductService) { }

  ngOnInit():void{
    this.service.getProducts().subscribe(
      products=>{this.products=products
      console.log(this.products)
      },
      error=>console.log(error)
    );
  }

  /*bookImage(product:Product){
    return product.
  }*/

}
