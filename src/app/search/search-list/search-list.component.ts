import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Location } from '../location.model';
import { LocationsService } from '../locations.service';

@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrls: ['./search-list.component.css']
})
export class SearchListComponent implements OnInit, OnDestroy{

  subscription!: Subscription;
  locations: Location[] = [];

  constructor(private locationService: LocationsService) { }

  ngOnInit(): void {

    this.locations = this.locationService.getLocations();
    this.subscription = this.locationService.locationsSub.subscribe(locations => {
      this.locations = locations;
    });
  }

  readAbout() { }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
