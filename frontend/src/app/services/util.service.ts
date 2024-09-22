import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  constructor() { }

  getFlagColor(flag: string): string {
    switch (flag) {
      case 'blue':
        return 'blue';
      case 'green':
        return 'green';
      case 'red':
        return 'red';
      case 'orange':
        return 'orange';
      default:
        return '';
    }
  }
}
