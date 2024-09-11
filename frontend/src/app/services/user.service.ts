import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { UserStudent } from '../models/userStudent.model';
import { UserAthlete } from '../models/userAthlete.model';
import { UserStudentAthlete } from '../models/userStudentAthlete.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}`);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/${id}`);
  }

  addUser(newUser: User): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/addUser`, newUser);
  }

  addUserStudent(newUserStudent: UserStudent): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/addUserStudent`, newUserStudent);
  }

  addUserAthlete(newUserAthlete: UserAthlete): Observable<any>{
    console.log('newUserAthlete', newUserAthlete, 2);
    return this.http.post<any>(`${this.baseUrl}/addUserAthlete`, newUserAthlete);
  }

  addUserStudentAthlete(newUserStudentAthlete: UserStudentAthlete): Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/addUserStudentAthlete`, newUserStudentAthlete);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  getUserByEmail(email: string): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}/email/${email}`);
  }

  getUserByFirstName(firstName: string): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}/firstName/${firstName}`);
  }

  getUserByFirstNameAndLastName(firstName: String, lastName: String): Observable<User>{
    return this.http.get<User>(`${this.baseUrl}/firstNameAndlastName/${firstName}/${lastName}`);
  }

  getUsersByPartialEmail(prefix: string): Observable<User>{
    return this.http.get<User>(`${this.baseUrl}\byEmail?email=${prefix}`)
  }

  getUsersByDate(date: string): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}/date?date=${date}`)
  }

  getCountOfLastName(lastName: string):Observable<number>{
    return this.http.get<number>(`${this.baseUrl}/lastNameCount/${lastName}`);
  }
}
