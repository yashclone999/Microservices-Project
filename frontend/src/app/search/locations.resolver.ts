import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { DataStorageService } from '../shared/dataStorage.service';
import { Observable } from 'rxjs';
import { LocationsService } from './locations.service';
import { Location } from './location.model';

@Injectable({ providedIn: 'root' })
export class LocationsResolverService implements Resolve<Location[]> {

  constructor(
    private dataStorageService: DataStorageService,
    private locationsService: LocationsService) {
  };

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Location[]> | Location[] {
    
    const locations = this.locationsService.getLocations();

    if (locations.length === 0) {

      this.dataStorageService.fetchLocations();
      
      return this.locationsService.getLocations();

    }
    else {
      return locations;
    }

  }

}
