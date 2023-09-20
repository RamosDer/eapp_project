import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.css']
})
export class SidebarMenuComponent implements OnInit {

  showRegistrarSubMenu = false;

  constructor() { }

  ngOnInit(): void {
  }

  toggleRegistrarSubMenu(): void {
    this.showRegistrarSubMenu = !this.showRegistrarSubMenu;

    console.log(this.showRegistrarSubMenu);
  }

}
