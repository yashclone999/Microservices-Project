import { Component, OnInit, Input } from '@angular/core';
import { Location } from '../location.model';

@Component({
  selector: 'app-search-item',
  templateUrl: './search-item.component.html',
  styleUrls: ['./search-item.component.css']
})
export class SearchItemComponent implements OnInit{
  @Input() l!: Location;
  @Input() index!: number;
  ngOnInit(): void {
  }

}
