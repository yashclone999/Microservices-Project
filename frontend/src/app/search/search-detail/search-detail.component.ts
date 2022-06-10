import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Location } from '../location.model';
import { LocationsService } from '../locations.service';

@Component({
  selector: 'app-search-detail',
  templateUrl: './search-detail.component.html',
  styleUrls: ['./search-detail.component.css']
})
export class SearchDetailComponent implements OnInit {

  id!: number;
  location!: Location;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private locationService: LocationsService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.location = this.locationService.getLocation(this.id);
      }
    )
  }

  book(id: number) {
    // this.router.navigate([`book/${this.flight.name}/${}`]);
  }
  about() { }

}
