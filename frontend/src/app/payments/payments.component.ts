import { Component, OnInit } from '@angular/core';
import { BookingDetailsService } from '../booking/booking.service';
import { BookingDetails } from '../booking/booking-details.model';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { DataStorageService } from '../shared/dataStorage.service';
import { Envoice } from './envoice.model';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit {

  message: String = "";
  paymentDetails!: BookingDetails;
  transcript!: Envoice;
  
  constructor(
    private bookingService: BookingDetailsService,
    private router: Router,
    private dataService: DataStorageService
  ) { }

  ngOnInit(): void {
    this.paymentDetails = this.bookingService.getDetail();
  }

  makePayment() {
    this.dataService.makePayments(this.paymentDetails)
    .subscribe(
      data => {
        this.message = "success";
        this.transcript = data;
      },
      error => {
        this.message = error.message;
        console.log(error);
      });
      
  }

  return() {
    this.router.navigate(['flights']);
  }
}
