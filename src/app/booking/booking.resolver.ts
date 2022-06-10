import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Params, ActivatedRoute } from '@angular/router';
import { DataStorageService } from '../shared/dataStorage.service';
import { Observable } from 'rxjs';
import { BookingDetails } from './booking-details.model';
import { BookingDetailsService } from './booking.service';

@Injectable({ providedIn: 'root' })
export class BookingResolverService implements Resolve<BookingDetails[]> {

  constructor(
    private dataStorageService: DataStorageService,
    private bookingService: BookingDetailsService
  ) {
  };


  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): BookingDetails[] {
    
    var flightName = route.params['name'];
    var flightCode = route.params['code'];

    let details = this.bookingService.getDetails();

    /*
    if (details.length === 0) {
      
    }
    else {
      return details;
    }
    */  

    this.dataStorageService.fetchBookingDetails(flightName, flightCode);
    return this.bookingService.getDetails();
  }

}
