import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DropDownDirective } from './drop-down.directive';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    DropDownDirective
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    DropDownDirective,
    CommonModule,
    FormsModule
  ]
})
export class SharedModule{}
