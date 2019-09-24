import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Invoice } from '../models/invoice';

@Injectable()
export class InvoiceService {

  private invoiceUrl: string;

  constructor(private http: HttpClient) {
    this.invoiceUrl = 'http://localhost:9000/addinvoice';
  }

  public save(invoice: Invoice) {
    return this.http.post<Invoice>(this.invoiceUrl, invoice);
  }
}
