import { Component, 
          ContentChildren,
          QueryList,
          AfterContentInit } from '@angular/core';

import {TabComponent} from './tab.component';

@Component({
  selector: 'app-tabs',
  styles: [
    `
    .tab-close {
      color: gray;
      text-align: right;
      cursor: pointer;
    }
    `
  ],
  template: `
    <ul class="nav nav-tabs">
      <li *ngFor="let tab of tabs" (click)="selectTab(tab)" [class.active]="tab.active">
        <a href="javascript: void(0);">{{tab.title}}</a>
      </li>
    </ul>
    <ng-content></ng-content>
    `
})
export class TabsComponent implements AfterContentInit {

  @ContentChildren(TabComponent) tabs: QueryList<TabComponent>;

  ngAfterContentInit() {
    const activeTabs = this.tabs.filter((tab) => tab.active);
    if (activeTabs.length === 0) {
      this.selectTab(this.tabs.first);
    }
  }

  selectTab(tab: TabComponent) {
      this.tabs.toArray().forEach(tab => tab.active = false);
      tab.active = true;
    }
}
