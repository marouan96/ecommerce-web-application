import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Product}  from '../models/product.module';
import { Observable,throwError } from 'rxjs';
import { catchError  } from 'rxjs/operators';


const URL='/api/products/';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  getProducts():Observable<Product[]>{
    return this.httpClient.get(URL).pipe(
     catchError(error=>this.handleError(error))
    ) as Observable<Product[]>;
  }

  getProductsPageable(params:any): Observable<any>{
      return this.httpClient.get(URL+`pages?page=${params.page}&size=${params.size}`).pipe();
  }

  private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}
}
