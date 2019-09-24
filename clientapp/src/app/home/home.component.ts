import { Component, OnInit } from '@angular/core';
import { HomeService } from '../services/home.service';
import { Invoice } from '../models/invoice';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private data: Object[];

  constructor(private homeService: HomeService) { }

  ngOnInit() {
    this.homeService.findAll().subscribe(res => {
       console.log(res);
       this.data = res;
    });
  }

  changeStatus(id: string) {
    this.homeService.changeStatus(id);
  }

}
