import { Component, OnInit } from '@angular/core';
import { HomeService } from '../services/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public data: Object[];
  
  constructor(private homeService: HomeService) { }

  ngOnInit() {
    this.loadNotifications();
    this.loadRecommendations();
  }

  loadNotifications(){
    this.homeService.findAll().subscribe(res => {
       console.log(res);
       this.data = res;
    });
  }

  loadRecommendations(){
    this.homeService.findAllRecommedations().subscribe(res => {
       console.log(res);
       this.data = res;
    });

  }

  changeStatus(id: string) {
    this.homeService.changeStatus(id).subscribe(() => {
       this.loadNotifications();
    });
  }

}
