import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user.model';
import { userStudent } from '../userStudent.model';

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

  addUserAndStudent(newUserStudent: userStudent): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/users/add', newUserStudent);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  getUserByEmail(email: string): Observable<User>{
    return this.http.get<User>(`${this.baseUrl}/email/${email}`);
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
