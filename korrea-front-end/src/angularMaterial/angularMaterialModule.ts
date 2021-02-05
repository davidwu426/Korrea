import { NgModule } from '@angular/core';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';

import { MatInputModule, MatInput } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule, MatButton } from '@angular/material/button';

import { MatTableModule } from '@angular/material/table';

const sideNavModule = [
    MatSidenavModule
]

const listModule = [
    MatListModule
]

const formModule = [
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
]

const tableModule = [
    MatTableModule
]

@NgModule({
    imports : [],
    exports : [sideNavModule, listModule, formModule, tableModule]
})

export class AngularMaterialModule { }