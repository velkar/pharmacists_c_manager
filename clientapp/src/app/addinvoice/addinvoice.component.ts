import { Component } from '@angular/core';
import { Invoice } from '../models/invoice';
import { InvoiceService } from '../services/invoice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  templateUrl: './addinvoice.component.html',
  styleUrls: ['./addinvoice.component.css']
})
export class AddinvoiceComponent {

  invoice: Invoice;

  constructor(private route: ActivatedRoute, private router: Router, private invoiceService: InvoiceService) {
    this.invoice = new Invoice();
   }

  onSubmit() {
    this.invoiceService.save(this.invoice).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/home']);
  }

}
