import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { MatCardModule } from '@angular/material/card';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BookingComponent } from './booking/booking.component';
import { PaymentsComponent } from './payments/payments.component';
import { SharedModule } from './shared/shared.module';
import { SearchComponent } from './search/search.component';
import { SearchDetailComponent } from './search/search-detail/search-detail.component';
import { SearchListComponent } from './search/search-list/search-list.component';
import { SearchItemComponent } from './search/search-item/search-item.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SearchComponent,
    BookingComponent,
    PaymentsComponent,
    SearchDetailComponent,
    SearchListComponent,
    SearchItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    HttpClientModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
