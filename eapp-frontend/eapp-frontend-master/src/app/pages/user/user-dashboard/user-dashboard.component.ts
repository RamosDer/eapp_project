import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';  // Asegúrate de importar el servicio desde su ubicación correcta.

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  
  public isUserLoggedIn: boolean | undefined;

  constructor(private loginService: LoginService) { }  // Inyectamos el LoginService

  ngOnInit(): void {
    this.isUserLoggedIn = this.loginService.isLoggedIn();
    console.log('Usuario conectado:', this.isUserLoggedIn);
  }

}
