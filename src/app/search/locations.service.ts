import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Location } from './location.model';

@Injectable({ providedIn: 'root' })
export class LocationsService {

  locationsSub: Subject<Location[]> = new Subject<Location[]>();


  private locations: Location[] = [];

  setLocations(locationsArr: Location[]) {

    this.locations = locationsArr;
    this.locationsSub.next(this.locations);
  }
  
  getLocations() {
    return this.locations.slice();
  }

  getLocation(id: number) {
    return this.locations[id];
  }

}
