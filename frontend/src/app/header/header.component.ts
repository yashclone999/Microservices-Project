import { Component, EventEmitter, Output, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  isAuthenticated: boolean = true;
  userSub: Subscription = new Subscription();

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  onSaveData() {
    /*
    this.dataService.saveRecipes()
      .subscribe(res => {
        console.log(res);
      },
        error => {
          console.log(error);
        });
      */
  }
  onFetchData() {
    /*this.dataService.fetchRecipes().subscribe();*/
  }

  onLogout() {
    this.router.navigate(['/search']);
  }
}
