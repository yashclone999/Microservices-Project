import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { BookingDetailsService } from './booking.service';
import { BookingDetails } from './booking-details.model';
import { Subscription, Subject } from 'rxjs';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit, OnDestroy {

  @ViewChild('f') signUpForm!: NgForm;
  details: BookingDetails[] = [];
  subscription!: Subscription;

  constructor(
    private detailsService: BookingDetailsService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.details = this.detailsService.getDetails();
    this.subscription = this.detailsService.detailsSub.subscribe(
      details => {
        this.details = details;
      }
    )
  }

  onSelect(id: number) {
    this.detailsService.setDetail(this.details[id]);
    this.router.navigate(['pay']);
  }

  ngOnDestroy() { 
    this.subscription.unsubscribe();
  }
}
