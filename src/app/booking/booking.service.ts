import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { BookingDetails } from './booking-details.model';
// import { FlightsService } from '../flights/flights.service';

@Injectable({ providedIn: 'root' })
export class BookingDetailsService {

  detailsSub: Subject<BookingDetails[]> = new Subject<BookingDetails[]>();
  details: BookingDetails[] = [];
  selectedDetail!: BookingDetails;

  constructor(
    private http: HttpClient
  ) { }


  setDetails(data: BookingDetails[]) {
    this.details = data;
    this.detailsSub.next(this.details);
  }

  setDetail(data: BookingDetails) {
    this.selectedDetail = data;
  }

  getDetails() {
    return this.details.slice();
  }

  getDetail() {
    return this.selectedDetail;
  }

}
