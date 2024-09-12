import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { UserStudent } from '../models/userStudent.model';
import { UserAthlete } from '../models/userAthlete.model';
import { UserStudentAthlete } from '../models/userStudentAthlete.model';
import { Student } from '../models/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
    private baseUrl = 'http://localhost:8080/api/students';

    constructor(private http: HttpClient) {}

    getAllStudents(): Observable<Student[]> {
        return this.http.get<Student[]>(`${this.baseUrl}`);
    }
}