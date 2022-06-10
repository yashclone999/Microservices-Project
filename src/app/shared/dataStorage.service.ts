import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, tap, catchError } from 'rxjs/operators';
import { Location } from '../search/location.model';
import { throwError, Subject } from 'rxjs';
import { BookingDetails } from '../booking/booking-details.model';
import { BookingDetailsService } from '../booking/booking.service';
import { Envoice } from '../payments/envoice.model';
import { LocationsService } from '../search/locations.service';

@Injectable({
  providedIn: 'root'
})
export class DataStorageService {
  constructor(
    private http: HttpClient,
    private locationService: LocationsService,
    private detailsService: BookingDetailsService
  ) { }


  private paymentSuccess: Subject<Location> = new Subject<Location>();


  fetchLocations() {

    return this.http.get<String[]>("http://localhost:8765/rooms/locations")
      .pipe(
        map(response => {
          return response.map(location => {
            return new Location(location, `get Description about ${location} from static files`, `/assets/images/${location}.png`);
          })
        }),
        tap(locations => {
            this.locationService.setLocations(locations);
          }
        ),
        catchError(err => {
          return throwError(err);
        })
      )
      .subscribe(
        data => console.log(data),
        error => {
          console.log("error - " + error);
        }
      );
  }


  fetchBookingDetails(name: String, code: String) {

    console.log("CALLED Details!")
    return this.http.get<BookingDetails[]>(
      `http://localhost:8765/book/${name}/${code}`
    )
      .pipe(
        tap(details => {
          this.detailsService.setDetails(details);
        }
        ),
        catchError(err => {
          return throwError(err);
        })
      )
      .subscribe(
        data => console.log(data),
        error => {
          console.log("error &($#@ " + error);
        }
      );
  }


  makePayments(flightDetails: BookingDetails) {

    //save changes in data on the backend side 
    this.http.get(
      `http://localhost:8765/book/persist/${flightDetails.hashCode}`
    )
      .subscribe(
        data => console.log("PERSIST")
      );

    this.http.get(
      'http://localhost:8765/book/env'
    ).subscribe(
        data => {
          console.log(data);
      }
      );

    //payments service
    return this.http.get<Envoice>(
      `http://localhost:8765/book/payment/${flightDetails.hashCode}`
    )

  }
}

