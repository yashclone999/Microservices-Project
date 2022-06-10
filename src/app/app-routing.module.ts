import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { PaymentsComponent } from './payments/payments.component';
import { BookingResolverService } from './booking/booking.resolver';
import { SearchComponent } from './search/search.component';
import { LocationsResolverService } from './search/locations.resolver';
import { SearchDetailComponent } from './search/search-detail/search-detail.component';

const routes: Routes = [
  {
    path: 'search',
    component: SearchComponent,
    resolve: [LocationsResolverService],
    children: [
      { path: ':id', component: SearchDetailComponent }
    ]
  },
  {
    path: 'book',
    component: BookingComponent,
    children: [
      { path: ':name/:code', component: BookingComponent, resolve: [BookingResolverService] }
    ]
  },
  {
    path: 'pay',
    component: PaymentsComponent
  },
  { path: '**', redirectTo: '/search' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
