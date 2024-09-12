import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { UserStudent } from '../models/userStudent.model';
import { UserAthlete } from '../models/userAthlete.model';
import { UserStudentAthlete } from '../models/userStudentAthlete.model';
import { Student } from '../models/student.model';
import { Athlete } from '../models/athlete.model';

@Injectable({
  providedIn: 'root'
})
export class AthleteService {
    private baseUrl = 'http://localhost:8080/api/athletes';

    constructor(private http: HttpClient) {}

    getAllAthletes(): Observable<Athlete[]> {
        return this.http.get<Athlete[]>(`${this.baseUrl}`);
    }
}