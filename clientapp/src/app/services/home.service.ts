import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Invoice } from '../models/invoice';
import { Observable } from 'rxjs';

@Injectable()
export class HomeService {

  private homeUrl: string;
  private changeStatusUrl: string;

  constructor(private http: HttpClient) {
    this.homeUrl = 'http://localhost:9000/home';
    this.changeStatusUrl = 'http://localhost:9000/changestatus';
  }

  public findAll(): Observable<Invoice[]> {
     return this.http.get<Invoice[]>(this.homeUrl);
  }

  public changeStatus(id: string) {
    return this.http.get(this.changeStatusUrl + '/' + id);
  }
}
